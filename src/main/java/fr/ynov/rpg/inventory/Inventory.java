package fr.ynov.rpg.inventory;
import fr.ynov.rpg.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items;
    private int spaces;

    public Inventory(){
        this.items = new ArrayList<>();
        this.spaces = 5;
    }

    public List<Item> getItems(){
        return this.items;
    }

    public Item getItem(int index){
        if(this.items.size() > index){
            return this.items.get(index);
        }
        System.out.println("this item don't exist");
        return null;
    }

    public boolean addItem(Item item){
        if(this.items.size() < this.spaces && item.getOwner()==null){
            this.items.add(item);
            return true;
        }
        return false;
    }

    public Item removeItem(int index){
       Item item = this.items.get(index);
       if(this.items.size() > 0){
           this.items.remove(index);
       }
       return  item;
    }

    public void setSpaces(int space){
        this.spaces = space;
    }
}
