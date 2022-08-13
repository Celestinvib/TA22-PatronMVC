package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame {
	/**
	 * Attributes
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel panelMenu;
	private JButton btnScientists;
	private JButton btnProjects;
	private JButton btnRestartDb;
	
	public Menu () {
		 /* Window frame*/
		frame = new JFrame();
		
		frame.setTitle("Menu"); // PopUp window title
		frame.setBounds(100, 100, 450, 300); // X Y coordinates of the application and its height and length
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // Close the window  when the operation is close
		frame.setVisible(true); // It allows the window to be visible
		
		/* Creation and added the panel to the window */
		panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBounds(0, 0, 434, 261);
		panelMenu.setVisible(false);
		
		frame.getContentPane().add(panelMenu);

		
		btnScientists = new JButton("Scientists");
		btnScientists.setBounds(99, 103, 95, 23);
		panelMenu.add(btnScientists);
		
		btnProjects = new JButton("Projects");
		btnProjects.setBounds(230, 103, 95, 23);
		panelMenu.add(btnProjects);
		
		JLabel lblNewLabel = new JLabel("Select one table to be able to CRUD!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(88, 52, 259, 14);
		panelMenu.add(lblNewLabel);
		
		btnRestartDb = new JButton("Restart Db");
		btnRestartDb.setBounds(10, 227, 116, 23);
		panelMenu.add(btnRestartDb);
		
		JButton btnScientistsProjects = new JButton("ScientistsProjects");
		btnScientistsProjects.setBounds(137, 152, 149, 23);
		panelMenu.add(btnScientistsProjects);
		
		
	}
	
	/**Getters & Setters */


	/**
	 * @return the frame
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * @param frame the frame to set
	 */
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	/**
	 * @return the panelMenu
	 */
	public JPanel getPanelMenu() {
		return panelMenu;
	}

	/**
	 * @param panelMenu the panelMenu to set
	 */
	public void setPanelMenu(JPanel panelMenu) {
		this.panelMenu = panelMenu;
	}

	/**
	 * @return the btnScientists
	 */
	public JButton getBtnScientists() {
		return btnScientists;
	}

	/**
	 * @param btnScientists the btnScientists to set
	 */
	public void setBtnScientists(JButton btnScientists) {
		this.btnScientists = btnScientists;
	}

	/**
	 * @return the btnProjects
	 */
	public JButton getBtnProjects() {
		return btnProjects;
	}

	/**
	 * @param btnProjects the btnProjects to set
	 */
	public void setBtnProjects(JButton btnProjects) {
		this.btnProjects = btnProjects;
	}

	/**
	 * @return the btnRestartDb
	 */
	public JButton getBtnRestartDb() {
		return btnRestartDb;
	}

	/**
	 * @param btnRestartDb the btnRestartDb to set
	 */
	public void setBtnRestartDb(JButton btnRestartDb) {
		this.btnRestartDb = btnRestartDb;
	}
	

	
}
