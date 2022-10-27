package ru.romanov.lab1.lab1.models;

public class Greeting {


    public Greeting() {
    }

    public Greeting(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}