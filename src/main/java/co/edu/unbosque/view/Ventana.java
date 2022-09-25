package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;



public class Ventana extends JFrame{

	private PanelFondo panelFondo;
	private JPanel panelMain = new JPanel();
	private JButton btnImportFile, btnSearch;
	private JTextField text;
	private JTextArea showText;
	private JLabel lblEnterText, lblSelect;
	private JRadioButton radioKMB, radioBM;
	
	
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

		lblSelect = new JLabel("Select the algorithm that you will use:");
		lblSelect.setBounds(530, 450, 300, 35);
		lblSelect.setFont(new Font("Roboto",Font.BOLD, 13));
		lblSelect.setForeground(Color.WHITE);
		lblSelect.setVisible(false);
		panelMain.add(lblSelect);
		
		radioKMB = new JRadioButton("KMP");
		radioKMB.setBounds(530,480,100,35);
		radioKMB.setBackground(null);
		radioKMB.setForeground(Color.white);
		radioKMB.setFont(new Font("Century Gothic", Font.BOLD, 12));
		radioKMB.setVisible(false);
		panelMain.add(radioKMB);

		radioBM = new JRadioButton("BM");
		radioBM.setBounds(530,510,100,35);
		radioBM.setBackground(null);
		radioBM.setForeground(Color.white);
		radioBM.setFont(new Font("Century Gothic", Font.BOLD, 12));
		radioBM.setVisible(false);
		panelMain.add(radioBM);
		
		ButtonGroup optionAlgorithm = new ButtonGroup();
		optionAlgorithm.add(radioKMB);
		optionAlgorithm.add(radioBM);
		
		showText = new JTextArea();
		showText.setBounds(30,80,770,350);
		showText.setLineWrap(true);
		showText.setBackground(null);
		showText.setEditable(false);
		showText.setBorder(BorderFactory.createLineBorder(Color.white));
		showText.setForeground(Color.WHITE);
		showText.setFont(new Font("Century Gothic", Font.BOLD, 12));
		panelMain.add(showText);

		text = new JTextField();
		text.setBounds(180, 450, 300, 35);
		text.setFont(new Font("Roboto",Font.LAYOUT_LEFT_TO_RIGHT, 12));
		text.setBorder(BorderFactory.createLineBorder(Color.gray));
		text.setVisible(false);
		panelMain.add(text);
		
		lblEnterText = new JLabel("Type the character or text: ");
		lblEnterText.setBounds(10, 450, 300, 35);
		lblEnterText.setFont(new Font("Roboto",Font.BOLD, 13));
		lblEnterText.setForeground(Color.WHITE);
		lblEnterText.setVisible(false);
		panelMain.add(lblEnterText);


		btnSearch = new JButton("Search");
		btnSearch.setBounds(285,500,90,30);
		btnSearch.setFont(new Font("Century Gothic",Font.BOLD, 12));
		btnSearch.setActionCommand("SEARCH");
		btnSearch.setVisible(false);
		panelMain.add(btnSearch);
		
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Search Text");
        panelMain.setBorder(bordejpanel);
        
       
//        Container contentpane = getContentPane(); // SE AGREGA LA IMAGEN DE PRESENTACI�N
//		panelFondo = new PanelFondo();
//		contentpane.add(panelFondo);

	}
	
	public File connectFileChooser() {
		FileChooser tf = new FileChooser();
		File fileChooser = tf.checkFile();
		System.out.println("The file selected is: " + fileChooser.getName());
		return fileChooser;
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


	public JLabel getLblEnterText() {
		return lblEnterText;
	}


	public void setLblEnterText(JLabel lblEnterText) {
		this.lblEnterText = lblEnterText;
	}


	public JLabel getSelect() {
		return lblSelect;
	}


	public void setSelect(JLabel select) {
		this.lblSelect = select;
	}


	public JRadioButton getRadioKMB() {
		return radioKMB;
	}


	public void setRadioKMB(JRadioButton radioKMB) {
		this.radioKMB = radioKMB;
	}


	public JRadioButton getRadioBM() {
		return radioBM;
	}


	public void setRadioBM(JRadioButton radioBM) {
		this.radioBM = radioBM;
	}

	public JLabel getLblSelect() {
		return lblSelect;
	}

	public void setLblSelect(JLabel lblSelect) {
		this.lblSelect = lblSelect;
	}
	
	
}
