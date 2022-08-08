package appMain;
	
import controller.Controller;
import model.Client;
import view.View;

public class MainApp {
	
	public static void main(String[] args) {
		
		/**
		 * Creation of new client, view and controller, and initiating them
		 */
		Client client = new Client();
		View view = new View();
		Controller controller = new Controller(client, view);
		controller.launchView();
		
	}
}

