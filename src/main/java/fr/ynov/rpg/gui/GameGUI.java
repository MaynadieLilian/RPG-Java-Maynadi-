package fr.ynov.rpg.gui;

import fr.ynov.rpg.building.Dungeon;
import fr.ynov.rpg.building.Merchant;
import fr.ynov.rpg.building.Tavern;
import fr.ynov.rpg.character.Paladin;
import fr.ynov.rpg.character.Warrior;
import fr.ynov.rpg.character.Wizard;
import fr.ynov.rpg.game.Game;
import javax.swing.*;
import java.awt.*;

public class GameGUI extends JFrame {
    private Game game;
    private JTextField nameField;
    private JPanel panel;

    public GameGUI() {
        game = new Game();
        setTitle("JAVA RPG - Select your Hero");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        JOptionPane.showMessageDialog(this,"Quick, the village needs you to defend it against the monsters that have awoken in the mines!\nPick a Hero");

        JLabel label = new JLabel("ENTER YOUR NAME :");
        nameField = new JTextField();

        JButton warriorButton = new JButton("Warrior: Warriors do an extra 50% more damage");
        JButton paladinButton = new JButton("Paladin: Paladins can equip shields to block damage");
        JButton wizardButton = new JButton("Wizard: Wizards have a 20% chance to dodge attacks");

        warriorButton.addActionListener(e ->startGame("Warrior"));
        paladinButton.addActionListener(e ->startGame("Paladin"));
        wizardButton.addActionListener(e ->startGame("Wizard"));

        panel.add(label);
        panel.add(nameField);
        panel.add(warriorButton);
        panel.add(paladinButton);
        panel.add(wizardButton);

        add(panel);
        setVisible(true);
    }

    private void startGame(String typeHero) {
        switch (typeHero){
            case "Warrior":
                game.setHero(new Warrior(nameField.getText()));
                break;
            case "Paladin":
                game.setHero(new Paladin(nameField.getText()));
                break;
            case "Wizard":
                game.setHero(new Wizard(nameField.getText()));
                break;
        }
        if (game.getHero().getName().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please enter your name !");
            return;
        }
        JOptionPane.showMessageDialog(this, "Welcome to the village " + game.getHero().getName() + " !");
        openVillage();
    }

    private void openVillage() {
        panel.removeAll();
        panel.setLayout(new GridLayout(4, 1));
        JLabel villageLabel = new JLabel("Where you want to go?!");
        JButton dungeonButton = new JButton("Go to  Dungeon\n\"The Dungeon is where you can fight the monsters that are attacking the village. The monsters drop gold that you can use to buy or upgrade your gear.\"");
        JButton tavernButton = new JButton("Go to Tavern\nThe Tavern is where you can restore your health, but that comes at a price.");
        JButton merchantButton = new JButton("Go to Merchant\nThe Merchant is where you can buy items with the gold you earn.");
        dungeonButton.addActionListener(e -> enterBuilding("Dungeon"));
        tavernButton.addActionListener(e -> enterBuilding("Tavern"));
        merchantButton.addActionListener(e -> enterBuilding("Merchant"));
        panel.add(villageLabel);
        panel.add(dungeonButton);
        panel.add(tavernButton);
        panel.add(merchantButton);
        panel.revalidate();
        panel.repaint();
    }

    private void enterBuilding(String building) {
        JOptionPane.showMessageDialog(this, "You enter in the" + building + " !");
        switch (building){
            case "Dungeon":
                if(game.getVillage().getBuildings().getFirst() instanceof Dungeon){
                    new DungeonGUI((Dungeon) game.getVillage().getBuildings().getFirst(),game.getHero());
                    break;
                }
            case "Tavern":
                if(game.getVillage().getBuildings().get(1) instanceof Tavern){
                    new TavernGUI((Tavern) game.getVillage().getBuildings().get(1),game.getHero());
                    break;
                }
            case "Merchant":
                if (game.getVillage().getBuildings().getLast() instanceof Merchant){
                    new MerchantGUI((Merchant) game.getVillage().getBuildings().getLast(), game.getHero());
                    break;
                }
        }

    }

}
