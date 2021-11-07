package org.quesong.quesookt.ui.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.quesong.quesookt.data.local.QuesooktPreference
import org.quesong.quesookt.data.local.QuesooktPreference.setDormitoryExist
import org.quesong.quesookt.data.local.QuesooktPreference.setFirstVisit
import org.quesong.quesookt.data.local.datasource.QuestionDataSource
import javax.inject.Inject

@HiltViewModel
class OnboardViewModel @Inject constructor(private val questionDataSource: QuestionDataSource) :
    ViewModel() {
    private var result = JINRI

    private var _jinri = 0
    val jinri: Int
        get() = _jinri

    private var _sunheon = 0
    val sunheon: Int
        get() = _sunheon

    private var _prime = 0
    val prime: Int
        get() = _prime

    private var _renaissance = 0
    val renaissance: Int
        get() = _renaissance

    fun getQuestionData() = questionDataSource.getQuestionData()

    fun addJinri(score: Int) {
        _jinri += score
    }

    fun addSunheon(score: Int) {
        _sunheon += score
    }

    fun addPrime(score: Int) {
        _prime += score
    }

    fun addRenaissance(score: Int) {
        _prime += score
    }

    fun compareDormitory(): String {
        if (jinri < sunheon) {
            result = SUNHEON
            if (sunheon < prime) {
                result = PRIME
                if (prime < renaissance)
                    result = RENAISSANCE
            } else {
                if (sunheon < renaissance)
                    result = RENAISSANCE
            }
        } else {
            if (jinri < prime) {
                result = PRIME
                if (prime < renaissance)
                    result = RENAISSANCE
            } else {
                if (jinri < renaissance)
                    result = RENAISSANCE
            }
        }
        return result
    }

    fun setNickName(nickname: String) {
        QuesooktPreference.setNickname(nickname)
        setFirstVisit(false)
    }

    fun setDormitory(dormitory: String) {
        QuesooktPreference.setDormitory(dormitory)
        setDormitoryExist(true)
    }

    fun getFirstVisit(): Boolean = QuesooktPreference.getFirstVisit()

    companion object {
        const val JINRI = "진리 기숙사"
        const val SUNHEON = "순헌 기숙사"
        const val PRIME = "프라임 기숙사"
        const val RENAISSANCE = "르네상스 기숙사"
    }
}