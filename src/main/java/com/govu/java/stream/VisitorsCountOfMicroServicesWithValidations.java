package com.govu.java.stream;

import com.govu.java.stream.model.MicroService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class VisitorsCountOfMicroServicesWithValidations {
    public static void main(String[] args) {
        List<MicroService> microServiceList = new ArrayList<>();
        microServiceList.add(new MicroService("Product Service", "24"));
        microServiceList.add(new MicroService("Payment Service", "10"));
        microServiceList.add(new MicroService("Cart Service", "30"));
        microServiceList.add(new MicroService("Product Service", "40"));
        microServiceList.add(new MicroService("Cart Service", "24"));

        Map<String, Long> resultMap = visitorCountOfMicroservices(microServiceList);
        System.out.println(resultMap);
    }

    static Map<String, Long> visitorCountOfMicroservices(List<MicroService> microServiceList){
        // check whether value is parseble to long or not
        // check if the microservice name is empty or not
        // don't count the null values
       return microServiceList.stream()
                .filter(Objects::nonNull)
                .filter(microService -> !microService.getVisitorCount().isEmpty() && !microService.getVisitorCount().isBlank() && microService.getVisitorCount() != null)
                .filter(m -> isLong(m.getVisitorCount()))
                .collect(Collectors.groupingBy(MicroService::getName, Collectors.counting()));
    }

    private static boolean isLong(String s){
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }


}
