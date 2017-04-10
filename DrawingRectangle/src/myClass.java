import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class myClass extends JPanel {
	public static Dimension size;
	
	public myClass(){
		super();
		//New colors - pass RGBA 0~255
		//Color myColor = newColor(255, 255, 255, 100);
		setBackground(Color.BLACK);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		g.setColor(Color.WHITE);
		
		
		// to the right of r, filled in , and green
		int boxesWidth = 15;
		int boxesHeight = 10;
		
		for (int x = 0; x < boxesWidth; x++){
			for(int y =0; y < boxesHeight; y++){
				
				int v = (int)((double) 255 / (double)(boxesWidth + boxesHeight) * (x+y));
				Color c = new Color(0,v,v,255); //RGBA
				g2.setColor(c);
				
				//Instantiate our Rectangle
				Rectangle2D r = new Rectangle2D.Double(
						x * size.getWidth() / boxesWidth,
						y * size.getHeight() / boxesHeight,
						size.getWidth() / boxesWidth,
						size.getHeight() / boxesHeight
						);  
				//Draw our rectangle
				g2.fill(r);
			}
			Color c1 = new Color( 100,0,0,30);
			g2.setColor(c1);
			Rectangle2D r1 = new Rectangle.Double(480, 270, 960, 540);
				g2.fill(r1);
			
			Color c2 = new Color( 50,0,50,15);
			g2.setColor(c2);
			Rectangle2D r2 = new Rectangle.Double(0, 0, 480, 270);
				g2.fill(r2);	
				
			Color c3 = new Color( 0,50,0,45);
			g2.setColor(c3);
			Rectangle2D r3 = new Rectangle.Double(1440, 0, 480, 270);
				g2.fill(r3);
		
			Color c4 = new Color( 0,0,50,15);
			g2.setColor(c4);
			Rectangle2D r4 = new Rectangle.Double(0, 810, 480, 270);
				g2.fill(r4);
		
			Color c5 = new Color( 0,50,50,60);
			g2.setColor(c5);
			Rectangle2D r5 = new Rectangle.Double(1440, 810, 480, 270);
				g2.fill(r5);
		}
	
	}
	
	public void setupDisplay(){
		JFrame application = new JFrame();
		application.add(this);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(1920, 1080);
		application.setExtendedState(JFrame.MAXIMIZED_BOTH);
		application.setUndecorated(true);
		application.setVisible(true);
		size = application.getSize();
	}
	
	
	public static void main(String[] args){
		myClass program = new myClass();
		program.setupDisplay();
		
		
		program.repaint();
	}

}
