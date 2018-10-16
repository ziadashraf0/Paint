package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.Map;

public  class LineSegment extends MyShape {
	private Point position2;

	
	public LineSegment(){
		
	}
	public LineSegment(Point position1,Point position2,Color color)
	{	
		super(position1,color,null,null);
		this.position2=position2;
	}
	public void setPosition2(Point position2) {
		this.position2= new Point(position2);

	}


	public Point getPosition2() {
		return position2;
	
	}
	
	@Override
	public void draw(Graphics canvas) {
		Graphics2D g2d=(Graphics2D) canvas;
		g2d.setColor(getColor());

		
		g2d.draw(new Line2D.Double((double)getPosition().x,(double)getPosition().y,(double)position2.x,(double) position2.y));
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		MyShape line= new LineSegment(super.getPosition(),position2,super.getColor());
		return line;
	}

}
