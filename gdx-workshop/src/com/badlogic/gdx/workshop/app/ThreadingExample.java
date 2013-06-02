package com.badlogic.gdx.workshop.app;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

/**
 * Demonstrates how to post results from another thread
 * to the thread the {@link ApplicationListener} is called
 * on. This will not work in HTML, no threads supported.
 * @author badlogic
 *
 */
public class ThreadingExample extends ApplicationAdapter {
	@Override
	public void create() {
		// create a thread that waits for 2 seconds and then
		// posts a runnable to the main thread, logging something
		// silly.
		new Thread(new Runnable() {
			@Override
			public void run() {
				// we are in the custom thread here, let's wait a little
				// (and enjoy checked exceptions)
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				
				// time to post on the main thread!
				Gdx.app.postRunnable(new Runnable() {
					@Override
					public void run() {
						// this will be run on the application listener thread
						// before the next call to ApplicationListener#render()
						Gdx.app.log("ThreadingExample", "i come in peace");
					}
				});
			}
		}).start();
	}
}
