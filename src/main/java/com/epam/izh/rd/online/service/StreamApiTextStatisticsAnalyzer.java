package com.epam.izh.rd.online.service;

import com.epam.izh.rd.online.helper.Direction;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Данный класс обязан использовать StreamApi из функционала Java 8. Функциональность должна быть идентична
 * {@link SimpleTextStatisticsAnalyzer}.
 */
public class StreamApiTextStatisticsAnalyzer implements TextStatisticsAnalyzer {
    @Override
    public int countSumLengthOfWords(String text) {
        return getWords(text).stream().mapToInt((word)->word.length()).sum();
    }

    @Override
    public int countNumberOfWords(String text) {
        return getWords(text).size();
    }

    @Override
    public int countNumberOfUniqueWords(String text) {
        return getWords(text).stream().distinct().mapToInt(s -> 1).sum();
    }

    @Override
    public List<String> getWords(String text) {
        return Arrays.stream(text.split(REGEX))
                .collect(Collectors.toList());
    }

    @Override
    public Set<String> getUniqueWords(String text) {
        return getWords(text)
                .stream()
                .collect(Collectors.toSet());
    }

    @Override
    public Map<String, Integer> countNumberOfWordsRepetitions(String text) {
        return getWords(text)
                .stream()
                .collect(Collectors
                        .toMap(word->word, count->1, (firstValueByThisKey, otherValueByThisKey) -> firstValueByThisKey + otherValueByThisKey));
    }

    @Override
    public List<String> sortWordsByLength(String text, Direction direction) {
        return getWords(text)
                .stream()
                .sorted((s1,s2)->direction == Direction.ASC ? s1.length()-s2.length()
                        : (direction == Direction.DESC ? s2.length() - s1.length() : 0))
                .collect(Collectors.toList());
    }
}
