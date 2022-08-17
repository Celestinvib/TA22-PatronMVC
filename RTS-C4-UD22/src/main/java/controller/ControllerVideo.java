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
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JButton b = (JButton) event.getSource();
		int id;
		switch(b.getName()) {
		case "btnUpdate":
			view.getPanelTable().setVisible(false);
			view.getPanelUpdateClient().setVisible(true);
			System.out.println("Update");
			break;
		case "btnCreate":
			view.getPanelTable().setVisible(false);
			view.getPanelCreateClient().setVisible(true);
			System.out.println("Create");
			break;
		case "btnDelete":
			id = (int)view.getTableVideo().getValueAt(view.getTableVideo().getSelectedRow(), 0);
			System.out.println("Delete");
			video.deleteVideo(conn, id);
			break;
		case "btnUpdateData":
			id = (int)view.getTableVideo().getValueAt(view.getTableVideo().getSelectedRow(), 0);
			video.updateVideo(conn, id, null, null, 0);
			break;
		case "btnCreateData":
			id = (int)view.getTableVideo().getValueAt(view.getTableVideo().getSelectedRow(), 0);
			video.updateVideo(conn, id, null, null, 0);
			break;
		default:
			System.out.println("Button not found.");
			break;
		}
		
		
	}

}

