package jp.ac.titech.itpro.sdl.die;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Octahedron implements Obj {

    private final static float[] VERTICES = {
            // bottom_left
            -1, 0, -1,
            0, -1, 0,
            -1, 0, 1,
            // bottom_right
            1, 0, -1,
            0, -1, 0,
            1, 0, 1,
            // bottom_back
            -1, 0, -1,
            0, -1, 0,
            1, 0, -1,
            // bottom_front
            -1, 0, 1,
            0, -1, 0,
            1, 0, 1,
            // top_left
            -1, 0, -1,
            0, 1, 0,
            -1, 0, 1,
            // top_right
            1, 0, -1,
            0, 1, 0,
            1, 0, 1,
            // top_back
            -1, 0, -1,
            0, 1, 0,
            1, 0, -1,
            // top_front
            -1, 0, 1,
            0, 1, 0,
            1, 0, 1
    };

    private final FloatBuffer vbuf;

    Octahedron() {
        vbuf = ByteBuffer
                .allocateDirect(VERTICES.length * 4)
                .order(ByteOrder.nativeOrder())
                .asFloatBuffer();
        vbuf.put(VERTICES);
        vbuf.position(0);
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // bottom_left
        gl.glNormal3f(0, -1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // bottom_right
        gl.glNormal3f(-1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // bottom_back
        gl.glNormal3f(1, 1, 0);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // bottom_front
        gl.glNormal3f(0, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

        // top_left
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 12, 3);

        // top_right
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);

        // top_back
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);

        // top_front
        gl.glNormal3f(0, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);
    }
}
