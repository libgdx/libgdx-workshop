package com.badlogic.gdx.workshop.graphics.glbasic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;

/**
 * Demonstrates how to create a colored triangle mesh
 * and draw it to the screen. Colors are packed
 * into 32-bit RGBA values. Uses OpenGL ES 1.0, 
 * won't work on iOS, HTML5!
 * @author badlogic
 *
 */
public class PackedColoredTriangleExample extends ApplicationAdapter {
	private Mesh triangle;

	@Override
	public void create() {
		// construct a mesh with 3 vertices, 3 indices.
		// every vertex has a position and packed color
		triangle = new Mesh(true, 3, 3, VertexAttribute.Position(),
										VertexAttribute.Color());
		
		// set the vertices, using Color#toFloatBits to pack
		// colors into 32-bit RGBA values
		triangle.setVertices(new float[] {
				0,  1, 0, Color.RED.toFloatBits(), // x,y,z, rgba
			    1, -1, 0, Color.GREEN.toFloatBits(),  
			   -1, -1, 0, Color.BLUE.toFloatBits()
		});
		triangle.setIndices(new short[] { 0, 1, 2 });
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		triangle.render(GL10.GL_TRIANGLES);
	}
}
