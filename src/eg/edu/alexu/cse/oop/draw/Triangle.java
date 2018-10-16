package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

public class Triangle extends MyShape {

	public Triangle(){
		
	}
	public Triangle(Point position,Color color,Color fillColor,Map<String,Double> properties)
	{
		super(position,color,fillColor,properties);
	}
	@Override
	public void draw(Graphics canvas) {
	
		
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		MyShape triangle= new Triangle(super.getPosition(),super.getColor(),super.getFillColor(),super.getProperties());
		return triangle;
	}

}
