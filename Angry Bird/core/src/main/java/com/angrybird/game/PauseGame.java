package com.angrybird.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class PauseGame implements Screen {
    private final AngryBirds game;
    private final Stage stage;
    private final SpriteBatch batch;
    private final Texture backgroundImage;
    private Texture resumeIcon;
    private Texture settingsIcon;
    private Texture restart;
    private Texture savenexit;

    public PauseGame(final AngryBirds game) {
        this.game = game;
        this.batch = new SpriteBatch();
        this.stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);
        backgroundImage = new Texture(Gdx.files.internal("pausebackground.png"));
        resumeIcon = new Texture(Gdx.files.internal("resumeicon.png"));
        settingsIcon = new Texture(Gdx.files.internal("settingsicon.png"));
        restart = new Texture(Gdx.files.internal("restart.png"));
        savenexit = new Texture(Gdx.files.internal("saveandexiticon.png"));
        ImageButton resumeButton = createButton(resumeIcon);
        ImageButton settingsButton = createButton(settingsIcon);
        ImageButton displayButton1 = createButton(restart);
        ImageButton displayButton2 = createButton(savenexit);
        resumeButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                if (game.getCurrentLevel() != null) {
                    game.setScreen(game.getCurrentLevel());
                }
            }
        });
        settingsButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                game.setScreen(new SettingsMenu(game));
            }
        });
        Table table = new Table();
        table.setFillParent(true);
        table.center();
        table.add(resumeButton).pad(10).size(100, 100);
        table.row();
        table.add(settingsButton).pad(10).size(100, 100);
        table.row();
        table.add(displayButton1).pad(10).size(100, 100);
        table.row();
        table.add(displayButton2).pad(10).size(100, 100);
        stage.addActor(table);
    }

    private ImageButton createButton(Texture texture) {
        ImageButton button = new ImageButton(new TextureRegionDrawable(texture));
        button.getImage().setFillParent(true);
        return button;
    }

    @Override
    public void show() { }

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
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() {
        batch.dispose();
        stage.dispose();
        backgroundImage.dispose();
        resumeIcon.dispose();
        settingsIcon.dispose();
        restart.dispose();
        savenexit.dispose();
    }
}
