package br.com.josepagnossim.restaurant.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

@Entity
public class Combo extends MenuItens{

    @Id
    private UUID id;

    @OneToMany
    private List<ComboItem> itens;

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
