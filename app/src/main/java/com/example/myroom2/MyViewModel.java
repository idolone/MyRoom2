package com.example.myroom2;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private LiveData<List<Word>> allWordsLive;
    WordRepository wordRepository;
    public MyViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return wordRepository.getAllWordsLive();
    }

    public void insertWords(Word... words){
        wordRepository.insertWords(words);
    }

    public void updateWords(Word... words){
       wordRepository.updateWords(words);
    }
    public void delWords(Word... words){
       wordRepository.delWords(words);
    }

    public void clearWords(){
        wordRepository.clearWords();
    }
}
