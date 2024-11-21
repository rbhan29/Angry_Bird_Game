package com.angrybird.game;

public class RedBird extends GameObject implements Bird {
    private int damage;

    public RedBird(float x, float y) {
        super("red.png", x, y);
        this.damage = 1; // Damage level unique to bird type
    }

    public int getDamage() {
        return damage;
    }

    // You can add additional behaviors for each bird type
}
