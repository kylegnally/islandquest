package com.kylenally.islandquest.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.kylenally.islandquest.IslandQuest;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new IslandQuest(), config);

		// sets the width and height of the window
		config.width = 800;
		config.height = 600;
	}
}
