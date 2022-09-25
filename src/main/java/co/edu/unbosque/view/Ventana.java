package co.edu.unbosque.view;

import java.io.File;
import javax.swing.JFrame;

public class Ventana extends JFrame{
	
	private PanelPrincipal panelMain = new PanelPrincipal();

	public Ventana() {

		setTitle("Search text by an algorithm");
		setSize(850,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(panelMain);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

	}
	
	public File connectFileChooser() {
		FileChooser tf = new FileChooser();
		File fileChooser = tf.checkFile();
		System.out.println("The file selected is: " + fileChooser.getName());
		return fileChooser;
	}

	public PanelPrincipal getPanelMain() {
		return panelMain;
	}

	public void setPanelMain(PanelPrincipal panelMain) {
		this.panelMain = panelMain;
	}

	
}
