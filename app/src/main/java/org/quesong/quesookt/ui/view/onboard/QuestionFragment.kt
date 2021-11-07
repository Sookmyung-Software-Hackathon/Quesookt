package org.quesong.quesookt.ui.view.onboard

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat.getColor
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint
import org.quesong.core.base.BindingFragment
import org.quesong.core.util.AnimationUtil.getFadeInAnim
import org.quesong.core.util.AnimationUtil.setProgressAnimation
import org.quesong.core.util.StatusBarUtil.setStatusBarColor
import org.quesong.quesookt.R
import org.quesong.quesookt.data.local.model.QuestionData
import org.quesong.quesookt.databinding.FragmentQuestionBinding
import org.quesong.quesookt.ui.view.onboard.Adapter.AnswerAdapter
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel

@AndroidEntryPoint
class QuestionFragment : BindingFragment<FragmentQuestionBinding>(R.layout.fragment_question) {
    private var questionPosition = 0
    private var progress = PROGRESS_NUM
    private lateinit var answerAdapter: AnswerAdapter
    private val questionDataList = mutableListOf<QuestionData>()
    private val onboardViewModel: OnboardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initStatusBar()
        initData()
        initAnswerAdapter()
    }

    private fun initStatusBar() {
        with(requireActivity()) {
            setStatusBarColor(getColor(this, R.color.deep_blue))
        }
    }

    private fun initData() {
        questionDataList.addAll(onboardViewModel.getQuestionData())
    }

    private fun showAnim() {
        binding.apply {
            with(requireContext().getFadeInAnim()) {
                tvQuestion.startAnimation(this)
                rvQuestion.startAnimation(this)
            }

            setProgressAnimation(pbQuestion, progress)
            progress += PROGRESS_NUM
        }
    }

    private fun initAnswerAdapter() {
        answerAdapter = AnswerAdapter()

        binding.apply {
            answerAdapter.apply {
                with(questionDataList[questionPosition]) {
                    tvQuestion.text = question
                    data = answerList
                }
                binding.rvQuestion.adapter = this

                setItemClickListener {
                    addScore(it)
                    ++questionPosition
                    if (questionPosition == questionDataList.size) {
                        setProgressAnimation(pbQuestion, progress)
                        findNavController().navigate(R.id.action_questionFragment_to_resultFragment)
                    }
                    else {
                        data = questionDataList[questionPosition].answerList
                        tvQuestion.text = questionDataList[questionPosition].question
                        showAnim()
                    }
                }
            }
        }
    }

    private fun addScore(score : List<Int>) {
        with(onboardViewModel) {
            addJinri(score[0])
            addSunheon(score[1])
            addPrime(score[2])
            addRenaissance(score[3])
        }
    }

    companion object {
        const val PROGRESS_NUM = 10
    }
}
