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
}
