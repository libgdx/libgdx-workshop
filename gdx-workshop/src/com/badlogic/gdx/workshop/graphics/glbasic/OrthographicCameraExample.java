package com.badlogic.gdx.workshop.graphics.glbasic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;

/**
 * Demonstrates how to use an OrthographicCamera
 * to setup a window into our world with custom units.
 * We want to show 5x4 units of our world on screen.
 * Texture and mesh need to be disposed when no longer needed.
 * Uses OpenGL ES 1.0, will not work on iOS and HTML5.
 * @author badlogic
 *
 */
public class OrthographicCameraExample extends ApplicationAdapter {
	private Mesh rectangle;
	private Texture texture;
	private OrthographicCamera camera;

	@Override
	public void create() {
		// create mesh and texture, our mesh is a rectangle, centered
		// around the origin, with a 1x1 unit size
		rectangle = new Mesh(true, 5, 6, VertexAttribute.Position(),
										 VertexAttribute.TexCoords(0));
		rectangle.setVertices(new float[] {
				-0.5f,  0.5f, 0, 0, 0, // x,y,z, s, t
			     0.5f,  0.5f, 0, 1, 0,
			     0.5f, -0.5f, 0, 1, 1,
			    -0.5f, -0.5f, 0, 0, 1
		});
		rectangle.setIndices(new short[] { 0, 1, 2, 2, 3, 0 });
		texture = new Texture(Gdx.files.internal("data/bob.png"));
		
		// setup orthographic camera, 5x4 unit viewport into our world
		// it's positioned at (0,0,0) by default.
		camera = new OrthographicCamera(5, 4);
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1,  1,  1,  1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// tell OpenGL about camera matrices (projection & view matrix)
		camera.apply(Gdx.gl10);
		
		// render rectangle
		Gdx.gl.glEnable(GL10.GL_TEXTURE_2D);
		texture.bind();
		rectangle.render(GL10.GL_TRIANGLES);
	}
}
