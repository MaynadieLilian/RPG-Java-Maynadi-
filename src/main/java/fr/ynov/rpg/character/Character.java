package fr.ynov.rpg.character;

public abstract class Character {
    private String name;
    private  int health;
    private  int attack;
    private int gold;

    Character(String name, int health, int attack, int gold) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.gold = gold;
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getAttack(){
        return this.attack;
    }

    public void setAttack(int attack){
        this.attack = attack ;
    }

    public int getGold(){
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public boolean isAlive(){
        return this.health > 0;
    }

    public void takeDamage(int damage){
        this.health -= damage;
        if(this.health <= 0){
            this.health = 0;
        }
    }

    public void attack(Character target){
        target.takeDamage(this.attack);
    }

    public void kill(Character target){
        this.gold += target.getGold();
    }

    public void show(){
        System.out.println("Name: "+this.name+"\nHealth: "+this.health+"\nAttack: "+this.attack);
    }

    public String showGUI(){
        return "Name: "+this.name+"\nHealth: "+this.health+"\nAttack: "+this.attack;
    }
}
