package fr.ynov.rpg.building;

public class Dungeon extends Building{
    private int level = 1;
    private int nbMonster = 1;
    private int previousNbMonster = 0;

    public Dungeon(String name,String description){
        super(name,description);
    }
}
