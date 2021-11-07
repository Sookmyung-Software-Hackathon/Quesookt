package org.quesong.quesookt.domain

import org.quesong.quesookt.data.local.model.QuestData

interface QuestRepository {
    fun getAll() : List<QuestData>

    fun insert(questData: QuestData)

    fun delete(questData: QuestData)
}