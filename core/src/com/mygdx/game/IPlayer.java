package com.mygdx.game;


import com.mygdx.game.Enum.Direction;
import com.mygdx.game.Enum.Rotation;

public interface IPlayer {

    /**
     * @param steps
     *          Times the player moves in the direction it's facing
     */
    void move(int steps);



    /**
     * Player loses 1 health
     */
    void takeDamage();



    /**
     * Player's health goes back to max
     */
    void repair();



    /**
     * Player rotates right or left
     * @param rot
     *         the direction to turn
     */
    void rotate(Rotation rot);



    /**
     * @return this player's health
     */
    int getHealth();



    /**
     * @return This player's current facing direction
     */
    Direction getDirection();

    /**
     * @return
     *      This player's current position
     */
    Position getPos();


    /**
     * @return true if player's health is above 0, otherwise false
     */
    boolean isAlive();


}
