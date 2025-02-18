package Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Hero extends Entity {
    private Image heroImage;
    private List<Arrow> arrows = new ArrayList<>();
    private int shotCD = 0 ;

    public Hero(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.loadHeroImage();
    }

    @Override
    public void move() {
    }
    public void shoot(int targetX, int targetY) {
        if (shotCD == 0) {
            Arrow arrow = new Arrow(this.x, this.y, targetX, targetY);
            arrows.add(arrow);
            shotCD = 20; // number of frames before the next possible shot.
        }
    }

    public List<Arrow> getArrows() {
        return arrows;
    }

    private void loadHeroImage() {
        try {
            heroImage = ImageIO.read(new File("res/images/hero.png"));
        } catch (IOException e) {
            System.err.println("error, the hero is not loading.");
            e.printStackTrace();
        }
    }

    public Image getHeroImage() {
        return heroImage;

    }

    public int getShotCD() {
        return shotCD;
    }

    public void setShotCD(int shotCD) {
        this.shotCD = shotCD;
    }
    public void reduceCooldown() {
        if (shotCD > 0) {
            shotCD--;
        }
    }
}