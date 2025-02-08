package Visual;

import Entities.Enemy;
import Entities.Entity;
import Entities.Hero;
import Map.Map;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GamePanel extends JPanel {
    private Map gameMap;

    public GamePanel(Map gameMap) {
        this.gameMap = gameMap;
        this.setDoubleBuffered(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGame(g);
    }

    private void drawGame(Graphics g) {
        Hero hero = gameMap.getHero();
        List<Entity> entities = gameMap.getEntities();

        g.drawImage(hero.getHeroImage(), hero.getX(), hero.getY(), hero.getWidth(), hero.getHeight(), null);

        g.setColor(Color.BLACK);
        for (Entity entity : entities) {
            if (entity instanceof Enemy enemy) {
                g.drawImage(enemy.getEnemyImage(), enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight(), null);
            }
        }
    }
}
