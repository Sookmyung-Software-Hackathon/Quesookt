package org.quesong.quesookt.ui.view

import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import org.quesong.core.base.BindingActivity
import org.quesong.core.util.extension.replace
import org.quesong.quesookt.R
import org.quesong.quesookt.databinding.ActivityMainBinding
import org.quesong.quesookt.ui.view.character.CharacterFragment
import org.quesong.quesookt.ui.view.complete.CompleteFragment
import org.quesong.quesookt.ui.view.quest.QuestFragment

@AndroidEntryPoint
class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val characterFragment: CharacterFragment by lazy { CharacterFragment() }
    private val questFragment: QuestFragment by lazy { QuestFragment() }
    private val completeFragment: CompleteFragment by lazy { CompleteFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initSelectMenu()
        replaceQuestFragment()
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        binding.bnvMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_character -> {
                    replaceCharacterFragment()
                    return@setOnItemSelectedListener true
                }
                R.id.menu_quest -> {
                    replaceQuestFragment()
                    return@setOnItemSelectedListener true
                }
                else -> {
                    replaceCompleteFragment()
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    private fun initSelectMenu() {
        binding.bnvMain.selectedItemId = R.id.menu_quest
    }

    private fun replaceCharacterFragment() {
        replace(R.id.container_main, characterFragment)
    }

    private fun replaceQuestFragment() {
        replace(R.id.container_main, questFragment)
    }

    private fun replaceCompleteFragment() {
        replace(R.id.container_main, completeFragment)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}
