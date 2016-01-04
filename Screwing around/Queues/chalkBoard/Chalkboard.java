package chalkBoard;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

import java.util.LinkedList;
import java.util.Queue;

public class Chalkboard extends JComponent{

	public static void main(String[] args){
		JFrame frame = new JFrame();

		final int FRAME_WIDTH = 1024;
		final int FRAME_HEIGHT = 768;
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		frame.setTitle("chalkboard");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		Component component = new Chalkboard();
		
		
		
		frame.add(component);

		frame.setVisible(true);

	}

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		LineDrawer thing = new LineDrawer();
		g2.setColor(new Color(601050));
		g2.setStroke(new BasicStroke(5));
		
		int x1 = 512;
		int y1 = 384;
		
		for(int x = 0; x < 10; x++){
			boolean xSign = Math.random() < 0.5;
			boolean ySign = Math.random() < 0.5;
			
			int xDiff= (int)(100 * Math.random());
			int yDiff= (int)(100 * Math.random());
			
			if(xSign)
				xDiff *= -1;
			if(ySign)
				yDiff *= -1;
			
			thing.draw(g2, x1, y1, x1+xDiff, y1+yDiff);
			
			x1+=xDiff;
			y1+=yDiff;
			
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
