package eg.edu.alexu.cse.oop.draw;

import java.awt.*;
import java.util.Map;

public class Ellipse extends MyShape {

	public Ellipse(){
		
	}
	public Ellipse(Point position,Color color,Color fillColor,Map<String,Double> properties){
		super(position,color,fillColor,properties);
		
	}
	
	
	
	@Override
	public void draw(Graphics canvas) {
		Graphics2D g2 = (Graphics2D)canvas;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g2.setRenderingHints(rh);
		double w=getProperties().get("width");
		double h=getProperties().get("height");
		g2.setColor(getColor());
		g2.fillOval(getPosition().x,getPosition().y, (int)w, (int)h);
		g2.drawOval(getPosition().x,getPosition().y, (int)w, (int)h);
		g2.drawOval(getPosition().x,getPosition().y, (int)w, (int)h);
	
	}

	@Override
	public Object clone()  {
	MyShape Ellipse=new Ellipse(super.getPosition(),super.getColor(),super.getFillColor(),super.getProperties());
		return Ellipse;
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				System.out.println("Hello from the other class");

			}});}
	

}
