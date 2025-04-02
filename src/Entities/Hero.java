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
    private double shotCD = 0 ;
    private int health = 3;

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

    public double getShotCD() {
        return shotCD;
    }

    public void setShotCD(double shotCD) {
        this.shotCD = shotCD;
    }
    public void reduceCooldown() {
        if (shotCD > 0) {
            shotCD--;
        }
    }
    public void setStunned(double sec){
        this.setShotCD(this.getShotCD()+sec*60);
    }

    public void loseHealth(){
        this.health--;
    }
    
    public int gethealth(){
        return this.health;
    }
}