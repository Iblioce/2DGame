package Map;

import Entities.Entity;
import Entities.EntitySpawner;
import Entities.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private int width;
    private int height;
    private List<Entity> entities;
    private Hero hero;
    private Floor floor;
    private EntitySpawner entitySpawner;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new ArrayList<>();
        this.hero = hero;
    }

    public void addEntity(Entity entity) {
        this.entities.add(entity);
    }

    public void spawn(String name){
        Random seed = new Random();
        int ran = seed.nextInt(8)+2;
        Entity entity = EntitySpawner.getEntity(name);
        entity.setX(this.getWidth() * 9 / 10);
        entity.setY(this.getHeight() / ran);
        this.addEntity(entity);

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

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Floor getFloor() {
        return floor;
    }
}
