package com.govu.java.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFirstNonRepeatedElementFromString {
    public static void main(String[] args) {
        String response = findFirstNonRepeatedElementFromString("ilovejavalearning");
        System.out.println(response);
    }

    public static String findFirstNonRepeatedElementFromString(String word){
        return Arrays.stream(word.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElseThrow();

    }
}
