package Visual;

import Map.Map;
import PlayerAction.HeroKeyListener;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GamePanel gamePanel;

    public GameWindow(Map gameMap) {
        super("2D Scroller");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(gameMap.getWidth(), gameMap.getHeight());
        this.setResizable(true);

        this.gamePanel = new GamePanel(gameMap);
        this.add(gamePanel);

        this.addKeyListener(new HeroKeyListener(gameMap.getHero()));

        this.setVisible(true);
    }

    public void refresh() {
        gamePanel.repaint();  // Rafraîchit proprement l'affichage
    }
}
