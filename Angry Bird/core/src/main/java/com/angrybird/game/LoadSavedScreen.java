package com.angrybird.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class LoadSavedScreen implements Screen {
    private final Game game;
    private final Stage stage;
    private final SpriteBatch batch;
    private final Texture backgroundImage;
    private final Skin skin;

    public LoadSavedScreen(Game game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        backgroundImage = new Texture(Gdx.files.internal("pausebackground.png"));
        skin = new Skin(Gdx.files.internal("uiskin.json"));

        TextButton loadGame1Button = new TextButton("Load Game 1", skin);
        TextButton loadGame2Button = new TextButton("Load Game 2", skin);

        Table table = new Table();
        table.setFillParent(true);
        table.add(loadGame1Button).pad(20);
        table.row();
        table.add(loadGame2Button).pad(20);

        stage.addActor(table);
    }

    @Override
    public void show() {}

    @Override
    public void render(float delta) {
        batch.begin();
        batch.draw(backgroundImage, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        backgroundImage.dispose();
        skin.dispose();
    }
}
