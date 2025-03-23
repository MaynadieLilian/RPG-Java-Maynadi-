package fr.ynov.rpg.item;

public class Staff extends HoldableItem{
    public Staff(String name, int stat, int price, String rarity, int durability){
        super(name,stat,price,rarity,durability);
    }

    public void show(){
        System.out.println("Name: " + getName() +"\n Rarity: " + getRarity() + "\n Attack: " + getStat() +"\n Durability: " + getDurability());
    }
}
