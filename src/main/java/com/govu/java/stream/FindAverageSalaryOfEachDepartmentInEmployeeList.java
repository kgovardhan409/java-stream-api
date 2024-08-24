package com.govu.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindAverageSalaryOfEachDepartmentInEmployeeList {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Govardhan", "9705547115", "IT", "Hindupur", 1485000L));
        employees.add(new Employee(2, "Archana", "9030129371", "HR", "Pydeti", 500000L));
        employees.add(new Employee(1, "Pavan", "9000722046", "IT", "Bangalore", 1400000L));
        employees.add(new Employee(1, "Vinoda", "6361798441", "Finance", "Somandepalli", 700000L));
        employees.add(new Employee(1, "Nagamani", "9704669439", "Finance", "K Narasapuram", 350000L));

        Map<String, Double> resultMap = findAverageSalaryBasedOnEmployeeDepartment(employees);
        System.out.println(resultMap);
    }

    static Map<String, Double> findAverageSalaryBasedOnEmployeeDepartment(List<Employee> employees){
        return employees.stream().
                collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
    }
}
