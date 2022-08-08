package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Client;
import view.View;

public class Controller implements ActionListener{

	private Client client;
	private View view;
	
	public Controller(Client client, View view) {
		this.client = client;
		this.view = view;
	}
	
	public void launchView() {
		view.setTitle("Clientes");
		view.pack();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setLocationRelativeTo(null);
		view.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		if(view.btnCreate == event.getSource()) {
			
		}else if(view.btnUpdate == event.getSource()) {
			
		}else if(view.btnDelete == event.getSource()) {
			
		}
		
	}

}
