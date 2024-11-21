package com.angrybird.game;

public class WoodenBlock extends GameObject {
    private int strength;

    public WoodenBlock(float x, float y) {
        super("woodenblock.png", x, y);
        this.strength = 1; // Wooden block has low strength
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
