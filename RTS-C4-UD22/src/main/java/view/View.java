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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame{

	/**
	 * Attributes 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private JPanel panelButtons;
	
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnCreate;
	private JButton btnNewButton;
	
	private JTable tableClients;
	
	private JPanel panel;
	private JTable tableUpdate;
	

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
	
	private JPanel panelUpdateClient;
	
	private JLabel lblClientSurnameU;
	private JLabel lblClientNameU;
	private JTextField textFieldNameU;
	private JTextField textFieldAddressU;
	private JLabel lblClientAddressU;
	private JTextField textFieldSurnameU;
	private JButton btnUpdateClientU;
	
	
	
	private JPanel panelCreateClient;
	
	private JButton btnCreateClientC;
	private JTextField textFieldSurnameC;
	private JLabel lblSurnameC;
	private JTextField textFieldNameC;
	private JLabel lblFieldNameC;
	private JLabel lblAddressC;
	private JTextField textFieldAddressC;
	
	public JPanel getPanelUpdateVideo() {
		return panelUpdateVideo;
	}

	public JPanel getPanelCreateVideo() {
		return panelCreateVideo;
	}

	public JPanel getPanelUpdateClient() {
		return panelUpdateClient;
	}

	public JPanel getPanelCreateClient() {
		return panelCreateClient;
	}

	public JTextField getTextFieldSurnameC() {
		return textFieldSurnameC;
	}

	public JTextField getTextFieldNameC() {
		return textFieldNameC;
	}

	public JTextField getTextFieldAddressC() {
		return textFieldAddressC;
	}

	public JPanel panelTable;
	private JTable tableVideo;
	
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
		
		btnNewButton = new JButton("Atrás");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelButtons.add(btnNewButton);
		
		btnUpdate = new JButton("Actualizar");
		panelButtons.add(btnUpdate);

		btnDelete = new JButton("Borrar");
		panelButtons.add(btnDelete);

		btnCreate = new JButton("Crear");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panelButtons.add(btnCreate);

		tableClients = new JTable();
		tableClients = new JTable(new DefaultTableModel(new Object[] {"ID", "Nombre", "Apellido", "Direcci�n", "Fecha"}, 0));
		tableClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableVideo = new JTable();
		tableVideo = new JTable(new DefaultTableModel(new Object[] {"ID", "Title", "Director", "Cli_id"}, 0));
		tableVideo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		panelTable.add(new JScrollPane(tableVideo), BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(tableClients);
		panelTable.add(scrollPane, BorderLayout.NORTH);
		
		/**
		 * Update panel
		 */
		
		panelUpdateClient = new JPanel();
		panelUpdateClient.setLayout(null);
		panelUpdateClient.setBounds(0, 0, 415, 240);
		frame.getContentPane().add(panelUpdateClient);
		
		btnUpdateClientU = new JButton("Update Client");
		btnUpdateClientU.setBounds(146, 154, 127, 23);
		panelUpdateClient.add(btnUpdateClientU);
		
		textFieldNameU = new JTextField();
		textFieldNameU.setColumns(10);
		textFieldNameU.setBounds(162, 41, 127, 20);
		panelUpdateClient.add(textFieldNameU);
		
		lblClientNameU = new JLabel("Name:");
		lblClientNameU.setBounds(125, 44, 38, 14);
		panelUpdateClient.add(lblClientNameU);
		
		lblClientSurnameU = new JLabel("Surname:");
		lblClientSurnameU.setBounds(111, 72, 67, 14);
		panelUpdateClient.add(lblClientSurnameU);
		
		textFieldSurnameU = new JTextField();
		textFieldSurnameU.setColumns(10);
		textFieldSurnameU.setBounds(162, 72, 127, 20);
		panelUpdateClient.add(textFieldSurnameU);
		
		lblClientAddressU = new JLabel("Address:");
		lblClientAddressU.setBounds(106, 103, 67, 14);
		panelUpdateClient.add(lblClientAddressU);
		
		textFieldAddressU = new JTextField();
		textFieldAddressU.setColumns(10);
		textFieldAddressU.setBounds(162, 103, 127, 20);
		panelUpdateClient.add(textFieldAddressU);
		
		/**
		 * Create panel
		 */
		
		panelCreateClient = new JPanel();
		panelCreateClient.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelCreateClient);
		panelCreateClient.setLayout(null);
		
		btnCreateClientC = new JButton("Crear");
		btnCreateClientC.setBounds(10, 210, 90, 20);
		panelCreateClient.add(btnCreateClientC);
		
		textFieldNameC = new JTextField();
		textFieldNameC.setColumns(10);
		textFieldNameC.setBounds(162, 41, 127, 20);
		panelCreateClient.add(textFieldNameC);
		
		lblFieldNameC = new JLabel("Name:");
		lblFieldNameC.setBounds(125, 44, 38, 14);
		panelCreateClient.add(lblFieldNameC);
		
		lblSurnameC = new JLabel("Surname:");
		lblSurnameC.setBounds(111, 72, 67, 14);
		panelCreateClient.add(lblSurnameC);
		
		textFieldSurnameC = new JTextField();
		textFieldSurnameC.setColumns(10);
		textFieldSurnameC.setBounds(162, 72, 127, 20);
		panelCreateClient.add(textFieldSurnameC);
		
		lblAddressC = new JLabel("Address:");
		lblAddressC.setBounds(106, 103, 67, 14);
		panelCreateClient.add(lblAddressC);
		
		textFieldAddressC = new JTextField();
		textFieldAddressC.setColumns(10);
		textFieldAddressC.setBounds(162, 103, 127, 20);
		panelCreateClient.add(textFieldAddressC);
		
		panel = new JPanel();
		panel.setBounds(10, 0, 395, 56);
		panelCreateClient.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		tableUpdate = new JTable();
		panel.add(tableUpdate);
		
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
		
	}

	public JTable getTableClients() {
		return tableClients;
	}

	/** Getters & Setters */
	
	
	public JFrame getFrame() {
		return frame;
	}

	public JButton getBtnClients() {
		return btnClients;
	}

	public JButton getBtnMovies() {
		return btnMovies;
	}

	public JButton getBtnUpdateClientU() {
		return btnUpdateClientU;
	}

	public JButton getBtnCreateClientC() {
		return btnCreateClientC;
	}

	/**
	 * @return the btnUpdate
	 */
	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	/**
	 * @param btnUpdate the btnUpdate to set
	 */
	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * @param btnDelete the btnDelete to set
	 */
	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	/**
	 * @return the btnCreate
	 */
	public JButton getBtnCreate() {
		return btnCreate;
	}

	/**
	 * @param btnCreate the btnCreate to set
	 */
	public void setBtnCreate(JButton btnCreate) {
		this.btnCreate = btnCreate;
	}

	/**
	 * @return the btnUpdateVideo
	 */
	public JButton getBtnUpdateVideo() {
		return btnUpdateVideo;
	}

	/**
	 * @param btnUpdateVideo the btnUpdateVideo to set
	 */
	public void setBtnUpdateVideo(JButton btnUpdateVideo) {
		this.btnUpdateVideo = btnUpdateVideo;
	}

	/**
	 * @return the btnCreateVideo
	 */
	public JButton getBtnCreateVideo() {
		return btnCreateVideo;
	}

	/**
	 * @param btnCreateVideo the btnCreateVideo to set
	 */
	public void setBtnCreateVideo(JButton btnCreateVideo) {
		this.btnCreateVideo = btnCreateVideo;
	}

	/**
	 * @return the btnCreateClient
	 */
	public JButton getBtnCreateClient() {
		return btnCreateClientC;
	}

	/**
	 * @param btnCreateClient the btnCreateClient to set
	 */
	public void setBtnCreateClient(JButton btnCreateClient) {
		this.btnCreateClientC = btnCreateClient;
	}

	/**
	 * @return the btnUpdateClient
	 */
	public JButton getBtnUpdateClient() {
		return btnUpdateClientU;
	}

	/**
	 * @param btnUpdateClient the btnUpdateClient to set
	 */
	public void setBtnUpdateClient(JButton btnUpdateClient) {
		this.btnUpdateClientU = btnUpdateClient;
	}
}
