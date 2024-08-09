package br.com.josepagnossim.restaurant.models.entities;

import br.com.josepagnossim.restaurant.models.enums.ItemType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class ComboItem extends MenuItens {

    @Id
    private UUID id;
    private String description;
    private ItemType itemType;
    private UUID itemId;

    public ComboItem(UUID id, String description, ItemType itemType, UUID itemId) {
        this.id = id;
        this.description = description;
        this.itemType = itemType;
        this.itemId = itemId;
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
        this.itemType = itemType;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }
}
