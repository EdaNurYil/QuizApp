package com.example.quizapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.quizapp.model.QuestionsList
import com.example.quizapp.repository.QuizRepository

class quizeViewModel : ViewModel() {

    private val repository = QuizRepository()
    private val questionsLiveData: LiveData<QuestionsList> = repository.getQuestionsFromAPI()

    fun getQuestionsFromLiveData(): LiveData<QuestionsList> {
        return questionsLiveData
    }
}
