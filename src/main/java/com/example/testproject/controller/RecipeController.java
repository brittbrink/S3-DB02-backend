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

    @GetMapping(value = "/get/recipes/nutrients")
    public List<Object> GetRecipesNutrients(){
        String url= "https://api.spoonacular.com/recipes/findByNutrients?maxCalories=6000&number=7&apiKey=f1cc1855d23a469487f59d4bc557c8a1";
        RestTemplate restTemplate = new RestTemplate();
        Object[] recipes = restTemplate.getForObject(url, Object[].class);
        return Arrays.asList(recipes);
    }

    @GetMapping(value = "/get/recipes/servings/{id}")
    public Object GetRecipesServings(@PathVariable Long id){
        String url= "https://api.spoonacular.com/recipes/"+ id + "/information?includeNutrition=false&apiKey=f1cc1855d23a469487f59d4bc557c8a1";
        RestTemplate restTemplate = new RestTemplate();
        Object recipes = restTemplate.getForObject(url, Object.class);
        return recipes;
    }

    @GetMapping(value = "/get/recipes/summary/{id}")
    public Object GetRecipesSummary(@PathVariable Long id){
        String url= "https://api.spoonacular.com/recipes/" + id + "/summary?apiKey=f1cc1855d23a469487f59d4bc557c8a1";
        RestTemplate restTemplate = new RestTemplate();
        Object recipes = restTemplate.getForObject(url, Object.class);
        return recipes;
    }


//    @PostMapping(value = "/addrecipes")

    // View recipe
    @GetMapping("/recipes")
    List<Recipes> getAllRecipes(){
        return recipeRepository.findAll();
    }
}
