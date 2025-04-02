package fr.ynov.rpg.gui;

import fr.ynov.rpg.building.Merchant;
import fr.ynov.rpg.character.Hero;
import fr.ynov.rpg.item.*;
import javax.swing.*;
import java.awt.*;


public class MerchantGUI extends JFrame {
    private Merchant merchant;
    private Hero hero;
    private JTextArea textArea;

    public MerchantGUI(Merchant merchant, Hero hero) {
        this.merchant = merchant;
        this.hero = hero;

        setTitle("Merchant");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        textArea = new JTextArea("Welcome to the Merchant !\nYour Gold : " + hero.getGold());
        textArea.setEditable(false);
        panel.add(textArea);
        JButton potionsButton = new JButton("Browse Potions");
        JButton swordsButton = new JButton("Browse Swords");
        JButton shieldsButton = new JButton("Browse Shields");
        JButton staffsButton = new JButton("Browse Staffs");
        JButton backpackButton = new JButton("Browse Backpack");
        JButton exitButton = new JButton("Leave");
        potionsButton.addActionListener(e -> browsePotions());
        swordsButton.addActionListener(e -> browseSwords());
        shieldsButton.addActionListener(e -> browseShields());
        staffsButton.addActionListener(e -> browseStaffs());
        backpackButton.addActionListener(e -> browseBackpack());
        exitButton.addActionListener(e -> dispose());
        panel.add(potionsButton);
        panel.add(swordsButton);
        panel.add(shieldsButton);
        panel.add(staffsButton);
        panel.add(exitButton);
        add(panel);
        setVisible(true);
    }

    private void browsePotions() {
        int choice = JOptionPane.showOptionDialog(this, "What potion do you want buy?", "Potions", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Health Potion (10 Gold)", "Strength Potion (10 Gold)", "Back"}, "Back");
        if (choice == 0) {
            buyItem(new HealthPotion("Health Potion", 20, 10));
        } else if (choice == 1) {
            buyItem(new StrengthPotion("Strength Potion", 5, 10));
        }
    }

    private void browseSwords() {
        int choice = JOptionPane.showOptionDialog(this, "What sword do you want buy?", "Sword", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Wooden Sword (30 Gold)", "Iron Sword (75 Gold)","Netherith Sword (115 Gold)","Sword of Drake(150 Gold)", "Back"}, "Back");
        if (choice == 0) {
            buyItem(new Sword("Wooden Sword", 5, 30, "Common", 20));
        } else if (choice == 1) {
            buyItem(new Sword("Iron Sword", 10, 75, "Rare", 50));
        } else if(choice == 2){
            buyItem(new Sword("Netherith Sword", 15, 115, "Epic", 75));
        }else if(choice == 3){
            buyItem(new Sword("Sword of Drake", 20, 150, "Legendary", 100));
        }
    }

    private void browseShields() {
        int choice = JOptionPane.showOptionDialog(this, "What shield do you want buy?", "Shield", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Wooden shield(30 Gold)", "Iron Shield(75 Gold)","Netherith Shield (115 Gold)","Shield of the Protector (150 Gold)", "Back"}, "Back");
        if (choice == 0) {
            buyItem(new Shield("Wooden Shield", 2, 30, "Common", 50));
        } else if (choice == 1) {
            buyItem(new Shield("Iron Shield", 5, 75, "Rare", 70));
        } else if(choice == 2){
            buyItem(new Shield("Netherith Shield", 7, 115, "Epic", 90));
        }else if(choice == 3){
            buyItem(new Shield("Shield of the Protector", 10, 150, "Legendary", 130));
        }
    }

    private void browseStaffs() {
        int choice = JOptionPane.showOptionDialog(this, "What staff do you want buy?", "Staff", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Wooden Staff (30 Gold)", "Iron Staff (75 Gold)","Netherith Staff (115 Gold)","Staff of the Great Wizard (150 Gold)", "Back"}, "Back");
        if (choice == 0) {
            buyItem(new Staff("Wooden Staff", 5, 30, "Common", 50));
        } else if (choice == 1) {
            buyItem(new Staff("Iron Staff", 10, 75, "Rare", 70));
        }else if(choice == 2){
            buyItem(new Staff("Netherith Staff", 15, 115, "Epic", 90));
        }else if(choice == 3){
            buyItem(new Staff("Staff of the Great Wizard", 20, 150, "Legendary", 130));
        }
    }

    private  void browseBackpack() {
        int choice = JOptionPane.showOptionDialog(this, "What shield do you want buy?", "Shield", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{"Backpack (100 Gold)","Back"}, "Back");
        if(choice == 0){
            if(hero.getGold() >= 100){
                hero.getInventory().setSpaces(10);
                hero.setGold(hero.getGold() - 100);
                textArea.setText("What you buy : Backpack \nYour Gold : " + hero.getGold());
            }else {
                JOptionPane.showMessageDialog(this, "You don't have enough gold to buy this item!");
            }
        }
    }

    private void buyItem(Item item) {
        if (hero.getGold() >= item.getPrice()) {
            merchant.sellItem(item, hero);
            textArea.setText("What you buy : " + item.getName() + "\nYour Gold : " + hero.getGold());
        } else {
            JOptionPane.showMessageDialog(this, "You don't have enough gold to buy this item!");
        }
    }
}