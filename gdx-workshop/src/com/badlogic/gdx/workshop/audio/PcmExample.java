package com.badlogic.gdx.workshop.audio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.AudioRecorder;

/**
 * Demonstrates how to perform PCM playback
 * and recording. Reads PCM data from an
 * {@link AudioRecorder}, outputs it via
 * an {@link AudioDevice}. You should use
 * headphones, otherwise you will get feedback.
 * Processing is done on a separate thread. This
 * will not work on iOS and HTML5.
 * @author badlogic
 *
 */
public class PcmExample extends ApplicationAdapter {
	/** used to signal thread to stop **/
	private volatile boolean done;
	
	@Override
	public void dispose() {
		// stop thread when app closes
		done = true;
	}

	@Override
	public void create() {
		// create and start a thread where we do the audio processing
		new Thread(new Runnable() {
			@Override
			public void run() {
				// create an AudioDevice, to output mono, 44.1khz PCM data
				AudioDevice device = Gdx.audio.newAudioDevice(44100, true);
				
				// create an AudioRecorder, to record mono, 44.1khz PCM data
				AudioRecorder recorder = Gdx.audio.newAudioRecorder(44100, true);
				
				// we need a buffer of shorts to store the recorded data
				// and pass it to the device. This equals roughly 1/10th 
				// of a second of PCM data.
				short[] pcmBuffer = new short[4096];
				
				// read data from the recorder, push it to the device
				// until app is closed
				while(!done) {
					recorder.read(pcmBuffer, 0, pcmBuffer.length);
					device.writeSamples(pcmBuffer, 0, pcmBuffer.length);
				}
				
				// native resources need to be diposed!
				device.dispose();
				recorder.dispose();
			}
		}).start();
	}
}
