package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class View  extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Attributes
	 */
	private JFrame frame;
	private JPanel panelTable;
	
	//Panel buttons JPanel & Jbuttons
	private JPanel panelButtons;
	
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnCreate;
	private JButton btnBack;
	
	//Jtables 
	private JTable tableProjects;
	
	// Update Projects
	private JPanel panelUpdateProject;
	private JButton btnUpdateProject;
	private JLabel lblProjectNameU;
	private JTextField textFieldProjectNameU;
	private JLabel lblProjectHoursU;
	private JTextField textFieldProjectHoursU;
	private JButton btnBackProjectU;
	
	//  Create projects
	private JPanel panelCreateProject;
	private JButton btnCreateProject;
	private JLabel lblProjectNameC;
	private JTextField textFieldProjectNameC;
	private JLabel lblProjectHoursC;
	private JTextField textFieldProjectHoursC;
	private JButton btnBackProjectC;
	
	// Create Scientist
	private JPanel panelCreateScientist;
	private JButton btnCreateScientist;
	private JLabel lblScientistDNIC;
	private JTextField textFieldDNIC;
	private JLabel lblScientistNameC;
	private JTextField textFieldScientistNameC;
	private JButton btnBackScientistC;
	
	// Update Scientist
	private JPanel panelUpdateScientist;
	private JButton btnUpdateScientist;
	private JLabel lblScientistNameU;
	private JTextField textFieldScientistNameU;
	private JButton btnBackScientistU;
	
	// Create ScientistProject
	private JPanel panelCreateScientistProject;
	private JButton btnCreateScientistProject;
	private JLabel lblScientistProjectDNIC;
	private JTextField textFieldDNIeC;
	private JLabel lblScientistProjectIdC;
	private JTextField textFieldIdC;
	private JButton btnBackScientistProjectC;
	
	// Update ScientistProject
	private JPanel panelUpdateScientistProject; 
	private JButton btnUpdateScientistProject;
	private JLabel lblScientistProjectDNIU;
	private JTextField textFieldDNIU;
	private JLabel lblScientistProjectIdU;
	private JTextField textFieldIdU;		
	private JButton btnBackScientistProjectU;
		
	
	
	public View ()  {
		/**
		 * Window frame
		 */
		frame  = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setLayout(null);
		panelTable = new JPanel();
		panelTable.setBounds(10, 10, 415, 240);
		frame.getContentPane().add(panelTable);
		panelTable.setLayout(new BorderLayout(0, 0));
		
		JPanel panelButtons = new JPanel();
		panelTable.add(panelButtons, BorderLayout.SOUTH);
		panelButtons.setLayout(new GridLayout(1, 0, 10, 0));
		
		btnBack = new JButton("Back");
		panelButtons.add(btnBack);
		
		btnUpdate = new JButton("Update");
		panelButtons.add(btnUpdate);

		btnDelete = new JButton("Delete");
		panelButtons.add(btnDelete);

		btnCreate = new JButton("Add");
		panelButtons.add(btnCreate);
		
		
		tableProjects = new JTable();
		tableProjects = new JTable(new DefaultTableModel(new Object[] {"ID", "Name", "Hours"}, 0));
		tableProjects.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		panelTable.add(new JScrollPane(tableProjects), BorderLayout.NORTH);
		
		/**
		 * Update panel Project
		 */
		
		panelUpdateProject = new JPanel();
		panelUpdateProject.setLayout(null);
		panelUpdateProject.setBounds(0, 0, 415, 240);
		frame.getContentPane().add(panelUpdateProject);
		
		btnUpdateProject = new JButton("Update");
		btnUpdateProject.setBounds(100, 210, 90, 20);
		panelUpdateProject.add(btnUpdateProject);
		
		lblProjectNameU = new JLabel("Name:");
		lblProjectNameU.setBounds(106, 44, 38, 14);
		panelUpdateProject.add(lblProjectNameU);
		
		textFieldProjectNameU = new JTextField();
		textFieldProjectNameU.setColumns(10);
		textFieldProjectNameU.setBounds(165, 44, 127, 20);
		panelUpdateProject.add(textFieldProjectNameU);
		
		lblProjectHoursU = new JLabel("Hours:");
		lblProjectHoursU.setBounds(106, 72, 67, 14);
		panelUpdateProject.add(lblProjectHoursU);
		
		textFieldProjectHoursU = new JTextField();
		textFieldProjectHoursU.setColumns(10);
		textFieldProjectHoursU.setBounds(165, 72, 127, 20);
		panelUpdateProject.add(textFieldProjectHoursU);
		
		btnBackProjectU = new JButton("Back");
		btnBackProjectU.setBounds(10, 210, 90, 20);
		panelUpdateProject.add(btnBackProjectU);
	
	
		/**
		 * Create panel Project
		 */
	
		panelCreateProject = new JPanel();
		panelCreateProject.setLayout(null);
		panelCreateProject.setBounds(0, 0, 415, 240);
		frame.getContentPane().add(panelCreateProject);
	
		btnCreateProject = new JButton("Create");
		btnCreateProject.setBounds(100, 210, 90, 20);
		panelCreateProject.add(btnCreateProject);
		
		lblProjectNameC = new JLabel("Name:");
		lblProjectNameC.setBounds(106, 44, 38, 14);
		panelCreateProject.add(lblProjectNameC);
	
		textFieldProjectNameC = new JTextField();
		textFieldProjectNameC.setColumns(10);
		textFieldProjectNameC.setBounds(165, 44, 127, 20);
		panelCreateProject.add(textFieldProjectNameC);
	
		lblProjectHoursC = new JLabel("Hours:");
		lblProjectHoursC.setBounds(106, 72, 67, 14);
		panelCreateProject.add(lblProjectHoursC);
	
		textFieldProjectHoursC = new JTextField();
		textFieldProjectHoursC.setColumns(10);
		textFieldProjectHoursC.setBounds(165, 72, 127, 20);
		panelCreateProject.add(textFieldProjectHoursC);
	
		btnBackProjectC = new JButton("Back");
		btnBackProjectC.setBounds(10, 210, 90, 20);
		panelCreateProject.add(btnBackProjectC);
		
		/**
		 * Update panel Scientist
		 */
		
		panelUpdateScientist = new JPanel();
		panelUpdateScientist.setLayout(null);
		panelUpdateScientist.setBounds(0, 0, 415, 240);
		frame.getContentPane().add(panelUpdateScientist);
	
		btnUpdateScientist = new JButton("Update");
		btnUpdateScientist.setBounds(100, 210, 90, 20);
		panelUpdateScientist.add(btnUpdateScientist);
	
		lblScientistNameU = new JLabel("NameSurnames:");
		lblScientistNameU.setBounds(50, 72, 140, 14);
		panelUpdateScientist.add(lblScientistNameU);
	
		textFieldScientistNameU = new JTextField();
		textFieldScientistNameU.setColumns(10);
		textFieldScientistNameU.setBounds(165, 72, 127, 20);
		panelUpdateScientist.add(textFieldScientistNameU);
	
		btnBackScientistU = new JButton("Back");
		btnBackScientistU.setBounds(10, 210, 90, 20);
		panelUpdateScientist.add(btnBackScientistU);
		
		/**
		 * Create panel for Scientist
		 */
		panelCreateScientist = new JPanel();
		panelCreateScientist.setLayout(null);
		panelCreateScientist.setBounds(0, 0, 415, 240);
		frame.getContentPane().add(panelCreateScientist);
	
		btnCreateScientist = new JButton("Create");
		btnCreateScientist.setBounds(100, 210, 90, 20);
		panelCreateScientist.add(btnCreateScientist);
		
		lblScientistDNIC = new JLabel("DNI:");
		lblScientistDNIC.setBounds(106, 44, 38, 14);
		panelCreateScientist.add(lblScientistDNIC);
	
		textFieldDNIC = new JTextField();
		textFieldDNIC.setColumns(10);
		textFieldDNIC.setBounds(165, 44, 127, 20);
		panelCreateScientist.add(textFieldDNIC);
	
		lblScientistNameC = new JLabel("NameSurnames:");
		lblScientistNameC.setBounds(50, 72, 140, 14);
		panelCreateScientist.add(lblScientistNameC);
	
		textFieldScientistNameC = new JTextField();
		textFieldScientistNameC.setColumns(10);
		textFieldScientistNameC.setBounds(165, 72, 127, 20);
		panelCreateScientist.add(textFieldScientistNameC);
	
		btnBackScientistC = new JButton("Back");
		btnBackScientistC.setBounds(10, 210, 90, 20);
		panelCreateScientist.add(btnBackScientistC);
		
		/**
		 * Create panel ScientistProject
		 */
	
		panelCreateScientistProject = new JPanel();
		panelCreateScientistProject.setLayout(null);
		panelCreateScientistProject.setBounds(0, 0, 415, 240);
		frame.getContentPane().add(panelCreateScientistProject);
	
		btnCreateScientistProject = new JButton("Create");
		btnCreateScientistProject.setBounds(100, 210, 90, 20);
		panelCreateScientistProject.add(btnCreateScientistProject);
		
		lblScientistProjectDNIC = new JLabel("DNI:");
		lblScientistProjectDNIC.setBounds(106, 44, 38, 14);
		panelCreateScientistProject.add(lblScientistProjectDNIC);
	
		textFieldDNIeC = new JTextField();
		textFieldDNIeC.setColumns(10);
		textFieldDNIeC.setBounds(165, 44, 127, 20);
		panelCreateScientistProject.add(textFieldDNIeC);
	
		lblScientistProjectIdC = new JLabel("Id:");
		lblScientistProjectIdC.setBounds(106, 72, 67, 14);
		panelCreateScientistProject.add(lblScientistProjectIdC);
	
		textFieldIdC = new JTextField();
		textFieldIdC.setColumns(10);
		textFieldIdC.setBounds(165, 72, 127, 20);
		panelCreateScientistProject.add(textFieldIdC);
	
		btnBackScientistProjectC = new JButton("Back");
		btnBackScientistProjectC.setBounds(10, 210, 90, 20);
		panelCreateScientistProject.add(btnBackScientistProjectC);
		
		/**
		 * Update panel ScientistProject
		 */
		
		panelUpdateScientistProject = new JPanel();
		panelUpdateScientistProject.setLayout(null);
		panelUpdateScientistProject.setBounds(0, 0, 415, 240);
		frame.getContentPane().add(panelUpdateScientistProject);
		
		btnUpdateScientistProject = new JButton("Update");
		btnUpdateScientistProject.setBounds(100, 210, 90, 20);
		panelUpdateScientistProject.add(btnUpdateScientistProject);
		
		lblScientistProjectDNIU = new JLabel("DNI:");
		lblScientistProjectDNIU.setBounds(106, 44, 38, 14);
		panelUpdateScientistProject.add(lblScientistProjectDNIU);
		
		textFieldDNIU = new JTextField();
		textFieldDNIU.setColumns(10);
		textFieldDNIU.setBounds(165, 44, 127, 20);
		panelUpdateScientistProject.add(textFieldDNIU);
		
		lblScientistProjectIdU = new JLabel("Id:");
		lblScientistProjectIdU.setBounds(106, 72, 67, 14);
		panelUpdateScientistProject.add(lblScientistProjectIdU);
		
		textFieldIdU = new JTextField();
		textFieldIdU.setColumns(10);
		textFieldIdU.setBounds(165, 72, 127, 20);
		panelUpdateScientistProject.add(textFieldIdU);
		
		btnBackScientistProjectU = new JButton("Back");
		btnBackScientistProjectU.setBounds(10, 210, 90, 20);
		panelUpdateScientistProject.add(btnBackScientistProjectU);
}
	
	/**Getters & Setters */

	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @return the panelTable
	 */
	public JPanel getPanelTable() {
		return panelTable;
	}

	/**
	 * @return the textFieldDNIU
	 */
	public JTextField getTextFieldDNIU() {
		return textFieldDNIU;
	}

	/**
	 * @return the panelButtons
	 */
	public JPanel getPanelButtons() {
		return panelButtons;
	}

	/**
	 * @return the btnUpdate
	 */
	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	/**
	 * @return the btnDelete
	 */
	public JButton getBtnDelete() {
		return btnDelete;
	}

	/**
	 * @return the btnCreate
	 */
	public JButton getBtnCreate() {
		return btnCreate;
	}

	/**
	 * @return the btnBack
	 */
	public JButton getBtnBack() {
		return btnBack;
	}

	/**
	 * @return the tableProjects
	 */
	public JTable getTableProjects() {
		return tableProjects;
	}


	/**
	 * @return the panelCreateScientist
	 */
	public JPanel getPanelCreateScientist() {
		return panelCreateScientist;
	}

	/**
	 * @return the lblScientistDNIC
	 */
	public JLabel getLblScientistDNIC() {
		return lblScientistDNIC;
	}

	/**
	 * @return the textFieldDNIC
	 */
	public JTextField getTextFieldDNIC() {
		return textFieldDNIC;
	}

	/**
	 * @return the lblScientistNameC
	 */
	public JLabel getLblScientistNameC() {
		return lblScientistNameC;
	}

	/**
	 * @return the textFieldScientistNameC
	 */
	public JTextField getTextFieldScientistNameC() {
		return textFieldScientistNameC;
	}

	/**
	 * @return the btnBackScientistC
	 */
	public JButton getBtnBackScientistC() {
		return btnBackScientistC;
	}

	/**
	 * @return the panelUpdateScientist
	 */
	public JPanel getPanelUpdateScientist() {
		return panelUpdateScientist;
	}

	/**
	 * @return the lblScientistNameU
	 */
	public JLabel getLblScientistNameU() {
		return lblScientistNameU;
	}

	/**
	 * @return the textFieldScientistNameU
	 */
	public JTextField getTextFieldScientistNameU() {
		return textFieldScientistNameU;
	}

	/**
	 * @return the btnBackScientistU
	 */
	public JButton getBtnBackScientistU() {
		return btnBackScientistU;
	}

	/**
	 * @return the btnCreateScientist
	 */
	public JButton getBtnCreateScientist() {
		return btnCreateScientist;
	}

	/**
	 * @return the btnUpdateScientist
	 */
	public JButton getBtnUpdateScientist() {
		return btnUpdateScientist;
	}

	public JPanel getPanelCreateScientistProject() {
		return panelCreateScientistProject;
	}

	public void setPanelCreateScientistProject(JPanel panelCreateScientistProject) {
		this.panelCreateScientistProject = panelCreateScientistProject;
	}

	public JButton getBtnCreateScientistProject() {
		return btnCreateScientistProject;
	}

	public void setBtnCreateScientistProject(JButton btnCreateScientistProject) {
		this.btnCreateScientistProject = btnCreateScientistProject;
	}

	public JButton getBtnBackScientistProjectC() {
		return btnBackScientistProjectC;
	}

	public void setBtnBackScientistProjectC(JButton btnBackScientistProjectC) {
		this.btnBackScientistProjectC = btnBackScientistProjectC;
	}

	public JPanel getPanelUpdateScientistProject() {
		return panelUpdateScientistProject;
	}

	public void setPanelUpdateScientistProject(JPanel panelUpdateScientistProject) {
		this.panelUpdateScientistProject = panelUpdateScientistProject;
	}

	public JButton getBtnUpdateScientistProject() {
		return btnUpdateScientistProject;
	}

	public void setBtnUpdateScientistProject(JButton btnUpdateScientistProject) {
		this.btnUpdateScientistProject = btnUpdateScientistProject;
	}

	public JButton getBtnBackScientistProjectU() {
		return btnBackScientistProjectU;
	}

	public void setBtnBackScientistProjectU(JButton btnBackScientistProjectU) {
		this.btnBackScientistProjectU = btnBackScientistProjectU;
	}

	public JTextField getTextFieldNameU() {
		return textFieldProjectNameU;
	}

	public void setTextFieldNameU(JTextField textFieldNameU) {
		this.textFieldProjectNameU = textFieldNameU;
	}

	public JTextField getTextFieldNameC() {
		return textFieldProjectNameC;
	}

	public void setTextFieldNameC(JTextField textFieldNameC) {
		this.textFieldProjectNameC = textFieldNameC;
	}

	public JLabel getLblScientistProjectDNIC() {
		return lblScientistProjectDNIC;
	}

	public void setLblScientistProjectDNIC(JLabel lblScientistProjectDNIC) {
		this.lblScientistProjectDNIC = lblScientistProjectDNIC;
	}

	public JLabel getLblScientistProjectIdC() {
		return lblScientistProjectIdC;
	}

	public void setLblScientistProjectIdC(JLabel lblScientistProjectIdC) {
		this.lblScientistProjectIdC = lblScientistProjectIdC;
	}

	public JTextField getTextFieldIdC() {
		return textFieldIdC;
	}

	public void setTextFieldIdC(JTextField textFieldIdC) {
		this.textFieldIdC = textFieldIdC;
	}

	public JLabel getLblScientistProjectDNIU() {
		return lblScientistProjectDNIU;
	}

	public void setLblScientistProjectDNIU(JLabel lblScientistProjectDNIU) {
		this.lblScientistProjectDNIU = lblScientistProjectDNIU;
	}

	public JLabel getLblScientistProjectIdU() {
		return lblScientistProjectIdU;
	}

	public void setLblScientistProjectIdU(JLabel lblScientistProjectIdU) {
		this.lblScientistProjectIdU = lblScientistProjectIdU;
	}

	public JTextField getTextFieldIdU() {
		return textFieldIdU;
	}

	public void setTextFieldIdU(JTextField textFieldIdU) {
		this.textFieldIdU = textFieldIdU;
	}

	public JTextField getTextFieldDNIeC() {
		return textFieldDNIeC;
	}

	public void setTextFieldDNIeC(JTextField textFieldDNIeC) {
		this.textFieldDNIeC = textFieldDNIeC;
	}

	/**
	 * @return the panelUpdateProject
	 */
	public JPanel getPanelUpdateProject() {
		return panelUpdateProject;
	}

	/**
	 * @param panelUpdateProject the panelUpdateProject to set
	 */
	public void setPanelUpdateProject(JPanel panelUpdateProject) {
		this.panelUpdateProject = panelUpdateProject;
	}

	/**
	 * @return the panelCreateProject
	 */
	public JPanel getPanelCreateProject() {
		return panelCreateProject;
	}

	/**
	 * @param panelCreateProject the panelCreateProject to set
	 */
	public void setPanelCreateProject(JPanel panelCreateProject) {
		this.panelCreateProject = panelCreateProject;
	}

	/**
	 * @return the btnUpdateProject
	 */
	public JButton getBtnUpdateProject() {
		return btnUpdateProject;
	}

	/**
	 * @param btnUpdateProject the btnUpdateProject to set
	 */
	public void setBtnUpdateProject(JButton btnUpdateProject) {
		this.btnUpdateProject = btnUpdateProject;
	}

	/**
	 * @return the btnBackProjectU
	 */
	public JButton getBtnBackProjectU() {
		return btnBackProjectU;
	}

	/**
	 * @param btnBackProjectU the btnBackProjectU to set
	 */
	public void setBtnBackProjectU(JButton btnBackProjectU) {
		this.btnBackProjectU = btnBackProjectU;
	}

	/**
	 * @return the btnCreateProject
	 */
	public JButton getBtnCreateProject() {
		return btnCreateProject;
	}

	/**
	 * @param btnCreateProject the btnCreateProject to set
	 */
	public void setBtnCreateProject(JButton btnCreateProject) {
		this.btnCreateProject = btnCreateProject;
	}

	/**
	 * @return the btnBackProjectC
	 */
	public JButton getBtnBackProjectC() {
		return btnBackProjectC;
	}

	/**
	 * @param btnBackProjectC the btnBackProjectC to set
	 */
	public void setBtnBackProjectC(JButton btnBackProjectC) {
		this.btnBackProjectC = btnBackProjectC;
	}

	/**
	 * @return the textFieldProjectNameU
	 */
	public JTextField getTextFieldProjectNameU() {
		return textFieldProjectNameU;
	}

	/**
	 * @param textFieldProjectNameU the textFieldProjectNameU to set
	 */
	public void setTextFieldProjectNameU(JTextField textFieldProjectNameU) {
		this.textFieldProjectNameU = textFieldProjectNameU;
	}

	/**
	 * @return the textFieldProjectHoursU
	 */
	public JTextField getTextFieldProjectHoursU() {
		return textFieldProjectHoursU;
	}

	/**
	 * @param textFieldProjectHoursU the textFieldProjectHoursU to set
	 */
	public void setTextFieldProjectHoursU(JTextField textFieldProjectHoursU) {
		this.textFieldProjectHoursU = textFieldProjectHoursU;
	}

	/**
	 * @return the textFieldProjectNameC
	 */
	public JTextField getTextFieldProjectNameC() {
		return textFieldProjectNameC;
	}

	/**
	 * @param textFieldProjectNameC the textFieldProjectNameC to set
	 */
	public void setTextFieldProjectNameC(JTextField textFieldProjectNameC) {
		this.textFieldProjectNameC = textFieldProjectNameC;
	}

	/**
	 * @return the textFieldProjectHoursC
	 */
	public JTextField getTextFieldProjectHoursC() {
		return textFieldProjectHoursC;
	}

	/**
	 * @param textFieldProjectHoursC the textFieldProjectHoursC to set
	 */
	public void setTextFieldProjectHoursC(JTextField textFieldProjectHoursC) {
		this.textFieldProjectHoursC = textFieldProjectHoursC;
	}

	
	
	
	
	
}
