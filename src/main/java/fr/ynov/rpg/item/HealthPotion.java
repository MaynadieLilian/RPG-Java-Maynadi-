package fr.ynov.rpg.item;

public class HealthPotion extends Potion{
    public HealthPotion(String name,int stat,int price){
        super(name,stat,price);
    }

    public void show(){
        System.out.println("Name: " + getName() + "\nEffect: heal " + getStat() + " HP");
    }
    public void drink(){
        int hp = this.getOwner().getHealth()+this.getStat();
        if(hp>100){
            hp=100;
        }
        this.getOwner().setHealth(hp);
    }
}
