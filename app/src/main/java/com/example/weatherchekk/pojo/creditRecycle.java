package com.example.weatherchekk.pojo;

public class creditRecycle {
    /**
     * getters and setters for the credits page
     * @author - Yash Kumar
     *
     */
    private  String name;
    private String description;


    public creditRecycle(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

