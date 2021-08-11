package com.example.mock_test;

import org.springframework.beans.factory.annotation.Autowired;

public class Company {


    String name;
    Person owner;



    public Company() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
