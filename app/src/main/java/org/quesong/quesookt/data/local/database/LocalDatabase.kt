package org.quesong.quesookt.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import org.quesong.quesookt.data.local.dao.QuestDao
import org.quesong.quesookt.data.local.model.QuestData

@Database(entities = [QuestData::class], version = 1)
abstract class LocalDatabase: RoomDatabase() {
    abstract val questDao: QuestDao
}