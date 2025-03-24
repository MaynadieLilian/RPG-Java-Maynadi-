package fr.ynov.rpg.building;

import fr.ynov.rpg.character.*;
import fr.ynov.rpg.item.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dungeon extends Building{
    private int level = 1;
    private int nbMonster = 1;
    private int previousNbMonster = 0;
    private ArrayList<Monster> monsters = new ArrayList<Monster>();

    public Dungeon(String name,String description){
        super(name,description);
        this.monsters.add(new Monster("Monster"));
    }

    public int getLevel(){
        return this.level;
    }

    public int getNbMonster(){
        return this.nbMonster;
    }

    public List<Monster> getMonsters(){
        return this.monsters;
    }

    public void nextLevel(){
        this.monsters.clear();
        this.level++;
        int temp = this.nbMonster;
        this.nbMonster += this.previousNbMonster;
        this.previousNbMonster = temp;
        for(int i = 0; i < nbMonster; i++){
            this.monsters.add(new Monster("Monster"));
        }
    }

    public void show(){
        for(int i = 0; i < this.monsters.size(); i++){
            System.out.println(this.monsters.get(i).getName()+": "+this.monsters.get(i).getHealth()+" HP ");
        }
        System.out.println("\n");
    }

    public boolean allDead(){
        for(int i = 0; i < this.monsters.size(); i++){
            if(this.monsters.get(i).isAlive()){
                return false;
            }
        }
        return true;
    }

    public void enter(Hero h) {
        Scanner scanner = new Scanner(System.in);
        int input;
        System.out.println("You are in the dungeon, good luck!");
        while (!allDead()) {
            System.out.println("1: Attack monster\n2: Open inventory");
            input = scanner.nextInt();
            if (input == 1) {
                System.out.println("There are " + monsters.size() + " alive");
                show();
                System.out.println("1: Attack monster\n2: Back");
                input = scanner.nextInt();
                if (input == 1) {
                    System.out.println("Choose the monster to attack (1-" + monsters.size() + ")");
                    input = scanner.nextInt();
                    if (input > monsters.size() || input == 0) {
                        System.out.println("This is impossible");
                    } else {
                        Monster target = monsters.get(input - 1);
                        if (target.isAlive()) {
                            if (h instanceof Warrior) {
                                h.attack(target);
                            } else if (h instanceof Paladin) {
                                h.attack(target);
                            } else if (h instanceof Wizard) {
                                h.attack(target);
                            }
                        } else {
                            target.show();
                            if (target.getHealth() == 0) {
                                System.out.println("You have killed this monster");
                            }
                        }
                        System.out.println("A monster attacked you");
                        Monster attackingMonster = monsters.get(0);
                        if (h instanceof Warrior) {
                            attackingMonster.attack(h);
                        } else if (h instanceof Paladin) {
                            attackingMonster.attack(h);
                        } else if (h instanceof Wizard) {
                            attackingMonster.attack(h);
                        }
                        h.show();
                        if (h.getHealth() == 0) {
                            System.out.println("YOU ARE DEAD");
                            return;
                        }
                    }
                }
            } else if (input == 2) {
                List<Item> items = h.getInventory().getItems();
                for (int i = 0; i < items.size(); i++) {
                    System.out.println(i + 1 + ": " + items.get(i).getName());
                }
                System.out.println("Choose the item you want to use (1-" + items.size() + ") or 11 to go back");
                input = scanner.nextInt();
                if (input != 11 && input <= items.size()) {
                    Item selectedItem = items.get(input - 1);
                    selectedItem.show();
                    int input1;
                    if (selectedItem instanceof Sword) {
                        System.out.println("1: Equip\n2: Back");
                        input1 = scanner.nextInt();
                        if (input1 == 1) {
                            if (h instanceof Warrior) {
                                ((Warrior) h).equipSword((Sword) selectedItem);
                            } else if (h instanceof Paladin) {
                                ((Paladin) h).equipSword((Sword) selectedItem);
                            } else {
                                System.out.println("You can't equip this item");
                            }
                        }
                    } else if (selectedItem instanceof Shield) {
                        System.out.println("1: Equip\n2: Back");
                        input1 = scanner.nextInt();
                        if (input1 == 1) {
                            if (h instanceof Paladin) {
                                ((Paladin) h).equipShield((Shield) selectedItem);
                            } else {
                                System.out.println("You can't equip this item");
                            }
                        }
                    } else if (selectedItem instanceof Staff) {
                        System.out.println("1: Equip\n2: Back");
                        input1 = scanner.nextInt();
                        if (input1 == 1) {
                            if (h instanceof Wizard) {
                                ((Wizard) h).equipStaff((Staff) selectedItem);
                            } else {
                                System.out.println("You can't equip this item");
                            }
                        }
                    } else if (selectedItem instanceof HealthPotion) {
                        System.out.println("1: Drink\n2: Back");
                        input1 = scanner.nextInt();
                        if (input1 == 1) {
                            h.drink((HealthPotion) selectedItem);
                            h.getInventory().removeItem(input - 1);
                        }
                    } else if (selectedItem instanceof StrengthPotion) {
                        System.out.println("1: Drink\n2: Back");
                        input1 = scanner.nextInt();
                        if (input1 == 1) {
                            h.drink((StrengthPotion) selectedItem);
                            h.getInventory().removeItem(input - 1);
                        }
                    }
                } else if (input == 11) {

                } else {
                    System.out.println("This item doesn't exist");
                }
            } else {
                System.out.println("That is not an option");
            }
        }
        nextLevel();
    }
}
