package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Client;
import model.SQLConnection;
import view.Menu;
import view.View;

public class ControllerClient{

	private Client client;
	private View view;
	private SQLConnection conn;
	private Menu menu;
	
	
	public ControllerClient(Client client, View view ,Menu menu, SQLConnection SqlCon) {
		this.client = client;
		this.view = view;
		this.menu = menu;
		this.conn = SqlCon;
		
	}
	
	public void launchView() {
		view.setTitle("Clientes");
		view.pack();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setLocationRelativeTo(null);
		view.getPanelUpdateClient().setVisible(false);
		view.getPanelCreateClient().setVisible(false);
		view.getPanelUpdateVideo().setVisible(false);
		view.getPanelCreateVideo().setVisible(false);
		buttonListeners();
		 
		view.getFrame().setVisible(true);
				
		loadTable(client.selectAllClients(conn), view.getTableClients());
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
				view.getPanelTable().setVisible(false);
				view.getPanelUpdateClient().setVisible(true);
			}
		});

		/**
		 * Opens Create panel
		 */
		view.getBtnCreate().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getPanelTable().setVisible(false);
				view.getPanelCreateClient().setVisible(true);
			}
		});
		
		/**
		 * Deletes the selected client
		 */
		view.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = (int)view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 0);
				client.deleteClient(conn, id);
				loadTable(client.selectAllClients(conn), view.getTableClients());
			}
		});
		
		/**
		 * Inserts a new client
		 */
		view.getBtnCreateClient().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = view.getTextFieldNameC().getText();
				String surname = view.getTextFieldSurnameC().getText();
				String address = view.getTextFieldAddressC().getText();
				
				//Not done
				int dni = 0;
				String date = LocalDateTime.now().toString();
				
				client.insertClient(conn, name, surname, address, dni, date);
			}
		});
		
		/**
		 * Updates an existing client
		 */
		view.getBtnUpdateClient().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = (int)view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 0);
				
				String name = "";
				String surname = "";
				String address = "";
				
				//Not done
				int dni = 0;
				Timestamp date = null;
				
				client.updateClient(conn, id, name, surname, address, dni, date);
				
				view.getPanelCreateClient().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
		
		view.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getFrame().setVisible(false);
				menu.getFrame().setVisible(true);

			}
		});
		
		view.getBtnBackClientC().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getPanelCreateClient().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
		
		view.getBtnBackClientU().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getPanelUpdateClient().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
		
		view.getBtnBackVideosC().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getBtnBackVideosC().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
		
		view.getbtnBackVideosU().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getbtnBackVideosU().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
	}
	
}
