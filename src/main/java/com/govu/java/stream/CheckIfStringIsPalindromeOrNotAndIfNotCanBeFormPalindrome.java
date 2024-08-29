package com.govu.java.stream;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CheckIfStringIsPalindromeOrNotAndIfNotCanBeFormPalindrome {
    public static void main(String[] args) {
        String str = "gffaa";
        String reversed = new StringBuilder(str).reverse().toString();

        if (str.equals(reversed)) {
            System.out.println(true);
        } else {
            Long oddCount = Arrays.stream(str.split(""))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .values().stream()
                    .filter(e -> e % 2 != 0)
                    .count();

            if (oddCount <= 1) {
                System.out.println(true);
            } else {
                System.out.println(false);
            }
        }
    }
}
