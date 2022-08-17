package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.SQLConnection;
import model.Video;
import view.View;

public class ControllerVideo implements ActionListener{

	private Video video;
	private View view;
	private SQLConnection conn;
	
	public ControllerVideo(Video video, View view) {
		this.video = video;
		this.view = view;
	}
	
	public void launchView() {
		view.setTitle("Video");
		view.pack();
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setLocationRelativeTo(null);
		view.getPanelUpdateClient().setVisible(false);
		view.getPanelCreateClient().setVisible(false);
		view.getPanelUpdateVideo().setVisible(false);
		view.getPanelCreateVideo().setVisible(false);
		
		//Sql connection & creation of the db and its structure
		conn = new SQLConnection();
		conn.createDB("TA22");
		video.tableStructureCreation(conn);
		video.tableStructureCreation(conn);
	
		view.getFrame().setVisible(true);
		video.insertVideo(conn, "Russia rocks", "Putin", 0);

		view.getTableClients().setVisible(false);
		view.getTableVideo().setVisible(false);
		loadTable(video.selectAllVideos(conn), view.getTableVideo());
	}
	
	private void loadTable(ResultSet resultSet, JTable table) {
	      DefaultTableModel model = (DefaultTableModel) table.getModel();
	      int id, cli_id;
	      String title, director;
		try {
			while(resultSet.next()) {
				id = resultSet.getInt("id");
				title = resultSet.getString("title");
				director = resultSet.getString("director");
				cli_id = resultSet.getInt("cli_id");
				
				model.addRow(new Object[] {id, title, director, cli_id});
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
				if(view.getTableVideo().getSelectedRow() != -1) {
					view.getPanelTable().setVisible(false);
					view.getPanelUpdateVideo().setVisible(true);
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
				view.getPanelCreateVideo().setVisible(true);
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
						video.deleteVideo(conn, id);
						loadTable(video.selectAllVideos(conn), view.getTableVideo());
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
				int dni = 0;
				String date = LocalDateTime.now().toString();
				
				if(!(name.isEmpty() && surname.isEmpty() && address.isEmpty())) {
					video.insertVideo(conn, name, surname, address, dni, date);
					view.getPanelCreateClient().setVisible(false);
					view.getPanelTable().setVisible(true);
					JOptionPane.showMessageDialog(null, "Cliente creado.");
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
				
				String name = "";
				String surname = "";
				String address = "";
				int dni = 0;
				Timestamp date = null;
				
				if(!(name.isEmpty() && surname.isEmpty() && address.isEmpty())) {
					client.updateClient(conn, id, name, surname, address, dni, date);
					view.getPanelCreateClient().setVisible(false);
					view.getPanelTable().setVisible(true);
					JOptionPane.showMessageDialog(null, "Cliente actualizado.");
				}
				
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

}

