package chalkBoard;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;

public class LineDrawer {

	public void draw(Graphics2D g2, double x1, double y1, double x2, double y2){

		g2.draw(new Line2D.Double(x1, y1, x2, y2));

	}
}
