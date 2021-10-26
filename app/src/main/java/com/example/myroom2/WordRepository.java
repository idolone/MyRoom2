package com.example.myroom2;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

public class WordRepository {
    private LiveData<List<Word>> allWordsLive;
    private WordDao wordDao;

    public WordRepository(Context context) {
        WordDatabase wordDatabase = WordDatabase.getInstance(context.getApplicationContext());
        wordDao = wordDatabase.getWordDao();
        allWordsLive = wordDao.getAllWordsLive();
    }

    public LiveData<List<Word>> getAllWordsLive() {
        return allWordsLive;
    }

    public void insertWords(Word... words){
        new InsertAsyncTask(wordDao).execute(words);
    }

    public void updateWords(Word... words){
        new UpdateAsyncTask(wordDao).execute(words);
    }
    public void delWords(Word... words){
        new DelAsyncTask(wordDao).execute(words);
    }

    public void clearWords(){
        new ClearAsyncTask(wordDao).execute();
    }




    class InsertAsyncTask extends AsyncTask<Word,Void,Void> {
        private WordDao wordDao;

        public InsertAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            wordDao.insertWords(words);
            return null;
        }
    }
    class UpdateAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao wordDao;

        public UpdateAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            // wordDao.insertWords(words);
            return null;
        }
    }

    class DelAsyncTask extends AsyncTask<Word,Void,Void>{
        private WordDao wordDao;

        public DelAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }
        @Override
        protected Void doInBackground(Word... words) {
            // wordDao.insertWords(words);
            return null;
        }
    }

   static class ClearAsyncTask extends AsyncTask<Void,Void,Void>{
        private WordDao wordDao;

        public ClearAsyncTask(WordDao wordDao) {
            this.wordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordDao.deleteAll();
            return null;
        }
    }
}
