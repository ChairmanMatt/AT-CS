package fractal;

import java.awt.Graphics;

import java.awt.Graphics2D;

import javax.swing.JComponent;

import javax.swing.JFrame;

import javax.swing.JOptionPane;

import java.awt.geom.Line2D;

import java.util.ArrayList;

import java.awt.geom.GeneralPath;

import java.awt.Polygon;

/**
 * INTENTION IS TO MAKE A RECTANGLE BASED FRACTAL
 * @author 16ML0369
 *
 */

public class KochComponent extends JComponent

{ 

	private int numIterations; 

	private int length; 

	public KochComponent(int iters, int aLength)
	{
		numIterations = iters;
		length = aLength;
	}

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 360;

		final int FRAME_HEIGHT = 500;

		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		frame.setTitle("My Rectangle (s)");

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String input = JOptionPane.showInputDialog(null, "Number of iterations");

		if (input == null)

			System.exit(0);

		int iterations = Integer.parseInt(input);

		KochComponent component = new KochComponent(iterations, 100);

		frame.add(component);

		frame.setVisible(true);

	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		KochLine koch = new KochLine();

		int x1 = 150;
		int y1 = 150;

		int x2 = x1 + length;
		int y2 = y1;

		int x3 = x2;
		int y3 = y2 - length;
		
		int x4 = x1;
		int y4 = y3;
		

		koch.draw(g2, numIterations, x1, y1, x2, y2);

		koch.draw(g2, numIterations, x2, y2, x3, y3);

		koch.draw(g2, numIterations, x3, y3, x4, y4);
		
		koch.draw(g2, numIterations, x4, y4, x1, y1);

	}

}