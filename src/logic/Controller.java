package logic;

import gui.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Vector;

import model.Calendars;
import model.Event;
import model.Events;
import model.Forecast;
import model.Forecasts;
import model.QOTD;
import model.ServerConnection;
import model.UserInfo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Controller {
	private String email;
	private String password;
	private Gson gson;
	private UserInfo userInfo;
	private QOTD qOTD;
	private Forecasts forecasts;
	private Events events;
	private Screen screen;
	private ServerConnection serverConnection;
	private Calendars calendars;

	public Controller() {

		screen = new Screen();
		screen.getLoginPanel().addActionListener(new LoginPanelActionListener());
		screen.getMainPanel().addActionListener(new MainPanelActionListener());
		screen.getForecastPanel().addActionListener(new ForecastPanelActionListener());
		screen.getCalendarPanel().addActionListener(new CalendarPanelActionListener());
		screen.getCalendarListPanel().addActionListener(new CalendarListPanelActionListener());
		events = new Events();
		serverConnection = new ServerConnection();
		gson = new GsonBuilder().create();
		userInfo = new UserInfo();
		qOTD = new QOTD();
		forecasts = new Forecasts();
		calendars = new Calendars();
	}

	public void run(){

		screen.show(Screen.LOGINPANEL);
		screen.setVisible(true);

	}
	
	public void resetCalendars(){
		String gsonString = gson.toJson(events);
		String calendar = null;
		try {
		calendar = serverConnection.getFromServer(gsonString);
		events = gson.fromJson(calendar, Events.class);
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		for(int i = 0; i<events.events.size(); i++) {

			Vector<Object> row = new Vector<Object>();
			row.addElement(events.events.get(i).getEventid());
			row.addElement(events.events.get(i).getType());
			row.addElement(events.events.get(i).getDescription());
			row.addElement(events.events.get(i).getStartdate().toString());
			row.addElement(events.events.get(i).getEnddate().toString());
			row.addElement(events.events.get(i).getLocation());
			row.addElement(events.events.get(i).getNote());
			data.addElement(row);
		}
		screen.getCalendarPanel().setEvents(data);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
	}

	private class LoginPanelActionListener implements ActionListener // Klasse der implementere actionlistener
	{
		public void actionPerformed(ActionEvent e) // metode der bliver kørt når en knap trykkes i login panelet
		{
			String cmd = e.getActionCommand(); // lokal string der gemmer actioncommand

			if(cmd.equals("LoginBtn")) // hvis actioncommand er "LoginBtn"
			{				
				serverConnection.connect();
				email = screen.getLoginPanel().getUserName_Login(); 
				password = screen.getLoginPanel().getPassword_Login();
				userInfo.setUsername(email);
				userInfo.setPassword(password);
				String gsonString = gson.toJson(userInfo);
				String info = null;
				try {
					info = serverConnection.getFromServer(gsonString);
					userInfo = gson.fromJson(info, UserInfo.class);
					info = userInfo.getAuthenticated();
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				if(info.equals("0")){
					screen.show(Screen.MAINPANEL);

				}
				else if (!info.equals("0")){
					screen.getLoginPanel().reset();
					screen.getLoginPanel().incorrect(); 
				}

			} 
		} 
	}

	private class MainPanelActionListener implements ActionListener // Klasse der implementere actionlistener
	{
		public void actionPerformed(ActionEvent e) // metode der bliver kørt når en knap trykkes i login panelet
		{
			String cmd = e.getActionCommand(); // lokal string der gemmer actioncommand
			if(cmd.equals("btnQotd")){
				String gsonString = gson.toJson(qOTD);
				String qoute = null;
				try {
					qoute = serverConnection.getFromServer(gsonString);
					qOTD = gson.fromJson(qoute, QOTD.class);
					screen.getMainPanel().setQoute(qOTD.getQuote());
				}
				catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}

			}

			else if (cmd.equals("btnLogout")){

				try {
					screen.getMainPanel().reset();
					screen.getLoginPanel().reset();
					serverConnection.close();
					screen.show(screen.LOGINPANEL);
				} catch (IOException e1) {
					e1.printStackTrace();
				}


			}

			else if(cmd.equals("btnWeather")) {
				String gsonString = gson.toJson(forecasts);
				String weather = null;
				try {
					weather = serverConnection.getFromServer(gsonString);
					forecasts = gson.fromJson(weather, Forecasts.class);

					Vector<Vector<Object>> data = new Vector<Vector<Object>>();

					for(int i = 0; i<7; i++) {
						Vector<Object> row = new Vector<Object>();
						row.addElement(forecasts.forecasts.get(i).getDate().substring(0,10));
						row.addElement(forecasts.forecasts.get(i).getCelsius());
						row.addElement(forecasts.forecasts.get(i).getDesc());
						data.addElement(row);
					}
					screen.getForecastPanel().createTable(data);

				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				screen.show(screen.FORECASTPANEL);
			}

			else if (cmd.equals("btnViewCalendar")){
				screen.setSize(880,500);
				resetCalendars();
				screen.show(screen.CALENDARPANEL);
			}

		}
	}
	private class ForecastPanelActionListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String cmd = e.getActionCommand();

			if (cmd.equals("btnBackToMain")) {
				screen.show(screen.MAINPANEL);
			}

		}
	} 
	private class CalendarPanelActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			String cmd = e.getActionCommand();

			if(cmd.equals("btnCalendars"))
			{
				String gsonString = gson.toJson(calendars);
				String calendarInfo = null;

				try{
					calendarInfo = serverConnection.getFromServer(gsonString);
					calendars = gson.fromJson(calendarInfo, Calendars.class);
					Vector<Vector<Object>> data = new Vector<Vector<Object>>();

					for(int i = 0; i<calendars.calendars.size(); i++) {
						Vector<Object> row = new Vector<Object>();
						row.addElement(calendars.calendars.get(i).getCalendarname());
						row.addElement(calendars.calendars.get(i).getUsername());
						data.addElement(row);
					}
					screen.getCalendarListPanel().setCalendars(data);
				} catch (UnknownHostException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				screen.show(screen.CALENDARLISTPANEL);
			}
			
			if (cmd.equals("btnAddNote")){
				
				String note = screen.getCalendarPanel().getNote();
				String eventID = screen.getCalendarPanel().getSelectedEvent();
				Event event = new Event(null, eventID, null, null, null, null, null);
				event.setNote(note);
				event.setOverallID("createNote");
				String gsonString = gson.toJson(event);
				try {
					serverConnection.getFromServer(gsonString);
					resetCalendars();
				} catch (ClassNotFoundException
						| IOException e1) {
					e1.printStackTrace();
				}
			}
			if (cmd.equals("btnDeleteNote")){
				String eventID = screen.getCalendarPanel().getSelectedEvent();
				Event event = new Event(null, eventID, null, null, null, null, null);
				event.setOverallID("deleteNote");
				String gsonString = gson.toJson(event);
				try {
					serverConnection.getFromServer(gsonString);
					resetCalendars();
				} catch (ClassNotFoundException
						| IOException e1) {
					e1.printStackTrace();
				}
				
			}
			if (cmd.equals("btnBack")) {
				screen.setSize(460, 519);
				screen.show(screen.MAINPANEL);
			}	
		}

	}
	
	private class CalendarListPanelActionListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			
		}
		
	}

}


