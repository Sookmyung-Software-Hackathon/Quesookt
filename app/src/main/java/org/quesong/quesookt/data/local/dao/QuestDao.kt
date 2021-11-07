package org.quesong.quesookt.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import org.quesong.quesookt.data.local.model.QuestData

@Dao
interface QuestDao {
    @Query("SELECT * FROM quest_data_table")
    fun getAll(): List<QuestData>

    @Insert
    fun insert(questData: QuestData)

    @Delete
    fun delete(questData: QuestData)
}