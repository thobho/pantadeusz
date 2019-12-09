package com.sda;

import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PanTadeuszWordCounter2 {
    public static void main(String[] args) {

        String panTadeuszFullText = TextUtils.readBook("pantadeusz.txt");

        List<String> panTadeuszWords = TextUtils.clearData(panTadeuszFullText);

        List<WordWithCount> listCounts = createListCounts(panTadeuszWords);

        showResults(listCounts);
    }

    private static void showResults(List<WordWithCount> wordWithCounts) {
        for (WordWithCount wordWithCount : wordWithCounts) {
            System.out.printf("%s -> %d\n", wordWithCount.getWord(), wordWithCount.getCount());
        }
    }

    private static List<WordWithCount> createListCounts(List<String> panTadeuszWords) {
        List<WordWithCount> wordWithCounts = new ArrayList<>();

        for (String panTadeuszWord : panTadeuszWords) {
            SleepUtil.sleepThread();
            WordWithCount wordInList = findWordInList(wordWithCounts, panTadeuszWord);
            if (wordInList != null) {
                wordInList.increment();
            } else {
                wordWithCounts.add(new WordWithCount(panTadeuszWord));
            }
        }
        wordWithCounts.sort(new WordWithCountComparator());
        return wordWithCounts;
    }

    private static WordWithCount findWordInList(List<WordWithCount> list, String word) {
        for (WordWithCount wordWithCount : list) {
            if (wordWithCount.hasWord(word)) {
                return wordWithCount;
            }
        }
        return null;
    }
}
