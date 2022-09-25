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
		view.getPanelMain().getBtnImportFile().addActionListener(this);
		view.getPanelMain().getBtnSearch().addActionListener(this);
		view.getPanelMain().getRadioBM().addActionListener(this);
		view.getPanelMain().getRadioKMB().addActionListener(this);
		
	}

	public void actionPerformed(ActionEvent e) {
		String comand = e.getActionCommand();

		if(comand.equals("IMPORTFILE")) {
			String text = "";
			text = persistence.contentText(view.connectFileChooser().getAbsolutePath());
			view.getPanelMain().getShowText().setText(text);
			
			view.getPanelMain().getText().setVisible(true);
			view.getPanelMain().getBtnSearch().setVisible(true);
			view.getPanelMain().getRadioBM().setVisible(true);
			view.getPanelMain().getRadioKMB().setVisible(true);
			view.getPanelMain().getLblEnterText().setVisible(true);
			view.getPanelMain().getLblSelect().setVisible(true);


			
		}
		
		
	}
	
}
