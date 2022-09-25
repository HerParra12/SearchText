package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JLabel lblEnterText;
	
	
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
		btnImportFile.setFont(new Font("Century Gothic",Font.BOLD, 12));
		btnImportFile.setActionCommand("IMPORTFILE");
		btnImportFile.setEnabled(true);
		panelMain.add(btnImportFile);
		
		btnKMB = new JButton("KMP");
		btnKMB.setBounds(10,250,70,40);
		btnKMB.setFont(new Font("Century Gothic",Font.BOLD, 12));
		btnKMB.setActionCommand("KMP");
		btnKMB.setEnabled(true);
		panelMain.add(btnKMB);
		
		btnBM = new JButton("BM");
		btnBM.setBounds(740,250,70,40);
		btnBM.setFont(new Font("Century Gothic",Font.BOLD, 12));
		btnBM.setActionCommand("BM");
		btnBM.setEnabled(true);
		panelMain.add(btnBM);
		
		showText = new JTextArea();
		showText.setBounds(110,80,600,350);
		showText.setLineWrap(true);
		showText.setBackground(null);
		showText.setEditable(false);
		showText.setBorder(BorderFactory.createLineBorder(Color.white));
		showText.setForeground(Color.WHITE);
		showText.setFont(new Font("Century Gothic", Font.BOLD, 12));
		showText.setText("Vamos con otra prueba");
		panelMain.add(showText);

		text = new JTextField();
		text.setBounds(260, 450, 300, 35);
		text.setFont(new Font("Roboto",Font.LAYOUT_LEFT_TO_RIGHT, 12));
		text.setBorder(BorderFactory.createLineBorder(Color.gray));
		panelMain.add(text);
		
		lblEnterText = new JLabel("Type the character or text: ");
		lblEnterText.setBounds(90, 450, 300, 35);
		lblEnterText.setFont(new Font("Roboto",Font.BOLD, 13));
		lblEnterText.setForeground(Color.WHITE);
		panelMain.add(lblEnterText);


		btnSearch = new JButton("Search");
		btnSearch.setBounds(365,500,90,30);
		btnSearch.setFont(new Font("Century Gothic",Font.BOLD, 12));
		btnSearch.setActionCommand("SEARCH");
		btnSearch.setEnabled(true);
		panelMain.add(btnSearch);
		
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Search Text");
        panelMain.setBorder(bordejpanel);

	}


	public JPanel getPanelMain() {
		return panelMain;
	}


	public void setPanelMain(JPanel panelMain) {
		this.panelMain = panelMain;
	}


	public JButton getBtnImportFile() {
		return btnImportFile;
	}


	public void setBtnImportFile(JButton btnImportFile) {
		this.btnImportFile = btnImportFile;
	}


	public JButton getBtnSearch() {
		return btnSearch;
	}


	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}


	public JButton getBtnKMB() {
		return btnKMB;
	}


	public void setBtnKMB(JButton btnKMB) {
		this.btnKMB = btnKMB;
	}


	public JButton getBtnBM() {
		return btnBM;
	}


	public void setBtnBM(JButton btnBM) {
		this.btnBM = btnBM;
	}


	public JTextField getText() {
		return text;
	}


	public void setText(JTextField text) {
		this.text = text;
	}


	public JTextArea getShowText() {
		return showText;
	}


	public void setShowText(JTextArea showText) {
		this.showText = showText;
	}
	
	
}
