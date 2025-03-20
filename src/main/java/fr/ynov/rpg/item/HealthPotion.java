package fr.ynov.rpg.item;

public class HealthPotion extends Potion{
    HealthPotion(String name,int stat,int price){
        super(name,stat,price);
    }

    public void show(){
        System.out.println("Name: " + getName() + "\nEffect: heal " + getStat() + " HP");
    }
    public void drink(){}
}
