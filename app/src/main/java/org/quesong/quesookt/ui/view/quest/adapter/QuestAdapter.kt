package org.quesong.quesookt.ui.view.quest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.quesong.core.util.extension.setImgFilter30
import org.quesong.quesookt.databinding.ItemQuestBinding
import org.quesong.quesookt.ui.view.quest.model.QuestDetailInfoData
import org.quesong.quesookt.ui.view.quest.model.QuestInfoData
import org.quesong.quesookt.ui.view.quest.model.ResponseQuestData

class QuestAdapter : RecyclerView.Adapter<QuestAdapter.QuestViewHolder>() {
    private val _questList = mutableListOf<ResponseQuestData>()

    var questList: MutableList<ResponseQuestData> = _questList
        set(value) {
            _questList.clear()
            _questList.addAll(value)
            notifyDataSetChanged()
        }

    private var questClickListener: ((QuestDetailInfoData) -> Unit)? = null

    fun setQuestClickListener(listener: (QuestDetailInfoData) -> Unit) {
        questClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestViewHolder {
        val binding = ItemQuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuestViewHolder(binding)
    }

    override fun onBindViewHolder(holder: QuestViewHolder, position: Int) {
        holder.onBind(_questList[position])
    }

    override fun getItemCount(): Int = questList.size

    inner class QuestViewHolder(
        private val binding: ItemQuestBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(responseQuestData: ResponseQuestData) {
            with(responseQuestData){
                binding.questInfoData = QuestInfoData(title, description, people.toString(), state, progress, imgUrl)
                binding.ivQuest.setImgFilter30()
            }

            binding.clQuest.setOnClickListener {
                with(responseQuestData){
                    questClickListener?.invoke(QuestDetailInfoData(imgUrl, title, state, description, tip, isStarted))
                }
            }
        }
    }
}