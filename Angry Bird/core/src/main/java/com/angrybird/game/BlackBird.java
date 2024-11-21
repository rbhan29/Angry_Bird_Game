package com.angrybird.game;

public class BlackBird extends GameObject implements Bird{
    private int damage;

    public BlackBird(float x, float y) {
        super("black.png", x, y);
        this.damage = 3; // Black bird has high damage
    }

    public int getDamage() {
        return damage;
    }
}
