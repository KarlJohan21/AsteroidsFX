package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 * Interface for game plugin services.
 */
public interface IGamePluginService {

    /**
     * Method to start the game plugin.
     *
     * @param gameData The game data containing necessary information about the game state.
     * @param world The game world containing all graphical elements.
     */
    void start(GameData gameData, World world);

    /**
     * Method to stop the game plugin service.
     *
     * @param gameData The game data containing necessary information about the game state.
     * @param world The game world containing all graphical elements.
     */
    void stop(GameData gameData, World world);
}
