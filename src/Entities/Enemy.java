package Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Enemy extends Entity {
    private Image enemyImage;
    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.loadEnemyImage();
    }

    @Override
    public void move() {
        this.x=this.x-5;
    }

    private void loadEnemyImage() {
        try {
            enemyImage = ImageIO.read(new File("res/images/enemy.png"));
        } catch (IOException e) {
            System.err.println("error, the enemy is not loading.");
            e.printStackTrace();
        }
    }

    public Image getEnemyImage() {
        return enemyImage;
    }
}