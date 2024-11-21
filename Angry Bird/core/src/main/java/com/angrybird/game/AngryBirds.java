package com.angrybird.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class AngryBirds extends Game {
    public SpriteBatch batch;
    private Screen currentLevel;

    @Override
    public void create() {
        batch = new SpriteBatch();
        this.setScreen(new LoadingScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    public void setCurrentLevel(Screen level) {
        this.currentLevel = level;
    }

    public Screen getCurrentLevel() {
        return currentLevel;
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
