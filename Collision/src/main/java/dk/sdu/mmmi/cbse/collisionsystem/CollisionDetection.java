package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

public class CollisionDetection implements IPostEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        // two for loops for all entities in the world
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                // if the two entities are identical, skip the iteration
                if (entity1.getID().equals(entity2.getID()) || entity1.getClass().equals(entity2.getClass())) {
                    continue;
                }

                if ((entity1.getParent() != null && entity1.getParent().getClass().equals(entity2.getClass())) || (entity2.getParent() != null && entity2.getParent().getClass().equals(entity1.getClass()))) {
                    continue;
                }

                // CollisionDetection
                if (this.collides(entity1, entity2)) {
                    entity1.setAlive(false);
                    entity2.setAlive(false);
                }
            }
        }

    }

    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }
}
