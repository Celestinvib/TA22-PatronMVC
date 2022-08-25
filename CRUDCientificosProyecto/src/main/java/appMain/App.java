package appMain;

import contoller.Controller;

//import controller.Controller;

public class App 
{
    public static void main( String[] args )
    {
		/**
		 * Creation of new controller, and initiating them
		 */		
		Controller controller = new Controller();
		controller.launchView();
    }
}