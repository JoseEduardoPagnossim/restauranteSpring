package br.com.josepagnossim.restaurant.models.entities;

import br.com.josepagnossim.restaurant.models.enums.MenuItemType;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class MenuItens {

    private MenuItemType menuItemType;
    private String name;
    private double price;

    public MenuItens() {
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

    public MenuItemType getMenuItem() {
        return menuItemType;
    }

    public void setMenuItem(MenuItemType menuItem) {
        this.menuItemType = menuItem;
    }
}
