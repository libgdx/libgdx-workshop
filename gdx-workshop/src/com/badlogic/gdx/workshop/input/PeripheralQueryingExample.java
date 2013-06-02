package com.badlogic.gdx.workshop.input;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Peripheral;

/**
 * Demonstrates how to query if a specific peripheral
 * is available.
 * @author badlogic
 *
 */
public class PeripheralQueryingExample extends ApplicationAdapter {
	@Override
	public void create() {
		for(Peripheral peripheral: Peripheral.values()) {
			boolean available = Gdx.input.isPeripheralAvailable(peripheral);
			Gdx.app.log("PeripheralQueryingExample", peripheral + ": " + available);
		}
	}
}
