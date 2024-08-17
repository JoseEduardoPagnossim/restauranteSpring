package br.com.josepagnossim.restaurant.models.enums;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum ItemType {

    @Enumerated(EnumType.STRING)
    DISH,
    DRINK,
    COMBO
}
