package org.quesong.quesookt.ui.view.onboard

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import org.quesong.core.base.BindingFragment
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.FragmentNicknameBinding
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel

@AndroidEntryPoint
class NicknameFragment : BindingFragment<FragmentNicknameBinding>(R.layout.fragment_nickname) {
    private val onboardViewModel: OnboardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setConfirmEnable()
        initClickEvent()
        initTextChangeEvent()
        skipNickname()
    }

    private fun skipNickname() {
        if(!onboardViewModel.getFirstVisit())
            findNavController().navigate(R.id.action_nicknameFragment_to_questionFragment)
    }

    private fun initTextChangeEvent() {
        binding.apply {
            etNickname.addTextChangedListener {
                tvCount.text = etNickname.length().toString()
                setConfirmEnable()
            }
        }
    }

    private fun setNickName() {
        onboardViewModel.setNickName(binding.etNickname.text.toString())
    }

    private fun initClickEvent() {
        binding.tvConfirm.setOnClickListener {
            setNickName()
            findNavController().navigate(R.id.action_nicknameFragment_to_questionFragment)
        }
    }

    private fun setConfirmEnable() {
        binding.tvConfirm.isEnabled = !binding.etNickname.text.isNullOrEmpty()
    }
}
