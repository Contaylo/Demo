import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.*;
import java.lang.Math;

public class Cat {
	// drawing constants are private - noone needs to know what we're doing
	// pick a head dimension
	private static final int HEAD_DIMENSION = 500;
	// eyes will be about 1/4 from top of head and 1/4 from left
	private static final int EYE_Y = HEAD_DIMENSION/4;
	private static final int EYE_X = HEAD_DIMENSION/4;
	private static final int EYE_SEPARATION = HEAD_DIMENSION/3;
	// pick eye dimensions
	private static final int EYE_HEIGHT = 20;
	private static final int EYE_WIDTH = 100;
	// pick mouth height, width is based on head dimension
	private static final int MOUTH_HEIGHT = 10;
	private static final int MOUTH_WIDTH = HEAD_DIMENSION/3;
	// mouth starts about 40% from left edge of head
	private static final int MOUTH_X = HEAD_DIMENSION/5 * 3;
	private static final int MOUTH_Y = HEAD_DIMENSION/5 * 3;
	//ear dimensions
	private static final int EAR_WIDTH = HEAD_DIMENSION/5;
	private static final int EAR_HEIGHT = 50;
	//ears are 20% the head size and 50 pixels tall
	private static final int EAR_X = HEAD_DIMENSION/5;
	private static final int EAR_Y = HEAD_DIMENSION/5;
	
	// draw will render the Cat on the Graphics object
	public void draw(Graphics g, int catX, int catY)
	{
		Graphics2D g2 = (Graphics2D) g;
		int x=catX;
		int y=catY;
		//draw the "ears"
		g2.setColor(Color.pink);
		drawEar(g2, x, y);
		drawEar(g2, x+HEAD_DIMENSION*2/5, y);
		// Draw the head
		g2.setColor(Color.gray);
		g2.fillOval(x, y, HEAD_DIMENSION, HEAD_DIMENSION);
		// Draw the eyes
		g2.setColor(Color.blue);
		x = catX + EYE_X; 
		y = catY + EYE_Y;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		x += EYE_SEPARATION;
		g2.fillOval(x, y, EYE_WIDTH, EYE_HEIGHT);
		// Draw the mouth
		g2.setColor(Color.pink);
		x = catX + MOUTH_X;
		y = catY + MOUTH_Y;
		g2.fillOval(x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		g2.setColor(Color.black);
		// Meow text appears below cat head, +10 places below 
		// so it doesn't overlap the drawing
		g2.drawString("Meow", catX, catY+HEAD_DIMENSION+10);
	
	}
	
	public void drawEar(Graphics2D  g2, int x, int y){
		int[] xPoints = {x+EAR_X, x+EAR_X+EAR_WIDTH/2, x+EAR_X+EAR_WIDTH};
		int[] yPoints = {y+EAR_Y,0,y+EAR_Y};
		
		GeneralPath polygon = new GeneralPath(GeneralPath.WIND_EVEN_ODD, xPoints.length);
		polygon.moveTo(xPoints[0],yPoints[0]);
		for(int i = 1; i<xPoints.length; i++){
			polygon.lineTo(xPoints[i], yPoints[i]);
		}
		polygon.closePath();
		g2.fill(polygon);
	}
	
	public int getHeadDimension(){
		return HEAD_DIMENSION;
	}
}
