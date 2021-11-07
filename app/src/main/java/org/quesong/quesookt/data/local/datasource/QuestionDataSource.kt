package org.quesong.quesookt.data.local.datasource

import org.quesong.quesookt.data.local.model.QuestionData

interface QuestionDataSource {
    fun getQuestionData() : List<QuestionData>
}