package br.com.josepagnossim.restaurant.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Combo extends MenuItens{

    @Id
    private UUID id;
    private String description;



}
