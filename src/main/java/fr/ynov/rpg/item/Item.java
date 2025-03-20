package fr.ynov.rpg.item;

import fr.ynov.rpg.character.Hero;

public abstract class Item {
    private String name;
    private  int stat;
    private  int price;
    private Hero owner;

    public Item(String name, int stat, int price){
        this.name = name;
        this.stat = stat;
        this.price = price;
        this.owner = null;
    }

    public String getName(){
        return this.name;
    }

    public int getStat(){
        return this.stat;
    }

    public int getPrice(){
        return this.price;
    }

    public Hero getOwner(){
        return this.owner;
    }

    public void setOwner(Hero owner){
        this.owner = owner;
    }

    public abstract void show();
}
