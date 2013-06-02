package com.badlogic.gdx.workshop.audio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

/**
 * Demonstrates how to load and play a music file.
 * Also shows how to set looping and pause/resume.
 * Note that music instances need to be disposed via
 * {@link Music#dispose()} if they are no longer used.
 * @author badlogic
 *
 */
public class MusicExample extends ApplicationAdapter {
	Music music;
	
	@Override
	public void create() {
		music = Gdx.audio.newMusic(Gdx.files.internal("data/music.mp3"));
		music.setLooping(true);
		music.play();
		music.setVolume(0.3f);
	}

	@Override
	public void render() {
		if(Gdx.input.justTouched()) {
			if(music.isPlaying()) {
				music.pause();
			} else {
				music.play();
			}
		}
	}
}
