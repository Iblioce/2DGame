package Visual;

import Map.Map;
import PlayerAction.HeroKeyListener;
import PlayerAction.HeroMouseListener;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GamePanel gamePanel;

    public GameWindow(Map gameMap) {
        super("2D Scroller");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(gameMap.getWidth(), gameMap.getHeight());
        this.setResizable(true);
        this.setBackground(Color.black);

        this.gamePanel = new GamePanel(gameMap);
        this.add(gamePanel);

        this.addMouseListener(new HeroMouseListener(gameMap.getHero()));

        this.setVisible(true);
    }

    public void refresh() {
        gamePanel.repaint();
    }
}
