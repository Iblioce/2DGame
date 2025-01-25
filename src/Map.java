import Entities.Entity;
import Entities.Hero;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private int width;
    private int height;
    private List<Entity> entities;
    private Hero hero;

    public Map(int width, int height, Hero hero) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.hero = hero;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public void update() {
        for (Entity entity : entities) {
            entity.move();
        }
    }

    public List<Entity> getEntities() {
        return entities;
    }
    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setEntities(List<Entity> entities) {
        this.entities = entities;
    }
}
