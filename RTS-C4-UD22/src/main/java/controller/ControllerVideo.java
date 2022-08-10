package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
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
		view.panelUpdateClient.setVisible(false);
		view.panelCreateClient.setVisible(false);
		view.panelUpdateVideo.setVisible(false);
		view.panelCreateVideo.setVisible(false);
		
		//Sql connection & creation of the db and itsstructure
		conn = new SQLConnection();
		conn.createDB("TA22");
		video.tableStructureCreation(conn);
		video.tableStructureCreation(conn);
	
		view.frame.setVisible(true);
		video.insertVideo(conn, "Russia rocks", "Putin", 0);

		view.tableClients.setVisible(false);
		view.tableVideo.setVisible(false);
		loadTable(video.selectAllVideos(conn), view.tableVideo);
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
			id = (int)view.tableVideo.getValueAt(view.tableVideo.getSelectedRow(), 0);
			video.deleteVideo(conn, id);
			break;
		case "btnUpdateData":
			id = (int)view.tableVideo.getValueAt(view.tableVideo.getSelectedRow(), 0);
			video.updateVideo(conn, id, null, null, 0);
			break;
		case "btnCreateData":
			id = (int)view.tableVideo.getValueAt(view.tableVideo.getSelectedRow(), 0);
			video.updateVideo(conn, id, null, null, 0);
			break;
		default:
			System.out.println("Button not found.");
			break;
		}
		
		
	}

}

