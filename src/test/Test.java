package test;

import java.io.IOException;
import java.net.UnknownHostException;

import logic.Controller;

public class Test {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Controller controller = new Controller();
		controller.run();
		
	}

}
