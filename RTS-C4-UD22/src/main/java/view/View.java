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
	public JPanel panelButtons;
	
	public JButton btnUpdate;
	public JButton btnDelete;
	public JButton btnCreate;
	public JTable tableClients;
	public JPanel panelUpdateClient;
	public JPanel panel;
	public JTable tableUpdate;
	public JButton btnUpdateData;
	private JPanel panelMenu;
	private JButton btnClients;
	private JButton btnMovies;
	private JLabel lblNewLabel;
	public JPanel panelUpdateVideo;
	private JTextField textField;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel1;
	private JTextField textField_1;
	private JLabel lblNewLabel2;
	private JTextField textField_2;
	private JButton btnUpdateVideo;
	public JPanel panelCreateVideo;
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
	private JTextField textField_10;
	private JTextField textField12;
	private JLabel lblNewLabel13;
	private JTextField textField_11;
	private JLabel lblNewLabel12;
	private JLabel lblNewLabel11;
	private JButton btnUpdateClient;
	private JTextField textField1;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel22;
	private JTextField textField_21;
	public JTable tableVideo;
	
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

		tableClients = new JTable();
		tableClients = new JTable(new DefaultTableModel(new Object[] {"ID", "Nombre", "Apellido", "Direcci�n", "Fecha"}, 0));
		tableClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableVideo = new JTable();
		tableVideo = new JTable(new DefaultTableModel(new Object[] {"ID", "Title", "Director", "Cli_id"}, 0));
		tableVideo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		panelTable.add(new JScrollPane(tableVideo), BorderLayout.NORTH);
		panelTable.add(new JScrollPane(tableClients), BorderLayout.NORTH);
		
		/**
		 * Update panel
		 */
		
		panelCreateClient = new JPanel();
		panelCreateClient.setLayout(null);
		panelCreateClient.setBounds(0, 0, 415, 240);
		frame.getContentPane().add(panelCreateClient);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(162, 41, 127, 20);
		panelCreateClient.add(textField_10);
		
		lblNewLabel11 = new JLabel("Title:");
		lblNewLabel11.setBounds(125, 44, 38, 14);
		panelCreateClient.add(lblNewLabel11);
		
		lblNewLabel12 = new JLabel("Director:");
		lblNewLabel12.setBounds(111, 72, 67, 14);
		panelCreateClient.add(lblNewLabel12);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(162, 72, 127, 20);
		panelCreateClient.add(textField_11);
		
		lblNewLabel13 = new JLabel("Client_Id:");
		lblNewLabel13.setBounds(106, 103, 67, 14);
		panelCreateClient.add(lblNewLabel13);
		
		textField12 = new JTextField();
		textField12.setColumns(10);
		textField12.setBounds(162, 103, 127, 20);
		panelCreateClient.add(textField12);
		
		btnCreateData = new JButton("Crear");
		btnCreateData.setBounds(10, 210, 90, 20);
		panelCreateClient.add(btnCreateData);
		panelUpdateClient = new JPanel();
		panelUpdateClient.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelUpdateClient);
		panelUpdateClient.setLayout(null);
		
		textField1 = new JTextField();
		textField1.setColumns(10);
		textField1.setBounds(162, 41, 127, 20);
		panelUpdateClient.add(textField1);
		
		lblNewLabel_13 = new JLabel("Title:");
		lblNewLabel_13.setBounds(125, 44, 38, 14);
		panelUpdateClient.add(lblNewLabel_13);
		
		lblNewLabel12 = new JLabel("Director:");
		lblNewLabel12.setBounds(111, 72, 67, 14);
		panelUpdateClient.add(lblNewLabel12);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(162, 72, 127, 20);
		panelUpdateClient.add(textField_11);
		
		lblNewLabel22 = new JLabel("Client_Id:");
		lblNewLabel22.setBounds(106, 103, 67, 14);
		panelUpdateClient.add(lblNewLabel22);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(162, 103, 127, 20);
		panelUpdateClient.add(textField_21);
		
		btnUpdateClient = new JButton("Update  Video");
		btnUpdateClient.setBounds(146, 154, 127, 23);
		panelUpdateClient.add(btnUpdateClient);
		
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
