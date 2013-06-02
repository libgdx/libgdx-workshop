package com.badlogic.gdx.workshop.graphics.basic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;

/**
 * Demonstrates vsynch toggling. Vsynch is on by default
 * and will synch the {@link ApplicationListener#render()}
 * method to the screen refresh rate, which avoids tearing.
 * Really only relevant on desktop, no effect on mobile/HTML.
 * Vsynch is always enabled on those platforms.g
 * @author badlogic
 *
 */
public class VsynchExample extends ApplicationAdapter {
	private FPSLogger fpsLogger = new FPSLogger();
	private boolean vsynch = true;
	
	@Override
	public void render() {
		// toggle vsynch on touch
		if(Gdx.input.justTouched()) {
			vsynch = !vsynch;
			Gdx.graphics.setVSync(vsynch);
		}
		
		// print FPS
		fpsLogger.log();
	}
}
