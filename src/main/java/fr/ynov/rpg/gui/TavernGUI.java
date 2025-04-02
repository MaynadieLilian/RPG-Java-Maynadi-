package fr.ynov.rpg.gui;

import fr.ynov.rpg.building.Tavern;
import fr.ynov.rpg.character.Hero;

import javax.swing.*;
import java.awt.*;

public class TavernGUI extends JFrame {
    private Hero hero;
    private Tavern tavern;
    private JTextArea textArea;

     public TavernGUI(Tavern tavern,Hero hero) {
        this.tavern =tavern;
        this.hero = hero;

        setTitle("Tavern");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,1));
        textArea = new JTextArea("Welcome to the Merchant !\nYour Gold : " + hero.getGold()+"\nYou can pay 30 Gold to get full health");
        textArea.setEditable(false);
        panel.add(textArea);
        JButton healButton = new JButton("Heal");
        JButton exitButton = new JButton("Exit");
        healButton.addActionListener(e -> {healGui(this.hero,this.tavern);});
        exitButton.addActionListener(e -> {dispose();});
        panel.add(healButton);
        panel.add(exitButton);
        add(panel);
        setVisible(true);
    }

    public void healGui(Hero hero ,Tavern tavern){
         if(hero.getGold()<30){
             textArea.setText("Welcome to the Merchant !\nYour Gold : " + hero.getGold()+"\nNot enough Gold to get full health");
         }else {
             tavern.heal(hero);
             textArea.setText("Welcome to the Merchant !\nYour Gold : " + hero.getGold()+"\nThat good now you have 100 health");
         }
    }
}
