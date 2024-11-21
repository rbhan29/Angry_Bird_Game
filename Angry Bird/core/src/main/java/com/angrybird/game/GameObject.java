// In GameObject.java
package com.angrybird.game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Gdx;

public abstract class GameObject {
    protected Texture texture;
    protected float x, y;  // Define x and y coordinates as properties

//    public GameObject(Texture texture, float x, float y) {
//        this.texture = texture;
//        this.x = x; // Initialize x coordinate
//        this.y = y; // Initialize y coordinate
//    }
    public GameObject(String texturePath, float x, float y) {
        this.texture = new Texture(Gdx.files.internal(texturePath));
        this.x = x;
        this.y = y;
    }

    // Draw method for rendering the texture at the specified x and y
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public void dispose() {

    }

    // Any additional methods or updates that might be needed for GameObject
}
