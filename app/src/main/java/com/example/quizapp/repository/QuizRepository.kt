package com.example.quizapp.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.quizapp.model.QuestionsList
import com.example.quizapp.retrofit.QuestionsApi
import com.example.quizapp.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuizRepository {
    val questionsAPI: QuestionsApi

    init {
        questionsAPI = RetrofitInstance().getRetrofitInstance().create(QuestionsApi::class.java)

    }
    fun getQuestionsFromAPI(): LiveData<QuestionsList> {
        val data = MutableLiveData<QuestionsList>()

        GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = questionsAPI.getQuestions()
                if (response.isSuccessful && response.body() != null) {
                    data.postValue(response.body())
                    Log.i("TAGY", "Fetched data: ${response.body()}")
                } else {
                    Log.e("TAGY", "Failed to get response or body is null")
                }
            } catch (e: Exception) {
                Log.e("TAGY", "Exception occurred: ${e.message}")
            }
        }

        return data
    }
}