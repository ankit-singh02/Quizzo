package com.example.quizapp

object Constants {

    const val USER_NAME: String="user_name"
    const val TOTAL_QUESTION:String="total_question"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()

        val que1=Question(1,
            "What Country does this Flag belongs to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questionsList.add(que1)

        val que2=Question(2,
            "What Country does this Flag belongs to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Armenia",
            "Netherlands",
            2
        )
        questionsList.add(que2)

        val que3=Question(3,
            "What Country does this Flag belongs to?",
            R.drawable.ic_flag_of_belgium,
            "Argentina",
            "Belgium",
            "Bulgaria",
            "Austria",
            2
        )
        questionsList.add(que3)

        val que4=Question(4,
            "What Country does this Flag belongs to?",
            R.drawable.ic_flag_of_brazil,
            "Argentina",
            "Puerto Rico",
            "Armenia",
            "Brazil",
            4
        )
        questionsList.add(que4)

        val que5=Question(5,
            "What Country does this Flag belongs to?",
            R.drawable.ic_flag_of_india,
            "India",
            "Ireland",
            "Armenia",
            "Sweden",
            1
        )
        questionsList.add(que5)

        val que6=Question(6,
            "What Country does this Flag belongs to?",
            R.drawable.ic_flag_of_denmark,
            "Kenya",
            "Sweden",
            "Denmark",
            "England",
            3
        )
        questionsList.add(que6)

        val que7=Question(7,
            "What Country does this Flag belongs to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "South Africa",
            "North Korea",
            "South Korea",
            1
        )
        questionsList.add(que7)

        val que8=Question(8,
            "What Country does this Flag belongs to?",
            R.drawable.ic_flag_of_kuwait,
            "Algeria",
            "Sudan",
            "Kuwait",
            "United Arab Emirates",
            3
        )
        questionsList.add(que8)

        val que9=Question(9,
            "What Country does this Flag belongs to?",
            R.drawable.ic_flag_of_fiji,
            "Fiji",
            "United Kingdom",
            "Armenia",
            "Somalia",
            1
        )
        questionsList.add(que9)

        val que10=Question(10,
            "What Country does this Flag belongs to?",
            R.drawable.ic_flag_of_new_zealand,
            "Britain",
            "Australia",
            "United States of America",
            "New Zealand",
            4
        )
        questionsList.add(que10)

        return questionsList
    }
}