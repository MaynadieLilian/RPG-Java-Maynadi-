package fr.ynov.rpg.item;


public abstract class Potion extends Item {
    Potion(String name, int stat, int price){
        super(name, stat, price);
    }

    public abstract void drink();
}
