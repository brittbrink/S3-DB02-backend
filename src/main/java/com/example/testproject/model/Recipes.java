package com.example.testproject.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.ArrayList;

@Entity
public class Recipes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Kcal")
    private String kcal;

    @ElementCollection
    @JoinTable(name = "RecipeProduct")
    private Collection<RecipeProduct> listOfRecipeProduct = new ArrayList<RecipeProduct>();

  // getters
    public Long getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getKcal() {
        return kcal;
    }
    public Collection<RecipeProduct> getListOfRecipeProduct() {
        return listOfRecipeProduct;
    }

  // setters
    public void setID(Long ID) {
        this.ID = ID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setKcal(String kcal) {
        this.kcal = kcal;
    }
    public void setListOfRecipeProduct(Collection<RecipeProduct> listOfRecipeProduct) {
        this.listOfRecipeProduct = listOfRecipeProduct;
    }
}
