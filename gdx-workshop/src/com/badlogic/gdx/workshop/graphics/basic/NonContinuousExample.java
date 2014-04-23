package com.badlogic.gdx.workshop.graphics.basic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics;

/**
 * Demonstrates non-continuous rendering. Rendering
 * is only performed when we ask for it ({@link Graphics#requestRendering()})
 * or when an input event occurs. On Android, touch the
 * screen to trigger rendering.
 * @author badlogic
 *
 */
public class NonContinuousExample extends ApplicationAdapter {
	@Override
	public void create() {
		Gdx.graphics.setContinuousRendering(false);
	}

	@Override
	public void render() {
		Gdx.app.log("NonContinuousExample", "rendering");
	}
}
