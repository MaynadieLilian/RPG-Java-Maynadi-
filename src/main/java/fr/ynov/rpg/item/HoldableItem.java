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

    public String getRarity(){
        return this.rarity;
    }

     public int getDurability(){
        return this.durability;
    }

    public void setDurability(int i){
        this.durability = i;
    }

    public boolean isBroken(){
        return this.durability < 1;
    }
}
