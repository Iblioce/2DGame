package GameLoop;

import Entities.Enemy;
import Entities.Entity;
import Entities.Hero;
import Map.Map;
import Map.Floor;
import Visual.GameWindow;

import java.awt.*;
import java.util.ArrayList;

public class GamePlay implements GameLoop {
    private Hero hero;
    private Map gameMap;
    private GameWindow window;

    public GamePlay() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        this.gameMap = new Map(screenWidth, screenHeight);
        this.hero = new Hero(screenWidth/10,screenHeight/2,10,50);
        this.gameMap.setHero(hero);
        Floor floor = new Floor(screenHeight/10,screenWidth);
        this.gameMap.setFloor(floor);

        this.window = new GameWindow(gameMap);
        FPSController fpsController = new FPSController(60);
        fpsController.run(this);
    }
    @Override
    public void update() {
        ArrayList<Entity> toRemove = new ArrayList<>();
        if(this.gameMap.getEntities().isEmpty()){
            this.gameMap.addEntity(new Enemy(this.gameMap.getWidth()*9/10, this.gameMap.getHeight()/2, 50, 50));
        }
        for(Entity e : gameMap.getEntities()) {
            e.move();

            if (e instanceof Enemy && hero.collidesWith(e)) {
                toRemove.add(e);
            }
        }
        gameMap.getEntities().removeAll(toRemove);
    }

    @Override
    public void render() {
        // Render game using Swing
        Graphics g = window.getGraphics();
        if (g != null) {
            this.window.repaint();
            g.dispose();
        }
    }

}