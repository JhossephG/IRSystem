package com.jhogo.irsystem.model;

import javax.persistence.Entity;

@Entity
public class Food {
    private int order_id;
    private String name;
    private String expiryDate;
    private String ingredients;
    private String nutritionalInformation;
    private String foodType;
    private String storageInstructions;
    private String preparationInstructions;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getIngredients() {
        return ingredients;
    }
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    public String getNutritionalInformation() {
        return nutritionalInformation;
    }
    public void setNutritionalInformation(String nutritionalInformation) {
        this.nutritionalInformation = nutritionalInformation;
    }
    public String getFoodType() {
        return foodType;
    }
    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }
    public String getStorageInstructions() {
        return storageInstructions;
    }
    public void setStorageInstructions(String storageInstructions) {
        this.storageInstructions = storageInstructions;
    }
    public String getPreparationInstructions() {
        return preparationInstructions;
    }
    public void setPreparationInstructions(String preparationInstructions) {
        this.preparationInstructions = preparationInstructions;
    }
}
