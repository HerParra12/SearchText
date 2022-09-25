package co.edu.unbosque.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Ventana extends JFrame{

	private JPanel panelMain = new JPanel();
	private JButton btnImportFile, btnSearch, btnKMB, btnBM;
	private JTextField text;
	private JTextArea showText;
	
	
	public Ventana() {

		setTitle("Search text by an algorithm");
		setSize(850,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(panelMain);
		panelMain.setBackground(Color.DARK_GRAY);
		panelMain.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);

		btnImportFile = new JButton("Import the file (txt)");
		btnImportFile.setBounds(320,20,170,35);
		btnImportFile.setActionCommand("IMPORTFILE");
		btnImportFile.setEnabled(true);
		panelMain.add(btnImportFile);
		
		btnKMB = new JButton("KMP");
		btnKMB.setBounds(10,250,70,40);
		btnKMB.setActionCommand("KMP");
		btnKMB.setEnabled(true);
		panelMain.add(btnKMB);
		
		btnBM = new JButton("BM");
		btnBM.setBounds(740,250,70,40);
		btnBM.setActionCommand("BM");
		btnBM.setEnabled(true);
		panelMain.add(btnBM);
		
		showText = new JTextArea();
		showText.setBounds(110,80,600,350);
		showText.setLineWrap(true);
		showText.setBackground(null);
		showText.setEnabled(false);
		showText.setEditable(false);
		showText.setForeground(Color.white);
		showText.setBorder(BorderFactory.createLineBorder(Color.white));
		showText.setText("La puta madre");
		panelMain.add(showText);

		text = new JTextField();
		text.setBounds(260, 450, 300, 35);
		text.setBorder(BorderFactory.createLineBorder(Color.gray));
		panelMain.add(text);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(365,500,90,30);
		btnSearch.setActionCommand("SEARCH");
		btnSearch.setEnabled(true);
		panelMain.add(btnSearch);
		
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Search Text");
        panelMain.setBorder(bordejpanel);

	}
	
	
}
