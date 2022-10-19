package com.example.testproject.repository;

import com.example.testproject.model.Recipes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipes, Long> {

}
