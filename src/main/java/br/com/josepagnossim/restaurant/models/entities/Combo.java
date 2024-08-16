package br.com.josepagnossim.restaurant.models.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Combo {

    @Id
    private UUID id;
    private String name;
    private double price;

    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ComboItem> itens = new ArrayList<>();

    public Combo() {

    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ComboItem> getItens() {
        return itens;
    }

    public void setItens(List<ComboItem> itens) {
        this.itens.clear();
        if(itens != null) {
            for(ComboItem item : itens) {
                this.itens.add(item);
            }
        }
    }

    public void addItem(ComboItem item) {
        itens.add(item);
        item.setCombo(this);
    }

    public void removeItem(ComboItem item) {
        itens.remove(item);
        item.setCombo(null);
    }
}
