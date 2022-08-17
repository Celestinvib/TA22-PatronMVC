
package appMain;
	
import controller.Controller;

public class MainApp {
	
	public static void main(String[] args) {
		
		/**
		 * Creation of new controller, and initiating them
		 */		
		Controller controller = new Controller();
		controller.launchView();
		
	}
}