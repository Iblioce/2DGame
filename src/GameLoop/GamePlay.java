package GameLoop;

import Entities.Arrow;
import Entities.BasicEnemy;
import Entities.Entity;
import Entities.Hero;
import Map.Map;
import Map.Floor;
import Visual.GameWindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GamePlay implements GameLoop {
    private Hero hero;
    private Map gameMap;
    private GameWindow window;
    private long lastSpawnTime;
    private int score = 0;

    public GamePlay() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        this.gameMap = new Map(1080, 720);
        this.hero = new Hero(this.gameMap.getWidth()/10,this.gameMap.getHeight()/2,50,50);
        this.gameMap.setHero(hero);
        Floor floor = new Floor(this.gameMap.getHeight()/10,this.gameMap.getWidth());
        this.gameMap.setFloor(floor);

        this.window = new GameWindow(gameMap);
        FPSController fpsController = new FPSController(60);
        fpsController.run(this);
    }
    @Override
    public void update() {
        ArrayList<Entity> toRemove = new ArrayList<>();
        long currentTime = System.currentTimeMillis();
        if (this.gameMap.getEntities().isEmpty() || (currentTime - lastSpawnTime >= 5000 - (long)score * 10)){
            this.gameMap.spawn("BasicEnemy");
            lastSpawnTime = currentTime;
        }

        // Move entities and check for collisions
        for (Entity e : gameMap.getEntities()) {
            e.move();
            if (e instanceof BasicEnemy && hero.collidesWith(e)) {
                toRemove.add(e);
                hero.loseHealth();
                System.out.print("hurt");
                updateHealth();
            }
            else if(e.getX() <= 0){
                hero.setStunned(0.5);
                toRemove.add(e);
            }
        }

        List<Arrow> arrowsToRemove = new ArrayList<>();

        // Iterate through arrows
        for (Arrow arrow : hero.getArrows()) {
            arrow.move();

            // Check if arrow goes off-screen
            if (arrow.getX() < 0 || arrow.getX() > gameMap.getWidth() ||
                    arrow.getY() < 0 || arrow.getY() > gameMap.getHeight()) {
                arrowsToRemove.add(arrow);
                continue; // Skip further checks for this arrow
            }


            for (Entity e : gameMap.getEntities()) {
                if (e instanceof BasicEnemy && arrow.collidesWith(e)) {
                    toRemove.add(e);
                    arrowsToRemove.add(arrow);
                    this.updateScore(1);
                    break;
                }

            }
        }
        hero.reduceCooldown();


        hero.getArrows().removeAll(arrowsToRemove);
        gameMap.getEntities().removeAll(toRemove);
    }

    @Override
    public void render() {
        this.window.refresh();
    }
    public void updateScore(int bonus) {
        this.score += bonus;
        this.window.updateScore(this.score); // Update the JLabel in GameWindow
    }

    public void updateHealth(){
        this.window.updateHealth(hero.gethealth());
    }

    public int getScore(){
        return this.score;
    }

}