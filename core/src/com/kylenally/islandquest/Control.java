package com.kylenally.islandquest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by kyleg on 1/3/2018.
 */

public class Control extends InputAdapter implements InputProcessor {

    // camera
    OrthographicCamera camera;

    // directions
    public boolean up;
    public boolean down;
    public boolean left;
    public boolean right;

    // mouse controls (buttons)
    public boolean leftMouse;
    public boolean rightMouse;
    public boolean processedClick;

    // mouse controls (click positions)
    public Vector2 mouseClickPosition = new Vector2();
    public Vector2 mapClickPosition = new Vector2();

    // debug var
    public boolean debug;

    // screen
    int screenWidth;
    int screenHeight;

    public Control(int screenWidth, int screenHeight, OrthographicCamera camera) {

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.camera = camera;

    }

    private void setMouseClickedPosition(int screenX, int screenY) {
        // set the mouse position (flip screen y)
        mouseClickPosition.set(screenX, screenHeight - screenY);
        mapClickPosition.set(getMapCoords(mouseClickPosition));
    }

    public Vector2 getMapCoords(Vector2 mouseCoords) {

        Vector3 v3 = new Vector3(mouseCoords.x, screenHeight - mouseCoords.y, 0);
        this.camera.unproject(v3);
        return new Vector2(v3.x, v3.y);

    }

    // this method and the following method handle the states of the keys we will be using
    // Other forms of input may be defined here as well (ex.: TAB for inventory, etc)
    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.DOWN:
                down = true;
                break;
            case Input.Keys.UP:
                up = true;
                break;
            case Input.Keys.LEFT:
                left = true;
                break;
            case Input.Keys.RIGHT:
                right = true;
                break;
            case Input.Keys.W:
                up = true;
                break;
            case Input.Keys.A:
                left = true;
                break;
            case Input.Keys.S:
                down = true;
                break;
            case Input.Keys.D:
                right = true;
                break;
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        switch (keycode) {
            case Input.Keys.DOWN:
                down = false;
                break;
            case Input.Keys.UP:
                up = false;
                break;
            case Input.Keys.LEFT:
                left = false;
                break;
            case Input.Keys.RIGHT:
                right = false;
                break;
            case Input.Keys.W:
                up = false;
                break;
            case Input.Keys.A:
                left = false;
                break;
            case Input.Keys.S:
                down = false;
                break;
            case Input.Keys.D:
                right = false;
                break;
            case Input.Keys.ESCAPE:
                Gdx.app.exit();
                break;
            case Input.Keys.BACKSPACE:
                debug = !debug;
                break;
        }
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (pointer == 0 && button == 0) {
            leftMouse = true;
        } else if (pointer == 0 && button == 0) {
            rightMouse = true;
        }

        setMouseClickedPosition(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (pointer == 0 && button == 0) {
            leftMouse = false;
            processedClick = false;
        } else if (pointer == 0 && button == 0) {
            rightMouse = false;
        }

        setMouseClickedPosition(screenX, screenY);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        setMouseClickedPosition(screenX, screenY);
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
