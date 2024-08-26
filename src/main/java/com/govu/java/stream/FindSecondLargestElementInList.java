package com.govu.java.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FindSecondLargestElementInList {
    public static void main(String[] args) {
        List<Integer> input1 = Arrays.asList(1,78, 32,90, 45, 12);
        Integer result = findSecondLargestElement(input1);
        System.out.println(result);
    }

    static Integer findSecondLargestElement(List<Integer> list){
        return list.stream()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
    }
}
