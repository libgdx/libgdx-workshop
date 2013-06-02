package com.badlogic.gdx.workshop.files;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class InternalFileExample extends ApplicationAdapter {
	@Override
	public void create() {
		FileHandle file = Gdx.files.internal("data/test.txt");
		Gdx.app.log("InternalFileExample", file.readString());
	}
}
