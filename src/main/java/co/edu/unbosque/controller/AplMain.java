package co.edu.unbosque.controller;
import javax.swing.UIManager;

public class AplMain {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new Controller();
		} catch (Exception e) {}
	}
	
}
