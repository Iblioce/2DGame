import Entities.Enemy;
import Entities.Entity;
import Entities.Hero;

import java.awt.*;

public class Main implements GameLoop {
    private Hero hero;
    private Map gameMap;
    private GameWindow window;

    public Main() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        this.hero = new Hero(screenWidth/10,screenHeight/2,10,50);
        this.gameMap = new Map(screenWidth, screenHeight,this.hero);
        this.gameMap.addEntity(new Enemy(screenWidth*9/10, screenHeight/2, 50, 50));
        this.window = new GameWindow(gameMap);
    }
    @Override
    public void update() {
        for(Entity e : gameMap.getEntities()) {
            e.move();
        }
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
    public static void main(String[] args) {
        Main game = new Main();
        FPSController fpsController = new FPSController(60);
        fpsController.run(game);
    }
}