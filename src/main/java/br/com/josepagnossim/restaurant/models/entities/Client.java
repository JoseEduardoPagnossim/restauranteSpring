package br.com.josepagnossim.restaurant.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import java.util.UUID;

@Entity
public class Client{
    @Id
    private UUID id;

    @Column
    private String name;

    @Column( nullable = false, unique = true, length = 11)
    private String document;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }
}

