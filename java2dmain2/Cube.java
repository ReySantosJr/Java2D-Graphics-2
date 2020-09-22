package java2dmain2;

/**
 * File: Cube.java
 * File Purpose: JOGL setup for creating Cube object.
 * 
 * @author ReynaldoSantos
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLJPanel;

public class Cube extends GLJPanel implements GLEventListener, KeyListener {
    /*
     * Fields
     */
    double rotateX = 8;
    double rotateY = -8;
    double rotateZ = 0;
    double scaling = 1.0;

    /*
     * Constructor
     */
    Cube() {
	super(new GLCapabilities(null));

	addGLEventListener(this);
	addKeyListener(this);
    }

    /*
     * Methods to form shape
     */
    // Create a shape by two methods
    private void square(GL2 gl2, double r, double g, double b) {
	gl2.glColor3d(r, g, b);
	gl2.glBegin(GL.GL_TRIANGLE_FAN);
	gl2.glVertex3d(-0.5, -0.5, 0.5);
	gl2.glVertex3d(0.5, -0.5, 0.5);
	gl2.glVertex3d(0.5, 0.5, 0.5);
	gl2.glVertex3d(-0.5, 0.5, 0.5);
	gl2.glEnd();
    }

    private void cube(GL2 gl2, double size) {
	gl2.glPushMatrix();
	gl2.glScaled(size, size, size);

	gl2.glTranslated(1, 1, 0);
	square(gl2, .5, .2, 5);

	gl2.glPushMatrix();
	gl2.glRotated(90, 0, 1, 0);
	square(gl2, 0, 1, 0);
	gl2.glPopMatrix();

	gl2.glPushMatrix();
	gl2.glRotated(-90, 1, 0, 0);
	square(gl2, .25, .25, .25);
	gl2.glPopMatrix();

	gl2.glPushMatrix();
	gl2.glRotated(180, 0, 1, 0);
	square(gl2, 0, 1, 1);
	gl2.glPopMatrix();

	gl2.glPushMatrix();
	gl2.glRotated(-90, 0, 1, 0);
	square(gl2, 0, 0, 1);
	gl2.glPopMatrix();

	gl2.glPushMatrix();
	gl2.glRotated(90, 1, 0, 0);
	square(gl2, 1, 1, 0);
	gl2.glPopMatrix();

	gl2.glPopMatrix();
    }

    /*
     * Override Methods, Event Listeners
     */
    // Using an array to make a shape.
    @Override
    public void display(GLAutoDrawable drawable) {
	GL2 gl2 = drawable.getGL().getGL2();

	gl2.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

	gl2.glLoadIdentity();
	gl2.glRotated(rotateZ, 0, 0, 0);
	gl2.glRotated(rotateY, 0, 1, 0);
	gl2.glRotated(rotateX, 1, 0, 0);

	cube(gl2, scaling);

    }

    @Override
    public void init(GLAutoDrawable drawable) {
	GL2 gl2 = drawable.getGL().getGL2();
	gl2.glMatrixMode(GL2.GL_PROJECTION);

	gl2.glOrtho(-5, 5, -5, 5, -5, 5);
	gl2.glMatrixMode(GL2.GL_MODELVIEW);
	gl2.glClearColor(255.0f, 255.0f, 255.0f, 0.0f);
	gl2.glEnable(GL2.GL_DEPTH_TEST);

    }

    @Override
    public void dispose(GLAutoDrawable drawable) {

    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
	int key = e.getKeyCode();

	if (key == KeyEvent.VK_LEFT) {
	    rotateY -= 10;
	} else if (key == KeyEvent.VK_RIGHT) {
	    rotateY += 10;
	} else if (key == KeyEvent.VK_DOWN) {
	    rotateX += 10;
	} else if (key == KeyEvent.VK_UP) {
	    rotateX -= 10;
	} else if (key == KeyEvent.VK_PAGE_UP) {
	    rotateZ += 10;
	} else if (key == KeyEvent.VK_PAGE_DOWN) {
	    rotateZ -= 10;
	} else if (key == KeyEvent.VK_HOME) {
	    rotateX = rotateY = rotateZ = 0;
	}

	if (e.getKeyCode() == KeyEvent.VK_F4) {
	    scaling += 0.1;
	}
	if (e.getKeyCode() == KeyEvent.VK_F5) {
	    scaling -= 0.1;
	}

	repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
