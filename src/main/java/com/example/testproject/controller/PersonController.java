package com.example.testproject.controller;

import com.example.testproject.exception.UserNotFoundException;
import com.example.testproject.model.Person;
import com.example.testproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    // Add Person
    @PostMapping("/person")
    Person newPerson(@RequestBody Person newPerson){
        return personRepository.save(newPerson);
    }

    // View Person
    @GetMapping("/persons")
    List<Person> getAllPersons(){
        return personRepository.findAll();
    }

    // Person by ID
    @GetMapping("/person/{id}")
    Person getPersonById(@PathVariable Long id){
        return personRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    // Edit Person
    @PutMapping("/person/{id}")
    Person updatePerson(@RequestBody Person newPerson, @PathVariable Long id){
        return personRepository.findById(id)
                .map(person -> {
                    person.setUsername(newPerson.getUsername());
                    person.setName(newPerson.getName());
                    person.setEmail(newPerson.getEmail());
                    return personRepository.save(person);
                }).orElseThrow(()->new UserNotFoundException(id));
    }

    // Delete Person
    @DeleteMapping("/person/{id}")
    String deletePerson(@PathVariable Long id){
        if(!personRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        personRepository.deleteById(id);
        return "User with id " + id + " has been deleted succesfully.";
    }
}
