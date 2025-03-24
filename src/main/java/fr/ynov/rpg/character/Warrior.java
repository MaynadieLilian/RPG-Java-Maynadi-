package fr.ynov.rpg.character;

import fr.ynov.rpg.item.Sword;

public class Warrior extends Hero {
    private Sword sword;

    public Warrior(String name){
        super(name);
        sword = null;
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

    public void attack(Character character){
        int att=this.getAttack();
        att = (int) (att*1.5);
        character.takeDamage(att);
        if (this.sword != null){
            this.sword.setDurability(this.sword.getDurability()-1);
        }
        if(character.getHealth()==0){
            this.kill(character);
        }
    }

    public void show(){
        System.out.println("Name: "+this.getName()+"\nHealth: "+this.getHealth()+"\nAttack :"+this.getAttack()+"\nGold: "+this.getGold()+"\nSword: ");
        if(this.sword != null){
            System.out.println(this.sword.getName());
        }else{
            System.out.println("No Sword");
        }
        System.out.println("\nInventory: ");
        for(int i=0;i<this.getInventory().getItems().size();i++){
            System.out.println(this.getInventory().getItems().get(i).getName()+" ");
        }
    }
}
