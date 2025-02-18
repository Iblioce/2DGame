package PlayerAction;

import Entities.Hero;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HeroMouseListener implements MouseListener {
    private Hero hero;

    public HeroMouseListener(Hero hero) {
        this.hero = hero;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            hero.shoot(e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
