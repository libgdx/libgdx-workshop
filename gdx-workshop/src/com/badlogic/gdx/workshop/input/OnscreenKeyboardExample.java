package com.badlogic.gdx.workshop.input;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

/**
 * Demonstrates how to show the on-screen keyboard on platforms
 * that support it. Will have no effect on platforms that don't
 * support an on-screen keyboard (desktop, HTML5)
 * @author badlogic
 *
 */
public class OnscreenKeyboardExample extends ApplicationAdapter {
	@Override
	public void create() {
		// set the on-screen keyboard visible, 
		// no effect on desktop/HTML5
		Gdx.input.setOnscreenKeyboardVisible(true);
		
		// listen for keyboard events via an InputProcessor
		Gdx.input.setInputProcessor(new InputAdapter() {
			@Override
			public boolean keyTyped(char character) {
				Gdx.app.log("OnscreenKeyboardExample", "typed: " + character);
				if(character == 'e') Gdx.input.setOnscreenKeyboardVisible(false);
				return true;
			}
		});
	}
}
