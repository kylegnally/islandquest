package com.kylenally.islandquest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;

/**
 * Created by kyleg on 1/3/2018.
 */

public class GameClass extends ApplicationAdapter {

    OrthographicCamera camera;

    // custom class which handles keyboard controls
    Control control;

    // display size
    private int displayHeight, displayWidth;

    // temp x and y coords
    int x, y;

    // for movement
    int direction_x, direction_y;

}
