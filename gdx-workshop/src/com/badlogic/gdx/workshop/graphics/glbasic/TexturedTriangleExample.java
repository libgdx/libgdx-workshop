package com.badlogic.gdx.workshop.graphics.glbasic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttribute;

/**
 * Demonstrates how to create a colored, textured
 * triangle mesh and draw it to the screen. Need
 * to load and bind a texture for texturing to work.
 * The mesh needs to be disposed when no longer used.
 * The texture needs to be disposed when no longer used,
 * via a call to {@link Texture#dispose()}.
 * Uses OpenGL ES 1.0, won't work on iOS, HTML5!
 * @author badlogic
 *
 */
public class TexturedTriangleExample extends ApplicationAdapter {
	private Mesh triangle;
	private Texture texture;

	@Override
	public void create() {
		// construct a mesh with 3 vertices, 3 indices.
		// every vertex has a position, packed color and
		// texture coordinates
		triangle = new Mesh(true, 3, 3, VertexAttribute.Position(),
										VertexAttribute.Color(),
										VertexAttribute.TexCoords(0));
		
		// set the vertices, using Color#toFloatBits to pack
		// colors into 32-bit RGBA values
		triangle.setVertices(new float[] {
				0,  1, 0, Color.RED.toFloatBits(), 0.5f, 0, // x,y,z, rgba, s, t
			    1, -1, 0, Color.GREEN.toFloatBits(), 1, 1, 
			   -1, -1, 0, Color.BLUE.toFloatBits(), 0, 1
		});
		triangle.setIndices(new short[] { 0, 1, 2 });
		
		// load the texture, 32x32, RGBA8888
		texture = new Texture(Gdx.files.internal("data/bob.png"));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1,  1,  1,  1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		// tell OpenGL to enable texturing
		Gdx.gl.glEnable(GL10.GL_TEXTURE_2D);
		
		// bind the texture, so its used for texture mapping
		texture.bind();
		triangle.render(GL10.GL_TRIANGLES);
	}
}
