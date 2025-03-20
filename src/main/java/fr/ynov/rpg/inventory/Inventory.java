package fr.ynov.rpg.inventory;
import fr.ynov.rpg.item.Item;
import fr.ynov.rpg.item.Potion;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private int space;

    public Inventory(){
        this.items = new ArrayList<>();
        this.space = 5;
    }
}
