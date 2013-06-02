package com.badlogic.gdx.workshop.audio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.math.MathUtils;

/**
 * Demonstrates how to load and play back a sound
 * effect. Sound effects are decompressed and loaded
 * into RAM, don't use huge files! Note that
 * sounds need to be disposed via {@link Sound#dispose()}
 * once they are no longer used!
 * @author badlogic
 *
 */
public class SoundExample extends ApplicationAdapter {
	private Sound shot;
	
	@Override
	public void create() {
		shot = Gdx.audio.newSound(Gdx.files.internal("data/shot.wav"));
	}

	@Override
	public void render() {
		// if the screen was just touched, play the sound
		// with a random pan (-1, 1)
		if(Gdx.input.justTouched()) {
			shot.play(1.0f, 1, 2 * (MathUtils.random() - 0.5f));
		}
	}
}
