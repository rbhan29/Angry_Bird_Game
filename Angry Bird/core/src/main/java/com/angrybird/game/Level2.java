package com.angrybird.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Level2 implements Screen {
    private AngryBirds game;
    private Texture background;
    private Stage stage;
    private Texture pauseButtonTexture;
    private Image pauseButton;

    public Level2(Game game) {
        this.game = (AngryBirds) game;

        background = new Texture(Gdx.files.internal("levelbackground.png"));

        stage = new Stage();

        pauseButtonTexture = new Texture(Gdx.files.internal("pauseicon.png"));
        pauseButton = new Image(pauseButtonTexture);

        pauseButton.setSize(64, 64);


        pauseButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                game.setScreen(new PauseGame((AngryBirds) game)); // Navigate to PauseMenu
            }
        });


        Table table = new Table();
        table.top().left();
        table.setFillParent(true);
        table.add(pauseButton).size(64, 64).padTop(10).padLeft(10);


        stage.addActor(table);
    }

    @Override
    public void show() {

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();
        game.batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        game.batch.end();

        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() {
        background.dispose();
        stage.dispose();
        pauseButtonTexture.dispose();
    }
}
