package com.example.oblig1;

public class Image {
    private String name;
    private int id;

    public Image(String n, int i){
        this.name = n;
        this.id = i;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
