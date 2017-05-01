package com.ctinute.foody.models;

public class Type {
    private int id;
    private String name;
    private String image;
    private boolean newType;

    public Type() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isNewType() {
        return newType;
    }

    public void setNewType(boolean newType) {
        this.newType = newType;
    }
}
