package com.example.a2kquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.a2kquiz.databinding.ActivityQuestionBinding
import com.example.a2kquiz.models.Constants.getAllQuestions

class QuestionActivity : AppCompatActivity() {
    //We need to define binding view
    private lateinit var binding: ActivityQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //UPDATED: inflate
        binding = ActivityQuestionBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Get the extra from intent (Push/Parse the nickname to an activity)
        val nickname = intent.getStringExtra("nickname").toString()


        //Call for all my questions
        var questions = getAllQuestions()
        val currentQuestion = questions[3]
        Log.i("Question Count:", "${currentQuestion.questionText}")

        binding.tvQuestionText.text = "Greetings ${nickname}! Let's see how much of a 2kayer you are:" + "${currentQuestion.questionText}"
        binding.mbAnswerOne.text = currentQuestion.optionOne
        binding.mbAnswerTwo.text = currentQuestion.optionTwo
        binding.mbAnswerThree.text = currentQuestion.optionThree
        binding.mbAnswerFour.text = currentQuestion.optionFour
        binding.imgLewis.setImageResource(currentQuestion.icon)
//        val currentQuestion = question[0]
//            binding.tvQuestionText.text = "${questions[1].questionText}"
        //Not Needed any more but just incase
//        R.id.tv_question_text.setText(questions[0].questionText)

    // Uncommment this later if run with errors
//        binding.tvQuestionText.setText(questions[3].questionText)
    }
}