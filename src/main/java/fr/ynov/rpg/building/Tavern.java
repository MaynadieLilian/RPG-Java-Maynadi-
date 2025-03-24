package fr.ynov.rpg.building;

import fr.ynov.rpg.character.Hero;

import java.util.Scanner;

public class Tavern extends Building{
    private int price;

    Tavern(String name, String description, int price) {
        super(name, description);
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }

    public void heal(Hero hero){
        if(this.price<hero.getGold()){
            hero.setHealth(100);
            hero.setGold(hero.getGold()-this.price);
        }
    }

    public void enter(Hero hero){
        System.out.println("Hello and welcome to the tavern, it will cost "+this.price+" gold to fully heal you");
        Scanner sc = new Scanner(System.in);
        System.out.println("1: Heal\n2: Exit Tavern");
        int choice = sc.nextInt();
        if(choice==1){
            if(hero.getGold()<30){
                System.out.println("you don't have the gold");
            }
            heal(hero);
        }
        System.out.println("Goodbye see you next time!");
    }
}
