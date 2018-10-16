package eg.edu.alexu.cse.oop.draw;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;

import static eg.edu.alexu.cse.oop.draw.DrawingEngine_Impl.list;
import static eg.edu.alexu.cse.oop.draw.DrawingEngine_Impl.unDoneShapes;

public class GUI extends JFrame {


	private JPanel contentPane;
	private int PosX, PosY, PosX1, PosY1;
	private double width, height;
	private BufferedImage image;
	private static int count=0;
	MyDrawingPanel drawingPanel = new MyDrawingPanel();
	DrawingEngine_Impl engine = new DrawingEngine_Impl(drawingPanel.getGraphics());
	public int essam=0,essams=0,flag=0,counter=0,foo=0,flagr=0;




	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 538);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox<String> comboBox = new JComboBox();
		contentPane.add(comboBox);

		drawingPanel.setForeground(Color.WHITE);
		drawingPanel.setBackground(Color.WHITE);
		drawingPanel.setBounds(218, 94, 479, 384);
		contentPane.add(drawingPanel);

		JButton button = new JButton("Rectangle");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Map<String, Double> properties = new HashMap<>();

				MyShape rectangle = new Rectangle();

				width = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter width"));
				height = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter height"));
				PosX = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter x"));
				PosY = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter y"));

				properties.put("width", width);
				properties.put("height", height);
				rectangle.setProperties(properties);
				rectangle.setPosition(new Point(PosX, PosY));
				rectangle.setColor(Color.RED);
				rectangle.setFillColor(Color.RED);


				engine.addShape(rectangle);
				repaint();

				comboBox.addItem("rectangle "+count );
				count++;
			}
		});
		button.setBounds(583, 13, 102, 34);
		contentPane.add(button);

		JButton button_1 = new JButton("Circle");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MyShape ellipse = new Ellipse();
				Map<String, Double> properties = new HashMap<>();

				DrawingEngine_Impl engine = new DrawingEngine_Impl(drawingPanel.getGraphics());

				height = width = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Radius"));
				PosX = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter x"));
				PosY = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter y"));

				properties.put("width", width);
				properties.put("height", height);
				ellipse.setProperties(properties);

				ellipse.setPosition(new Point(PosX, PosY));
				ellipse.setColor(Color.RED);
				ellipse.setFillColor(Color.RED);
				engine.addShape(ellipse);

				repaint();


				comboBox.addItem("circle " +count  );
				count++;

			}
		});
		button_1.setBounds(137, 13, 83, 34);
		contentPane.add(button_1);

		JButton button_2 = new JButton("Line Segment");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Map<String, Double> properties = new HashMap<>();

				MyShape line = new LineSegment();


				PosX1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter x1"));
				PosY1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter y1"));
				PosX = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter x2"));
				PosY = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter y2"));

				line.setPosition(new Point(PosX, PosY));
				((LineSegment) line).setPosition2(new Point(PosX1, PosY1));
				line.setColor(Color.RED);
				line.setFillColor(Color.RED);
				engine.addShape(line);
				repaint();
				comboBox.addItem("line "+count );
				count++;
			}
		});
		button_2.setBounds(218, 13, 110, 34);
		contentPane.add(button_2);

		JButton button_3 = new JButton("Square");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyShape rectangle = new Rectangle();
				Map<String, Double> properties = new HashMap<>();

				DrawingEngine_Impl engine = new DrawingEngine_Impl(drawingPanel.getGraphics());


				width = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter Side"));
				height = width;
				PosX = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter x"));
				PosY = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter y"));

				properties.put("width", width);
				properties.put("height", height);
				rectangle.setProperties(properties);

				rectangle.setPosition(new Point(PosX, PosY));
				rectangle.setColor(Color.RED);
				rectangle.setFillColor(Color.RED);
				engine.addShape(rectangle);
				repaint();

				comboBox.addItem("square " +count );

				count++;
			}
		});
		button_3.setBounds(327, 13, 83, 34);
		contentPane.add(button_3);

		JButton button_4 = new JButton("Ellipse");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyShape ellipse = new Ellipse();
				Map<String, Double> properties = new HashMap<>();


				width = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter width"));
				height = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter height"));
				PosX = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter x"));
				PosY = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter y"));

				properties.put("width", width);
				properties.put("height", height);
				ellipse.setProperties(properties);
				ellipse.setPosition(new Point(PosX, PosY));
				ellipse.setColor(Color.RED);
				ellipse.setFillColor(Color.RED);
				engine.addShape(ellipse);
				repaint();
				comboBox.addItem(" ellipse "+count );
				count++;

			}
		});
		button_4.setBounds(410, 13, 88, 34);
		contentPane.add(button_4);

		JButton button_5 = new JButton("Triangle");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_5.setBounds(498, 13, 88, 34);
		contentPane.add(button_5);

		JButton btnMove = new JButton("Move");
		btnMove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBox.getSelectedIndex();
				PosX = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter x"));
				PosY = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter y"));
				list.get(index).setPosition(new Point(PosX,PosY));
				if(essam>19)
				{flag=1;
				}
				repaint();

			}
		});
		btnMove.setBounds(104, 263, 102, 34);
		contentPane.add(btnMove);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBox.getSelectedIndex();
				 Map<String,Double> properties =new HashMap<String,Double>();
				 width = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter width"));
				height = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter height"));
				properties.put("width", width)	;
				properties.put("height", height);
				list.get(index).setProperties(properties);
				repaint();

			}
		});
		btnEdit.setBounds(0, 263, 102, 34);
		contentPane.add(btnEdit);

		JButton btnCopy = new JButton("Copy");
		btnCopy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = comboBox.getSelectedIndex();
				try {
					Object object = list.get(index).clone();
					list.add((Shape) object);
					PosX = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter x"));
					PosY = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter y"));
					list.get(index).setPosition(new Point(PosX,PosY));
					comboBox.addItem(" copied shape "+count );
					count++;
					repaint();
					
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCopy.setBounds(0, 310, 102, 34);
		contentPane.add(btnCopy);

		JButton btnColorize = new JButton("Colorize");
		btnColorize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = comboBox.getSelectedIndex();
				Color color= JColorChooser.showDialog(btnColorize,"Select a color",Color.black);
                     list.get(index).setColor(color);
                     repaint();

			}
		});
		btnColorize.setBounds(104, 310, 102, 34);
		contentPane.add(btnColorize);

		JButton btnDelete = new JButton("Delete");

		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index= comboBox.getSelectedIndex();
				//System.out.print(index);
				comboBox.removeItemAt(index);
				engine.unDoneShapes.add(list.get(index));
				engine.removeShape(list.get(index));
				repaint();

			}
		});


		btnDelete.setBounds(104, 357, 102, 34);
		contentPane.add(btnDelete);

		JButton btnUndo = new JButton("Undo");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
if(!list.isEmpty()){

	if(engine.essam<4 ){

	engine.undo();
	repaint();
	System.out.println(engine.essam);
	engine.essam++;}
	if (engine.essam>4){
					if(engine.flag==0){
						list.add(unDoneShapes.remove(unDoneShapes.size()-1));
						JOptionPane.showMessageDialog(null,"hahahah","error",JOptionPane.ERROR_MESSAGE);
					}
					if(engine.flag==1){
						list.remove(list.size()-1);
						list.add(unDoneShapes.remove(unDoneShapes.size()-1));
						engine.refresh(drawingPanel.getGraphics());
						repaint();
						System.out.println(engine.essam);


					}}
if(engine.essams>0)
	engine.essams--;
}};
				/*comboBox.removeItemAt(engine.unDoneShapes.size()-1);
				count--;*/

			}
	);
		btnUndo.setBounds(0, 156, 102, 34);
		contentPane.add(btnUndo);

		JButton btnRedo = new JButton("Redo");
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!unDoneShapes.isEmpty()){

					if(engine.essams<4){
						engine.redo();
						engine.essam--;
						repaint();
						System.out.println(engine.essams);
						engine.essams++;}
				if (engine.essams>4){
					if (engine.flag==0 )

					{	unDoneShapes.add(list.remove(list.size()-1));
						JOptionPane.showMessageDialog(null,"hahahah","error",JOptionPane.ERROR_MESSAGE);
					}

					if(engine.flagr==1){
                          list.remove(list.size()-2);
						engine.refresh(drawingPanel.getGraphics());
						repaint();
						flag=0;
					}


				}
			}}
				//comboBox.addItem();
		});
		btnRedo.setBounds(103, 156, 102, 34);
		contentPane.add(btnRedo);

		comboBox.setBounds(0, 228, 206, 22);
		contentPane.add(comboBox);

		JLabel lblSelectShape = new JLabel("Select Shape");
		lblSelectShape.setBounds(12, 203, 118, 16);
		contentPane.add(lblSelectShape);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setBounds(55, 13, 83, 34);
		contentPane.add(btnLoad);
		btnLoad.addActionListener(e -> {

			JFileChooser chooser =new JFileChooser();
			 chooser.showOpenDialog(this);

			//System.out.println(file.getSelectedFile().getName());
			try {


				File file = chooser.getSelectedFile();
				System.out.println(file.toURL());
				URL url[] ={file.toURL()};

				URLClassLoader child = new URLClassLoader (url, this.getClass().getClassLoader());
				String className=JOptionPane.showInputDialog(null,"Enter class name");
				Class classToLoad = Class.forName ("eg.edu.alexu.cse.oop.draw."+className, true, child);
				/*Method method = classToLoad.getDeclaredMethod ("hello");
				Object instance = classToLoad.newInstance ();
				Object result = method.invoke (instance);*/

				engine.installPluginShape(classToLoad);


				JButton btnPlugin= new JButton("Plugin");
				btnPlugin.setBounds(55,50,83,34);
				contentPane.add(btnPlugin);
				btnPlugin.addActionListener(e1 -> {
					Map<String, Double> properties = new HashMap<>();

					width = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter width"));
					height = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter height"));
					PosX = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter x"));
					PosY = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter y"));

					properties.put("width", width);
					properties.put("height", height);
					engine.list.get(list.size()-1).setProperties(properties);
					engine.list.get(list.size()-1).setPosition(new Point(PosX, PosY));
					engine.list.get(list.size()-1).setColor(Color.RED);
					engine.list.get(list.size()-1).setFillColor(Color.RED);


					repaint();
					comboBox.addItem(" ellipse "+count );
					count++;




				});

			} catch (MalformedURLException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();

			}

		});

		 // TODO add your handling code here:
	}
	public void hello(){
		System.out.println("Hello from the other class");
	}
public class MyDrawingPanel extends JPanel{

		public void paintComponent(Graphics g){
			super.paintComponent(g);
		
			engine.refresh(g);

		}

}
}
