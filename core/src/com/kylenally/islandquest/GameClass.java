package com.kylenally.islandquest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by kyleg on 1/3/2018.
 */

public class GameClass extends ApplicationAdapter {

    OrthographicCamera camera;

    // custom class which handles keyboard controls
    Control control;

    SpriteBatch batch;
    Texture img;

    // display size
    private int displayHeight, displayWidth;

    // temp x and y coords
    int x, y;

    // for movement
    int direction_x, direction_y;
    int speed = 3;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img =  new Texture("badlogic.jpg");

        // camera
        displayWidth = Gdx.graphics.getWidth();
        displayHeight = Gdx.graphics.getHeight();

        // for 800x600 we will get 266*200
        int h = (int) (displayHeight / Math.floor(displayHeight / 160));
        int w = (int) (displayWidth / (displayHeight / (displayHeight / Math.floor(displayHeight / 160))));

        camera = new OrthographicCamera(w,h);
        camera.zoom = .4f;

        // Used to capture keyboard input
        control = new Control(displayWidth, displayHeight, camera);
        Gdx.input.setInputProcessor(control);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // GAME LOGIC
        // reset the direction values
        direction_x = 0;
        direction_y = 0;

        if (control.down) direction_y = -1;
        if (control.up) direction_y = 1;
        if (control.left) direction_x = -1;
        if (control.right) direction_x = 1;

        camera.position.x += direction_x * speed;
        camera.position.y += direction_y * speed;
        camera.update();

        // GAME DRAW
        batch.setProjectionMatrix(camera.combined);
        batch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);

        batch.begin();
        batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
