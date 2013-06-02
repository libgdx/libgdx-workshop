package com.badlogic.gdx.workshop.graphics.basic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;
import com.badlogic.gdx.graphics.FPSLogger;

/**
 * Demonstrates how to query different graphics properties.
 * @author badlogic
 *
 */
public class GraphicsQueryingExample extends ApplicationAdapter {
	/** helps us log fps every second and not flood the log **/
	FPSLogger fpsLogger;

	@Override
	public void create() {
		fpsLogger = new FPSLogger();
		
		// output width and height in pixels
		Gdx.app.log("GraphicsQueryingExample", Gdx.graphics.getWidth() + "x"
											 + Gdx.graphics.getHeight());
		
		// output pixels per inch and pixels per centimeter
		// may be inaccurate on desktop/HTML
		Gdx.app.log("GraphicsQueryingExample", "ppi: " + Gdx.graphics.getPpiX() + "x"
				                                       + Gdx.graphics.getPpiY() + "ppi");
		Gdx.app.log("GraphicsQueryingExample", "ppi: " + Gdx.graphics.getPpcX() + "x"
                									   + Gdx.graphics.getPpcY() + "ppc");
		
		// output available full screen modes
		Gdx.app.log("GraphicsQueryingExample", "supports mode change: " + Gdx.graphics.supportsDisplayModeChange());
		for(DisplayMode mode: Gdx.graphics.getDisplayModes()) {
			Gdx.app.log("GraphicsQueryingExample", mode.toString());
		}
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log("GraphicsQueryingExample", "resized: " + width + "x" + height);
	}

	@Override
	public void render() {
		// log the fps (only logs once a second to not flood log);
		fpsLogger.log();
	}
}
