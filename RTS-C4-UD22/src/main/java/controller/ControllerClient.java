package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Client;
import model.SQLConnection;
import view.View;

public class ControllerClient implements ActionListener{

	private Client client;
	private View view;
	private SQLConnection conn;
	
	
	public ControllerClient(Client client, View view , SQLConnection SqlCon) {
		this.client = client;
		this.view = view;
		this.conn = SqlCon;
	}
	
	public void launchView() {
		view.setTitle("Clientes");
		view.pack();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setLocationRelativeTo(null);
		view.panelUpdateClient.setVisible(false);
		view.panelCreateClient.setVisible(false);
		view.panelUpdateVideo.setVisible(false);
		view.panelCreateVideo.setVisible(false);
		
		
		view.frame.setVisible(true);
				
		loadTable(client.selectAllClients(conn), view.tableClients);
	}
	
	
	private void loadTable(ResultSet resultSet, JTable table) {
	      DefaultTableModel model = (DefaultTableModel) table.getModel();
	      int id;
	      String name, surname, address, date;
		try {
			while(resultSet.next()) {
				id = resultSet.getInt("id");
				name = resultSet.getString("name");
				surname = resultSet.getString("surname");
				address = resultSet.getString("address");
				date = resultSet.getString("date");
				
				model.addRow(new Object[] {id, name, surname, address, date});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton b = (JButton) event.getSource();
		int id;
		System.out.println("A");
		switch(b.getName()) {
		case "btnUpdate":
			view.panelTable.setVisible(false);
			view.panelUpdateClient.setVisible(true);
			System.out.println("Update");
			break;
		case "btnCreate":
			view.panelTable.setVisible(false);
			view.panelCreateClient.setVisible(true);
			System.out.println("Update");
			break;
		case "btnDelete":
			id = (int)view.tableClients.getValueAt(view.tableClients.getSelectedRow(), 0);
			client.deleteClient(conn, id);
			System.out.println("Delete");
			break;
		case "btnUpdateData":
			id = (int)view.tableClients.getValueAt(view.tableClients.getSelectedRow(), 0);
			client.updateClient(conn, id, null, null, null, 0, null);
			break;
		case "btnCreateData":
			//client.insertClients();
			break;
		default:
			System.out.println("Button not found.");
			break;
		}
		
		
	}

}
