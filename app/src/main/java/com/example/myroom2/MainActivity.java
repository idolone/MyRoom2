package com.example.myroom2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   WordDatabase wordDatabase;
   WordDao wordDao;

   Button buttonAdd,buttonUpdate,buttonDel,buttonClear;
   TextView textView;
  // LiveData<List<Word>>  allWordsLive;
   MyViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        wordDatabase = Room.databaseBuilder(this,WordDatabase.class,"word_db")
//                       .allowMainThreadQueries()
//                       .build();
        viewModel = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this))
                        .get(MyViewModel.class);
        wordDatabase = WordDatabase.getInstance(this);
        wordDao = wordDatabase.getWordDao();

        //allWordsLive = wordDao.getAllWordsLive();

        initData();
//        updateView();
       viewModel.getAllWordsLive().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuffer text = new StringBuffer();
                for (int i = 0; i < words.size(); i++) {
                  text.append( words.get(i).toString()).append("\n");
                }
                textView.setText(text);
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Word word1 = new Word("Hello","nihao ");
                Word word2 = new Word("World","shijie ");
               // wordDao.insertWords(word1,word2 );
               viewModel.insertWords(word1,word2);
//                updateView();

            }
        });

        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //   wordDao.deleteAll();
               // new ClearAsyncTask(wordDao).execute();
                viewModel.clearWords();
//               updateView();
            }
        });
    }

//    private void updateView() {
//        String text = "";
//        List<Word> list = wordDao.getAllWords();
//        for (int i = 0; i < list.size(); i++) {
//            Word word = list.get(i);
//            text += word.toString()+"\n";
//        }
//        textView.setText(text);
//    }

    private void initData() {
        textView = findViewById(R.id.textView);
        buttonAdd = findViewById(R.id.button);
        buttonUpdate = findViewById(R.id.button2);
        buttonDel = findViewById(R.id.button3);
        buttonClear = findViewById(R.id.button4);
    }

}