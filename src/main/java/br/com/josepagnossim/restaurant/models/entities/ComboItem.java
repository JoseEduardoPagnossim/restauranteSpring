package br.com.josepagnossim.restaurant.models.entities;

import br.com.josepagnossim.restaurant.models.enums.ItemType;
import br.com.josepagnossim.restaurant.models.enums.MenuItemType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class ComboItem{

    @Id
    private UUID id;

    private UUID itemId;
    private String description;
    private ItemType itemType;
    private MenuItemType menuItemType;

    @ManyToOne
    @JoinColumn(name = "comboId")
    @JsonBackReference
    private Combo combo;


    public ComboItem() {

    }

    public ComboItem(UUID id, UUID itemId, String description, ItemType itemType) {
        this.id = id;
        this.itemId = itemId;
        this.description = description;
        this.itemType = itemType;
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

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        if(itemType == ItemType.COMBO){
            throw new IllegalArgumentException("Não é possivel adicionar um combo a um combo");
        } else {
            this    .itemType = itemType;
        }
    }

    public MenuItemType getMenuItemType() {
        return menuItemType;
    }

    public void setMenuItemType(MenuItemType menuItemType) {
        this.menuItemType = menuItemType;
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
