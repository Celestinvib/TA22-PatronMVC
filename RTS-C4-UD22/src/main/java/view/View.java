package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class View extends JFrame{

	public JFrame frame;
	public JTable table;
	public JPanel panelButtons;
	
	public JButton btnUpdate;
	public JButton btnDelete;
	public JButton btnCreate;

	public JPanel panelUpdateClient;
	public JPanel panel;
	public JTable tableUpdate;
	public JButton btnUpdateData;
	private JPanel panelMenu;
	private JButton btnClients;
	private JButton btnMovies;
	private JLabel lblNewLabel;
	private JPanel panelUpdateVideo;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel1;
	private JTextField textField_1;
	private JLabel lblNewLabel2;
	private JTextField textField_2;
	private JButton btnUpdateVideo;
	private JPanel panelCreateVideo;
	private JTextField textField_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel1_1;
	private JTextField textField_4;
	private JLabel lblNewLabel2_1;
	private JTextField textField_5;
	private JButton btnCreateVideo;
	public JPanel panelCreateClient;
	private JButton btnCreateData;
	public JPanel panelTable;
	
	/**
	 * Create the application.
	 */
	public View() {
		/**
		 * Window frame
		 */
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		
		/**
		 * Main panel with the table and CRUD options
		 */
		panelTable = new JPanel();
		panelTable.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		panelButtons = new JPanel();
		panelTable.add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new GridLayout(1, 0, 10, 0));
		
		btnUpdate = new JButton("Actualizar");
		panelButtons.add(btnUpdate);

		btnDelete = new JButton("Borrar");
		panelButtons.add(btnDelete);

		btnCreate = new JButton("Crear");
		panelButtons.add(btnCreate);

		table = new JTable();
		table = new JTable(new DefaultTableModel(new Object[] {"ID", "Nombre", "Apellido", "Dirección", "Fecha"}, 0));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		

		panelTable.add(new JScrollPane(table), BorderLayout.NORTH);
		
		
		/**
		 * Update panel
		 */
		
		panelCreateClient = new JPanel();
		panelCreateClient.setVisible(false);
		panelCreateClient.setLayout(null);
		panelCreateClient.setBounds(0, 0, 415, 240);
		frame.getContentPane().add(panelCreateClient);
		
		btnCreateData = new JButton("Crear");
		btnCreateData.setBounds(10, 210, 90, 20);
		panelCreateClient.add(btnCreateData);
		panelUpdateClient = new JPanel();
		panelUpdateClient.setVisible(false);
		panelUpdateClient.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelUpdateClient);
		panelUpdateClient.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(10, 0, 395, 56);
		panelUpdateClient.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		tableUpdate = new JTable();
		panel.add(tableUpdate);
		
		btnUpdateData = new JButton("Actualizar");
		btnUpdateData.setBounds(10, 210, 90, 20);
		panelUpdateClient.add(btnUpdateData);
		
		/**
		 * Create panel
		 */
		
		panelCreateVideo = new JPanel();
		panelCreateVideo.setVisible(false);
		panelCreateVideo.setLayout(null);
		panelCreateVideo.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelCreateVideo);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(162, 41, 127, 20);
		panelCreateVideo.add(textField_3);
		
		lblNewLabel_2 = new JLabel("Title:");
		lblNewLabel_2.setBounds(125, 44, 38, 14);
		panelCreateVideo.add(lblNewLabel_2);
		
		lblNewLabel1_1 = new JLabel("Director:");
		lblNewLabel1_1.setBounds(111, 72, 67, 14);
		panelCreateVideo.add(lblNewLabel1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(162, 72, 127, 20);
		panelCreateVideo.add(textField_4);
		
		lblNewLabel2_1 = new JLabel("Client_Id:");
		lblNewLabel2_1.setBounds(106, 103, 67, 14);
		panelCreateVideo.add(lblNewLabel2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(162, 103, 127, 20);
		panelCreateVideo.add(textField_5);
		
		btnCreateVideo = new JButton("Create  Video");
		btnCreateVideo.setBounds(146, 154, 127, 23);
		panelCreateVideo.add(btnCreateVideo);
		
		panelUpdateVideo = new JPanel();
		panelUpdateVideo.setVisible(false);
		panelUpdateVideo.setLayout(null);
		panelUpdateVideo.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelUpdateVideo);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(162, 41, 127, 20);
		panelUpdateVideo.add(textField);
		
		lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setBounds(125, 44, 38, 14);
		panelUpdateVideo.add(lblNewLabel_1);
		
		lblNewLabel1 = new JLabel("Director:");
		lblNewLabel1.setBounds(111, 72, 67, 14);
		panelUpdateVideo.add(lblNewLabel1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(162, 72, 127, 20);
		panelUpdateVideo.add(textField_1);
		
		lblNewLabel2 = new JLabel("Client_Id:");
		lblNewLabel2.setBounds(106, 103, 67, 14);
		panelUpdateVideo.add(lblNewLabel2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(162, 103, 127, 20);
		panelUpdateVideo.add(textField_2);
		
		btnUpdateVideo = new JButton("Update  Video");
		btnUpdateVideo.setBounds(146, 154, 127, 23);
		panelUpdateVideo.add(btnUpdateVideo);
		
		panelMenu = new JPanel();
		panelMenu.setVisible(false);
		panelMenu.setLayout(null);
		panelMenu.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelMenu);
		
		btnClients = new JButton("Clients");
		btnClients.setBounds(97, 129, 89, 23);
		panelMenu.add(btnClients);
		
		btnMovies = new JButton("Movies");
		btnMovies.setBounds(228, 129, 89, 23);
		panelMenu.add(btnMovies);
		
		lblNewLabel = new JLabel("Select one database ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(144, 64, 143, 14);
		panelMenu.add(lblNewLabel);
		
	}
}
