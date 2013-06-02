package com.badlogic.gdx.workshop.audio;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.AudioDevice;
import com.badlogic.gdx.audio.AudioRecorder;
import com.badlogic.gdx.utils.Array;

/**
 * Same as {@link PcmExample}, but uses two threads,
 * one for recording, one for playback, to get rid
 * of noises. PCM data is passed from the recording
 * to the playback thread. We keep a list of free
 * buffers and a list of buffers ready to be played back.
 * Use headphones! Will not work on iOS and HTML.
 * 
 * @author badlogic
 *
 */
public class BetterPcmExample extends ApplicationAdapter {
	/** used to tell threads to exit **/
	private volatile boolean done;
	
	@Override
	public void dispose() {
		done = true;
	}

	@Override
	public void create() {
		// array of free buffers (libgdx collection class!)
		final Array<short[]> freeBuffers = new Array<short[]>();
		// array of recorded buffers, ready for playback
		final Array<short[]> recordedBuffers = new Array<short[]>();
		
		// create a few free buffers
		for(int i = 0; i < 5; i++) {
			freeBuffers.add(new short[4410]);
		}
		
		// setup and start recording thread, records
		// a buffer and puts it into the recordedBuffers queue
		// blocks if there are no more free buffers, via a busy
		// wait (bad :))
		new Thread(new Runnable() {
			@Override
			public void run() {
				// setup AudioRecorder, 44.1khz, mono
				AudioRecorder recorder = Gdx.audio.newAudioRecorder(44100, true);
				
				while(!done) {
					short[] buffer = null;
					
					// wait for a free buffer
					synchronized(freeBuffers) {
						if(freeBuffers.size == 0) continue;
						buffer = freeBuffers.pop();
					}
					
					// get the buffer and fill it with PCM data
					recorder.read(buffer, 0, buffer.length);
					
					// put the buffer into the playback queue
					synchronized(recordedBuffers) {
						recordedBuffers.add(buffer);
					}
				}
				
				recorder.dispose();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(!done) {
					// setup AudioDevice, 44.1khz, mono
					AudioDevice device = Gdx.audio.newAudioDevice(44100, true);
					
					while(!done) {
						short[] buffer = null;
						
						// wait for a recorded buffer
						synchronized(recordedBuffers) {
							if(recordedBuffers.size == 0) continue;
							buffer = recordedBuffers.pop();
						}
						
						// send the buffer for playback
						device.writeSamples(buffer, 0, buffer.length);
						
						// put the buffer into the free buffer queue
						synchronized(freeBuffers) {
							freeBuffers.add(buffer);
						}
					}
					
					device.dispose();
				}
			}
		}).start();
	}
}
