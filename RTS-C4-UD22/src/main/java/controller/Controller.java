package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Client;
import model.SQLConnection;
import view.View;

public class Controller implements ActionListener{

	private Client client;
	private View view;
	private SQLConnection conn;
	
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
		view.panelUpdate.setVisible(false);
		view.panelCreate.setVisible(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton b = (JButton) event.getSource();
		int id;
		switch(b.getName()) {
		case "btnUpdate":
			view.panelTable.setVisible(false);
			view.panelUpdate.setVisible(true);
			break;
		case "btnCreate":
			view.panelTable.setVisible(false);
			view.panelCreate.setVisible(true);
			break;
		case "btnDelete":
			id = (int)view.table.getValueAt(view.table.getSelectedRow(), 0);
			client.deleteClients(conn, id);
			break;
		case "btnUpdateData":
			id = (int)view.table.getValueAt(view.table.getSelectedRow(), 0);
			client.updateClients(conn, id, null, null, null, null);
			break;
		case "btnCreateData":
			//client.insertClients();
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
