package com.example.myroom2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    private int Id;

    @ColumnInfo(name = "English")
    private String word;

    @ColumnInfo(name = "Chinese")
    private String chinese_meaning;

    public Word(String word, String chinese_meaning) {
        this.word = word;
        this.chinese_meaning = chinese_meaning;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChinese_meaning() {
        return chinese_meaning;
    }

    public void setChinese_meaning(String chinese_meaning) {
        this.chinese_meaning = chinese_meaning;
    }

    @Override
    public String toString() {
        return "Word{" +
                "Id=" + Id +
                ", word='" + word + '\'' +
                ", chinese_meaning='" + chinese_meaning + '\'' +
                '}';
    }


}
