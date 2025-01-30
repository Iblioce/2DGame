package PlayerAction;

import Entities.Hero;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HeroKeyListener implements KeyListener {
    private Hero hero;

    public HeroKeyListener(Hero hero) {
        this.hero = hero;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            hero.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
