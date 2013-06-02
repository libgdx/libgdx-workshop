package com.badlogic.gdx.workshop.graphics.glbasic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Mesh;
import com.badlogic.gdx.graphics.VertexAttribute;

/**
 * Demonstrates how to create a triangle mesh
 * and draw it to the screen. On screen, the
 * area [-1,-1]-[1,1] will be visible, irrespective
 * of the pixel width and height of the drawing area.
 * Uses OpenGL ES 1.0, won't work on iOS, HTML5!
 * @author badlogic
 *
 */
public class TriangleExample extends ApplicationAdapter {
	private Mesh triangle;

	@Override
	public void create() {
		// construct a mesh with 3 vertices, 3 indices.
		// every vertex has a position attribute.
		// the indices define which vertices make up a triangle
		triangle = new Mesh(true, 3, 3, VertexAttribute.Position());
		
		// set the vertices
		triangle.setVertices(new float[] {
				0,  1, 0, // x,y,z coordinates of top vertex
			    1, -1, 0, // x,y,z coordinates of bottom right vertex
			   -1, -1, 0, // x,y,z coordinates of bottm left vertex
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
