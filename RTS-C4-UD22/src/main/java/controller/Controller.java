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
import model.Video;
import view.View;

public class Controller implements ActionListener{

	private Client client;
	private Video video;
	private View view;
	private SQLConnection conn;
	
	public Controller(Client client,Video video, View view) {
		this.client = client;
		this.video = video;
		this.view = view;
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
		
		//Sql connection & creation of the db and itsstructure
		conn = new SQLConnection();
		
		view.frame.setVisible(true);
		
		resetStructure();
		
		loadTable(client.selectAllClients(conn), view.tableClients);
	}
	
	
	/**
	 * Method that creates the basic structure of this db
	 */		
	private void resetStructure() {
		conn.createDB("TA22");
		client.tableStructureCreation(conn);
		video.tableStructureCreation(conn);
		
//		client.insertClient(conn, "Nico", "Basora", "C/Josep Fregos N33", 377566722,"2018-10-20" );
//		client.insertClient(conn, "Celestin", "Tanga", "C/Josep Fregos N31", 366522123,null );

//      DELTE THIS COMMENT (THE LINE BELOW WORK) JUST NEED 2 CLIENTS
		
//		video.insertVideo(conn, "Homemade Spiderman 1", "Mike Scott", 1);
//		video.insertVideo(conn, "Homemade Spiderman 2", "Mike Scott", 1);
//		video.insertVideo(conn, "The last light", "Tarantino", 2);

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
		switch(b.getName()) {
		case "btnUpdate":
			view.panelTable.setVisible(false);
			view.panelUpdateClient.setVisible(true);
			break;
		case "btnCreate":
			view.panelTable.setVisible(false);
			view.panelCreateClient.setVisible(true);
			break;
		case "btnDelete":
			id = (int)view.table.getValueAt(view.tableClients.getSelectedRow(), 0);
			client.deleteClient(conn, id);
			break;
		case "btnUpdateData":
			id = (int)view.table.getValueAt(view.tableClients.getSelectedRow(), 0);
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
