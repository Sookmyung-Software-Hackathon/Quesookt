package org.quesong.quesookt.data.local.repository

import org.quesong.quesookt.data.local.dao.QuestDao
import org.quesong.quesookt.data.local.model.QuestData
import org.quesong.quesookt.domain.QuestRepository
import javax.inject.Inject

class QuestRepositoryImpl@Inject constructor(private val questDao: QuestDao) : QuestRepository {
    override fun getAll(): List<QuestData> = questDao.getAll()

    override fun insert(questData: QuestData) = questDao.insert(questData)

    override fun delete(questData: QuestData) = questDao.delete(questData)
}