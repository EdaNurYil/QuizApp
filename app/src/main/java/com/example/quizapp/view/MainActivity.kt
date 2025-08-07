package com.example.quizapp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.quizapp.R
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.model.Question
import com.example.quizapp.viewmodel.quizeViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var quizViewModel: quizeViewModel
    private lateinit var questionsList: List<Question>
    private var currentQuestionIndex = 0

    companion object {
        var result = 0
        var totalQuestions = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        result = 0
        totalQuestions = 0

        quizViewModel = ViewModelProvider(this)[quizeViewModel::class.java]

        quizViewModel.getQuestionsFromLiveData().observe(this@MainActivity) { questions ->
            if (!questions.isNullOrEmpty()) {
                questionsList = questions
                totalQuestions = questions.size
                displayQuestion(currentQuestionIndex)
            } else {
                binding.txtQuestion.text = "No questions received."
            }
        }

        binding.btnNext.setOnClickListener {
            val selectedId = binding.radioGroup.checkedRadioButtonId

            if (selectedId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                val selectedAnswer = selectedRadioButton.text.toString()
                val correctAnswer = questionsList[currentQuestionIndex].correct_option

                if (selectedAnswer == correctAnswer) {
                    result++
                    binding.resultTextView.text = "Correct!"
                } else {
                    binding.resultTextView.text = "Wrong! Correct: $correctAnswer"
                }

                currentQuestionIndex++

                if (currentQuestionIndex < questionsList.size) {
                    displayQuestion(currentQuestionIndex)
                    binding.radioGroup.clearCheck()
                } else {
                    // Go to result activity
                    val intent = Intent(this@MainActivity, ResultActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            } else {
                binding.resultTextView.text = "Please select an option."
            }
        }
    }

    private fun displayQuestion(index: Int) {
        val question = questionsList[index]
        binding.apply {
            txtQuestion.text = question.question
            radioButton1.text = question.option1
            radioButton2.text = question.option2
            radioButton3.text = question.option3
            radioButton4.text = question.option4
        }
    }
}
