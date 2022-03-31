package com.example.myapplication.Env_Certicate;

import java.util.UUID;

public class Env_Certificate {
    String id= UUID.randomUUID().toString();;
    String name;
    String description;
    String imagePath;
    int rank;

    public Env_Certificate(String id, String name, String description, String imagePath, int rank) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imagePath = imagePath;
        this.rank = rank;
    }

    public Env_Certificate() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
