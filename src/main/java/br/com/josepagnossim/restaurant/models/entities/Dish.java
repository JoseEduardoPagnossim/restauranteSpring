package br.com.josepagnossim.restaurant.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Dish extends MenuItens{

    @Id
    private UUID id;
    private String description;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }


        public String getDescription () {
            return description;
        }

        public void setDescription (String description){
            this.description = description;
        }

}
