package org.quesong.quesookt.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.quesong.quesookt.data.local.model.QuestData
import org.quesong.quesookt.domain.QuestRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val questRepo: QuestRepository) :
    ViewModel() {
    private val _questList = MutableLiveData<List<QuestData>>()
    val questList: LiveData<List<QuestData>>
        get() = _questList

    fun insertQuestData(questData: QuestData) {
        CoroutineScope(Dispatchers.IO).launch {
            runCatching { questRepo.insert(questData) }
                .onSuccess {

                }
                .onFailure {
                    it.printStackTrace()
                }
        }
    }

    fun deleteQuestData(questData: QuestData) {
        CoroutineScope(Dispatchers.IO).launch {
            runCatching { questRepo.delete(questData) }
                .onSuccess {

                }
                .onFailure {
                    it.printStackTrace()
                }
        }
    }

    fun getAll() {
        CoroutineScope(Dispatchers.IO).launch {
            runCatching { questRepo.getAll() }
                .onSuccess {
                    _questList.postValue(it)
                }
                .onFailure {
                    it.printStackTrace()
                }
        }
    }
}