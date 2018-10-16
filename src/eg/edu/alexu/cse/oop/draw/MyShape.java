package eg.edu.alexu.cse.oop.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
public class MyShape implements Shape {

	private Point position;
	private Color color;
	private Color fillColor;
	private Map<String,Double> properties =new HashMap<String,Double>();
	private double width,height;
	private static int index=0;
	
	public MyShape(){
		
	}
	public MyShape(Point position,Color color,Color fillColor,Map<String,Double> properties)
	{
		this.position=position;
		this.color = color;
		this.fillColor=color;
		this.properties= properties;
	}
	@Override
	public void setPosition(Point position) {
		this.position= new Point(position);

	}

	@Override
	public Point getPosition() {
		return position;
	
	}
	

	@Override
	public void setProperties(Map<String, Double> properties) {

		this.properties=properties;
		this.width = properties.get("width");
		this.height = properties.get("height");
		

	}

	@Override
	public Map<String, Double> getProperties() {
		return properties;
	}

	@Override
	public void setColor(Color color) {
		
		this.color= color;
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public void setFillColor(Color color) {
		fillColor = color;

	}

	@Override
	public Color getFillColor() {
		return fillColor;
	}

	@Override
	public  void draw(Graphics canvas){
		
	}

	public Object clone() throws CloneNotSupportedException{
		return null;
	}

}
