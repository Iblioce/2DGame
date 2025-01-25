import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private Renderer renderer;
    private Map gameMap;

    public GameWindow(Map gameMap) {
        super("2D Scroller");
        this.gameMap = gameMap;
        this.renderer = new Renderer();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(gameMap.getWidth(), gameMap.getHeight());
        this.setVisible(true);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        renderer.render(g, gameMap.getHero(), gameMap.getEntities());
    }
}
