package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerConnection {
	private String serverReply; 
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private Socket clientSocket;

	public String getFromServer(String gsonString) throws UnknownHostException, IOException, ClassNotFoundException{
	
		clientSocket = new Socket("localhost", 8888);

	input = new ObjectInputStream(clientSocket.getInputStream());
	output = new ObjectOutputStream(clientSocket.getOutputStream());
	
	output.writeObject(gsonString);
	output.flush();
	serverReply = (String) input.readObject();
	return serverReply; 
	
	}
	public void close() throws IOException{
		clientSocket.close();
	}
	

	
}
