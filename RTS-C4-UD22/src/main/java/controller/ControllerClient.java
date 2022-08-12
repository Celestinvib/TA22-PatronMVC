package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Client;
import model.SQLConnection;
import view.View;

public class ControllerClient{

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
		buttonListeners();
		
		view.frame.setVisible(true);
				
		loadTable(client.selectAllClients(conn), view.tableClients);
	}
	

	private void loadTable(ResultSet resultSet, JTable table) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model = (DefaultTableModel) table.getModel();
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



	public void buttonListeners() {
		
		/**
		 * Opens Update panel
		 */
		view.getBtnUpdate().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.panelTable.setVisible(false);
				view.panelUpdateClient.setVisible(true);
			}
		});

		/**
		 * Opens Create panel
		 */
		view.getBtnCreate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.panelTable.setVisible(false);
				view.panelCreateClient.setVisible(true);
			}
		});
		
		/**
		 * Deletes the selected client
		 */
		view.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = (int)view.tableClients.getValueAt(view.tableClients.getSelectedRow(), 0);
				client.deleteClient(conn, id);
				loadTable(client.selectAllClients(conn), view.tableClients);
			}
		});
		
		/**
		 * Inserts a new client
		 */
		view.getBtnCreateClient().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = view.textFieldName.getText();
				String surname = view.textFieldSurname.getText();
				String address = view.textFieldAddress.getText();
				
				//Not done
				int dni = 0;
				String date = "";
				
				client.insertClient(conn, name, surname, address, dni, date);
			}
		});
		
		/**
		 * Updates an existing client
		 */
		view.getBtnUpdateClient().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = (int)view.tableClients.getValueAt(view.tableClients.getSelectedRow(), 0);
				
				String name = "";
				String surname = "";
				String address = "";
				
				//Not done
				int dni = 0;
				Timestamp date = null;
				
				client.updateClient(conn, id, name, surname, address, dni, date);
			}
		});
	}
}
