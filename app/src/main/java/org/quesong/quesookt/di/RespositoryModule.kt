package org.quesong.quesookt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.quesong.quesookt.data.local.dao.QuestDao
import org.quesong.quesookt.data.local.repository.QuestRepositoryImpl
import org.quesong.quesookt.domain.QuestRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RespositoryModule {
    @Provides
    @Singleton
    fun questRepo(
        questDao: QuestDao
    ) : QuestRepository = QuestRepositoryImpl(questDao)
}