package com.group1.game;

import java.util.List;

/**
 * Created by Fatih on 02/12/2014.
 */
public class HostileCharacter extends NonPlayerCharacter {



    Item weapon;


    public Item getWeapon() {
        return weapon;
    }

    /**
     * Constructor for HostileCharacter, Designed to work both when initialization and loading the game
     * NonPlayer
     *
     * @param name      String name to assign to character
     */

    public HostileCharacter(String name, Item weapon) {
        super(name);
        this.weapon = weapon;
        getInventory().add(weapon);
        setStrength(15);
        dead= false;
    }

    public void setHitpoint(int hitpoint) {
        if(hitpoint <0)
        {
            dead = true;
        }

        super.setHitpoint(hitpoint);
    }

    public boolean getAwake() {
        return awake;
    }

    public void setAwake(boolean awake) {
        this.awake = awake;
    }
}
