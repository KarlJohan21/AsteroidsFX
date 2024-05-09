package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Interface of entity processing services.
 */
public interface IEntityProcessingService {

    /**
     * Method to process entities within the game.
     *
     * @param gameData The game data containing necessary information about the game state.
     * @param world The game world containing all graphical elements.
     */
    void process(GameData gameData, World world);
}
