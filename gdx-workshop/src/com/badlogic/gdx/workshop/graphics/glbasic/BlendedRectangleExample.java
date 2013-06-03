package com.badlogic.gdx.workshop.graphics.glbasic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;

/**
 * Demonstrates how to create a textured
 * triangle mesh and draw it to the screen. Need
 * to load and bind a texture for texturing to work.
 * The mesh needs to be disposed when no longer used.
 * The texture needs to be disposed when no longer used,
 * via a call to {@link Texture#dispose()}.
 * Uses OpenGL ES 1.0, won't work on iOS, HTML5!
 * @author badlogic
 *
 */
public class BlendedRectangleExample extends ApplicationAdapter {
	private Mesh rectangle;
	private Texture texture;

	@Override
	public void create() {
		// construct a mesh with 4 vertices, 6 indices.
		// every vertex has a position and texture coordinates
		rectangle = new Mesh(true, 5, 6, VertexAttribute.Position(),
										 VertexAttribute.TexCoords(0));
		
		// set the vertices, using Color#toFloatBits to pack
		// colors into 32-bit RGBA values
		rectangle.setVertices(new float[] {
				-0.5f,  0.5f, 0, 0, 0, // x,y,z, s, t
			     0.5f,  0.5f, 0, 1, 0,
			     0.5f, -0.5f, 0, 1, 1,
			    -0.5f, -0.5f, 0, 0, 1
		});
		rectangle.setIndices(new short[] { 0, 1, 2, 2, 3, 0 });
		
		// load the texture, 32x32, RGBA8888
		texture = new Texture(Gdx.files.internal("data/bob.png"));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1,  1,  1,  1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// tell OpenGL to enable texturing
		Gdx.gl.glEnable(GL10.GL_TEXTURE_2D);
		
		// tell OpenGL to enable blending, and use a standard blend function
		Gdx.gl.glEnable(GL10.GL_BLEND);
		Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		// bind the texture, so its used for texture mapping
		texture.bind();
		rectangle.render(GL10.GL_TRIANGLES);
	}
}
