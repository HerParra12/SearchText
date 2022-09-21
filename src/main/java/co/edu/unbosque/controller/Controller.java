package co.edu.unbosque.controller;

import co.edu.unbosque.model.Modelo;
import co.edu.unbosque.view.Ventana;

public class Controller {

	private Modelo model;
	private Ventana view;
	
	public Controller() {
		model = new Modelo();
		view = new Ventana();
		funcionar();
	}
	
	private void funcionar() {
		try {
			int menu = 0;
			do {
				menu = view.leerDato("TITULO" + 
			           "\n Selecciona la opcion a realizar." +
					   "\n 1. " +
			           "\n 0. Salir");
				
				switch(menu) {
					case 1:
						
						break;
							
					case 0:
						break;
						default:
							
							break;
				}
			}while(menu != 0);
		} catch(NumberFormatException formt) {
			view.warningMessage("Debes tener mas cuidado.");
			funcionar();
		}
	}
}
