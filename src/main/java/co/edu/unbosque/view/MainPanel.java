/**
 * The package of the class
 */
package co.edu.unbosque.view;

/**
 * The necessary imports to work the class
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;

/**
 * The class that shows the panel contained in the frame
 * 
 * @author Kevin Pinzón, Hernan Alvarado, Omar Santos
 *
 */
public class MainPanel extends JPanel {

	/**
	 * Variable of the version that the serial has
	 */
	private static final long serialVersionUID = 3975846491697319807L;
	/**
	 * Variables of the buttons showed in the panel
	 */
	private JButton btnImportFile, btnSearch;
	/**
	 * Variable of the space to write the word that will be searched
	 */
	private JTextField text;
	/**
	 * Variables {showText} is area where will be showed the txt, {rectangle} is a
	 * visual element
	 */
	private JTextArea showText, rectangle;
	/**
	 * Variables indicatives of the text that will be showed in the program
	 */
	private JLabel lblEnterText, lblSelect, lblCoincidences;
	/**
	 * Variables of the buttons to select the algorithm to search
	 */
	private JRadioButton radioKMB, radioBM;
	/**
	 * The variable of the image background, it will be used to paint text
	 */
	private Image background;
	/**
	 * Variable that helps to highlighter
	 */
	private Highlighter high;
	/**
	 * Variable that will paint the character(s) searched
	 */
	private HighlightPainter paint;
	/**
	 * Variable that allows the movement in the field where the program shows the .txt file
	 */
	private JScrollPane barraSalida;

	/**
	 * Variable that allows to select the type of search(Capital letter, lower case letter, without distinction)
	 */
	private JComboBox optionsSearch;

	/**
	 * The constructor of the clase, it contains the different configurations of the
	 * buttons, labels, areas and other specifications of the panel
	 */
	MainPanel() {
		setBackground();
		setLayout(null);
		setForeground(null);

		btnImportFile = new JButton("Import the file (txt)");
		btnImportFile.setBounds(320, 20, 170, 35);
		btnImportFile.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnImportFile.setActionCommand("IMPORTFILE");
		btnImportFile.setEnabled(true);
		add(btnImportFile);

		lblSelect = new JLabel("Select the algorithm that you will use:");
		lblSelect.setBounds(530, 450, 300, 35);
		lblSelect.setFont(new Font("Roboto", Font.BOLD, 13));
		lblSelect.setForeground(Color.WHITE);
		lblSelect.setVisible(false);
		add(lblSelect);
		
		lblCoincidences = new JLabel("The quantity of coincidences is: ");
		lblCoincidences.setBounds(540, 20, 300, 35);
		lblCoincidences.setFont(new Font("Roboto", Font.BOLD, 14));
		lblCoincidences.setForeground(Color.WHITE);
		lblCoincidences.setVisible(false);
		add(lblCoincidences);

		radioKMB = new JRadioButton("KMP");
		radioKMB.setBounds(530, 480, 100, 35);
		radioKMB.setOpaque(false);
		radioKMB.setForeground(Color.white);
		radioKMB.setFont(new Font("Century Gothic", Font.BOLD, 12));
		radioKMB.setVisible(false);
		add(radioKMB);

		radioBM = new JRadioButton("BM");
		radioBM.setBounds(530, 510, 100, 35);
		radioBM.setOpaque(false);
		radioBM.setForeground(Color.white);
		radioBM.setFont(new Font("Century Gothic", Font.BOLD, 12));
		radioBM.setVisible(false);
		add(radioBM);

		ButtonGroup optionAlgorithm = new ButtonGroup();
		optionAlgorithm.add(radioKMB);
		optionAlgorithm.add(radioBM);

		
		
		showText = new JTextArea();
		showText.setLineWrap(true);
		showText.setEditable(false);
		showText.setFont(new Font("Century Gothic", Font.BOLD, 12));
		add(showText);

		barraSalida = new JScrollPane(showText);
		barraSalida.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		barraSalida.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		barraSalida.setBounds(30, 80, 770, 350);
		barraSalida.setVisible(false);
		add(barraSalida);
		
		rectangle = new JTextArea();
		rectangle.setBounds(515, 450, 260, 100);
		rectangle.setLineWrap(true);
		rectangle.setOpaque(false);
		rectangle.setEditable(false);
		rectangle.setBorder(BorderFactory.createLineBorder(Color.white));
		rectangle.setForeground(Color.WHITE);
		rectangle.setVisible(false);
		add(rectangle);

		text = new JTextField();
		text.setBounds(180, 450, 300, 35);
		text.setFont(new Font("Roboto", Font.LAYOUT_LEFT_TO_RIGHT, 12));
		text.setBorder(BorderFactory.createLineBorder(Color.gray));
		text.setVisible(false);
		add(text);

		lblEnterText = new JLabel("Type the character or text: ");
		lblEnterText.setBounds(10, 450, 300, 35);
		lblEnterText.setFont(new Font("Roboto", Font.BOLD, 13));
		lblEnterText.setForeground(Color.WHITE);
		lblEnterText.setVisible(false);
		add(lblEnterText);

		btnSearch = new JButton("Search");
		btnSearch.setBounds(390, 500, 90, 30);
		btnSearch.setFont(new Font("Century Gothic", Font.BOLD, 12));
		btnSearch.setActionCommand("SEARCH");
		btnSearch.setVisible(false);
		add(btnSearch);
		
		optionsSearch = new JComboBox<String>();
		optionsSearch.setBounds(180, 500, 180, 30);
		optionsSearch.setFont(new Font("Century Gothic", Font.BOLD, 12));
		optionsSearch.addItem("Select a type of search");
		optionsSearch.addItem("Capital letter");
		optionsSearch.addItem("Lower case letter");
		optionsSearch.addItem("Without distinction");
		optionsSearch.setVisible(false);
		add(optionsSearch);
		
		Border bordejpanel = new TitledBorder(new EtchedBorder(), "               ");
		setBorder(bordejpanel);

		high = new DefaultHighlighter();
		paint = new DefaultHighlighter.DefaultHighlightPainter(Color.gray);
		showText.setHighlighter(high);
	}

	/**
	 * Method that searches in the file the character(s) selected
	 * @param file   String of the file selected
	 * @param search String of the character(s) that will be showed
	 * @return An unidimensional array that already searched the character(s)
	 *         requested
	 */
	public String estados() {
		boolean kmp = radioKMB.isSelected();
		boolean bm = radioBM.isSelected();
		if (!kmp && !bm)
			return null;
		else
			return kmp? "KMP" : "BM";
	}

	/**
	 * Method that paints the character(s) finded
	 * 
	 * @param chars String Unidimensional arrangement with the character(s) that
	 *              will be painted
	 * @param size  Integer that gives the maxium distance to pint a segment
	 */
	public void paintText(String chars[], int size) {
		high.removeAllHighlights();
		try {
			for (int i = 1; i < chars.length; i++) {
				high.addHighlight(Integer.parseInt(chars[i]), Integer.parseInt(chars[i]) + size, paint);
				showText.setCaretPosition(Integer.parseInt(chars[i]) + size);
			}
		} catch (Exception error) {
		}
	}

	/**
	 * Method that paints graphically the character(s) selected by the user
	 */
	public void paintComponent(Graphics g) {
		int width = getSize().width;
		int height = getSize().height;
		if (background != null)
			g.drawImage(background, 0, 0, width, height, null);
		super.paintComponent(g);
	}

	/**
	 * Method that paints the background image at the panel
	 */
	public void setBackground() {
		setOpaque(false);
		background = new ImageIcon("src/main/resources/3.jpg").getImage();
		repaint();
	}

	/**
	 * Method to call the button
	 * 
	 * @return The button to import a file
	 */
	public JButton getBtnImportFile() {
		return btnImportFile;
	}

	/**
	 * Method to sets a value to the button
	 * 
	 * @param btnImportFile The button to import a file
	 */
	public void setBtnImportFile(JButton btnImportFile) {
		this.btnImportFile = btnImportFile;
	}

	/**
	 * Method to call the button
	 * 
	 * @return The button to search the character(s)
	 */
	public JButton getBtnSearch() {
		return btnSearch;
	}

	/**
	 * Method to sets a value to the button
	 * 
	 * @param btnSearch The button to make a search
	 */
	public void setBtnSearch(JButton btnSearch) {
		this.btnSearch = btnSearch;
	}

	/**
	 * Method to call the field of the character(s) that will be showed
	 * 
	 * @return The field of the text
	 */
	public JTextField getText() {
		return text;
	}

	/**
	 * Method to sets the fieldo f the character(s) that will be showed
	 * 
	 * @param text The field of the text
	 */
	public void setText(JTextField text) {
		this.text = text;
	}

	/**
	 * Method to call the area where will be showed the file .txt
	 * 
	 * @return The area of the text
	 */
	public JTextArea getShowText() {
		return showText;
	}

	/**
	 * Method to sets the area where will be showed the file .txt
	 * 
	 * @param showText The area of the text
	 */
	public void setShowText(JTextArea showText) {
		this.showText = showText;
	}

	/**
	 * Method to call the label that indicates the user must enter the text to
	 * search
	 * 
	 * @return The label enter text
	 */
	public JLabel getLblEnterText() {
		return lblEnterText;
	}

	/**
	 * Method to sets the label that indicates the user must enter the text to
	 * search
	 * 
	 * @param lblEnterText The label enter text
	 */
	public void setLblEnterText(JLabel lblEnterText) {
		this.lblEnterText = lblEnterText;
	}

	/**
	 * Method to call the label that indicated the user must select an option of
	 * algorithm
	 * 
	 * @return The label select
	 */
	public JLabel getLblSelect() {
		return lblSelect;
	}

	/**
	 * Method to sets the label that indicated the user must select an option of
	 * algorithm
	 * 
	 * @param lblSelect The label select
	 */
	public void setLblSelect(JLabel lblSelect) {
		this.lblSelect = lblSelect;
	}

	/**
	 * Method to call the radio button of the algorithm KMB
	 * 
	 * @return The radio button KMB
	 */
	public JRadioButton getRadioKMB() {
		return radioKMB;
	}

	/**
	 * Method to sets the radio button of the algorithm KMB
	 * 
	 * @param radioKMB The radio button KMB
	 */
	public void setRadioKMB(JRadioButton radioKMB) {
		this.radioKMB = radioKMB;
	}

	/**
	 * Method to call the radio button of the algorithm BM
	 * 
	 * @return The radio button BM
	 */
	public JRadioButton getRadioBM() {
		return radioBM;
	}

	/**
	 * Method to sets the radio button of the algorithm BM
	 * 
	 * @param radioBM The radio button BM
	 */
	public void setRadioBM(JRadioButton radioBM) {
		this.radioBM = radioBM;
	}

	/**
	 * Method that calls a visual rectangle to difference some aspects of the panel
	 * 
	 * @return The TextArea rectangle
	 */
	public JTextArea getRectangle() {
		return rectangle;
	}

	/**
	 * Method that sets a visual rectangle to difference some aspects of the panel
	 * 
	 * @param rectangle The TextArea rectangle
	 */
	public void setRectangle(JTextArea rectangle) {
		this.rectangle = rectangle;
	}
	/**
	 * Method that calls the scroll pane contained in the field to show the .txt
	 * @return The scroll pane
	 */
	public JScrollPane getBarraSalida() {
		return barraSalida;
	}
	/**
	 * Method that sets the scroll pane contained in the field to show the .txt
	 * @param barraSalida The scroll pane
	 */
	public void setBarraSalida(JScrollPane barraSalida) {
		this.barraSalida = barraSalida;
	}
	
	/**
	 * Method that calls the label which indicates the quantity of repetitions of the search
	 * @return The label of coincidences
	 */
	public JLabel getLblCoincidences() {
		return lblCoincidences;
	}
	
	/**
	 * Method that sets the label which indicates the quantity of repetitions of the search
	 * @param lblCoincidences The label of coincidences
	 */
	public void setLblCoincidences(JLabel lblCoincidences) {
		this.lblCoincidences = lblCoincidences;
	}

	public JComboBox getOptionsSearch() {
		return optionsSearch;
	}

	public void setOptionsSearch(JComboBox optionsSearch) {
		this.optionsSearch = optionsSearch;
	}

	
}