package com.govu.java.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDupicateInNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(12, 53, 12, 56, 42, 12, 89, 98, 56, 56);
        Set<Integer> result = findDuplicateInNumbers(numbers);
        System.out.println(result);
    }

    static Set<Integer> findDuplicateInNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(n -> Collections.frequency(numbers, n)> 1)
                .collect(Collectors.toSet());
    }

}
