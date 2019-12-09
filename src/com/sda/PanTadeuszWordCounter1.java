package com.sda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class PanTadeuszWordCounter1 {

    public static void main(String[] args) {

        String panTadeuszFullText = TextUtils.readBook("pantadeusz.txt");

        List<String> panTadeuszWords = TextUtils.clearData(panTadeuszFullText);

        Map<String, Long> sortedWordsMap = countWord(panTadeuszWords);

        showResults(sortedWordsMap);

    }

    private static Map<String, Long> countWord(List<String> panTadeuszWords) {
        return panTadeuszWords.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting())) //grupowanie elementów listy
                .entrySet().stream()
                .peek(stringLongEntry -> SleepUtil.sleepThread())// "spowolnienie aplikacji"
                .sorted((first, second) -> (int) (second.getValue() - first.getValue())) //sorotowanie - tutaj komparator jest przedstawiony w postaci lambdy
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Long::sum, LinkedHashMap::new)); // LinkedHashMap potrafi przechowywać kolejność elementów
    }

    static void showResults(Map<String, Long> sortedWords) {
        sortedWords.forEach((key, value) -> System.out.printf("%s -> %d\n", key, value)); //metoda printf
    }

}
