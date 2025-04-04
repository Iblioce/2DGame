package Visual;

import Entities.Arrow;
import Entities.BasicEnemy;
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
    private BufferedImage basicEnemyImage;
    private BufferedImage arrowImage;
    private BufferedImage backgroundImage;

    public Renderer(){
        try {
            heroImage = ImageIO.read(new File("res/images/hero.png"));
            basicEnemyImage = ImageIO.read(new File("res/images/basicEnemy.png"));
            arrowImage = ImageIO.read((new File("res/images/arrow.png")));
            backgroundImage = ImageIO.read(new File("res/images/background0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void renderGamePlay(Graphics g, Hero hero, List<Entity> entities, int width, int height) {
        g.drawImage(backgroundImage, 0, 0, null); // First tile
        for (int x = backgroundImage.getWidth(); x < width; x += backgroundImage.getWidth()) {
            g.drawImage(backgroundImage, x, 0, null);
            for (int y = backgroundImage.getHeight(); y < height; y += backgroundImage.getHeight()) {
                g.drawImage(backgroundImage, x, y, null);
                g.drawImage(backgroundImage, 0, y, null);
            }
        }
        g.drawImage(heroImage, hero.getX(), hero.getY(), null);

        for (Arrow arrow : hero.getArrows()) {
            g.drawImage(arrowImage, arrow.getX(), arrow.getY(), null);
        }

        // Render enemies
        for (Entity entity : entities) {
            if (entity instanceof BasicEnemy) {
                renderBasicEnemy(g, (BasicEnemy) entity);
            }
        }
    }

    private void renderBasicEnemy(Graphics g, BasicEnemy basicEnemy) {
        g.setColor(java.awt.Color.RED);
        g.drawImage(basicEnemyImage, basicEnemy.getX(), basicEnemy.getY(),null);
    }
}
