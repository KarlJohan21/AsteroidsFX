package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;


/**
 * Interface for post-entity processing services.
 */
public interface IPostEntityProcessingService {

    /**
     *
     *
     * @param gameData The game data containing necessary information about the game state.
     * @param world The game world where the game is taking place.
     */
    void process(GameData gameData, World world);
}
