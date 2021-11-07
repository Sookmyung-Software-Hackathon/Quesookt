package org.quesong.quesookt.data.local.model

data class QuestionData(
    val question : String,
    val answerList : List<Answer>
) {
    data class Answer(
        val title : String,
        val scoreList : List<Int>
    )
}
