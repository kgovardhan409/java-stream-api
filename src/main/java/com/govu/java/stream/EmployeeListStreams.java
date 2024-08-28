package com.govu.java.stream;

import com.govu.java.stream.model.Employee;
import com.govu.java.stream.model.IdProof;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeListStreams {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Govardhan", "9705547115", "IT", "Hindupur", 1485000L, List.of(new IdProof("Aadhar", "1234567890"), new IdProof("Pan", "BTRPG3456q"))));
        employees.add(new Employee(2, "Archana", "9030129371", "HR", "Pydeti", 500000L, List.of(new IdProof("Aadhar", "987654320"), new IdProof("Pan", "ABGPGE2345T"))));
        employees.add(new Employee(1, "Pavan", "9000722046", "IT", "Bangalore", 1400000L, List.of(new IdProof("Aadhar", "2342352423"), new IdProof("Pan", "GFDGER2423GFD"), new IdProof("Voter", "rgim122424313"))));
        employees.add(new Employee(1, "Vinoda", "6361798441", "Finance", "K Narasapuram", 700000L, List.of(new IdProof("Aadhar", "324523432"), new IdProof("Pan", "gfdg435324"))));
        employees.add(new Employee(1, "Nagamani", "9704669439", "Finance", "K Narasapuram", 350000L, List.of(new IdProof("Aadhar", "432424"), new IdProof("Pan", "fds3242"))));

        // 1. find employees whose salary is 5 lakh to 10 lakh
        Set<Employee> salaryInbetween = employees.stream()
                .filter(employee -> employee.getSalary() > 500000 && employee.getSalary() < 1000000)
                .collect(Collectors.toSet());
        System.out.println(salaryInbetween.toString());

        // 2. Employee whose address is K Narasapuram and sort by their name

        List<Employee> filteredSortedEmployees = employees.stream()
                .filter(employee -> employee.getAddress().equals("K Narasapuram"))
                .sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder()))
                .toList();
        //For descending order --> .sorted(Comparator.comparing(Employee::getName, Comparator.reverseOrder()))
        System.out.println(filteredSortedEmployees.toString());


        // 3. find all department names
        List<String> departmentNames = employees.stream()
                .map(Employee::getDepartment)
                .distinct()
                .toList();

        //another way with Set<String> --> .collect(Collectors.toSet());
        System.out.println(departmentNames);


        // 4. find all the aadhar card numbers
        List<String> aadharCardNumbers = employees.stream()
                .flatMap(employee -> employee.getIdProofList().stream())
                .filter(idProof -> idProof.getName().equals("Aadhar"))
                .map(IdProof::getNumber)
                .toList();

        System.out.println(aadharCardNumbers);


        // 5. find the department whose salary is maximum
        Map.Entry<String, Long> maximumSalaryDept =
                employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingLong(Employee::getSalary)))
                        .entrySet().stream()
                        .max(Comparator.comparing(e -> e.getValue())).orElse(null);
        System.out.println(maximumSalaryDept);


        // 6. find average salary of department
        Map<String, Double> aveageSalaryByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(aveageSalaryByDepartment);


        // 7. find the highest salary in each department
        Map<String, Optional<Employee>> highestSalaryInEachDepartment = employees.stream()
                .collect(
                        Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparing(Employee::getSalary)))
                );
        System.out.println(highestSalaryInEachDepartment);

        // 8. find the second average highest salary
        Employee employee = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                        .findFirst().get();

        System.out.println(employee);
    }
}
