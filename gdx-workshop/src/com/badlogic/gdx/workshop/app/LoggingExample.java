package com.badlogic.gdx.workshop.app;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

/**
 * Demonstrates log levels. We only want to output errors, just
 * like in production mode. All other log calls will be ignored.
 * @author badlogic
 *
 */
public class LoggingExample extends ApplicationAdapter {
	@Override
	public void create() {
		// only let errors through
		Gdx.app.setLogLevel(Application.LOG_ERROR);
		
		Gdx.app.log("LoggingExample", "this won't get output");
		Gdx.app.debug("LoggingExample", "neither will this");
		Gdx.app.error("LoggingExample", "erma gehrd, error!");
	}
}
