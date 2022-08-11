package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	public JPanel panelMenu;
	public JButton btnClients;
	public JButton btnMovies;
	public JButton btnRestartDb;
	
	public Menu () {
		 /* Window frame
		 */
		frame = new JFrame();
		
		frame.setTitle("Menu"); // PopUp window title
		frame.setBounds(100, 100, 450, 300); // X Y coordinates of the application and its height and length
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE); // Close the window  when the operation is close
		frame.setVisible(true); // It allows the window to be visible
		
		/* Creation and added the panel to the window */
		panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBounds(0, 0, 434, 261);
		setContentPane(panelMenu);
		panelMenu.setVisible(false);

		
		btnClients = new JButton("Clients");
		btnClients.setBounds(97, 129, 89, 23);
		panelMenu.add(btnClients);
		
		btnMovies = new JButton("Movies");
		btnMovies.setBounds(228, 129, 89, 23);
		panelMenu.add(btnMovies);
		
		JLabel lblNewLabel = new JLabel("Select one table to be able to CRUD!");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(101, 74, 259, 14);
		panelMenu.add(lblNewLabel);
		
		btnRestartDb = new JButton("Restart Db");
		btnRestartDb.setBounds(10, 227, 143, 23);
		panelMenu.add(btnRestartDb);
		
		frame.getContentPane().add(panelMenu);
		
	}

	
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
	 * @return the btnRestartDb
	 */
	public JButton getBtnRestartDb() {
		return btnRestartDb;
	}



	
	
	
}
