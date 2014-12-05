package logic;

import gui.Screen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Vector;

import model.Calendar;
import model.CalendarInfo;
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
	private Forecast forecast;
	private Calendar calendar;
	private Calendars calendars;
	private CalendarInfo calendarInfo;
	private Event event;
	private Events events;
	private Screen screen;
	private ServerConnection serverConnection;

	public Controller() {

		screen = new Screen();
		screen.getLoginPanel().addActionListener(new LoginPanelActionListener());
		screen.getMainPanel().addActionListener(new MainPanelActionListener());
		screen.getForecastPanel().addActionListener(new ForecastPanelActionListener());
		screen.getWeekPanel().addActionListener(new WeekPanelActionListener());
		calendar = new Calendar(null, null, false);
		calendars = new Calendars();
		calendarInfo = new CalendarInfo();
		event = new Event(null, null, null, null, null, null, null);
		events = new Events();
		serverConnection = new ServerConnection();
		gson = new GsonBuilder().create();
		userInfo = new UserInfo();
		qOTD = new QOTD();
		forecasts = new Forecasts();
		forecast = new Forecast(null, null, null);

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
				serverConnection.connect();
				email = screen.getLoginPanel().getUserName_Login(); 
				password = screen.getLoginPanel().getPassword_Login();
				userInfo.setUsername(email);
				userInfo.setPassword(password);
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
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
					// TODO Auto-generated catch block
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
						row.addElement(forecasts.getForecasts().get(i).getDate().substring(0,10));
						row.addElement(forecasts.getForecasts().get(i).getCelsius());
						row.addElement(forecasts.getForecasts().get(i).getDesc());
						data.addElement(row);
					}
					screen.getForecastPanel().createTable(data);

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
				screen.show(screen.FORECASTPANEL);
			}

			else if (cmd.equals("btnViewCalendar")){
				screen.setSize(880,500);
				String gsonString = gson.toJson(events);
				String calendar = null;
				try {
					calendar = serverConnection.getFromServer(gsonString);
					events = gson.fromJson(calendar, Events.class);

					Vector<Vector<Object>> data = new Vector<Vector<Object>>();

					for(int i = 0; i<25; i++) {
						Vector<Object> row = new Vector<Object>();
						row.addElement(events.getEvents().get(i).getEventid());
						row.addElement(events.getEvents().get(i).getType());
						row.addElement(events.getEvents().get(i).getDescription());
						row.addElement(events.getEvents().get(i).getStart());
						row.addElement(events.getEvents().get(i).getEnd());
						row.addElement(events.getEvents().get(i).getLocation());
						data.addElement(row);
					}
					screen.getWeekPanel().createTable(data);

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
				screen.show(screen.WEEKPANEL);
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
	private class WeekPanelActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			String cmd = e.getActionCommand();

			if (cmd.equals("btnBack")) {
				screen.show(screen.MAINPANEL);
			}
		}
	}


}

