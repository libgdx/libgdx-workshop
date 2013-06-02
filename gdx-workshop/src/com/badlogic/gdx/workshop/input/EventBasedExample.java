package com.badlogic.gdx.workshop.input;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

/**
 * Demonstrates how to perform event-based input handling.
 * An {@link InputProcessor} is registered, which is then
 * called on every input event. The processor will be
 * called on the main thread.
 * @author badlogic
 *
 */
public class EventBasedExample extends ApplicationAdapter {
	@Override
	public void create() {
		Gdx.input.setInputProcessor(new InputProcessor() {
			@Override
			public boolean keyDown(int keycode) {
				Gdx.app.log("EventBasedExample", "key down: " + keycode);
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				Gdx.app.log("EventBasedExample", "key up: " + keycode);
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				Gdx.app.log("EventBasedExample", "key typed: " + character);
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer, int button) {
				Gdx.app.log("EventBasedExample", "touch down: " + screenX + ", " + screenY + ", " + pointer + ", " + button);
				return false;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer, int button) {
				Gdx.app.log("EventBasedExample", "touch up: " + screenX + ", " + screenY + ", " + pointer + ", " + button);
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				Gdx.app.log("EventBasedExample", "touch dragged: " + screenX + ", " + screenY + ", " + pointer);
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				Gdx.app.log("EventBasedExample", "mouse moved: " + screenX + ", " + screenY);
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				Gdx.app.log("EventBasedExample", "scrolled: " + amount);
				return false;
			}
		});
	}
}
