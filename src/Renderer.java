import Entities.Enemy;
import Entities.Entity;
import Entities.Hero;

import java.awt.*;
import java.util.List;

public class Renderer {
    public void render(Graphics g, Hero hero, List<Entity> entities) {
        g.setColor(java.awt.Color.BLUE);
        g.fillRect(hero.getX(), hero.getY(), hero.getWidth(), hero.getHeight());

        for (Entity entity : entities) {
            if (entity instanceof Enemy) {
                renderEnemy(g, (Enemy) entity);
            }
        }
    }

    private void renderEnemy(Graphics g, Enemy enemy) {
        g.setColor(java.awt.Color.RED);
        g.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
    }
}
