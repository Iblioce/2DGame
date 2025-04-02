package Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BasicEnemy extends Entity {
    private Image enemyImage;
    public BasicEnemy(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.loadEnemyImage();
    }
    public BasicEnemy(int width, int height){
        super(0,0,width,height);
        this.loadEnemyImage();
    }

    @Override
    public void move() {
        this.x=this.x-5;
    }

    private void loadEnemyImage() {
        try {
            enemyImage = ImageIO.read(new File("res/images/basicEnemy.png"));
        } catch (IOException e) {
            System.err.println("error, the enemy is not loading.");
            e.printStackTrace();
        }
    }

    public Image getEnemyImage() {
        return enemyImage;
    }
}