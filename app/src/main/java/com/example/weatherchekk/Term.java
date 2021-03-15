package com.example.weatherchekk;


public class Term {
    private int name;
    private  String description;

    public Term(int name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
