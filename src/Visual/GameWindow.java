package Visual;

import Entities.Hero;
import Map.Map;
import PlayerAction.HeroKeyListener;

import javax.swing.*;
import java.awt.*;


public class GameWindow extends JFrame {
    private Visual.Renderer renderer;
    private Map gameMap;
    private Hero hero;

    public GameWindow(Map gameMap) {
        super("2D Scroller");
        this.gameMap = gameMap;
        this.hero = gameMap.getHero();
        this.renderer = new Renderer();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(gameMap.getWidth(), gameMap.getHeight());
        this.setVisible(true);

        this.addKeyListener(new HeroKeyListener(hero));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        renderer.renderGamePlay(g, gameMap.getHero(), gameMap.getEntities());
    }
}
