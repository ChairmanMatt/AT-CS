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

	private Queue<Integer> points = new LinkedList<Integer>();

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

		int x = 512;
		int y = 384;

		points.add(x);
		points.add(y);

		for(int c = 0; c < 10; c++){
			boolean xSign = Math.random() < 0.5;
			boolean ySign = Math.random() < 0.5;

			int xDiff= (int)(100 * Math.random());
			int yDiff= (int)(100 * Math.random());

			if(xSign)
				xDiff *= -1;
			if(ySign)
				yDiff *= -1;

			thing.draw(g2, x, y, x+xDiff, y+yDiff);

			x+=xDiff;
			y+=yDiff;

			points.add(x);
			points.add(y);


		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("SIZE OF QUEUE: "+points.size());
		
		g2.setColor(new Color(255255));
		
		int x1 = 512;
		int y1 = 384;
		int x2;
		int y2;
//		
//		
//		while(points.peek() != null){
//			x2 = 
//
//			thing.draw(g2, points.poll(), points.poll(), points.poll(), points.poll());
//		}

	}

}
