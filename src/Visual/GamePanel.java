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
    private Renderer renderer;

    public GamePanel(Map gameMap) {
        this.gameMap = gameMap;
        this.renderer = new Renderer();
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

        renderer.renderGamePlay(g, hero, entities,gameMap.getWidth(),gameMap.getHeight());

    }
}
