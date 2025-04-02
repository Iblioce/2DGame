package Visual;

import Map.Map;
import PlayerAction.HeroMouseListener;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private GamePanel gamePanel;
    private JLabel scoreLabel;
    private JLabel healthLabel;


    public GameWindow(Map gameMap) {
        super("2D Scroller");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(gameMap.getWidth(), gameMap.getHeight());
        this.setResizable(true);
        this.setBackground(Color.black);

        this.gamePanel = new GamePanel(gameMap);
        this.add(gamePanel);

        this.addMouseListener(new HeroMouseListener(gameMap.getHero()));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBackground(Color.DARK_GRAY);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 20));

        healthLabel = new JLabel("Health: 3");
        healthLabel.setFont(new Font("Arial", Font.BOLD, 20));

        infoPanel.add(scoreLabel);
        infoPanel.add(Box.createHorizontalStrut(20));
        infoPanel.add(healthLabel);

        this.add(infoPanel,  BorderLayout.NORTH);
        this.setVisible(true);
    }

    public void updateScore(int score) {
        this.scoreLabel.setText("Score: " + score);
    }

    public void updateHealth(int health){
        this.healthLabel.setText("Health: " + health);
    }

    public void refresh() {
        gamePanel.repaint();
    }
}
