package fr.ynov.rpg.character;
import fr.ynov.rpg.inventory.Inventory;
import fr.ynov.rpg.item.Item;
import fr.ynov.rpg.item.Potion;

public abstract class Hero extends Character {
    private Inventory  inventory;

    Hero(String name){
        super(name,100,10,50);
        this.inventory = new Inventory();
    }

    public void pickup(Item item){
        this.inventory.addItem(item);
    }

    public void throwAway(int index){
        Item item = this.inventory.removeItem(index);
        item = null;
    }

    public void drink(Potion potion){
        potion.drink();
    }

    public Inventory getInventory(){
        return this.inventory;
    }
}
