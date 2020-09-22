package java2dmain2;
/**
 * File: Java2DMain2.java
 * File Purpose: GUI Components, contains main method.
 * 
 * @author ReynaldoSantos
 */

import javax.swing.JFrame;

public class Java2DMain2 {
    /*
     * Windows of the program
     */
    void display_JFrame_RectangularPrism() {
	RectangularPrism rectangPrism = new RectangularPrism();
	JFrame rectangularPrism_JFrame = new JFrame("Rectangular Prism");

	rectangularPrism_JFrame.setSize(200, 300);
	rectangularPrism_JFrame.setLocation(50, 50);
	rectangularPrism_JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	rectangularPrism_JFrame.getContentPane().add("Center", rectangPrism);
	rectangularPrism_JFrame.setResizable(false);
	rectangularPrism_JFrame.setVisible(true);
    }

    void display_JFrame_Cube() {
	Cube cube = new Cube();
	JFrame cube_JFrame = new JFrame("Cube");

	cube_JFrame.setSize(200, 300);
	cube_JFrame.setLocation(475, 50);
	cube_JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	cube_JFrame.getContentPane().add("Center", cube);
	cube_JFrame.setResizable(false);
	cube_JFrame.setVisible(true);
    }

    void display_JFrame_Pyramid() {
	Pyramid pyramid = new Pyramid();
	JFrame pyramid_JFrame = new JFrame("Pyramid");

	pyramid_JFrame.setSize(200, 300);
	pyramid_JFrame.setLocation(875, 50);
	pyramid_JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	pyramid_JFrame.getContentPane().add("Center", pyramid);
	pyramid_JFrame.setResizable(false);
	pyramid_JFrame.setVisible(true);
    }

    /*
     * Main Method
     */
    public static void main(String[] args) {
	Java2DMain2 mj = new Java2DMain2();

	mj.display_JFrame_RectangularPrism();
	mj.display_JFrame_Cube();
	mj.display_JFrame_Pyramid();
    }
}
