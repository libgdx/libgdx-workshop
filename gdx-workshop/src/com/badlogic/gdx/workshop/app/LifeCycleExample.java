package com.badlogic.gdx.workshop.app;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

/**
 * Demonstrates life-cycle events by logging them in each method, except
 * {@link #render()}, as that would flood the log window.
 * @author badlogic
 *
 */
public class LifeCycleExample implements ApplicationListener {
	@Override
	public void create() {
		Gdx.app.log("LifeCycleExample", "created");
	}

	@Override
	public void resize(int width, int height) {
		Gdx.app.log("LifeCycleExample", "resized: " + width + "x" + height);
	}

	@Override
	public void render() {
		// commented as it would flood the log
//		Gdx.app.log("LifeCycleExample", "rendering");
	}

	@Override
	public void pause() {
		Gdx.app.log("LifeCycleExample", "paused");
	}

	@Override
	public void resume() {
		Gdx.app.log("LifeCycleExample", "resumed");
	}

	@Override
	public void dispose() {
		Gdx.app.log("LifeCycleExample", "disposed");
	}
}
