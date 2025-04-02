package Entities;

import java.util.List;

public class EntitySpawner {

    public EntitySpawner(){

    }

    public static Entity getEntity(String name){
        Entity entity = null;
        switch (name){
            case "BasicEnemy":
                entity = new BasicEnemy(50, 50);
                break;
        }
        return entity;
    }
}
