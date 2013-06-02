package com.badlogic.gdx.workshop.files;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

/**
 * Demonstrates how to read/write files. Files can
 * only be written to local or external files. On
 * Android, we also need to add the WRITE_EXTERNAL_STORAGE 
 * permission to the AndroidManifest.xml file.
 * @author badlogic
 *
 */
public class ReadWriteExample extends ApplicationAdapter {

	@Override
	public void create() {
		// Write a file to the local storage, overwrite it
		// if it already exists. Then read it back in and
		// output the content. Finally, delete the file
		FileHandle local = Gdx.files.local("local-file.txt");
		local.writeString("Local file!", false);
		Gdx.app.log("ReadWriteExample", local.readString());
		local.delete();
		Gdx.app.log("ReadWriteExample", "Local file exists: " + local.exists());
		
		// Same as above, using an external file
		FileHandle external = Gdx.files.local("external-file.txt");
		external.writeString("External file!", false);
		Gdx.app.log("ReadWriteExample", external.readString());
		external.delete();
		Gdx.app.log("ReadWriteExample", "External file exists: " + external.exists());
	}
}
