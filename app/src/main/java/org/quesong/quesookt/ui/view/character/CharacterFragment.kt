package org.quesong.quesookt.ui.view.character

import android.os.Bundle
import android.view.View
import org.quesong.core.base.BindingFragment
import org.quesong.quesookt.R
import org.quesong.quesookt.data.local.QuesooktPreference
import org.quesong.quesookt.databinding.FragmentCharacterBinding
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.JINRI
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.PRIME
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.RENAISSANCE
import org.quesong.quesookt.ui.viewmodel.OnboardViewModel.Companion.SUNHEON

class CharacterFragment : BindingFragment<FragmentCharacterBinding>(R.layout.fragment_character) {
    private var level: Int = 1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initCharacterInfoData()
    }

    private fun initCharacterInfoData() {
        with(binding) {
            with(QuesooktPreference) {
                characterInfoData = checkScore(getScore(), getNickname())
                when (getDormitory()) {
                    JINRI -> {
                        when (level) {
                            1 -> imgLnoonsong.setImageResource(R.drawable.img_jnoonsong1)
                            2 -> imgLnoonsong.setImageResource(R.drawable.img_jnoonsong2)
                            3 -> imgLnoonsong.setImageResource(R.drawable.img_jnoonsong3)
                            else -> imgLnoonsong.setImageResource(R.drawable.img_jnoonsong1)
                        }
                        clCharacterColor.setBackgroundResource(R.drawable.rectangle_fill_jinri_purple_20)
                    }
                    SUNHEON -> {
                        when (level) {
                            1 -> imgLnoonsong.setImageResource(R.drawable.img_snoonsong1)
                            2 -> imgLnoonsong.setImageResource(R.drawable.img_snoonsong2)
                            3 -> imgLnoonsong.setImageResource(R.drawable.img_snoonsong3)
                            else -> imgLnoonsong.setImageResource(R.drawable.img_snoonsong1)
                        }
                        clCharacterColor.setBackgroundResource(R.drawable.rectangle_fill_sunheon_green_20)
                    }
                    PRIME -> {
                        when (level) {
                            1 -> imgLnoonsong.setImageResource(R.drawable.img_pnoonsong1)
                            2 -> imgLnoonsong.setImageResource(R.drawable.img_pnoonsong2)
                            3 -> imgLnoonsong.setImageResource(R.drawable.img_pnoonsong3)
                            else -> imgLnoonsong.setImageResource(R.drawable.img_pnoonsong1)
                        }
                        clCharacterColor.setBackgroundResource(R.drawable.rectangle_fill_prime_red_20)
                    }
                    RENAISSANCE -> {
                        when (level) {
                            1 -> imgLnoonsong.setImageResource(R.drawable.img_lnoonsong1)
                            2 -> imgLnoonsong.setImageResource(R.drawable.img_lnoonsong2)
                            3 -> imgLnoonsong.setImageResource(R.drawable.img_lnoonsong3)
                            else -> imgLnoonsong.setImageResource(R.drawable.img_lnoonsong1)
                        }
                        clCharacterColor.setBackgroundResource(R.drawable.rectangle_fill_renaissance_yellow_20)
                    }
                    else -> {

                    }
                }

            }

        }
    }

    private fun checkScore(score: Int, name: String): CharacterInfoData {
        var progress: Int = 0
        var content: String = getString(R.string.level1)
        if (score < 100) {
            progress = score
            content = getString(R.string.level1)
        } else if (score < 200) {
            level = 2
            progress = score - 100
            content = getString(R.string.level2)
        } else {
            level = 3
            progress = score - 200
            content = getString(R.string.level3)
        }

        return CharacterInfoData(name, level.toString(), progress, content)
    }
}
