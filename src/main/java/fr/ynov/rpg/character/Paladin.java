package fr.ynov.rpg.character;

import fr.ynov.rpg.item.Shield;
import fr.ynov.rpg.item.Sword;

public class Paladin extends Hero {
    private Sword sword;
    private Shield shield;

    Paladin(String name){
        super(name);
        this.sword = null;
        this.shield = null;
    }

    public void equipSword(Sword sword){
        if(this.sword != null){
            unequipSword(sword);
        }
        this.sword = sword;
        setAttack(this.getAttack()+sword.getStat());
    }

    public void unequipSword(Sword sword){
        this.sword = null;
        setAttack(this.getAttack()-sword.getStat());
    }

    public void equipShield(Shield shield){
        this.shield = shield;
    }

    public void unequipShield(){
        this.shield = null;
    }

    public void takeDamage(int damage){
        if(this.shield != null){
            super.takeDamage(damage-this.shield.getStat());
            this.shield.setDurability(this.shield.getDurability()-1);
        }else{
            super.takeDamage(damage);
        }
    }

    public void attack(Character character){
        character.takeDamage(this.getAttack());
        if(this.sword != null){
            this.sword.setDurability(this.sword.getDurability()-1);
        }
        if(character.getHealth() == 0){
            this.kill(character);
        }
    }

    public void show(){
        System.out.println("Name: "+this.getName()+"\nHealth: "+this.getHealth()+"\nAttack: "+this.getAttack()+"\nGold: "+this.getGold()+"\nSword: ");
        if(this.sword != null){
            System.out.println(this.sword.getName());
        }else {
            System.out.println("No Sword");
        }
        System.out.println("\nShield: ");
        if(this.shield != null){
            System.out.println(this.shield.getName());
        }else{
            System.out.println("No Shield");
        }
        System.out.println("\nInventory: ");
        for(int i =0;i<this.getInventory().getItems().size();i++){
            System.out.println(this.getInventory().getItems().get(i).getName()+" ");
        }
    }
}
