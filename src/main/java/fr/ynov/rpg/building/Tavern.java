package fr.ynov.rpg.building;

public class Tavern extends Building{
    private int price;

    Tavern(String name, String description, int price) {
        super(name, description);
        this.price = price;
    }
}
