package appMain;
	
import controller.Controller;
import model.Client;
import model.Video;
import view.View;

public class MainApp {
	
	public static void main(String[] args) {
		
		/**
		 * Creation of new client, view and controller, and initiating them
		 */
		Client client = new Client();
		Video video = new Video();
		View view = new View();
		Controller controller = new Controller(client, video ,view);
		controller.launchView();
		
	}
}