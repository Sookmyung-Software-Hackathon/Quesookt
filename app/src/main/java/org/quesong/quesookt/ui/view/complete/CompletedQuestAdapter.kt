package org.quesong.quesookt.ui.view.complete

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.quesong.core.util.extension.setImgFilter30
import org.quesong.quesookt.R
import org.quesong.quesookt.data.local.model.QuestData
import org.quesong.quesookt.databinding.ItemCompletedQuestBinding
import org.quesong.quesookt.ui.view.complete.model.CompletedInfoData
import java.util.*

class CompletedQuestAdapter : RecyclerView.Adapter<CompletedQuestAdapter.CompletedQuestViewHolder>() {
    private val _completedList = mutableListOf<QuestData>()

    var completedList: MutableList<QuestData> = _completedList
        set(value){
            _completedList.clear()
            _completedList.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompletedQuestViewHolder {

        val binding = ItemCompletedQuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompletedQuestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompletedQuestViewHolder, position: Int) {
        holder.onBind(_completedList[position])
    }

    override fun getItemCount(): Int = completedList.size
    class CompletedQuestViewHolder(private val binding: ItemCompletedQuestBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(questData: QuestData){
            if(Random().nextInt(4) % 2 == 0)
                binding.noondozang.setImageResource(R.drawable.ic_thumb)
            else
                binding.noondozang.setImageResource(R.drawable.ic_snow)
            binding.ivQuest.setImgFilter30()
            binding.completedInfoData = CompletedInfoData(questData.title, questData.date, questData.imageUrl)
        }
    }
}