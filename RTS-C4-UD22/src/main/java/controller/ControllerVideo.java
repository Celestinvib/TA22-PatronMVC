package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import model.SQLConnection;
import model.Video;
import view.Menu;
import view.View;

public class ControllerVideo {

	private Video video;
	private View view;
	private SQLConnection conn;
	private Menu menu;
	
	public ControllerVideo(Video video, View view, Menu menu, SQLConnection SqlCon) {
		this.video = video;
		this.view = view;
		this.menu = menu;
		this.conn = SqlCon;
	}
	
	public void launchView() {
		view.getFrame().setTitle("Videos");
		view.pack();
		view.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		view.setLocationRelativeTo(null);
		view.getPanelUpdateClient().setVisible(false);
		view.getPanelCreateClient().setVisible(false);
		view.getPanelUpdateVideo().setVisible(false);
		view.getPanelCreateVideo().setVisible(false);
		buttonListeners();
		
		view.getFrame().setVisible(true);

		loadTable(video.selectAllVideos(conn), view.getTableClients());
	}
	
	private void loadTable(ResultSet resultSet, JTable table) {
		table.setModel(new DefaultTableModel(new Object[] {"ID", "Title", "Director", "Cli_id"}, 0));
	      DefaultTableModel model = (DefaultTableModel) table.getModel();
	      model.setRowCount(0);
	      model = (DefaultTableModel) table.getModel();
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
				if(view.getTableClients().getSelectedRow() != -1) {
					view.getPanelTable().setVisible(false);
					view.getPanelUpdateVideo().setVisible(true);
					
					String title = (String) view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 1);
					String director = (String) view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 2);
					int cli_id = (int) view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 3);
					
					view.getTextFieldTitleU().setText(title);
					view.getTextFieldDirectorU().setText(director);
					view.getTextFieldClient_IdU().setText(cli_id+"");
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
				
				view.getTextFieldTitleC().setText("");
				view.getTextFieldDirectorC().setText("");
				view.getTextFieldClient_IdC().setText("");
			}
		});

		/**
		 * Deletes the selected video
		 */
		view.getBtnDelete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(view.getTableClients().getSelectedRow() != -1) {
					int id = (int)view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 0);
					if(JOptionPane.showConfirmDialog(null, "Seguro que quieres borrar el video con id " + view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 0), "SEGURO?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						video.deleteVideo(conn, id);
						loadTable(video.selectAllVideos(conn), view.getTableClients());
					}
				}
			}
		});
		
		/**
		 * Inserts a new video
		 */
		view.getBtnCreateVideo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String title = view.getTextFieldTitleC().getText();
				String director = view.getTextFieldDirectorC().getText();
				int cli_id = Integer.parseInt(view.getTextFieldClient_IdC().getText());
				
				if(!(title.isEmpty() && director.isEmpty() && view.getTextFieldClient_IdC().getText().isEmpty())) {
					video.insertVideo(conn, title, director, cli_id);
					JOptionPane.showMessageDialog(null, "Video creado.");
					view.getPanelCreateVideo().setVisible(false);
					loadTable(video.selectAllVideos(conn), view.getTableClients());
					view.getPanelTable().setVisible(true);
					
					
					
				}
				
			}
		});
		
		/**
		 * Updates an existing video
		 */
		view.getBtnUpdateVideo().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int id = (int)view.getTableClients().getValueAt(view.getTableClients().getSelectedRow(), 0);
				
				String title = view.getTextFieldTitleU().getText();
				String director = view.getTextFieldDirectorU().getText();
				int cli_id = Integer.parseInt(view.getTextFieldClient_IdU().getText());
				
				
				
				if(!(title.isEmpty() && director.isEmpty() && view.getTextFieldClient_IdU().getText().isEmpty())) {
					video.updateVideo(conn, id, title, director, cli_id);
					JOptionPane.showMessageDialog(null, "Video updated.");
					view.getPanelUpdateClient().setVisible(false);
					loadTable(video.selectAllVideos(conn), view.getTableClients());
					view.getPanelTable().setVisible(true);
					
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
		
		view.getBtnBackVideosC().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getBtnCreateVideo().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
		
		view.getbtnBackVideosU().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				view.getBtnUpdateVideo().setVisible(false);
				view.getPanelTable().setVisible(true);
			}
		});
	}
	
}

