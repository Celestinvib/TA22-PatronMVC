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
	private JButton btnBack;
	
	private JTable tableClients;

	private JTable tableUpdate;
	

	private JButton btnClients;
	private JButton btnMovies;
	
	
	private JPanel panelUpdateVideo;
	
	private JTextField textFieldTitleU;
	private JLabel lblTitleU;
	private JLabel lblDirectorU;
	private JTextField textFieldDirectorU;
	private JLabel lblClient_IdU;
	private JTextField textFieldClient_IdU;
	private JButton btnUpdateVideo;
	private JButton btnBackVideosC;
	
	private JPanel panelCreateVideo;
	
	private JTextField textFieldTitleC;
	private JLabel lblTitleC;
	private JLabel lblDirectorC;
	private JTextField textFieldDirectorC;
	private JLabel lblClient_IdC;
	private JTextField textFieldClient_IdC;
	private JButton btnCreateVideo;
	private JButton btnBackVideosU;
	
	private JPanel panelUpdateClient;
	
	private JLabel lblClientSurnameU;
	private JLabel lblClientNameU;
	private JTextField textFieldNameU;
	private JTextField textFieldAddressU;
	private JLabel lblClientAddressU;
	private JTextField textFieldSurnameU;
	private JButton btnUpdateClientU;
	private JButton btnBackClientU;
	private JLabel lblClientDNIU;
	private JTextField textFieldDNIU;
	
	
	private JPanel panelCreateClient;
	
	private JButton btnCreateClientC;
	private JTextField textFieldSurnameC;
	private JLabel lblSurnameC;
	private JTextField textFieldNameC;
	private JLabel lblFieldNameC;
	private JLabel lblAddressC;
	private JTextField textFieldAddressC;
	private JButton btnBackClientC;
	private JLabel lblClientDNIC;
	private JTextField textFieldDNIC;
	
	private JPanel panelTable;
	
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
		
		btnBack = new JButton("Back");
		panelButtons.add(btnBack);
		
		btnUpdate = new JButton("Update");
		panelButtons.add(btnUpdate);

		btnDelete = new JButton("Delete");
		panelButtons.add(btnDelete);

		btnCreate = new JButton("Create");
		panelButtons.add(btnCreate);

		tableClients = new JTable();
		//tableClients = new JTable(new DefaultTableModel(new Object[] {"ID", "Name", "Surname", "Address", "DNI", "Date"}, 0));
		tableClients.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableVideo = new JTable();
		tableVideo = new JTable(new DefaultTableModel(new Object[] {"ID", "Title", "Director", "Cli_id"}, 0));
		tableVideo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		panelTable.add(new JScrollPane(tableVideo), BorderLayout.NORTH);
		JScrollPane scrollPane = new JScrollPane(tableClients);
		panelTable.add(scrollPane, BorderLayout.NORTH);
		
		/**
		 * Update panel Client
		 */
		
		panelUpdateClient = new JPanel();
		panelUpdateClient.setLayout(null);
		panelUpdateClient.setBounds(0, 0, 415, 240);
		frame.getContentPane().add(panelUpdateClient);
		
		btnUpdateClientU = new JButton("Update");
		btnUpdateClientU.setBounds(10, 210, 90, 20);
		panelUpdateClient.add(btnUpdateClientU);
		
		textFieldNameU = new JTextField();
		textFieldNameU.setColumns(10);
		textFieldNameU.setBounds(165, 44, 127, 20);
		panelUpdateClient.add(textFieldNameU);
		
		lblClientNameU = new JLabel("Name:");
		lblClientNameU.setBounds(106, 44, 38, 14);
		panelUpdateClient.add(lblClientNameU);
		
		lblClientSurnameU = new JLabel("Surname:");
		lblClientSurnameU.setBounds(106, 72, 67, 14);
		panelUpdateClient.add(lblClientSurnameU);
		
		textFieldSurnameU = new JTextField();
		textFieldSurnameU.setColumns(10);
		textFieldSurnameU.setBounds(165, 72, 127, 20);
		panelUpdateClient.add(textFieldSurnameU);
		
		lblClientAddressU = new JLabel("Address:");
		lblClientAddressU.setBounds(106, 103, 67, 14);
		panelUpdateClient.add(lblClientAddressU);
		
		textFieldAddressU = new JTextField();
		textFieldAddressU.setColumns(10);
		textFieldAddressU.setBounds(165, 103, 127, 20);
		panelUpdateClient.add(textFieldAddressU);
		
		lblClientDNIU = new JLabel("DNI:");
		lblClientDNIU.setBounds(106, 133, 67, 14);
		panelUpdateClient.add(lblClientDNIU);
		
		textFieldDNIU = new JTextField();
		textFieldDNIU.setColumns(10);
		textFieldDNIU.setBounds(165, 133, 127, 20);
		panelUpdateClient.add(textFieldDNIU);
		
		btnBackClientU = new JButton("Back");
		btnBackClientU.setBounds(100, 210, 90, 20);
		panelUpdateClient.add(btnBackClientU);
		
		/**
		 * Create panel Client
		 */
		
		panelCreateClient = new JPanel();
		panelCreateClient.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelCreateClient);
		panelCreateClient.setLayout(null);
		
		btnCreateClientC = new JButton("Create");
		btnCreateClientC.setBounds(10, 210, 90, 20);
		panelCreateClient.add(btnCreateClientC);
		
		textFieldNameC = new JTextField();
		textFieldNameC.setColumns(10);
		textFieldNameC.setBounds(165, 41, 127, 20);
		panelCreateClient.add(textFieldNameC);
		
		lblFieldNameC = new JLabel("Name:");
		lblFieldNameC.setBounds(106, 44, 38, 14);
		panelCreateClient.add(lblFieldNameC);
		
		lblSurnameC = new JLabel("Surname:");
		lblSurnameC.setBounds(106, 72, 67, 14);
		panelCreateClient.add(lblSurnameC);
		
		textFieldSurnameC = new JTextField();
		textFieldSurnameC.setColumns(10);
		textFieldSurnameC.setBounds(165, 72, 127, 20);
		panelCreateClient.add(textFieldSurnameC);
		
		lblAddressC = new JLabel("Address:");
		lblAddressC.setBounds(106, 103, 67, 14);
		panelCreateClient.add(lblAddressC);
		
		textFieldAddressC = new JTextField();
		textFieldAddressC.setColumns(10);
		textFieldAddressC.setBounds(165, 103, 127, 20);
		panelCreateClient.add(textFieldAddressC);
		
		lblClientDNIC = new JLabel("DNI:");
		lblClientDNIC.setBounds(106, 133, 67, 14);
		panelCreateClient.add(lblClientDNIC);
		
		textFieldDNIC = new JTextField();
		textFieldDNIC.setColumns(10);
		textFieldDNIC.setBounds(165, 133, 127, 20);
		panelCreateClient.add(textFieldDNIC);
		
		tableUpdate = new JTable();
		panelCreateClient.add(tableUpdate);
		
		btnBackClientC = new JButton("Back");
		btnBackClientC.setBounds(100, 210, 90, 20);
		panelCreateClient.add(btnBackClientC);
		
		/**
		 * Create panel Videos
		 */
		
		panelCreateVideo = new JPanel();
		panelCreateVideo.setLayout(null);
		panelCreateVideo.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelCreateVideo);
		
		textFieldTitleC = new JTextField();
		textFieldTitleC.setColumns(10);
		textFieldTitleC.setBounds(165, 41, 127, 20);
		panelCreateVideo.add(textFieldTitleC);
		
		lblTitleC = new JLabel("Title:");
		lblTitleC.setBounds(106, 44, 38, 14);
		panelCreateVideo.add(lblTitleC);
		
		lblDirectorC = new JLabel("Director:");
		lblDirectorC.setBounds(106, 72, 67, 14);
		panelCreateVideo.add(lblDirectorC);
		
		textFieldDirectorC = new JTextField();
		textFieldDirectorC.setColumns(10);
		textFieldDirectorC.setBounds(165, 72, 127, 20);
		panelCreateVideo.add(textFieldDirectorC);
		
		lblClient_IdC = new JLabel("Client_Id:");
		lblClient_IdC.setBounds(106, 103, 67, 14);
		panelCreateVideo.add(lblClient_IdC);
		
		textFieldClient_IdC = new JTextField();
		textFieldClient_IdC.setColumns(10);
		textFieldClient_IdC.setBounds(165, 103, 127, 20);
		panelCreateVideo.add(textFieldClient_IdC);
		
		btnCreateVideo = new JButton("Create");
		btnCreateVideo.setBounds(10, 210, 90, 20);
		panelCreateVideo.add(btnCreateVideo);
		
		btnBackVideosC = new JButton("Back");
		btnBackVideosC.setBounds(100, 210, 90, 20);
		panelCreateVideo.add(btnBackVideosC);
		
		/**
		 * Update panel Video
		 */
		
		panelUpdateVideo = new JPanel();
		panelUpdateVideo.setLayout(null);
		panelUpdateVideo.setBounds(0, 0, 434, 261);
		frame.getContentPane().add(panelUpdateVideo);
		
		textFieldTitleU = new JTextField();
		textFieldTitleU.setColumns(10);
		textFieldTitleU.setBounds(165, 41, 127, 20);
		panelUpdateVideo.add(textFieldTitleU);
		
		lblTitleU = new JLabel("Title:");
		lblTitleU.setBounds(106, 44, 38, 14);
		panelUpdateVideo.add(lblTitleU);
		
		lblDirectorU = new JLabel("Director:");
		lblDirectorU.setBounds(106, 72, 67, 14);
		panelUpdateVideo.add(lblDirectorU);
		
		textFieldDirectorU = new JTextField();
		textFieldDirectorU.setColumns(10);
		textFieldDirectorU.setBounds(165, 72, 127, 20);
		panelUpdateVideo.add(textFieldDirectorU);
		
		lblClient_IdU = new JLabel("Client_Id:");
		lblClient_IdU.setBounds(106, 103, 67, 14);
		panelUpdateVideo.add(lblClient_IdU);
		
		textFieldClient_IdU = new JTextField();
		textFieldClient_IdU.setColumns(10);
		textFieldClient_IdU.setBounds(165, 103, 127, 20);
		panelUpdateVideo.add(textFieldClient_IdU);
		
		btnUpdateVideo = new JButton("Update");
		btnUpdateVideo.setBounds(10, 210, 90, 20);
		panelUpdateVideo.add(btnUpdateVideo);
		
		btnBackVideosU = new JButton("Back");
		btnBackVideosU.setBounds(100, 210, 90, 20);
		panelUpdateVideo.add(btnBackVideosU);
		
	}

	public JTable getTableClients() {
		return tableClients;
	}

	/** Getters & Setters */
	
	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the btnClients
	 */
	public JButton getBtnClients() {
		return btnClients;
	}

	/**
	 * @return the btnMovies
	 */
	public JButton getBtnMovies() {
		return btnMovies;
	}

	/**
	 * @return the btnUpdateClientU
	 */
	public JButton getBtnUpdateClientU() {
		return btnUpdateClientU;
	}

	/**
	 * @return the btnCreateClientC
	 */
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
	
	/**
	 * @return the panelUpdateVideo
	 */
	public JPanel getPanelUpdateVideo() {
		return panelUpdateVideo;
	}

	/**
	 * @return the panelCreateVideo
	 */
	public JPanel getPanelCreateVideo() {
		return panelCreateVideo;
	}

	/**
	 * @return the panelUpdateClient
	 */
	public JPanel getPanelUpdateClient() {
		return panelUpdateClient;
	}

	/**
	 * @return the panelCreateClient
	 */
	public JPanel getPanelCreateClient() {
		return panelCreateClient;
	}

	/**
	 * @return the textFieldSurnameC
	 */
	public JTextField getTextFieldSurnameC() {
		return textFieldSurnameC;
	}

	/**
	 * @return the textFieldNameC
	 */
	public JTextField getTextFieldNameC() {
		return textFieldNameC;
	}

	/**
	 * @return the textFieldAddressC
	 */
	public JTextField getTextFieldAddressC() {
		return textFieldAddressC;
	}
	
	/**
	 * @return the panelTable
	 */
	public JPanel getPanelTable() {
		return panelTable;
	}

	/**
	 * @return the tableVideo
	 */
	public JTable getTableVideo() {
		return tableVideo;
	}

	/**
	 * @return the bntBack
	 */
	public JButton getBtnBack() {
		return btnBack;
	}

	/**
	 * @return the btnBackVideosC
	 */
	public JButton getBtnBackVideosC() {
		return btnBackVideosC;
	}

	/**
	 * @return the btnBACKVideosU
	 */
	public JButton getbtnBackVideosU() {
		return btnBackVideosU;
	}

	/**
	 * @return the btnBackClientU
	 */
	public JButton getBtnBackClientU() {
		return btnBackClientU;
	}

	/**
	 * @return the btnBackClientC
	 */
	public JButton getBtnBackClientC() {
		return btnBackClientC;
	}
	

	public JTextField getTextFieldTitleU() {
		return textFieldTitleU;
	}

	public JTextField getTextFieldDirectorU() {
		return textFieldDirectorU;
	}

	public JTextField getTextFieldClient_IdU() {
		return textFieldClient_IdU;
	}

	public JTextField getTextFieldTitleC() {
		return textFieldTitleC;
	}

	public JTextField getTextFieldDirectorC() {
		return textFieldDirectorC;
	}

	public JTextField getTextFieldClient_IdC() {
		return textFieldClient_IdC;
	}

	/**
	 * @return the textFieldNameU
	 */
	public JTextField getTextFieldNameU() {
		return textFieldNameU;
	}

	/**
	 * @param textFieldNameU the textFieldNameU to set
	 */
	public void setTextFieldNameU(JTextField textFieldNameU) {
		this.textFieldNameU = textFieldNameU;
	}

	/**
	 * @return the textFieldAddressU
	 */
	public JTextField getTextFieldAddressU() {
		return textFieldAddressU;
	}

	/**
	 * @param textFieldAddressU the textFieldAddressU to set
	 */
	public void setTextFieldAddressU(JTextField textFieldAddressU) {
		this.textFieldAddressU = textFieldAddressU;
	}

	/**
	 * @return the textFieldSurnameU
	 */
	public JTextField getTextFieldSurnameU() {
		return textFieldSurnameU;
	}

	/**
	 * @param textFieldSurnameU the textFieldSurnameU to set
	 */
	public void setTextFieldSurnameU(JTextField textFieldSurnameU) {
		this.textFieldSurnameU = textFieldSurnameU;
	}

	/**
	 * @return the textFieldDNIU
	 */
	public JTextField getTextFieldDNIU() {
		return textFieldDNIU;
	}

	/**
	 * @param textFieldDNIU the textFieldDNIU to set
	 */
	public void setTextFieldDNIU(JTextField textFieldDNIU) {
		this.textFieldDNIU = textFieldDNIU;
	}

	public JTextField getTextFieldDNIC() {
		return textFieldDNIC;
	}

	public void setTextFieldDNIC(JTextField textFieldDNIC) {
		this.textFieldDNIC = textFieldDNIC;
	}	
	
	
	

}