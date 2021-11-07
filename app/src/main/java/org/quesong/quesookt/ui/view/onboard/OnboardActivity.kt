package org.quesong.quesookt.ui.view.onboard

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import org.quesong.core.base.BindingActivity
import org.quesong.core.util.DialogUtil
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.ActivityOnboardBinding
import org.quesong.quesookt.databinding.LayoutQuesooktDialogBinding

@AndroidEntryPoint
class OnboardActivity : BindingActivity<ActivityOnboardBinding>(R.layout.activity_onboard) {
    private lateinit var quitDialog: Dialog
    private lateinit var quitDialogBinding: LayoutQuesooktDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initDialogDataBinding()
        initDialog()
        initClickEvent()
    }

    private fun initClickEvent() {
        quitDialogBinding.apply {
            clNext.setOnClickListener {
                quitDialog.dismiss()
                finish()
            }
            clQuit.setOnClickListener {
                quitDialog.dismiss()
            }
        }
    }

    private fun initDialog() {
        quitDialog = DialogUtil.makeDialog(this)

        DialogUtil.setDialog(quitDialog, quitDialogBinding.root)
    }

    private fun initDialogDataBinding() {
        quitDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this),
            R.layout.layout_quesookt_dialog,
            null,
            false
        )
    }

    override fun onBackPressed() {
        quitDialog.show()
    }
}
