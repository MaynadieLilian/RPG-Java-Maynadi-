package fr.ynov.rpg.gui;
import fr.ynov.rpg.building.Dungeon;
import fr.ynov.rpg.character.*;
import fr.ynov.rpg.item.*;
import javax.swing.*;
import java.awt.*;

public class DungeonGUI extends JFrame {
    private Dungeon dungeon;
    private Hero hero;
    private JTextArea textArea;

    public DungeonGUI(Dungeon dungeon, Hero hero) {
        this.dungeon = dungeon;
        this.hero = hero;

        setTitle("Dungeon Level " + dungeon.getLevel());
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));
        textArea = new JTextArea();
        textArea.setEditable(false);
        updateTextArea();
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        JButton attackButton = new JButton("Attack Monster");
        JButton inventoryButton = new JButton("Open Inventory");
        JButton nextLevelButton = new JButton("Next Level");
        JButton exitButton = new JButton("Exit");
        attackButton.addActionListener(e -> attackMonster());
        inventoryButton.addActionListener(e -> openInventory());
        nextLevelButton.addActionListener(e -> nextLevel());
        exitButton.addActionListener(e -> exitDungeon());
        panel.add(attackButton);
        panel.add(inventoryButton);
        panel.add(nextLevelButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    private void updateTextArea() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dungeon Level: ").append(dungeon.getLevel()).append("\n\n");
        sb.append("Monsters:\n");

        for (int i = 0; i < dungeon.getMonsters().size(); i++) {
            Monster monster = dungeon.getMonsters().get(i);
            sb.append(i + 1).append(". ").append(monster.getName())
                    .append(" (").append(monster.getHealth()).append(" HP)\n");
        }

        sb.append("\nHero Health: ").append(hero.getHealth()).append(" HP\n");
        textArea.setText(sb.toString());
    }

    private void attackMonster() {
        if (dungeon.allDead()) {
            JOptionPane.showMessageDialog(this, "All monsters are dead! Go to the next level.");
            return;
        }

        String[] monsterChoices = new String[dungeon.getMonsters().size()];
        for (int i = 0; i < monsterChoices.length; i++) {
            monsterChoices[i] = dungeon.getMonsters().get(i).getName() +
                    " (" + dungeon.getMonsters().get(i).getHealth() + " HP)";
        }

        int choice = JOptionPane.showOptionDialog(this, "Choose a monster to attack:",
                "Attack", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                monsterChoices, monsterChoices[0]);

        if (choice >= 0 && choice < dungeon.getMonsters().size()) {
            Monster target = dungeon.getMonsters().get(choice);
            if (target.isAlive()) {
                hero.attack(target);
                JOptionPane.showMessageDialog(this, "You attacked " + target.getName() + "!");
            }

            if (!dungeon.allDead()) {
                Monster attackingMonster = dungeon.getMonsters().get(0);
                attackingMonster.attack(hero);
                JOptionPane.showMessageDialog(this, "A monster attacked you!");
            }

            if (hero.getHealth() == 0) {
                JOptionPane.showMessageDialog(this, "YOU ARE DEAD!");
                System.exit(0);
            }
        }

        updateTextArea();
    }

    private void openInventory() {
        java.util.List<Item> items = hero.getInventory().getItems();
        if (items.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Your inventory is empty!", "Inventory", JOptionPane.PLAIN_MESSAGE);
            return;
        }
        String[] options = new String[items.size() + 1];
        for (int i = 0; i < items.size(); i++) {
            options[i] = items.get(i).getName();
        }
        options[items.size()] = "Back";
        int choice = JOptionPane.showOptionDialog(this, "Choose an item to equip:", "Inventory", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, "Back");
        Item selectedItem = items.get(choice);
        if  (selectedItem instanceof Potion) {
            int choice2 = JOptionPane.showOptionDialog(this, "what do you do?","item chosen", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,new String[]{"Drink","Back"} ,"Back");
            if (choice2 == 0) {
                ((Potion)selectedItem).drink();
                hero.getInventory().removeItem(choice);
                JOptionPane.showMessageDialog(this, "You drunk " + selectedItem.getName() + "!");
                updateTextArea();
            }
        }else{
            int choice2 = JOptionPane.showOptionDialog(this, "what do you do?","item choice", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null,new String[]{"equip","Back"} ,"Back");
            if (choice2 == 0) {
                if (selectedItem instanceof Sword && hero instanceof Warrior) {
                    ((Warrior) hero).equipSword((Sword) selectedItem);
                    JOptionPane.showMessageDialog(this, "You equipped the sword!");
                } else if (selectedItem instanceof Sword && hero instanceof Paladin) {
                    ((Paladin) hero).equipSword((Sword) selectedItem);
                    JOptionPane.showMessageDialog(this, "You equipped the sword!");
                } else if (selectedItem instanceof Shield && hero instanceof Paladin) {
                    ((Paladin) hero).equipShield((Shield) selectedItem);
                    JOptionPane.showMessageDialog(this, "You equipped the shield!");
                } else if (selectedItem instanceof Staff && hero instanceof Wizard) {
                    ((Wizard) hero).equipStaff((Staff) selectedItem);
                    JOptionPane.showMessageDialog(this, "You equipped the staff!");
                }else {
                    JOptionPane.showMessageDialog(this, "You cannot equip this item.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }


    private void nextLevel() {
        if (!dungeon.allDead()) {
            JOptionPane.showMessageDialog(this, "Defeat all monsters first!");
            return;
        }

        dungeon.nextLevel();
        setTitle("Dungeon Level " + dungeon.getLevel());
        updateTextArea();
    }

    private void exitDungeon(){
        if (!dungeon.allDead()) {
            JOptionPane.showMessageDialog(this, "Defeat all monsters first!");
            return;
        }

        dungeon.nextLevel();
        this.dispose();

    }
}

