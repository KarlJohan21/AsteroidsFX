package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;

import java.util.Random;

public class EnemyPlugin implements IGamePluginService {
    @Override
    public void start(GameData gameData, World world) {
        for(int i = 0; i < 5; i++) {
            Entity enemy = createEnemyShip(gameData);
            world.addEntity(enemy);
        }
    }

    private Entity createEnemyShip(GameData gameData) {
        Random rnd = new Random();
        Entity Enemy = new Enemy();
        int size = rnd.nextInt(20) + 10;
        Enemy.setPolygonCoordinates(-size,0, -size/2,-size/2,size,0,-size/2,size/2, -size,0);
        Enemy.setX(gameData.getDisplayHeight());
        Enemy.setY(gameData.getDisplayWidth());
        Enemy.setRotation(180+rnd.nextInt(90));
        double targetX = rnd.nextDouble(gameData.getDisplayHeight());
        double targetY = rnd.nextDouble(gameData.getDisplayWidth());
        Enemy.setTarget(targetX, targetY);
        Enemy.setShootCounter(100);
        Enemy.setSize(size);
        Enemy.setRadius(size*2/3);
        Enemy.setAlive(true);
        return Enemy;
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {
            world.removeEntity(enemy);
        }
    }
}
