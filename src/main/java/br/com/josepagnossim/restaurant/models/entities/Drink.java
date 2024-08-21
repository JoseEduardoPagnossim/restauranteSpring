package br.com.josepagnossim.restaurant.models.entities;

import jakarta.persistence.Entity;

@Entity
public class Drink extends MenuItens{


    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
