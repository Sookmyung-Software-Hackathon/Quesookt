package org.quesong.quesookt.ui.view.quest.model

data class ResponseQuestData (
        val description: String = "",
        val imgUrl: String = "",
        val isStarted: Int = 0,
        val people: Int = 5,
        val progress: Int = 50,
        val state: String = "",
        val tip: String = "",
        val title: String = ""
        )
