package com.badlogic.gdx.workshop.input;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;

/**
 * Demonstrates how to use an {@link InputMultiplexer} so
 * different code paths (InputProcessors) can handle
 * different input events. This is useful if you want to
 * separate UI input event handling from game input event
 * handling.
 * @author badlogic
 *
 */
public class InputMultiplexerExample extends ApplicationAdapter {
	@Override
	public void create() {
		// Create processor that consumes all touch events
		InputProcessor touchProc = new InputAdapter() {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				Gdx.app.log("InputMultiplexerExample", "touch down");
				return true;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				Gdx.app.log("InputMultiplexerExample", "touch up");
				return true;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				Gdx.app.log("InputMultiplexerExample", "touch dragged");
				return true;
			}
		};
		
		// Create processor that consumes all key events
		InputProcessor keyProc = new InputAdapter() {
			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				// this is never called, events get consumed by touchProc
				return true;
			}

			@Override
			public boolean keyDown(int keycode) {
				Gdx.app.log("InputMultiplexerExample", "key down");
				return true;
			}

			@Override
			public boolean keyUp(int keycode) {
				Gdx.app.log("InputMultiplexerExample", "key up");
				return true;
			}

			@Override
			public boolean keyTyped(char character) {
				Gdx.app.log("InputMultiplexerExample", "key typed");
				return true;
			}
		};
		
		// Create input multiplexer, add processors, and set it as
		// main InputProcessor
		InputMultiplexer multiplexer = new InputMultiplexer();
		multiplexer.addProcessor(touchProc);
		multiplexer.addProcessor(keyProc);
		Gdx.input.setInputProcessor(multiplexer);
	}
}
