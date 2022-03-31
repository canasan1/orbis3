package com.example.myapplication.Product;


import com.example.myapplication.Env_Certicate.Env_Certificate;

import java.util.List;
import java.util.UUID;

public class Product {
    String id= UUID.randomUUID().toString();;
    String name;
    int score;
    String imagePath;
    String brand;
    String description;
    List<Env_Certificate> Env_Certicates;


    public Product() {
    }

    public Product(String id, String name, int score, String imagePath, String brand, String description, List<Env_Certificate> env_Certicates) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.imagePath = imagePath;
        this.brand = brand;
        this.description = description;
        Env_Certicates = env_Certicates;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public List<Env_Certificate> getEnv_Certicates() {
        return Env_Certicates;
    }

    public void setEnv_Certicates(List<Env_Certificate> env_Certicates) {
        Env_Certicates = env_Certicates;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                ", imagePath='" + imagePath + '\'' +
                ", brand='" + brand + '\'' +
                ", description='" + description + '\'' +
                ", Env_Certicates=" + Env_Certicates +
                '}';
    }
}
