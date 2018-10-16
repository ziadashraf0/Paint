package eg.edu.alexu.cse.oop.draw;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawingEngine_Impl extends JPanel implements DrawingEngine {
	public static ArrayList<Shape> unDoneShapes = new ArrayList<>();
	public static ArrayList<Shape> list = new ArrayList<>();
	private int index;
	private Graphics canvas;
    int essam=0,essams=0,flag=0,flagr=0;

	public DrawingEngine_Impl(){
		
	}

	public DrawingEngine_Impl(Graphics canvas){
		this.canvas=canvas;
	}
	
	@Override
	public void addShape(Shape shape) {

		list.add(shape);
       if(unDoneShapes.size()>1 && essam>0){
       	essam--;
       flag=1;}
		System.out.println(essam);
		if(unDoneShapes.size()>1 && essams>0){
			--essams;
			flagr=1;}


	
		
	}

	@Override
	public void removeShape(Shape shape) {
		list.remove(shape);
		unDoneShapes.add(shape);
		
	}
@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
		Shape shapes[]=new Shape[list.size()];
		for (int i=0;i<list.size();i++)
		{
			shapes[i]=list.get(i);
		}

		return shapes;

	}

	@Override
	public void refresh(Graphics canvas) {

		list.forEach(shape -> shape.draw(canvas));
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void installPluginShape(Class<? extends Shape> shapeClass) {
		// TODO Auto-generated method stub

		try {
			Object obj = shapeClass.newInstance();
			this.addShape(((Shape)obj));
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void undo() {

		unDoneShapes.add(list.remove(list.size()-1));



	}

	@Override
	public void redo() {
	list.add(unDoneShapes.remove(unDoneShapes.size()-1));


			
	}

}
