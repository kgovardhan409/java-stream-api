package com.govu.java.stream.model;

public class MicroService {
    private Long id;
    private String name;
    private String visitorCount;

    public MicroService(String name, String visitorCount) {
        this.name = name;
        this.visitorCount = visitorCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVisitorCount() {
        return visitorCount;
    }

    public void setVisitorCount(String visitorCount) {
        this.visitorCount = visitorCount;
    }
}
