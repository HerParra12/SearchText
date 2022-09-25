package co.edu.unbosque.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		view.getBtnImportFile().addActionListener(this);
		view.getBtnSearch().addActionListener(this);
		view.getRadioBM().addActionListener(this);
		view.getRadioKMB().addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();

		if(comand.equals("IMPORTFILE")) {
			String text = "";
			text = persistence.contentText(view.connectFileChooser().getAbsolutePath());
			view.getShowText().setText(text);
			
			view.getText().setVisible(true);
			view.getBtnSearch().setVisible(true);
			view.getRadioBM().setVisible(true);
			view.getRadioKMB().setVisible(true);
			view.getLblEnterText().setVisible(true);
			view.getLblSelect().setVisible(true);


			
		}
		
		
	}
	
}
