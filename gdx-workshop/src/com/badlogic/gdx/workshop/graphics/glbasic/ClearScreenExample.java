package com.badlogic.gdx.workshop.graphics.glbasic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;

/**
 * Demonstrates how to clear the screen with
 * a specific color. We use OpenGL ES, colors
 * are specificed component-wise (red, green, blue,
 * alpha), ranging from 0 to 1.
 * @author badlogic
 *
 */
public class ClearScreenExample extends ApplicationAdapter {
	@Override
	public void render() {
		// set the color to clear the screen with (pink)
		Gdx.gl.glClearColor(1, 0, 1, 1);
		
		// clear the screen
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
	}
}
