package org.quesong.quesookt.data.local.datasource

import org.quesong.quesookt.data.local.model.QuestionData

class LocalQuestionDataSource : QuestionDataSource {
    override fun getQuestionData(): List<QuestionData> = listOf(
        QuestionData(
            "오늘은 팀플 과제가 있는 날. 당신이라면 어떤 역할을 맡으시겠습니까?",
            listOf(
                QuestionData.Answer("선배를 만나 인터뷰하기", listOf(0, 5, 0, 0)),
                QuestionData.Answer("팀플을 할만한 좋은 카페 장소 찾기", listOf(0, 0, 0, 3)),
                QuestionData.Answer("꼼꼼한 자료 조사", listOf(3, 0, 0, 0)),
                QuestionData.Answer("팀플 분위기 메이커", listOf(0, 0, 5, 0))
            )
        ),
        QuestionData(
            "오늘은 숙명인의 밤. 당신이라면 어떤 코너를 가장 즐기시겠습니까?",
            listOf(
                QuestionData.Answer("선배와의 간담회", listOf(3, 5, 0, 0)),
                QuestionData.Answer("맛있는 뷔페 먹기", listOf(0, 0, 0, 3)),
                QuestionData.Answer("동기들과 함께 하는 게임 시간", listOf(0, 0, 3, 0))
            )
        ),
        QuestionData(
            "오늘은 교수님과의 면담 시간. 당신이라면 어떤 반응?",
            listOf(
                QuestionData.Answer("교수님과의 면담이라니 설렌다!", listOf(0, 3, 3, 0)),
                QuestionData.Answer("교수님과의 면담, 나한테는 너무 부담스러워", listOf(3, 0, 0, 5))
            )
        ),
        QuestionData(
            "어느날 공강 시간이 생긴 당신 어떤 일을 하면서 시간을 보내시겠습니까?",
            listOf(
                QuestionData.Answer("도서관이나 빈 강의실에서 공부하기", listOf(5, 0, 0, 0)),
                QuestionData.Answer("소파에서 혼자 휴식을 취하거나 잠자기", listOf(0, 0, 0, 5)),
                QuestionData.Answer("공강인 친구들 만나서 수다떨기", listOf(0, 3, 3, 0))
            )
        ),
        QuestionData(
            "시험 기간, 당신의 공부 스타일은?",
            listOf(
                QuestionData.Answer("도서관에서 공부하기", listOf(3, 0, 0, 0)),
                QuestionData.Answer("카페에서 공부하기", listOf(0, 0, 0, 3)),
                QuestionData.Answer("친구들과 대화하며 공부하기", listOf(0, 0, 3, 0)),
                QuestionData.Answer("선배에게 족보부터 얻기", listOf(0, 7, 0, 0))
            )
        ),
        QuestionData(
            "과방에서 당신은 어떤 사람인가요?",
            listOf(
                QuestionData.Answer("동기들과 떠드는 사람", listOf(0, 0, 3, 0)),
                QuestionData.Answer("과제를 하는 사람", listOf(3, 0, 0, 0)),
                QuestionData.Answer("간식을 먹는 사람", listOf(0, 0, 0, 3)),
                QuestionData.Answer("스노웨이 비교과 찾는 사람", listOf(0, 5, 0, 0))
            )
        ),
        QuestionData(
            "시간표 짜기",
            listOf(
                QuestionData.Answer("인생은 혼자! 내가 듣고 싶은 수업을 듣는다", listOf(0, 0, 0, 5)),
                QuestionData.Answer("동기들과 같은 수업을 신청한다", listOf(0, 0, 5, 0)),
                QuestionData.Answer("먼 미래까지 내다보고 학점을 다 계산한다", listOf(5, 0, 0, 0)),
                QuestionData.Answer("선배에게 조언을 구한다", listOf(0, 7, 0, 0))
            )
        ),
        QuestionData(
            "선배와의 약속이 있는 당신 어떤 하루를 보내겠습니까?",
            listOf(
                QuestionData.Answer("학업, 진로 고민에 대해 얘기하기", listOf(5, 0, 0, 3)),
                QuestionData.Answer("취미를 공유하며 같이 놀기", listOf(0, 3, 5, 0))
            )
        )
    )
}