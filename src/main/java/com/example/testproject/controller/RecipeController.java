package com.example.testproject.controller;

import com.example.testproject.model.Person;
import com.example.testproject.model.Recipes;
import com.example.testproject.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    // View recipe
    @GetMapping("/recipes")
    List<Recipes> getAllRecipes(){
        return recipeRepository.findAll();
    }

}
