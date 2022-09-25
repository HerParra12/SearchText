package co.edu.unbosque.view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelFondo extends JPanel{
	
	private Image fondo;
	
	
	public PanelFondo () {
		
		preInit();
		initComponents();
		
	}

	private void initComponents() {		
	}

	private void preInit() {

		
		

		
		fondo = new ImageIcon("src/main/resources/2.jpg").getImage();
		
		
	}
	
	public void paint (Graphics g) {
		
		g.drawImage(fondo,0,0,getWidth(),getHeight(),this);
        setOpaque(false);
		super.paintComponent(g);
	}
	
	
}
