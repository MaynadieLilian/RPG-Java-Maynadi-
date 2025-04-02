package fr.ynov.rpg.main;

import fr.ynov.rpg.game.Game;
import fr.ynov.rpg.gui.GameGUI;

import javax.swing.*;

public class ApplicationRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameGUI::new);
    }
}
