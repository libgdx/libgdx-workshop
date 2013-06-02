package com.badlogic.gdx.workshop.net;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

/**
 * Demonstrates how to open a browser and load
 * a specific URL.
 * @author badlogic
 *
 */
public class OpenBrowserExample extends ApplicationAdapter {
	@Override
	public void create() {
		Gdx.net.openURI("http://libgdx.badlogicgames.com");
	}
}
