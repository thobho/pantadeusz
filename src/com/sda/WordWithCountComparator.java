package com.sda;

import java.util.Comparator;

public class WordWithCountComparator implements Comparator<WordWithCount> {
    @Override
    public int compare(WordWithCount o1, WordWithCount o2) {
        return o2.getCount() - o1.getCount();
    }
}
