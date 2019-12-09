package com.sda;

import java.util.Objects;

public class WordWithCount {

    private final String word;
    private int count;

    WordWithCount(String word) {
        this.word = word;
        this.count = 1;
    }

    boolean hasWord(String word) {
        return this.word.equals(word);
    }

    void increment() {
        this.count++;
    }

    int getCount() {
        return count;
    }

    public String getWord() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordWithCount that = (WordWithCount) o;
        return Objects.equals(word, that.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
