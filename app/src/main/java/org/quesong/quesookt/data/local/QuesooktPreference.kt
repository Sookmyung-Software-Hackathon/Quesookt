package org.quesong.quesookt.data.local

import android.content.Context
import android.content.SharedPreferences

object QuesooktPreference {
    private const val NICKNAME = "NICKNAME"
    private const val DORMITORY = "DORMITORY"
    private const val IS_FIRST_VISIT = "IS_FIRST_VISIT"
    private const val IS_DORMITORY_EXIST = "IS_DORMITORY_EXIST"
    private const val SCORE = "SCORE"

    lateinit var preferences: SharedPreferences

    fun init(context: Context) {
        preferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }

    fun getNickname(): String {
        return preferences.getString(NICKNAME, "") ?: ""
    }

    fun getDormitory(): String {
        return preferences.getString(DORMITORY, "") ?: ""
    }

    fun setNickname(value: String) {
        preferences.edit().putString(NICKNAME, value).apply()
    }

    fun setDormitory(value: String) {
        preferences.edit().putString(DORMITORY, value).apply()
    }

    fun getFirstVisit(): Boolean {
        return preferences.getBoolean(IS_FIRST_VISIT, true)
    }

    fun setFirstVisit(value: Boolean) {
        preferences.edit().putBoolean(IS_FIRST_VISIT, value).apply()
    }

    fun getDormitoryExist(): Boolean {
        return preferences.getBoolean(IS_DORMITORY_EXIST, false)
    }

    fun setDormitoryExist(value: Boolean) {
        preferences.edit().putBoolean(IS_DORMITORY_EXIST, value).apply()
    }

    fun getScore() : Int {
        return preferences.getInt(SCORE, 0)
    }

    fun setScore(value: Int) {
        preferences.edit().putInt(SCORE, value).apply()
    }
}