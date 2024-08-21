package br.com.josepagnossim.restaurant.models.entities;

import br.com.josepagnossim.restaurant.models.enums.ItemType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.UUID;

@MappedSuperclass
public abstract class MenuItens {

    @Id
    private UUID id;
    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    private ItemType menuItemType;

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

    public ItemType getMenuItemType() {
        return menuItemType;
    }

    public void setMenuItemType(ItemType menuItemType) {
        this.menuItemType = menuItemType;
    }
}
