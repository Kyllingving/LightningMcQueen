package com.mygdx.game;


import com.mygdx.game.Enum.Direction;
import com.mygdx.game.Enum.Rotation;

public class Player implements IPlayer {
    private int health;
    private final int maxHealth;
    private Direction dir;
    private Position pos;
    // private Game game;

    /**
     * Constructs a Player object with position, direction and health
     */
    public Player(Position pos, Direction dir, int health) {
        this.pos = pos;
        this.dir = dir;
        this.health = health;
        this.maxHealth = health;
    }

    /**
     * The piece moves i times in the direction it's facing
     * @param steps
     */
    @Override
    public void move(int steps) {
        for (int j = 0; j < steps; j++) {
            switch (this.dir) {
                case NORTH: this.pos = this.pos.north(); break;
                case EAST: this.pos = this.pos.east(); break;
                case SOUTH: this.pos = this.pos.south(); break;
                case WEST: this.pos = this.pos.west(); break;
            }
        }
    }

    /**
     * This player loses 1 health
     */
    @Override
    public void takeDamage() {
        this.health--;
    }

    /**
     * Player's health goes back to max
     */
    @Override
    public void repair() {
        this.health = this.maxHealth;
    }


    /**
     * The player rotates in the designated direction
     * @param rot
     */
    @Override
    public void rotate(Rotation rot) {
        if (rot == Rotation.R) {
            switch (this.dir) {
                case NORTH: this.dir = Direction.EAST; break;
                case EAST: this.dir = Direction.SOUTH; break;
                case SOUTH: this.dir = Direction.WEST; break;
                case WEST: this.dir = Direction.NORTH; break;
            }
        }
        else if (rot == Rotation.L) {
            switch (this.dir) {
                case NORTH: this.dir = Direction.WEST; break;
                case EAST: this.dir = Direction.NORTH; break;
                case SOUTH: this.dir = Direction.EAST; break;
                case WEST: this.dir = Direction.SOUTH; break;
            }
        }
        else if (rot == Rotation.U) {
            switch (this.dir) {
                case NORTH: this.dir = Direction.SOUTH; break;
                case EAST: this.dir = Direction.WEST; break;
                case SOUTH: this.dir = Direction.NORTH; break;
                case WEST: this.dir = Direction.EAST; break;
            }
        }
        else {
            throw new IllegalArgumentException("Not a valid rotation!");
        }
    }

    /**
     * @return This player's current health
     */
    @Override
    public int getHealth() {
        return this.health;
    }

    /**
     * @return The direction this player currently is facing
     */
    @Override
    public Direction getDirection() {
        return this.dir;
    }

    @Override
    public Position getPos() {
        return this.pos;
    }

    /**
     * @return true if player's health is above 0, otherwise false
     */
    @Override
    public boolean isAlive() {
        return this.health > 0;
    }
}
