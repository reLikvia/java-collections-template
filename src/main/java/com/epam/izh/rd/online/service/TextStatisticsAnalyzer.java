package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public interface TextStatisticsAnalyzer {
    static final String REGEX = "[^a-zA-Zа-яА-Я]+";

    int countSumLengthOfWords(String text);

    int countNumberOfWords(String text);

    int countNumberOfUniqueWords(String text);

    List<String> getWords(String text);

    Set<String> getUniqueWords(String text);

    Map<String, Integer> countNumberOfWordsRepetitions(String text);

    List<String> sortWordsByLength(String text, Direction direction);
}
