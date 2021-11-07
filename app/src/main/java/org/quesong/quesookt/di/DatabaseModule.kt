package org.quesong.quesookt.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import org.quesong.quesookt.data.local.dao.QuestDao
import org.quesong.quesookt.data.local.database.LocalDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideLocalDatabase(@ApplicationContext context: Context): LocalDatabase =
        Room.databaseBuilder(
            context,
            LocalDatabase::class.java,
            "local database"
        ).fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideQuestDao(database: LocalDatabase): QuestDao = database.questDao
}