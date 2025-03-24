package fr.ynov.rpg.game;

import fr.ynov.rpg.building.Building;
import fr.ynov.rpg.building.Dungeon;
import fr.ynov.rpg.building.Merchant;
import fr.ynov.rpg.building.Tavern;
import fr.ynov.rpg.character.Hero;
import fr.ynov.rpg.character.Paladin;
import fr.ynov.rpg.character.Warrior;
import fr.ynov.rpg.character.Wizard;
import fr.ynov.rpg.village.Village;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Hero hero;
    private Village village;

    public Game(){
        Dungeon dungeon = new Dungeon("Dungeon","The Dungeon is where you can fight the monsters that are attacking the village. The monsters drop gold that you can use to buy or upgrade your gear.");
        Tavern tavern = new Tavern("Tavern","The Tavern is where you can restore your health, but that comes at a price.",30);
        Merchant merchant = new Merchant("Merchant","The Merchant is where you can buy items with the gold you earn.");
        Village village = new Village();
        village.addBuilding(dungeon);
        village.addBuilding(tavern);
        village.addBuilding(merchant);
        this.village=village;
    }

    public Hero getHero(){
        return this.hero;
    }

    public Village getVillage(){
        return this.village;
    }

    public void initilaize(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Quick, the village needs you to defend it against the monsters that have awoken in the mines!\nPick a Hero, type 1 for Warrior, 2 for Paladin or 3 for Wizard.");
        System.out.println("Each hero has a diffenrent ability, Warriors do an extra 50% more damage, paladins can equip shields to block damage and wizards have a 20% chance to dodge attacks.");
        String type=sc.nextLine();
        System.out.println("What is your name?");
        String name=sc.nextLine();
        if(type.equals("1")){
            this.hero=new Warrior(name);
        }else if(type.equals("2")){
            this.hero=new Paladin(name);
        }else if(type.equals("3")){
            this.hero=new Wizard(name);
        }
    }

    public void startGame(){
        Scanner sc =new Scanner(System.in);
        while(this.hero.getHealth()!=0){
            this.hero.show();
            System.out.println("Where you want to go?");
            this.village.show();
            int choice = sc.nextInt();
            if(village.getBuildings().get(choice-1) instanceof Dungeon){
                ((Dungeon) village.getBuildings().get(choice-1)).enter(hero);
            }
            if(village.getBuildings().get(choice-1) instanceof Tavern){
                ((Tavern) village.getBuildings().get(choice-1)).enter(hero);
            }
            if(village.getBuildings().get(choice-1) instanceof Merchant){
                ((Merchant) village.getBuildings().get(choice-1)).enter(hero);
            }
        }
        System.out.println("GAME OVER");
    }
}
