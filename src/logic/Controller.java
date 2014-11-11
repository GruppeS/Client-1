package logic;

import gui.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import model.ServerConnection;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Controller {
	private String email;
	private String password;
	private Gson gson;
	private UserInfo userInfo;
	private Screen screen;
	private ServerConnection serverConnection;

	public void userInfoGet() throws UnknownHostException, IOException{
		
		gson = new GsonBuilder().create();
		userInfo = new UserInfo();
		screen = new Screen();
		serverConnection = new ServerConnection();
		
				
				userInfo.setAuthUserEmail(email);
				userInfo.setAuthUserPassword(password);
				userInfo.setAuthUserIsAdmin(false);
				String gsonString = gson.toJson(userInfo);
				String info = serverConnection.getFromServer(gsonString);
		 if(info.equals("0")){
			 
		 }
	}

	private class LoginPanelActionListener implements ActionListener // Klasse der implementere actionlistener
	{
		public void actionPerformed(ActionEvent e) // metode der bliver kørt når en knap trykkes i login panelet
		{
			String cmd = e.getActionCommand(); // lokal string der gemmer actioncommand

			if(cmd.equals("LoginBtn")) // hvis actioncommand er "LoginBtn"
			{				
				email = screen.getLoginPanel().getUserName_Login(); 
				password = screen.getLoginPanel().getPassword_Login();
				try {
					userInfoGet();
				} catch (UnknownHostException e1) {
				
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				
			} // if sætning slutter
		} // Metode slutter
	} // Klasse slutter
	
}
