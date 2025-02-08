package Entities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Hero extends Entity {
    private Image heroImage;
    private boolean isJumping = false;

    public Hero(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.loadHeroImage();
    }

    @Override
    public void move() {

    }

    public void jump() {
        if (!this.isJumping) {
            this.isJumping = true;

        }
        else{
            this.isJumping = false;
        }

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
}