package fractal;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.awt.geom.GeneralPath;

public class KochLine

{

	public void draw(Graphics2D g2, int iteration, double x1, double y1, double x2, double y2)

	{

		if (iteration == 1)

		{

			g2.draw(new Line2D.Double(x1, y1, x2, y2));

		}

		else

		{
			//difference between points
			double dx = Math.abs((x2 - x1) / 3);

			double dy = Math.abs((y2 - y1) / 3);

			//whichever one is nonzero
			if(dx == 0)
				dx = dy;
			else dy = dx;
				
			//points
			double x5,y5;
			double x6,y6;
			double x7,y7;
			double x8,y8;

			
			//top of rectangle
			if(y1 == y2 && x1 < x2){
				x5 = x1 + dx;
				y5 = y1;

				x6 = x5;
				y6 = y5 - dy;

				x7 = x6 + dx;
				y7 = y6;

				x8 = x7;
				y8 = y7 + dy;
			}
			
			//bottom of rectangle
			else if(y1 == y2){
				x5 = x1 - dx;
				y5 = y1;

				x6 = x5;
				y6 = y5 + dy;

				x7 = x6 - dx;
				y7 = y6;

				x8 = x7;
				y8 = y7 - dy;
			}
			
			//right side of rectangle
			else if(x1 == x2 && y1 < y2){
				x5 = x1;
				y5 = y1 + dy;

				x6 = x5 + dx;
				y6 = y5;

				x7 = x6;
				y7 = y6 + dy;

				x8 = x7 - dx;
				y8 = y7;
			}
			
			//left side of rectangle
			else{
				x5 = x1;
				y5 = y1 - dy;

				x6 = x5 - dx;
				y6 = y5;

				x7 = x6;
				y7 = y6 - dy;

				x8 = x7 + dx;
				y8 = y7;
			}
			
			
			

			draw(g2, iteration - 1, x1, y1, x5, y5);

			draw(g2, iteration - 1, x5, y5, x6, y6);

			draw(g2, iteration - 1, x6, y6, x7, y7);

			draw(g2, iteration - 1, x7, y7, x8, y8);

			draw(g2, iteration - 1, x8, y8, x2, y2);        

		}

	}

}