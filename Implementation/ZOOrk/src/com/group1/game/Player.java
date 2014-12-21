package com.group1.game;

import java.util.List;

//import static com.group1.game.Direction.*;

/**
 * Created by Fatih on 27/11/2014.
 */
public class Player extends Character {
    private String seed;
    private int fullness;
    private int heat;
    private int strength;
    private int sanity;
    private final int MAX_FULLNESS = 20;
    private boolean alive = true;
    int x,y;


    /**
     * Constructor for Player, Designed to work both when initialization and loading the game
     *
     * @param name      String name to assign to Player
     * @param inventory List of Items Player has
     * @param x         Location of the Player
     * @param y         Location of the Player
     */

    public Player(String name, List<Item> inventory, int x, int y) {
        super(name);
        this.x=x;
        this.y=y;
    }

    /**
     * Player moves according to given direction if it is possible,
     * result given with an appropriate string message
     * This method designed to be called from Player object inside Game object inside Parser object
     * game.player.move(Direction.d);
     *
     * @param direction to move
     * @return resulting boolean or string message depending on the implementation
     */
    public String go(Direction direction) {
        String message = "";
        if (getCurrent().isPassable(direction)) {
            setCurrent(getCurrent().getAdjacent(direction));
            message = getCurrent().getMessage();
        }
        else
            message = "You can't go that way.";
        return message;
    }

    /**
     * Player interacts with given Thing if it is possible,
     * result given with an appropriate string message
     * This method designed to be called from Player object inside Game object inside Parser object
     * game.player.interact(thing);
     *
     * @param thing to interact
     * @return resulting boolean or string message depending on the implementation
     */
    public String interact(Thing thing) {
        return "Message";
    }

    /**
     * Player uses given Item if it is possible,
     * result given with an appropriate string message
     * This method designed to be called from Player object inside Game object inside Parser object
     * game.player.use(item);
     *
     * @param item to interact
     * @return resulting boolean or string message depending on the implementation
     */
    public String use(Item item) {
        int foodVal = item.getFoodValue();
        String message = "";
        if (foodVal > 0){
            fullness += foodVal;
            getInventory().remove(item);
            if (fullness >= MAX_FULLNESS)
                fullness = MAX_FULLNESS;
            message = "Thank you. I really needed that.";
        }
        else
            message = "Are you serious? Me... Eating.. that " + item.getName();
        return message;
    }

    /**
     * Player takes given Item if it is possible,
     * result given with an appropriate string message
     * Item will be added to players inventory
     * This method designed to be called from Player object inside Game object inside Parser object
     * game.player.take(item);
     *
     * @param item to take
     * @return resulting boolean or string message depending on the implementation
     */
    public String take(Item item) {
        if (super.getInventory().size() < 15) {
            super.getInventory().add(item);
            return "Taken.";
        }
        else
            return "Cannot take item because your inventory is full.";
    }

    /**
     * Player looks to given direction if it is possible,
     * result given with an appropriate string message
     * This method designed to be called from Player object inside Game object inside Parser object
     * game.player.look(Direction.d);
     *
     * @param direction to look
     * @return resulting boolean or string message depending on the implementation
     */
    public String look(Direction direction) {
        return getCurrent().getAdjacent(direction).getMessage();
    }

    /**
     * Player inspects given thing if it is possible,
     * result given with an appropriate string message
     * This method designed to be called from Player object inside Game object inside Parser object
     * game.player.inspect(item);
     * Reader will understand look Thing, as inspect Thing
     *
     * @param thing to take
     * @return resulting boolean or string message depending on the implementation
     */
    public String inspect(Thing thing) {
        return thing.getMessage();
    }

    public String getSeed() {
        return seed;
    }

    public int getFullness() {

        return fullness;
    }

    private String update() {
        // TODO
        String message = null;
        fullness--;
        if (fullness <= 0) {
            alive = false;
            message = "You are dead! GAME OVER";
        }
        else if (fullness < 5)
            message = "Your health is running dangerously low. If you don't eat something you will die.";
        else
            message = "";
        return message;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSanity() {
        return sanity;
    }

    public void setSanity(int sanity) {
        this.sanity = sanity;
    }
}
