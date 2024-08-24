package com.govu.java.stream;

public class Employee {
    private Integer id;
    private String name;
    private String mobileNumber;
    private String department;
    private String address;
    private Long salary;

    public Employee() {
    }

    public Employee(Integer id, String name, String mobileNumber, String department, String address, Long salary) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.department = department;
        this.address = address;
        this.salary = salary;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
}
