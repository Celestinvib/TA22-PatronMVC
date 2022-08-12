
package appMain;
	
import view.Menu;

import controller.Controller;
import controller.ControllerClient;
import model.Client;
import model.Video;
import view.View;

public class MainApp {
	
	public static void main(String[] args) {
		
		/**
		 * Creation of new controller, and initiating them
		 */		
		Controller controller = new Controller();
		controller.launchView();
		
	}
}