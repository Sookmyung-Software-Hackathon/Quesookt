package org.quesong.quesookt.ui.view.complete

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import dagger.hilt.android.AndroidEntryPoint
import org.quesong.core.base.BindingFragment
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.FragmentCompleteBinding
import org.quesong.quesookt.ui.view.complete.model.CompletedInfoData
import org.quesong.quesookt.ui.viewmodel.MainViewModel

@AndroidEntryPoint
class CompleteFragment : BindingFragment<FragmentCompleteBinding>(R.layout.fragment_complete) {
    private lateinit var completedQuestAdapter: CompletedQuestAdapter
    private val mainViewModel: MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
        initCompletedAdapter()
        observeCompleteQuestList()
    }

    private fun initCompletedAdapter() {
        completedQuestAdapter = CompletedQuestAdapter()
        binding.rvCompleted.adapter = completedQuestAdapter
    }

    private fun initData() {
        mainViewModel.getAll()
    }

    private fun observeCompleteQuestList() {
        mainViewModel.questList.observe(viewLifecycleOwner) {
            completedQuestAdapter.completedList = it.toMutableList()
        }
    }
}