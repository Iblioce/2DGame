package Entities;

public class Enemy extends Entity {
    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void move() {
        this.setX(this.getX() - 5);
    }

}