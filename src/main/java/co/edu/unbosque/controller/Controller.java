package co.edu.unbosque.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import co.edu.unbosque.model.Modelo;
import co.edu.unbosque.model.persistence.Persistencia;
import co.edu.unbosque.view.Ventana;

public class Controller implements ActionListener{

	private Modelo model;
	private Persistencia persistence;
	private Ventana view;
	
	public Controller() {
		model = new Modelo();
		persistence = new Persistencia();
		view = new Ventana();
		assigningListeners();
	}
	
	public void assigningListeners() {
		view.getPanelMain().getBtnImportFile().addActionListener(this);
		view.getPanelMain().getBtnSearch().addActionListener(this);
		view.getPanelMain().getRadioBM().addActionListener(this);
		view.getPanelMain().getRadioKMB().addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();
		String text = null;
		if(comand.equals("IMPORTFILE")) {
			text = persistence.contentText(view.connectFileChooser().getAbsolutePath());
			view.getPanelMain().getShowText().setText(text);
			view.getPanelMain().getText().setVisible(true);
			view.getPanelMain().getBtnSearch().setVisible(true);
			view.getPanelMain().getRadioBM().setVisible(true);
			view.getPanelMain().getRadioKMB().setVisible(true);
			view.getPanelMain().getLblEnterText().setVisible(true);
			view.getPanelMain().getLblSelect().setVisible(true);
		}
		/**
		 * Seleccion el algoritmo a usar.
		 */
		if(comand.equals("SEARCH")) {
			String search = view.getPanelMain().getText().getText();
			text = persistence.contentText(view.getRuta());
			if(!search.isEmpty()) {
				String estados [] = view.getPanelMain().estados(view.getRuta(), search);
				System.out.println("Estados = " + Arrays.toString(estados));
				if(estados != null) {
					paintText(text, estados[0], "nose");
				}
			}else {
				System.out.println("Debe ingresar un texto a buscar.");
			}
		}
		
	}
	
	
	public void paintText(String content, String algorithm, String search) {
		System.out.println("content = " + content + ", algoritm = " + algorithm + ", search = " + search);
		String chars [] = null;
		if(algorithm.equals("KMP")) 
			chars = model.kmpAlgorithm(content, search).split(",");
		else 
			chars = model.bmAlgorithm(content, search).split(",");
		System.out.println(Arrays.toString(chars));
		//view.getPanelMain().paintText(chars, search.length());
	}
}