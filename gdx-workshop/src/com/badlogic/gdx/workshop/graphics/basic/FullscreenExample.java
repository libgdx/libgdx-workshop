package com.badlogic.gdx.workshop.graphics.basic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;

/**
 * Demonstrates toggling fullsreen. No effect
 * on mobile. Using {@link Graphics#getDesktopDisplayMode()}
 * is a trick to make sure we select a fullscreen mode
 * that's 100% supported. You can of course set other
 * display modes as well.
 * @author badlogic
 *
 */
public class FullscreenExample extends ApplicationAdapter {
	@Override
	public void render() {
		if(Gdx.input.justTouched()) {
			// if we are in fullscreen mode switch to windowed
			// and vice versa
			if(!Gdx.graphics.isFullscreen()) {
				Gdx.graphics.setDisplayMode(Gdx.graphics.getDesktopDisplayMode());
			} else {
				Gdx.graphics.setDisplayMode(480, 320, false);
			}
		}
	}
}
