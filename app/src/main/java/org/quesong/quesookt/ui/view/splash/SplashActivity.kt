package org.quesong.quesookt.ui.view.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import org.quesong.core.base.BindingActivity
import org.quesong.core.util.AnimationUtil.getFadeInAnim
import org.quesong.quesookt.R
import org.quesong.quesookt.data.local.QuesooktPreference
import org.quesong.quesookt.databinding.ActivitySplashBinding
import org.quesong.quesookt.ui.view.MainActivity
import org.quesong.quesookt.ui.view.onboard.OnboardActivity

class SplashActivity : BindingActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initTitleAnim()
        setHandler()
    }

    private fun initTitleAnim() {
        binding.tvTitle.startAnimation(getFadeInAnim())
    }


    private fun setHandler() {
        Handler(Looper.getMainLooper()).postDelayed({
            if (QuesooktPreference.getDormitoryExist())
                startActivity(Intent(this, MainActivity::class.java))
            else
                startActivity(Intent(this, OnboardActivity::class.java))
            finish()
        }, SPLASH_TIME)
    }

    companion object {
        const val SPLASH_TIME = 2500L
    }
}