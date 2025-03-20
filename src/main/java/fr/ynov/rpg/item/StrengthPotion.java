package fr.ynov.rpg.item;

public class StrengthPotion extends Potion{
    StrengthPotion(String name,int stat,int price){
        super(name, stat, price);
    }

    public void show(){
        System.out.println("Name: " + getName() + "\nEffect: +" + getStat() + " attack");
    }

    public void drink(){}
}
