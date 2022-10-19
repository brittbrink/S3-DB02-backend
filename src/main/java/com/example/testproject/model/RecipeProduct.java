package com.example.testproject.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class RecipeProduct {

    private Integer Amount;

    @ManyToOne
    @JoinColumn(name = "products_id")
    private Products products;
}
