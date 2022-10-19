package com.example.testproject.model;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    @Column(name = "Username")
    private String username;

    @Column(name = "Name")
    private String name;

    @Column(name = "Email")
    private String email;

  // getters
    public Long getID() {
        return ID;
    }
    public String getUsername() {
        return username;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }

  // setters
    public void setID(Long ID) {
        this.ID = ID;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
