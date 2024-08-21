package br.com.josepagnossim.restaurant.models.entities;

import br.com.josepagnossim.restaurant.exceptions.menuitens.InvalidTypeInsertion;
import br.com.josepagnossim.restaurant.models.enums.ItemType;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class ComboItem{

    @Id
    private UUID id;

    private UUID itemId;
    @Enumerated(EnumType.STRING)
    private ItemType menuItem;
    private String description;

    @ManyToOne
    private Combo combo;


    public ComboItem() {

    }

    public ComboItem(UUID id, UUID itemId, String description, ItemType itemType) {
        this.id = id;
        this.itemId = itemId;
        this.description = description;
        this.menuItem = itemType;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemType getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(ItemType menuItem) {
        if(menuItem == ItemType.COMBO){
            throw new InvalidTypeInsertion("Type COMBO not supported");
        } else {
            this.menuItem = menuItem;
        }
    }


    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }
}
