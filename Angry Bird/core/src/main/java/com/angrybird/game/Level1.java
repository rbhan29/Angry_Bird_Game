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

public class Level1 implements Screen {
    private AngryBirds game;
    private Texture background;
    private Stage stage;
    private Texture pauseButtonTexture;
    private Image pauseButton;

    private Texture redBirdTexture, blackBirdTexture, yellowBirdTexture, slingshotTexture, blockTexture, pigTexture;
    private Image redBird, blackBird, yellowBird, slingshot;
    private Image[] blocks = new Image[6];
    private Image[] pigs = new Image[3];

    public Level1(Game game) {
        this.game = (AngryBirds) game;

        background = new Texture(Gdx.files.internal("levelbackground.png"));
        stage = new Stage();

        pauseButtonTexture = new Texture(Gdx.files.internal("pauseicon.png"));
        pauseButton = new Image(pauseButtonTexture);
        pauseButton.setSize(64, 64);
        pauseButton.addListener(new ClickListener() {
            @Override
            public void clicked(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y) {
                game.setScreen(new PauseGame((AngryBirds) game));
            }
        });

        Table table = new Table();
        table.top().left();
        table.setFillParent(true);
        table.add(pauseButton).size(64, 64).padTop(10).padLeft(10);
        stage.addActor(table);

        redBirdTexture = new Texture(Gdx.files.internal("red.png"));
        blackBirdTexture = new Texture(Gdx.files.internal("black.png"));
        yellowBirdTexture = new Texture(Gdx.files.internal("yellow.png"));
        slingshotTexture = new Texture(Gdx.files.internal("catapault.png"));
        blockTexture = new Texture(Gdx.files.internal("woodenblock.png"));
        pigTexture = new Texture(Gdx.files.internal("littlepig.png"));

        redBird = new Image(redBirdTexture);
        blackBird = new Image(blackBirdTexture);
        yellowBird = new Image(yellowBirdTexture);
        redBird.setSize(40, 40);
        blackBird.setSize(40, 40);
        yellowBird.setSize(40, 40);
        redBird.setPosition(10, 137);
        blackBird.setPosition(50, 137);
        yellowBird.setPosition(90, 137);

        stage.addActor(redBird);
        stage.addActor(blackBird);
        stage.addActor(yellowBird);

        slingshot = new Image(slingshotTexture);
        slingshot.setSize(80, 150);
        slingshot.setPosition(100, 125);
        stage.addActor(slingshot);

        for (int i = 0; i < 6; i++) {
            blocks[i] = new Image(blockTexture);
            blocks[i].setSize(60, 40);

            switch (i) {
                case 0: blocks[i].setPosition(400, 140); break;
                case 1: blocks[i].setPosition(400, 180); break;
                case 2: blocks[i].setPosition(480, 140); break;
                case 3: blocks[i].setPosition(480, 180); break;
                case 4: blocks[i].setPosition(560, 140); break;
                case 5: blocks[i].setPosition(560, 180); break;
            }

            stage.addActor(blocks[i]);
        }

        for (int i = 0; i < 3; i++) {
            pigs[i] = new Image(pigTexture);
            pigs[i].setSize(40, 40);

            switch (i) {
                case 0: pigs[i].setPosition(410, 220); break;
                case 1: pigs[i].setPosition(490, 220); break;
                case 2: pigs[i].setPosition(570, 220); break;
            }

            stage.addActor(pigs[i]);
        }

        ((AngryBirds) game).setCurrentLevel(this);
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
        redBirdTexture.dispose();
        blackBirdTexture.dispose();
        yellowBirdTexture.dispose();
        slingshotTexture.dispose();
        blockTexture.dispose();
        pigTexture.dispose();
    }
}
