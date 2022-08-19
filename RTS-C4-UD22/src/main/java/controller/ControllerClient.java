package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	
	/**
	 * Hides any other panel or view and makes and displays the main table
	 */
	public void launchView() {
		view.getFrame().setTitle("Clients");
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
	
	/**
	 * Sets table model and inserts the data in the table
	 * @param resultSet
	 * @param table
	 */
	private void loadTable(ResultSet resultSet, JTable table) {
		table.setModel(new DefaultTableModel(new Object[] {"ID", "Name", "Surname", "Address", "DNI", "Date"}, 0));
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		model = (DefaultTableModel) table.getModel();
		int id;
		String name, surname, address, dni, date; // DNI es int
		try {
			while(resultSet.next()) {
				id = resultSet.getInt("id");
				name = resultSet.getString("name");
				surname = resultSet.getString("surname");
				address = resultSet.getString("address");
				dni = resultSet.getString("dni");
				date = resultSet.getString("date");

				model.addRow(new Object[] {id, name, surname, address, dni, date});
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
				if(view.getTableClients().getSelectedRow() != -1) {
					view.getPanelTable().setVisible(false);
					view.getPanelUpdateClient().setVisible(true);
					
					String name = (String) view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 1);
					String surname = (String) view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 2);
					String address = (String) view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 3);
					String dni = (String) view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 4);
					
					view.getTextFieldNameU().setText(name);
					view.getTextFieldSurnameU().setText(surname);
					view.getTextFieldAddressU().setText(address);
					view.getTextFieldDNIU().setText(dni);
				}
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
				if(view.getTableClients().getSelectedRow() != -1) {
					int id = (int)view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 0);
					if(JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar al cliente con id " + view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 0), "SEGURO?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						client.deleteClient(conn, id);
						loadTable(client.selectAllClients(conn), view.getTableClients());
					}
				}
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
				int dni = Integer.parseInt(view.getTextFieldDNIC().getText());
				String date = LocalDateTime.now().toString();
				
				if(!(name.isEmpty() && surname.isEmpty() && address.isEmpty())) {
					client.insertClient(conn, name, surname, address, dni, date);
					JOptionPane.showMessageDialog(null, "Cliente creado.");
					loadTable(client.selectAllClients(conn), view.getTableClients());
					view.getPanelCreateClient().setVisible(false);
					view.getPanelTable().setVisible(true);
					
				}
				
			}
		});
		
		/**
		 * Updates an existing client
		 */
		view.getBtnUpdateClient().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = (int)view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 0);
				
				String name = view.getTextFieldNameU().getText();
				String surname = view.getTextFieldSurnameU().getText();
				String address = view.getTextFieldAddressU().getText();
				int dni = Integer.parseInt(view.getTextFieldDNIU().getText());
				String date = LocalDateTime.now().toString();;
				
				if(!(name.isEmpty() && surname.isEmpty() && address.isEmpty())) {
					client.updateClient(conn, id, name, surname, address, dni, date);
					JOptionPane.showMessageDialog(null, "Cliente actualizado.");
					loadTable(client.selectAllClients(conn), view.getTableClients());
					view.getPanelCreateClient().setVisible(false);
					view.getPanelTable().setVisible(true);
					
				}
				
			}
		});
		
		/**
		 * "Closes" the clients table data menu panel and opens the main menu
		 */
		view.getBtnBack().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getFrame().setVisible(false);
				menu.getFrame().setVisible(true);

			}
		});
		
		/**
		 * "Closes" the panel of create client and opens the video table data menu panel
		 */
		view.getBtnBackClientC().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getPanelCreateClient().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
		
		/**
		 * "Closes" the panel of update client and opens the video table data menu panel
		 */
		view.getBtnBackClientU().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getPanelUpdateClient().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
	}
	
}
