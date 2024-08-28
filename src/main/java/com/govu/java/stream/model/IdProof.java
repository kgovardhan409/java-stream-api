package com.govu.java.stream.model;

public class IdProof {
    private String name;
    private String number;

    public IdProof(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "IdProof{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
