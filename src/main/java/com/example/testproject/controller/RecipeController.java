package com.example.testproject.controller;


import com.example.testproject.model.Recipes;
import com.example.testproject.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello World";
    }

    @GetMapping(value = "/testen/api")
    private String GetTestApi(){
        String uri="http://localhost:8080/hello";
        RestTemplate restTemplate = new RestTemplate();
        String result= restTemplate.getForObject(uri, String.class);
        return result;
    }

    @GetMapping(value = "/testrecipes")
    public List<Object> GetRecipesTest(){
        String url= "https://api.spoonacular.com/recipes/findByNutrients?maxCalories=2000&number=7&apiKey=972014c421004f89861d4cf91103d355";
        RestTemplate restTemplate = new RestTemplate();
        Object[] recipes = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(recipes);
    }

//    @PostMapping(value = "/addrecipes")

    // View recipe
    @GetMapping("/recipes")
    List<Recipes> getAllRecipes(){
        return recipeRepository.findAll();
    }
}
