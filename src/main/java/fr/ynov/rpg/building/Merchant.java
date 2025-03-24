package fr.ynov.rpg.building;

import fr.ynov.rpg.character.Hero;
import fr.ynov.rpg.inventory.Inventory;
import fr.ynov.rpg.item.HealthPotion;
import fr.ynov.rpg.item.Item;
import fr.ynov.rpg.item.StrengthPotion;
import fr.ynov.rpg.item.Sword;
import fr.ynov.rpg.item.Shield;
import fr.ynov.rpg.item.Staff;

import java.util.Scanner;

public class Merchant extends Building {
    private Inventory inventory;

    public Merchant(String name, String description) {
        super(name,description);
    }

    public void sellItem(Item item, Hero hero){
        if(item.getPrice()>hero.getGold()){
            System.out.println("You don't have enough money!");
            return;
        }else if(hero.getInventory().addItem(item)){
            item.setOwner(hero);
            hero.setGold(hero.getGold()-item.getPrice());
            System.out.println("Item added to your inventory!");
        }else{
            System.out.println("Inventory is full!");
        }
    }

    public void browsePotions(Hero hero) {
        System.out.println("1: Potion of Health(20 HP), 2: Potion of Strength (5 attack), 3: Back");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            System.out.println("That will cost 10 gold.\n1: Buy\n2: Back");
            input = scanner.nextInt();
            if (input == 1) {
                HealthPotion healthPotion = new HealthPotion("Health Potion", 20, 10);
                sellItem(healthPotion, hero);
            } else {
                System.out.println("Goodbye see you next time!");
            }
        } else if (input == 2) {
            System.out.println("That will cost 10 gold\n1: Buy\n2: Back");
            input = scanner.nextInt();
            if (input == 1) {
                StrengthPotion strengthPotion = new StrengthPotion("Strength Potion", 5, 10);
                sellItem(strengthPotion, hero);
            } else {
                System.out.println("Goodbye see you next time!");
            }
        } else if (input == 3) {
            browseItems(hero);
        }
    }

    public void browseSwords(Hero hero) {
        System.out.println("1: Wooden Sword\n2: Iron Sword\n3: Netherith Sword\n4: Sword of Drake\n5: Back");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            System.out.println("That will cost 30 gold\n1: Buy\n2: Exit");
            input = scanner.nextInt();
            if (input == 1) {
                Sword woodenSword = new Sword("Wooden Sword", 5, 30, "Common", 20);
                sellItem(woodenSword, hero);
            } else {
                System.out.println("Goodbye see you next time!");
            }
        } else if (input == 2) {
            System.out.println("That will cost 75 gold\n1: Buy\n2: Exit");
            input = scanner.nextInt();
            if (input == 1) {
                Sword ironSword = new Sword("Iron Sword", 10, 75, "Rare",50);
                sellItem(ironSword, hero);
            } else {
                System.out.println("Goodbye see you next time!");
            }
        } else if (input == 3) {
            System.out.println("That will cost 115 gold \n1: Buy\n2: Exit");
            input = scanner.nextInt();
            if (input == 1) {
                Sword netherithSword = new Sword("Netherith Sword", 15, 115, "Epic", 75);
                sellItem(netherithSword, hero);
            } else {
                System.out.println("Goodbye see you next time!");
            }
        } else if (input == 4) {
            System.out.println("That will cost 150 gold\n1: Buy\n2: Exit");
            input = scanner.nextInt();
            if (input == 1) {
                Sword swordOfDrake = new Sword("Sword of Drake", 20, 150, "Legendary", 100);
                sellItem(swordOfDrake, hero);
            } else {
                System.out.println("Goodbye see you next time!");
            }
        } else if (input == 5) {
            browseItems(hero);
        }
    }

    public void browseShields(Hero hero) {
        System.out.println("1: Wooden Shield\n2: Iron Shield\n3: Netherith Shield\n4: Shield of the Protector\n5: Back");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            System.out.println("That will cost 30 gold\n1: Buy\n2: Exit");
            if (scanner.nextInt() == 1) {
                sellItem(new Shield("Wooden Shield", 2, 30, "Common", 50), hero);
            }
        } else if (input == 2) {
            System.out.println("That will cost 75 gold\n1: Buy\n2: Exit");
            if (scanner.nextInt() == 1) {
                sellItem(new Shield("Iron Shield", 5, 75, "Rare", 70), hero);
            }
        } else if (input == 3) {
            System.out.println("That will cost 115 gold\n1: Buy\n2: Exit");
            if (scanner.nextInt() == 1) {
                sellItem(new Shield("Netherith Shield", 7, 115, "Epic", 90), hero);
            }
        } else if (input == 4) {
            System.out.println("That will cost 150 gold\n1: Buy\n2: Exit");
            if (scanner.nextInt() == 1) {
                sellItem(new Shield("Shield of the Protector", 10, 150, "Legendary", 130), hero);
            }
        } else if (input == 5) {
            browseItems(hero);
        }
    }

    public void browseStaffs(Hero hero) {
        System.out.println("1: Wooden Staff\n2: Iron Staff\n3: Netherith Staff\n4: Staff of the Great Wizard\n5: Back");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            System.out.println("That will cost 30 gold\n1: Buy\n2: Exit");
            if (scanner.nextInt() == 1) {
                sellItem(new Staff("Wooden Staff", 5, 30, "Common", 50), hero);
            }
        } else if (input == 2) {
            System.out.println("That will cost 75 gold\n1: Buy\n2: Exit");
            if (scanner.nextInt() == 1) {
                sellItem(new Staff("Iron Staff", 10, 75, "Rare", 70), hero);
            }
        } else if (input == 3) {
            System.out.println("That will cost 115 gold\n1: Buy\n2: Exit");
            if (scanner.nextInt() == 1) {
                sellItem(new Staff("Netherith Staff", 15, 115, "Epic", 90), hero);
            }
        } else if (input == 4) {
            System.out.println("That will cost 150 gold\n1: Buy\n2: Exit");
            if (scanner.nextInt() == 1) {
                sellItem(new Staff("Staff of the Great Wizard", 20, 150, "Legendary", 130), hero);
            }
        } else if (input == 5) {
            browseItems(hero);
        }
    }

    public void browseBackpacks(Hero hero) {
        System.out.println("1: Backpack\n2: Back");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            System.out.println("This Backpack gives an extra 5 spaces, it costs 100 gold\n1: Buy\n2: Exit");
            if (scanner.nextInt() == 1) {
                if (hero.getGold() >= 100) {
                    hero.getInventory().setSpaces(10);
                    hero.setGold(hero.getGold() - 100);
                    System.out.println("You now have 10 inventory spaces");
                } else {
                    System.out.println("You don't have enough gold");
                }
            }
        } else if (input == 3) {
            browseItems(hero);
        }
    }

    public void browseItems(Hero hero) {
        System.out.println("1: Browse Potions\n2: Browse Swords\n3: Browse Shields\n4: Browse Staffs\n5: Browse Backpacks\n6: Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                browsePotions(hero);
                break;
            case 2:
                browseSwords(hero);
                break;
            case 3:
                browseShields(hero);
                break;
            case 4:
                browseStaffs(hero);
                break;
            case 5:
                browseBackpacks(hero);
                break;
            case 6:
                System.out.println("Goodbye, see you next time!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                browseItems(hero);
                break;
        }
    }

    public void enter(Hero hero) {
        System.out.println("Hello and welcome to the merchant, would you like to buy anything?\n1: Yes\n2: No");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 2) {
            System.out.println("Goodbye, see you next time!");
        } else {
            browseItems(hero);
        }
    }

    public Inventory getInventory(){
        return this.inventory;
    }

}
