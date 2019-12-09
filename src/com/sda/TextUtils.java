package com.sda;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

class TextUtils {

    static List<String> clearData(String bookText) {
        return Arrays.stream(bookText
                .replaceAll("[/.,;:!?]", "")
                .toLowerCase()
                .split(" "))
                .filter(word -> word.length() > 3)
                .collect(Collectors.toList());
    }

    static String readBook(String fileName) {
        File file = new File(fileName);

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku!");
        }

        List<String> listOfLines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            listOfLines.add(scanner.nextLine());
        }

        return String.join(" ", listOfLines);
    }
}
