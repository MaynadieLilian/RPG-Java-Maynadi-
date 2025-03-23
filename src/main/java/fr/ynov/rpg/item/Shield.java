package fr.ynov.rpg.item;

public class Shield extends HoldableItem {
    public Shield(String name, int stat, int price, String rarity, int durability){
        super(name,stat,price,rarity,durability);
    }

    public void show(){
        System.out.println("Name: " + getName() +"\n Rarity: " + getRarity() + "\n Defense: " + getStat() +"\n Durability: " + getDurability());
    }
}
