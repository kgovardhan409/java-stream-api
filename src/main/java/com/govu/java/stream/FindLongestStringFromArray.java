package com.govu.java.stream;

import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindLongestStringFromArray {
    public static void main(String[] args) {
        List<String> list = List.of("java", "spring", "docker amazon aws", "springboot", "microservices");
        String result = findLongestString(list);
        System.out.println(result);
    }

    public static String findLongestString(List<String> words){
        return words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1:word2)
                .get();
    }
}
