package dk.sdu.mmmi.cbse.asteroid;

import dk.sdu.mmmi.cbse.common.asteroids.Asteroid;
import dk.sdu.mmmi.cbse.common.asteroids.IAsteroidSplitter;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.World;

import java.util.List;
import java.util.Random;


public class AsteroidSplitter implements IAsteroidSplitter {

    @Override
    public void createSplitAsteroid(Entity e, World world) {

        int splits = (int)Math.floor(e.getSize() / 3);
        if (splits <= 1 || e.getSize() <= 5) {
            return;
        }
        double size = e.getSize()/(splits);
        System.out.println(splits);
        System.out.println(size);
        for (int i = 0; i<splits; i++) {
            Entity asteroid = new Asteroid();
            asteroid.setRadius(size);
            asteroid.setSize(size);
            asteroid.setAlive(true);
            asteroid.setPolygonCoordinates(size,-size,-size,-size,-size,size, size, size);
            asteroid.setX(e.getX());
            asteroid.setY(e.getY());
            asteroid.setRotation(-e.getRotation()+(360/splits)*i);
            world.addEntity(asteroid);
        }
    }

}