package com.angrybird.game;

public class YellowBird extends GameObject implements Bird {
    private int damage;

    public YellowBird(float x, float y) {
        super("yellow.png", x, y);
        this.damage = 2; // Yellow bird has medium damage
    }

    public int getDamage() {
        return damage;
    }
}
