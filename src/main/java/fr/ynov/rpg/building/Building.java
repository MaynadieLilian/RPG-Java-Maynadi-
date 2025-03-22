package fr.ynov.rpg.building;

public abstract class Building {
    private String name;
    private String description;

    Building(String name,String description){
        this.name=name;
        this.description=description;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void show(){
        System.out.println("Name: " + this.name + "\nDescription: " + this.description);
    }
}
