package com.govu.java.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindRepeatedWordInSentense {
    public static void main(String[] args) {
        String str = "I am a java developer and I am proud of it";
        Set<String> repeatedWords = findRepeatedWordInGivenSentense(str);
        System.out.println(repeatedWords);
    }

    static Set<String> findRepeatedWordInGivenSentense(String str){
        List<String> words = Arrays.asList(str.split(" "));
        return words.stream()
                .filter(s -> Collections.frequency(words, s) > 1)
                .collect(Collectors.toSet());
    }
}
