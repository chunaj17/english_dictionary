package com.example.englishdictionary.history

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.englishdictionary.db.HistoryWords
import com.example.englishdictionary.db.HistoryWordsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HistoryViewModel(private val database:HistoryWordsDao,
                       application: Application) : AndroidViewModel(application) {
   val words = database.getAllWord()
    fun deleteWord(word:HistoryWords){
        viewModelScope.launch(Dispatchers.IO) {
            database.deleteWord(word)
        }
    }
    fun deleteAllWord() {
        viewModelScope.launch(Dispatchers.IO) {
            database.deleteAllWord()
        }
    }
}