package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import java.util.Random;

public class AsteroidPlugin implements IGamePluginService {

    @Override
    public void start(GameData gameData, World world) {
        for (int i = 0; i < 10; i++) {
            Entity asteroid = createAsteroid(gameData);
            world.addEntity(asteroid);
        }
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            world.removeEntity(asteroid);
        }
    }

    private Entity createAsteroid(GameData gameData) {
        Entity asteroid = new Asteroid();

        Random rnd = new Random();
        int size = rnd.nextInt(10) + 5 ;
        asteroid.setSize(size);
        asteroid.setPolygonCoordinates(size,-size,-size,-size,-size,size, size, size);
        asteroid.setX(0);
        asteroid.setY(0);
        asteroid.setRotation(rnd.nextInt(90));
        asteroid.setRadius(size);
        asteroid.setAlive(true);

        return asteroid;
    }
}