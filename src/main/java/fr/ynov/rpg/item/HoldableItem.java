package fr.ynov.rpg.item;

import fr.ynov.rpg.character.Warrior;

public abstract class HoldableItem extends Item {
    private String rarity;
    private int durability;

    HoldableItem(String name, int stat, int price, String rarity, int durability){
        super(name, stat, price);
        this.rarity = rarity;
        this.durability = durability;
    }
}
