package org.quesong.quesookt.ui.view.quest

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.quesong.core.base.BindingActivity
import org.quesong.core.util.AnimationUtil.setProgressAnimation
import org.quesong.core.util.CalendarUtil.convertCalendarToString
import org.quesong.core.util.DialogUtil
import org.quesong.core.util.StatusBarUtil.setStatusBarColor
import org.quesong.core.util.extension.setImgFilter20
import org.quesong.quesookt.R
import org.quesong.quesookt.data.local.QuesooktPreference
import org.quesong.quesookt.data.local.model.QuestData
import org.quesong.quesookt.databinding.ActivityQuestDetailBinding
import org.quesong.quesookt.databinding.LayoutQuesooktDialogBinding
import org.quesong.quesookt.ui.view.quest.model.QuestDetailInfoData
import org.quesong.quesookt.ui.viewmodel.MainViewModel
import java.util.*

@AndroidEntryPoint
class QuestDetailActivity :
    BindingActivity<ActivityQuestDetailBinding>(R.layout.activity_quest_detail) {
    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var trashDialog: Dialog
    private lateinit var trashDialogBinding: LayoutQuesooktDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initQuestDetailInfoData()
        initBackBtnClickListener()
        initTrashBtnClickListener()
        initStateBtnClickListener()
        initDialogDataBinding()
        initDialog()
        setDialog()
        initClickEvent()
        setStatusBarColor(ContextCompat.getColor(this, R.color.black))
    }

    private fun initQuestDetailInfoData() {
        with(intent) {
            with(binding) {
                questDetailInfoData = QuestDetailInfoData(
                    getStringExtra("imgUrl").toString(), getStringExtra("title").toString(),
                    getStringExtra("state").toString(), getStringExtra("description").toString(),
                    getStringExtra("tip").toString(), 0
                )
                ivQuest.setImgFilter20()
                when (getIntExtra("isStarted", START)) {
                    START -> {
                        setProgressAnimation(binding.pbQuest, 0)
                        btnQuestState.text = "시작하기"
                    }
                    ING -> {
                        setProgressAnimation(binding.pbQuest, 50)
                        btnQuestState.text = "완료하기"
                    }
                    else -> {

                    }
                }
            }
        }
    }

    private fun initStateBtnClickListener() {
        with(binding) {
            btnQuestState.setOnClickListener {
                when (btnQuestState.text) {
                    getString(R.string.start) -> {
                        setProgressAnimation(pbQuest, 50)
                        btnQuestState.text = getString(R.string.finish_quest)
                    }
                    getString(R.string.finish_quest) -> {
                        //항목 삭제
                        intent.apply {
                            mainViewModel.insertQuestData(
                                QuestData(
                                    null,
                                    getStringExtra("title").toString(),
                                    convertCalendarToString(
                                        Calendar.getInstance(Locale.KOREA)
                                    ),
                                    getStringExtra("imgUrl").toString()
                                )
                            )
                            QuesooktPreference.setScore(QuesooktPreference.getScore() + 40)
                            finish()
                        }
                    }
                }
            }
        }
    }

    private fun initBackBtnClickListener() {
        binding.ivArrowBack.setOnClickListener {
            finish()
        }
    }

    private fun initTrashBtnClickListener() {
        binding.ivTrash.setOnClickListener {
            trashDialog.show()
        }
    }

    private fun initClickEvent() {
        trashDialogBinding.apply {
            clNext.setOnClickListener {
                trashDialog.dismiss()
                finish()
            }
            clQuit.setOnClickListener {
                trashDialog.dismiss()
            }
        }
    }

    private fun initDialog() {
        trashDialog = DialogUtil.makeDialog(this)

        DialogUtil.setDialog(trashDialog, trashDialogBinding.root)
    }

    private fun initDialogDataBinding() {
        trashDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this),
            R.layout.layout_quesookt_dialog,
            null,
            false
        )
    }

    private fun setDialog() {
        trashDialogBinding.apply {
            tvNext.text = getString(R.string.accept)
            tvContent.text = getString(R.string.delete_desc)
            tvTitle.text = getString(R.string.delete_sure)
        }
    }

    companion object {
        const val START = 0
        const val ING = 1
    }
}