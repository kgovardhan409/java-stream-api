package com.govu.java.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOccurenceOfEachCharacterInString {
    public static void main(String[] args) {
        String str = "Ilovejava";
        Map<String, Long> map = findOccurenceOfCharacter(str);
        System.out.println(map);
    }

    private static Map<String, Long> findOccurenceOfCharacter(String str){

//       return str.chars().mapToObj(c -> (char) c)
//                .collect(Collectors.groupingBy(Function.identity(),
//                        Collectors.counting()));

        return Arrays.stream(str.split(""))
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
    }
}
