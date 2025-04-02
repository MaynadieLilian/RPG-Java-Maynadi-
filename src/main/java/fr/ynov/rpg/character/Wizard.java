package fr.ynov.rpg.character;

import fr.ynov.rpg.item.Staff;

import java.util.Random;

public class Wizard extends Hero {
    private Staff staff;

    public Wizard(String name){
        super(name);
        this.staff = null;
    }

    public void equipStaff(Staff staff){
        if(this.staff != null){
            unequipStaff(staff);
        }
        this.staff = staff;
        setAttack(this.getAttack()+staff.getStat());
    }

    public void unequipStaff(Staff staff){
        this.staff = null;
        setAttack(this.getAttack()-staff.getStat());
    }

    public void takeDamage(int damage){
        Random random = new Random();
        int nb = random.nextInt(5);
        if(nb!=0){
            super.takeDamage(damage);
        }
    }

    public void attack(Character character){
        character.takeDamage(this.getAttack());
        if(staff != null){
            staff.setDurability(staff.getDurability()-1);
        }
        if(character.getHealth()==0){
            this.kill(character);
        }
    }

    public void show(){
        System.out.println("Name: "+this.getName()+"\nHealth: "+this.getHealth()+"\nAttack :"+this.getAttack()+"\nGold: "+this.getGold()+"\nSword: ");
        if(this.staff != null){
            System.out.println(this.staff.getName());
        }else{
            System.out.println("No Sword");
        }
        System.out.println("\nInventory: ");
        for(int i=0;i<this.getInventory().getItems().size();i++){
            System.out.println(this.getInventory().getItems().get(i).getName()+" ");
        }
    }

    public String showGUI(){
        StringBuilder str = new StringBuilder("Name: " + this.getName() + "\nHealth: " + this.getHealth() + "\nAttack: " + this.getAttack() + "\nGold: " + this.getGold() + "\nSword: ");
        if(this.staff != null){
            str.append(this.staff.getName());
        }else {
            str.append("No Sword");
        }
        str.append("\nInventory: ");
        for(int i =0;i<this.getInventory().getItems().size();i++){
            str.append(this.getInventory().getItems().get(i).getName()).append(" ");
        }
        return str.toString();
    }
}
