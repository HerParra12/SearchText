/**
 * The package of the class
 */
package co.edu.unbosque.controller;

/**
 * The necessary imports to work the class
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.unbosque.model.Algorithm;
import co.edu.unbosque.model.persistence.Persistencia;
import co.edu.unbosque.view.View;

/**
 * Class that connects the model with the view
 * 
 * @author Omar Santos, Hernan Alvarado, Kevin Pinzón
 *
 */
public class Controller implements ActionListener {

	/**
	 * Variable of the class Algorithm
	 */
	private Algorithm model;
	/**
	 * Variable of the class Persistence
	 */
	private Persistencia persistence;
	/**
	 * Variable of the class View
	 */
	private View view;

	/**
	 * Constructor of the class, it calls a Listeners method and instances the
	 * classes declared before
	 */
	public Controller() {
		model = new Algorithm();
		persistence = new Persistencia();
		view = new View();
		assigningListeners();
	}

	/**
	 * Method that assigns the buttons listeners of the view
	 */
	public void assigningListeners() {
		view.getPanelMain().getBtnImportFile().addActionListener(this);
		view.getPanelMain().getBtnSearch().addActionListener(this);
		view.getPanelMain().getRadioBM().addActionListener(this);
		view.getPanelMain().getRadioKMB().addActionListener(this);
	}

	/**
	 * Method that connects the differents options of the view with the model. Also
	 * makes validations
	 */
	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();
		String text = null;
		if (comand.equals("IMPORTFILE")) {
			text = persistence.contentText(view.connectFileChooser().getAbsolutePath());
			view.getPanelMain().getShowText().setText(text);
			view.getPanelMain().getText().setVisible(true);
			view.getPanelMain().getBtnSearch().setVisible(true);
			view.getPanelMain().getRadioBM().setVisible(true);
			view.getPanelMain().getRadioKMB().setVisible(true);
			view.getPanelMain().getLblEnterText().setVisible(true);
			view.getPanelMain().getLblSelect().setVisible(true);
			view.getPanelMain().getRectangle().setVisible(true);
			view.getPanelMain().getBarraSalida().setVisible(true);
			view.getPanelMain().getOptionsSearch().setVisible(true);

		} else if (comand.equals("SEARCH")) {
			String search = view.getPanelMain().getText().getText();
			text = persistence.contentText(view.getRuta());
			if (!search.isEmpty()) {
				String estados = view.getPanelMain().estados();
				String statusCombo = view.getPanelMain().getOptionsSearch().getSelectedItem().toString();
				if (estados != null) {
					
					if(statusCombo.equals("Select a type of search")) {
						view.warningMessage("You must select a type of search");
					} else
					paintText(text, estados, search);

				} else
					view.warningMessage("You must select an algorithm");
			} else {
				view.warningMessage("You must fill out a text to perform the search");
			}
			view.getPanelMain().getText().setText("");
		}
	}

	/**
	 * Method that paints the character(s) solicited by the user, considering the
	 * algorithm selected
	 * 
	 * @param content   String where the character(s) will be searched
	 * @param algorithm String of the algorithm selected
	 * @param search    String of character(s) that will be painted
	 */
	private void paintText(String content, String algorithm, String search) {
		String chars[];
		String status = view.getPanelMain().getOptionsSearch().getSelectedItem().toString();
		if (algorithm.equals("KMP")) {
			if (status.equals("Capitar letter"))
				search = search.toUpperCase();
			if (status.equals("Lower case letter"))
				search = search.toLowerCase();
			if (status.equals("Without distinction")) {
				content = content.toUpperCase();
				search = search.toUpperCase();
			}
			chars = model.kmpAlgorithm(content, search).split(",");

		} else {
			if (status.equals("Capitar letter"))
				search = search.toUpperCase();
			if (status.equals("Lower case letter"))
				search = search.toLowerCase();
			if (status.equals("Without distinction")) {
				content = content.toUpperCase();
				search = search.toUpperCase();
			}
			chars = model.bmAlgorithm(content, search).split(",");
		}
		view.getPanelMain().getLblCoincidences().setText("The quantity of coincidences is: " + (chars.length - 1));
		view.getPanelMain().getLblCoincidences().setVisible(true);
		view.getPanelMain().paintText(chars, search.length());
	}
}