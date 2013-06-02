package com.badlogic.gdx.workshop.input;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.TextInputListener;

/**
 * Demonstrates how to bring up a platform specific
 * text dialog to let the user enter text.
 * @author badlogic
 *
 */
public class TextDialogExample extends ApplicationAdapter {
	@Override
	public void create() {
		Gdx.input.getTextInput(new TextInputListener() {
			@Override
			public void input(String text) {
				Gdx.app.log("TextDialogExample", "got text: " + text);
			}

			@Override
			public void canceled() {
				Gdx.app.log("TextDialogExample", "user canceled");
			}
			
		}, "Enter Credentials", "placeholder text");
	}
}
