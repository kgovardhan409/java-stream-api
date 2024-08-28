package com.govu.java.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class FindNthHighestInMap {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("anil", 1000);
        map1.put("bhavna", 1300);
        map1.put("micael", 1500);
        map1.put("tom", 1600);//output
        map1.put("ankit", 1200);
        map1.put("daniel", 1700);
        map1.put("james", 1400);

         Map.Entry<Integer, List<String>> results = getNthHighestSalary(1, map1);
        System.out.println(results);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("anil", 1000);
        map2.put("ankit", 1200);
        map2.put("bhavna", 1200);
        map2.put("james", 1200);
        map2.put("micael", 1000);
        map2.put("tom", 1300);
        map2.put("daniel", 1300);
        Map.Entry<Integer, List<String>> results2 = getNthHighestSalary(1, map2);
        System.out.println(results2);
    }

    static  Map.Entry<Integer, List<String>> getNthHighestSalary(Integer num, Map<String, Integer> map){

         return map.entrySet().stream()
                  .collect(Collectors.groupingBy(Map.Entry::getValue,
                          Collectors.mapping(Map.Entry::getKey,
                                  Collectors.toList())))
                  .entrySet().stream()
                  .sorted(Comparator.comparing(Map.Entry::getKey, Comparator.reverseOrder()))
                  .skip(num)
                  .findFirst()
                  .orElse(null);
    }
}
