package com.angrybird.game;

public class StoneBlock extends GameObject {
    private int strength;

    public StoneBlock(float x, float y) {
        super("stoneblock.png", x, y);
        this.strength = 3; // Stone block has high strength
    }

    public void takeDamage(int damage) {
        strength -= damage;
        if (strength <= 0) {
            // Handle destruction
        }
    }

    public int getStrength() {
        return strength;
    }
}
