package com.dicoding.englishbuddy.data

import com.dicoding.englishbuddy.R

object Constants {

    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWER: String = "correct_answers"

    fun getQuestions(): ArrayList<QuestionListening> {
        val questionsList = ArrayList<QuestionListening>()

        // 1
        val que1 = QuestionListening(
            1, "What time was it in Tokyo, when Yuki telephoned Mrs. Grey?",
            R.raw.aspose_audio_merger_133464407320845391,
            "3:00 PM", "3:00 AM",
            "7 o’clock in the morning", "7 o’clock at night", 2
        )

        questionsList.add(que1)

        // 2
        val que2 = QuestionListening(
            2, "What time was it in London, when Yuki telephoned Mrs. Grey?",
            R.raw.aspose_audio_merger_133464407320845391,
            "3:00 PM", "3:00 AM",
            "7 o’clock in the morning", "7 o’clock at night", 4
        )

        questionsList.add(que2)

        // 3
        val que3 = QuestionListening(
            3, "Who told Yuki about the right time to call English people?",
            R.raw.aspose_audio_merger_133464407320845391,
            "Maths teacher", "Science teacher",
            "Homestay officer", "English teacher", 4
        )

        questionsList.add(que3)

        // 4
        val que4 = QuestionListening(
            4, "What do people usually eat in London?",
            R.raw.aspose_audio_merger_133464407320845391,
            "Sushi", "Fish and chips",
            "Both A & B", "None of the above", 2
        )

        questionsList.add(que4)

        // 5
        val que5 = QuestionListening(
            5, "What do people usually eat in Tokyo?",
            R.raw.aspose_audio_merger_133464407320845391,
            "Sushi", "Fish and chips",
            "Both A & B", "None of the above", 1
        )

        questionsList.add(que5)

        // 6
        val que6 = QuestionListening(
            6, "The coelacanth was?",
            R.raw.section2,
            "well known to Indonesian fishermen", "unknown to Indonesian fishermen",
            "a first in the market", "revered in local folklore", 1
        )

        questionsList.add(que6)

        // 7
        val que7 = QuestionListening(
            7, "The only difference between the Comoros coelacanth and the Sulawesi coelacanth is?",
            R.raw.section2,
            "their intracranial joint", "their paired fins",
            "their colour", "their genetic makeup", 3
        )

        questionsList.add(que7)

        // 8
        val que8 = QuestionListening(
            8, "Coelacanths seemed to have their greatest population?",
            R.raw.section2,
            "360 million years ago", "240 million years ago",
            "80 million years ago", "during the Jurassic period", 2
        )

        questionsList.add(que8)

        // 9
        val que9 = QuestionListening(
            9, "Modern coelacanths probably left no fossilized remains over the past 80 million years because?",
            R.raw.section2,
            "of too much clay sediment", "conditions where they lived were not favorable for fossilization",
            "volcanoes are needed for fossilization.", "they decayed rapidly after death", 2
        )

        questionsList.add(que9)

        // 10
        val que10 = QuestionListening(
            10, "Scientists had a better understanding of the coelacanth after 1991 because?",
            R.raw.section2,
            "The French government had previously limited study on the Comoros coelacanth", "Comoros were far away and difficult to reach.",
            "Comoros opened an airport", "significant research expeditions were conducted", 1
        )

        questionsList.add(que10)

        return questionsList
    }
    // END
    var MAX_PROGRESS_VALUE = 10
}