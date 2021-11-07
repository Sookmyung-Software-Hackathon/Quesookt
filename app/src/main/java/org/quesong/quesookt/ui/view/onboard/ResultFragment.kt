package org.quesong.quesookt.ui.view.onboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.quesong.core.base.BindingFragment
import org.quesong.core.util.StatusBarUtil.setStatusBarColor
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.FragmentResultBinding
import org.quesong.quesookt.ui.view.MainActivity
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.JINRI
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.PRIME
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.RENAISSANCE
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.SUNHEON

@AndroidEntryPoint
class ResultFragment : BindingFragment<FragmentResultBinding>(R.layout.fragment_result) {
    private val onboardViewModel: OnboardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showResult()
        initClickEvent()
    }

    private fun showResult() {
        with(onboardViewModel.compareDormitory()) {
            binding.tvDormitory.text = this
            onboardViewModel.setDormitory(this)
            initView(this)
        }
    }

    private fun initClickEvent() {
        binding.btnStart.setOnClickListener {
            startMainActivity()
        }
    }

    private fun initView(dormitory: String) {
        when (dormitory) {
            JINRI -> setView(R.drawable.img_jinri_logo, R.color.jinri_purple, getString(R.string.jinri_explain))
            SUNHEON -> setView(R.drawable.img_sunheon_logo, R.color.sunheon_green, getString(R.string.sunheon_explain))
            RENAISSANCE -> setView(R.drawable.img_renaissance_logo, R.color.renaissance_yellow, getString(R.string.renaissance_explain))
            PRIME -> setView(R.drawable.img_prime_logo, R.color.prime_red, getString(R.string.prime_explain))
        }
    }

    private fun setView(logo: Int, background: Int, explain: String) {
        binding.apply {
            ivLogo.setImageResource(logo)
            clResult.setBackgroundResource(background)
            with(requireActivity()) {
                setStatusBarColor(ContextCompat.getColor(this, background))
            }
            tvExplain.text = explain
        }
    }


    private fun startMainActivity() {
        startActivity(Intent(requireActivity(), MainActivity::class.java))
    }
}
