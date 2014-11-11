package model;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerConnection {
	private String serverReply; 

	public String getFromServer(String gsonString) throws UnknownHostException, IOException{
	
	Socket clientSocket = new Socket("localhost", 8888);

	DataInputStream is = new DataInputStream(clientSocket.getInputStream());
		PrintStream os = new PrintStream(clientSocket.getOutputStream());
		os.println(gsonString);
		serverReply = is.readLine();
		
	return serverReply; 
	}
	

	
}
