package com.badlogic.gdx.workshop.files;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Demonstrates how to read the content of an internal text file.
 * The file is located in the Android project's assets/data folder.
 * The file path is specified relative to the assets/ folder, "data/test.txt",
 * not "assets/data/test.txt".
 * 
 * @author badlogic
 *
 */
public class InternalFileExample extends ApplicationAdapter {
	@Override
	public void create() {
		FileHandle file = Gdx.files.internal("data/test.txt");
		Gdx.app.log("InternalFileExample", file.readString());
	}
}
