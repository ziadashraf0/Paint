package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Map;

public class Rectangle extends MyShape {

	public Rectangle() {

	}	
	public Rectangle(Point position,Color color,Color fillColor,Map<String,Double> properties)
	{
		super(position,color,fillColor,properties);
	}
	@Override
	public void draw(Graphics canvas) {

		double w = getProperties().get("width");
		double h = getProperties().get("height");
		canvas.setColor(getColor());

		canvas.fillRect(getPosition().x, getPosition().y, (int) w, (int) h);
		canvas.drawRect(getPosition().x, getPosition().y, (int) w, (int) h);

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		MyShape Rectangle = new Rectangle(super.getPosition(),super.getColor(),super.getFillColor(),super.getProperties());
		return Rectangle;
	}

}
