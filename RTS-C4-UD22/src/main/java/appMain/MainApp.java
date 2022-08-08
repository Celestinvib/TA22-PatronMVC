package appMain;
	
import controller.Controller;
import model.Client;
import view.View;

public class MainApp {
	
	public static void main(String[] args) {
	
		Client client = new Client(null, null, null, 0, null);
		View view = new View();
		Controller controller = new Controller(client, view);
		controller.initiateView();
		
	}
}

