package appMain;
	
import java.awt.Menu;

import controller.Controller;
import controller.ControllerClient;
import model.Client;
import model.Video;
import view.View;

public class MainApp {
	
	public static void main(String[] args) {
		
		/**
		 * Creation of new client, view and controller, and initiating them
		 */
		Client client = new Client();
		//Video video = new Video();
		View view = new View();
		ControllerClient controllerClient = new ControllerClient(client, view);
		//ControllerClient controllerVideo = new ControllerClient(client, view);
		controllerClient.launchView();
		
//		NOT WORKING VIEW DO NOT LAUNCH -------	
//		Menu menu = new Menu();
		
//		Controller controller = new Controller();
//		controller.launchView();
		
	}
}