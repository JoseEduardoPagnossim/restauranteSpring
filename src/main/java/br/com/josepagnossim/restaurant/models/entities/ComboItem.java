package br.com.josepagnossim.restaurant.models.entities;

import br.com.josepagnossim.restaurant.models.enums.ItemType;
import br.com.josepagnossim.restaurant.models.enums.MenuItemType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class ComboItem extends MenuItens {

    @Id
    private UUID id;

    private UUID itemId;
    private String description;
    private ItemType itemType;
    private MenuItemType menuItemType;

    @ManyToOne
    @JoinColumn(name = "comboId")
    private Combo combo;


    public ComboItem() {

    }

    public ComboItem(UUID id, UUID itemId, String description, ItemType itemType, MenuItemType menuItemType, Combo combo) {
        this.id = id;
        this.itemId = itemId;
        this.description = description;
        this.itemType = itemType;
        this.menuItemType = menuItemType;
        this.combo = combo;
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
            this.itemType = itemType;
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
