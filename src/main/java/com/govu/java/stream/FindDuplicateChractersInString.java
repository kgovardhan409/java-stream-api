package com.govu.java.stream;

import java.util.*;
import java.util.function.Function;
import java.util.logging.Filter;
import java.util.stream.Collectors;

public class FindDuplicateChractersInString {
    public static void main(String[] args) {
        String message = "ilovejava";
        Set<String> result = finDuplicateChractersInString(message);
        System.out.println(result);
    }

    public static Set<String> finDuplicateChractersInString(String message){
        return Arrays.stream(message.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        // for unique elements
//        .filter(m -> getValue() == 1)
    }
}

//        return characters.stream()
//                .filter(c -> Collections.frequency(characters, c) > 1)
//                .collect(Collectors.toSet());