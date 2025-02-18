package Entities;


import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Arrow {
    private Image arrowImage;
    private int damage = 1;
    private final int moveSpeed = 20;
    private int x, y;
    private int width, height;
    private double dx,dy;

    public Arrow(int x, int y,int targetX,int targetY){
        this.x = x;
        this.y = y;
        this.loadArrowImage();
        this.calculateDirection(targetX, targetY);

    }

    private void calculateDirection(int targetX, int targetY) {
        double angle = Math.atan2(targetY - y, targetX - x);
        dx = Math.cos(angle) * moveSpeed;
        dy = Math.sin(angle) * moveSpeed;
    }

    public void move(){
        this.x += (int) dx;
        this.y += (int) dy;
    }

    public Image getArrowImage() {
        return arrowImage;
    }

    public boolean collidesWith(Entity other) {
        if(this.x < other.x + other.width &&
                this.x + this.width > other.x &&
                this.y < other.y + other.height &&
                this.y + this.height > other.y)
        {
            return true;
        }
        else return false;
    }

    private void loadArrowImage() {
        try {
            arrowImage = ImageIO.read(new File("res/images/arrow.png"));
            this.width = arrowImage.getWidth(null);  // Initialize width
            this.height = arrowImage.getHeight(null);
        } catch (IOException e) {
            System.err.println("error, the arrow is not loading.");
            e.printStackTrace();
        }
    }

    public int getX() {
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
