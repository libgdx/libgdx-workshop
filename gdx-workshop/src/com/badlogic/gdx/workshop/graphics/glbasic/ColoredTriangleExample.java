package com.badlogic.gdx.workshop.graphics.glbasic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;

/**
 * Demonstrates how to create a colored triangle mesh
 * and draw it to the screen. The mesh needs to be
 * dispoed when no longer used, via a call to {@link Mesh#dispose()}. 
 * Uses OpenGL ES 1.0, won't work on iOS, HTML5!
 * @author badlogic
 *
 */
public class ColoredTriangleExample extends ApplicationAdapter {
	private Mesh triangle;

	@Override
	public void create() {
		// construct a mesh with 3 vertices, 3 indices.
		// every vertex has a position and color
		triangle = new Mesh(true, 3, 3, VertexAttribute.Position(),
										VertexAttribute.ColorUnpacked());
		
		// set the vertices
		triangle.setVertices(new float[] {
				0,  1, 0, 0, 1, 0, 1, // x,y,z, r, g, b, a
			    1, -1, 0, 1, 0, 0, 1,  
			   -1, -1, 0, 0, 0, 1, 1
		});
		// set the indices, the triangle is made up of
		// vertex 1, vertex 2 and vertex 3
		triangle.setIndices(new short[] { 0, 1, 2 });
	}

	@Override
	public void render() {
		// clear the screen (black is default)
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		// render the triangle, tell OpenGL the mesh contains
		// triangles
		triangle.render(GL10.GL_TRIANGLES);
	}
}
