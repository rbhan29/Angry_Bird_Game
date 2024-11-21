package com.angrybird.game;

public class GlassBlock extends GameObject {
    private int strength;

    public GlassBlock(float x, float y) {
        super("glassblock.png", x, y);
        this.strength = 2; // Glass block has medium strength
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
