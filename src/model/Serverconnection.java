package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ServerConnection {

	private byte[] serverReply; 
	private ObjectInputStream input;
	private ObjectOutputStream output;
	private Socket clientSocket;
	private Encryption encryption = new Encryption();

	public void connect(){

		try {
			clientSocket = new Socket("localhost", 8888);

			input = new ObjectInputStream(clientSocket.getInputStream());
			output = new ObjectOutputStream(clientSocket.getOutputStream());
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	public String getFromServer(String gsonString) throws UnknownHostException, IOException, ClassNotFoundException{

		output.writeObject(encryption.encrypt(gsonString));
		output.flush();
		serverReply = (byte[]) input.readObject();
		String reply = encryption.decrypt(serverReply);
		return reply; 

	}
	public void close() throws IOException{
		clientSocket.close();
	}

}
