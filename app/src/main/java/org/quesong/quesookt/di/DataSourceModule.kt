package org.quesong.quesookt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.quesong.quesookt.data.local.datasource.LocalQuestionDataSource
import org.quesong.quesookt.data.local.datasource.QuestionDataSource
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun provideQuestionDataSource(): QuestionDataSource = LocalQuestionDataSource()
}