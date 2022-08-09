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
		view.frame.setVisible(true);
		view.panelUpdateClient.setVisible(false);
		view.panelCreateClient.setVisible(false);
		view.panelUpdateVideo.setVisible(false);
		view.panelCreateVideo.setVisible(false);
		
		//Sql connection & creation of the db and itsstructure
		conn = new SQLConnection();
		conn.createDB("TA22");
		client.tableStructureCreation(conn);
		video.tableStructureCreation(conn);
	
		loadTable(video.selectAllVideos(conn), view.table);
	}
	
	private void loadTable(ResultSet resultSet, JTable table) {
	      DefaultTableModel model = (DefaultTableModel) table.getModel();
	      int id;
	      String name, surname, adress, date;
		try {
			while(resultSet.next()) {
				id = resultSet.getInt("id");
				name = resultSet.getString("nombre");
				surname = resultSet.getString("apellido");
				adress = resultSet.getString("direccion");
				date = resultSet.getString("fecha");
				
				model.addRow(new Object[] {id, name, surname, adress, date});
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
			id = (int)view.table.getValueAt(view.table.getSelectedRow(), 0);
			client.deleteClients(conn, id);
			break;
		case "btnUpdateData":
			id = (int)view.table.getValueAt(view.table.getSelectedRow(), 0);
			client.updateClients(conn, id, null, null, null, 0, null);
			break;
		case "btnCreateData":
			//client.insertClients();
			break;
		default:
			System.out.println("Button not found.");
			break;
		}
		
		if(view.btnCreate == event.getSource()) {
			view.panelTable.setVisible(false);
			view.panelCreateClient.setVisible(true);
		}else if(view.btnUpdate == event.getSource()) {
			
		}else if(view.btnDelete == event.getSource()) {
			
		}
		
	}

}
