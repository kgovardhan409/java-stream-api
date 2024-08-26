package com.govu.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindElmentsWhoStartWith1 {
    public static void main(String[] args) {
        int[] elements = {3, 9, 17, 14, 2, 11, 8};
        List<Integer> out = findElementWhoStartWith1(elements);
        System.out.println(out);
    }

    public static List<Integer> findElementWhoStartWith1(int[] elements) {
        return Arrays.stream(elements)
                .filter(s -> String.valueOf(s).startsWith("1"))
                .boxed()
                .collect(Collectors.toList());
    }
}
