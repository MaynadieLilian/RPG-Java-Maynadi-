package fr.ynov.rpg.item;

import fr.ynov.rpg.character.Warrior;

public abstract class Potion extends Item {
    Potion(String name, int stat, int price){
        super(name, stat, price);
    }

    public abstract void drink();
}
