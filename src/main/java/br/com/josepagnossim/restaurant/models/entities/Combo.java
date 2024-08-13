package br.com.josepagnossim.restaurant.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

@Entity
public class Combo {

    @Id
    private UUID id;
    private String name;

    @OneToMany
    private List<ComboItem> itens;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setItens(List<ComboItem> itens) {
        this.itens = itens;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<ComboItem> getItens() {
        return itens;
    }

}
