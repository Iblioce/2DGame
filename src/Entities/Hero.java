package Entities;

public class Hero extends Entity {
    private boolean isJumping = false;
    public Hero(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void move() {

    }

    public void jump(){
        if(!this.isJumping){
        this.isJumping = true;
    }
}
}
