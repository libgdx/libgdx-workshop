package com.badlogic.gdx.workshop.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

/**
 * Demonstrates how to get memory usage, check what platform
 * we run on.
 * @author badlogic
 *
 */
public class QueryingExample extends ApplicationAdapter {
	@Override
	public void create() {
		Gdx.app.log("QueryingExample", "java heap: " + Gdx.app.getJavaHeap());
		Gdx.app.log("QueryingExample", "native heap: " + Gdx.app.getNativeHeap());
		Gdx.app.log("QueryingExample", "we are running on " + Gdx.app.getType());
	}
}
