package com.badlogic.gdx.workshop.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;

/**
 * Demonstrates usage of {@link Preferences} to store small data.
 * @author badlogic
 *
 */
public class PreferencesExample extends ApplicationAdapter {
	@Override
	public void create() {
		// get preferences, use a unique name, e.g. package name!
		Preferences prefs = Gdx.app.getPreferences("com.badlogic.gdx.workshop");
		
		// check if we previously saved a key/value pair, 
		// initialize it if we haven't. remember to flush
		// to actually persist changes
		if(!prefs.contains("key")) {
			Gdx.app.log("PreferencesExample", "initializing preferences");
			prefs.putFloat("key", 123);
			prefs.flush();
		}
		
		// read the value
		Gdx.app.log("PreferencesExample", "value: " + prefs.getFloat("key"));
	}
}
