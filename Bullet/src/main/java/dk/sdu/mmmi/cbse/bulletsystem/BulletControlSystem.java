package dk.sdu.mmmi.cbse.bulletsystem;

import dk.sdu.mmmi.cbse.common.bullet.Bullet;
import dk.sdu.mmmi.cbse.common.bullet.BulletSPI;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX * 2);
            bullet.setY(bullet.getY() + changeY * 2);

            if (!bullet.isAlive()) {
                world.removeEntity(bullet);
            }
        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        Entity bullet = new Bullet();
        bullet.setX(shooter.getX());
        bullet.setY(shooter.getY());
        double size = shooter.getSize()/10;
        bullet.setPolygonCoordinates(size, -size, size, size, -size, size, -size, -size);
        bullet.setRotation(shooter.getRotation());
        bullet.setRadius(size);
        bullet.setAlive(true);
        bullet.setParent(shooter);
        return bullet;
    }
}
