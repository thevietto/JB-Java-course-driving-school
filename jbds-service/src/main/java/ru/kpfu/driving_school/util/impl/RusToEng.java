package ru.kpfu.driving_school.util.impl;

/**
 * Created by aleksandrpliskin on 18.03.16.
 */

class RusToEng {

    private final String[] _alpha = {"a", "b", "v", "g", "d", "e", "yo", "g", "z", "i", "y", "i",
            "k", "l", "m", "n", "o", "p", "r", "s", "t", "u",
            "f", "h", "tz", "ch", "sh", "sh", "'", "e", "yu", "ya"};


    String translate(String str) {
        str = str.toLowerCase();
        char[] chs = str.toCharArray();
        StringBuilder result = new StringBuilder("");
        for (char ch : chs) {
            String alpha = "абвгдеёжзиыйклмнопрстуфхцчшщьэюя";
            int k = alpha.indexOf(ch);
            if (k != -1)
                result.append(_alpha[k]);
            else {
                result.append(ch);
            }
        }
        return firstUpperCase(result.toString());
    }

    private String firstUpperCase(String word) {
        if (word == null || word.isEmpty()) return "";//или return word;
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }
}
