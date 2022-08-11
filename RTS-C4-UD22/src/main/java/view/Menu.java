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
	public JPanel panelMenu;
	public JButton btnClients;
	public JButton btnMovies;
		
	public Menu () {
		 /* Window frame
		 */
		
		setTitle("Menu"); // PopUp window title
		setBounds(100, 100, 450, 300); // X Y coordinates of the application and its height and length
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Close the window  when the operation is close
		setVisible(true); // It allows the window to be visible
		
		/* Creation and added the panel to the window */
		panelMenu = new JPanel();
		panelMenu.setLayout(null);
		panelMenu.setBounds(0, 0, 434, 261);
		setContentPane(panelMenu);
		
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
		
		JButton btnRestoreDefaultStructure = new JButton("Restart Db");
		btnRestoreDefaultStructure.setBounds(10, 227, 143, 23);
		panelMenu.add(btnRestoreDefaultStructure);
		
		
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


	
	
	
}
