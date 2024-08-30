package com.govu.java.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FindSecondLargestWordInSentense {
    public static void main(String[] args) {
        String message = "I Am A Good Programmer";

        Map.Entry<Integer, List<String>> out = Arrays.stream(message.split(" "))
                .toList().stream()
                .collect(Collectors.groupingBy(e -> e.length(), Collectors.toList()))
                .entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
                .skip(1)
                .findFirst().orElse(null);

        System.out.println(out.getValue().get(0));

    }
}
