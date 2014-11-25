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

	public Controller() {
		
		screen = new Screen();
		screen.getLoginPanel().addActionListener(new LoginPanelActionListener());
		serverConnection = new ServerConnection();
		gson = new GsonBuilder().create();
		userInfo = new UserInfo();
	}
	
	public void run(){
		
		screen.show(Screen.LOGINPANEL);
		screen.setVisible(true);
		
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
				userInfo.setAuthUserEmail(email);
				userInfo.setAuthUserPassword(password);
				userInfo.setAuthUserIsAdmin(false);
				String gsonString = gson.toJson(userInfo);
				String info = null;
				try {
					info = serverConnection.getFromServer(gsonString);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		 if(info.equals("0")){
			 screen.show(Screen.MAINPANEL);
		
		 }
		 else{
			 System.out.println("succes");
		 }
				
			} // if sætning slutter
		} // Metode slutter
	} // Klasse slutter
	
}
