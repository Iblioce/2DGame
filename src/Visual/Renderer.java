package Visual;

import Entities.Enemy;
import Entities.Entity;
import Entities.Hero;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class Renderer  {
    private BufferedImage heroImage;
    private BufferedImage ennemyImage;

    public Renderer(){
        try {
            heroImage = ImageIO.read(new File("res/images/hero.png"));
            ennemyImage = ImageIO.read(new File("res/images/enemy.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void renderGamePlay(Graphics g, Hero hero, List<Entity> entities) {
        g.setColor(java.awt.Color.BLUE);
        g.drawImage(heroImage,hero.getX(), hero.getY(),null);

        for (Entity entity : entities) {
            if (entity instanceof Enemy) {
                renderEnemy(g, (Enemy) entity);
            }
        }
    }

    private void renderEnemy(Graphics g, Enemy enemy) {
        g.setColor(java.awt.Color.RED);
        g.drawImage(ennemyImage,enemy.getX(),enemy.getY(),null);
    }
}
