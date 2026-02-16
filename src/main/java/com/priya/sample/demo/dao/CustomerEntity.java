package com.priya.sample.demo.dao;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class CustomerEntity {

    @Id
    private String id;   // Mongo uses String/ObjectId

    private String name;
    private String location;

    // Constructors
    public CustomerEntity() {}
    

    public CustomerEntity(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
