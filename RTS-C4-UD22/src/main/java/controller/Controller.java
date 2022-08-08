package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
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
		JButton b = (JButton) event.getSource();
		
		switch(b.getName()) {
		case "btnUpdate":
			break;
		case "btnCreate":
			break;
		case "btnDelete":
			break;
		case "btnUpdateData":
			break;
		case "btnCreateData":
			break;
		default:
			System.out.println("Button not found.");
			break;
		}
		/*
		if(view.btnCreate == event.getSource()) {
			
		}else if(view.btnUpdate == event.getSource()) {
			
		}else if(view.btnDelete == event.getSource()) {
			
		}
		*/
	}

}
