package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class PanelPrincipal extends JPanel{
	
	private JButton btnImportFile, btnSearch;
	private JTextField text;
	private JTextArea showText;
	private JLabel lblEnterText, lblSelect;
	private JRadioButton radioKMB, radioBM;
	private Image background;

	
	PanelPrincipal(){
		
        setBackground();
		setLayout(null);
		setForeground(null);

		btnImportFile = new JButton("Import the file (txt)");
		btnImportFile.setBounds(320,20,170,35);
		btnImportFile.setFont(new Font("Century Gothic",Font.BOLD, 12));
		btnImportFile.setActionCommand("IMPORTFILE");
		btnImportFile.setEnabled(true);
		add(btnImportFile);

		lblSelect = new JLabel("Select the algorithm that you will use:");
		lblSelect.setBounds(530, 450, 300, 35);
		lblSelect.setFont(new Font("Roboto",Font.BOLD, 13));
		lblSelect.setForeground(Color.WHITE);
		lblSelect.setVisible(false);
		add(lblSelect);
		
		radioKMB = new JRadioButton("KMP");
		radioKMB.setBounds(530,480,100,35);
		radioKMB.setOpaque(false);
		radioKMB.setForeground(Color.white);
		radioKMB.setFont(new Font("Century Gothic", Font.BOLD, 12));
		radioKMB.setVisible(false);
		add(radioKMB);

		radioBM = new JRadioButton("BM");
		radioBM.setBounds(530,510,100,35);
		radioBM.setOpaque(false);
		radioBM.setForeground(Color.white);
		radioBM.setFont(new Font("Century Gothic", Font.BOLD, 12));
		radioBM.setVisible(false);
		add(radioBM);
		
		ButtonGroup optionAlgorithm = new ButtonGroup();
		optionAlgorithm.add(radioKMB);
		optionAlgorithm.add(radioBM);
		
		showText = new JTextArea();
		showText.setBounds(30,80,770,350);
		showText.setLineWrap(true);
		showText.setOpaque(false);
		showText.setEditable(false);
		showText.setBorder(BorderFactory.createLineBorder(Color.white));
		showText.setForeground(Color.WHITE);
		showText.setFont(new Font("Century Gothic", Font.BOLD, 12));
		add(showText);

		text = new JTextField();
		text.setBounds(180, 450, 300, 35);
		text.setFont(new Font("Roboto",Font.LAYOUT_LEFT_TO_RIGHT, 12));
		text.setBorder(BorderFactory.createLineBorder(Color.gray));
		text.setVisible(false);
		add(text);
		
		lblEnterText = new JLabel("Type the character or text: ");
		lblEnterText.setBounds(10, 450, 300, 35);
		lblEnterText.setFont(new Font("Roboto",Font.BOLD, 13));
		lblEnterText.setForeground(Color.WHITE);
		lblEnterText.setVisible(false);
		add(lblEnterText);


		btnSearch = new JButton("Search");
		btnSearch.setBounds(285,500,90,30);
		btnSearch.setFont(new Font("Century Gothic",Font.BOLD, 12));
		btnSearch.setActionCommand("SEARCH");
		btnSearch.setVisible(false);
		add(btnSearch);
		
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Search Text");
        setBorder(bordejpanel);
        
		
	}
	
	public void paintComponent(Graphics g) {
		int width = this.getSize().width;
		int height = this.getSize().height;
		if (this.background != null) {
			g.drawImage(this.background, 0, 0, width, height, null);
		}
		super.paintComponent(g);
	}

	
	public void setBackground() {
		this.setOpaque(false);
		this.background = new ImageIcon("src/main/resources/2.jpg").getImage();
		repaint();
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


	public JLabel getLblSelect() {
		return lblSelect;
	}


	public void setLblSelect(JLabel lblSelect) {
		this.lblSelect = lblSelect;
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

	
	
	
}
