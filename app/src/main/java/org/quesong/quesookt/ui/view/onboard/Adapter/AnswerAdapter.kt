package org.quesong.quesookt.ui.view.onboard.Adapter

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.quesong.quesookt.data.local.model.QuestionData
import org.quesong.quesookt.databinding.ItemQuestionBinding

class AnswerAdapter : RecyclerView.Adapter<AnswerAdapter.AnswerViewHolder>() {
    private var itemClickListener: ((List<Int>) -> Unit)? = null
    private var isSelectedViewType = 0
    private val _data = mutableListOf<QuestionData.Answer>()
    var data: List<QuestionData.Answer> = _data
        set(value) {
            _data.clear()
            _data.addAll(value)
            notifyDataSetChanged()
        }

    fun setItemViewType(type: Int) {
        isSelectedViewType = type
    }

    override fun getItemViewType(position: Int): Int {
        return isSelectedViewType
    }

    fun setItemClickListener(listener: (List<Int>) -> Unit) {
        this.itemClickListener = listener
    }

    override fun getItemCount(): Int = _data.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val binding: ItemQuestionBinding = ItemQuestionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )

        return AnswerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        holder.bind(_data[position])
    }

    inner class AnswerViewHolder(private val binding: ItemQuestionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: QuestionData.Answer) {
            binding.tvAnswer.text = data.title
            binding.tvAnswer.setOnClickListener {
                it.isSelected = true
                Handler(Looper.getMainLooper()).postDelayed({
                    it.isSelected = false
                    itemClickListener?.invoke(data.scoreList)
                }, SHOW_TIME)
            }
        }
    }

    companion object {
        const val SHOW_TIME = 500L
    }
}