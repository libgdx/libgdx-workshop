package com.badlogic.gdx.workshop.input;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.Input.Keys;

/**
 * Demonstrates how to do polling for keyboard, mouse, touch
 * accelerometer and compass. You should never construct
 * that many strings in the manner presented here. Android's
 * garbage collector will go crazy.
 * @author badlogic
 *
 */
public class PollingExample extends ApplicationAdapter {
	@Override
	public void render() {
		// check first 5 touch indices
		for(int i = 0; i < 5; i++) {
			Gdx.app.log("PollingExample", "coords " + i + ": " + Gdx.input.getX(i) + ", " + Gdx.input.getY(i));
			Gdx.app.log("PollingExample", "touched " + i + ": " + Gdx.input.isTouched(i));
		}
		
		// output accelerometer and compass readings
		Gdx.app.log("PollingExample", "accelerometer: " + Gdx.input.getAccelerometerX() + ", "
														+ Gdx.input.getAccelerometerY() + ", "
														+ Gdx.input.getAccelerometerZ());
		Gdx.app.log("PollingExample", "compass: " + Gdx.input.getAzimuth() + ", "
												  + Gdx.input.getPitch() + ", " 
												  + Gdx.input.getRoll());
		
		// check if the right mouse button is pressed
		Gdx.app.log("PollingExample", "right button pressed: " + Gdx.input.isButtonPressed(Buttons.RIGHT));
		
		// check if the ESCAPE key is pressed
		Gdx.app.log("PollingExample", "escape pressed: " + Gdx.input.isKeyPressed(Keys.ESCAPE));
	}
}
