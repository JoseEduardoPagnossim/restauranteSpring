package br.com.josepagnossim.restaurant.models.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Combo extends MenuItens{

    @OneToMany(mappedBy = "combo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComboItem> itens = new ArrayList<>();

    public List<ComboItem> getItens() {
        return itens;
    }

    public void setItens(List<ComboItem> itens) {
        this.itens.clear();
        if(itens != null) {
            this.itens.addAll(itens);
        }
    }

    public void addItem(ComboItem item) {
        item.setId(UUID.randomUUID());
        this.itens.add(item);
    }

    public void addItems(List<ComboItem> items) {
        for (ComboItem item : items) {
            addItem(item);
        }
    }
}
