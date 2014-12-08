package gui;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gui.CalendarListPanel;
import gui.EventListPanel;

public class Screen extends JFrame 
{
	private static final long serialVersionUID = 1L; 

	public static final String MAINPANEL = "1";
	public static final String LOGINPANEL = "2";
	public static final String FORECASTPANEL = "3";
	public static final String CALENDARPANEL = "4";
	public static final String DAYPANEL = "5";
	public static final String CALENDARLISTPANEL = "6";
	public static final String EVENTLISTPANEL = "7";

	private JPanel contentPane;
	private LoginPanel loginPanel;
	private MainPanel mainPanel;
	private ForecastPanel forecastPanel;
	private CalendarPanel calendarPanel;
	private CalendarListPanel calendarListPanel;
	private EventListPanel eventListPanel;

	CardLayout c; 
	/**
	 * Constructer that holds the frame and an object for every panel
	 */
	public Screen() 
	{
		setTitle("DoekCalendar"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setBounds(100, 100, 460, 519); 
		contentPane = new JPanel(); 
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane); 
		contentPane.setLayout(new CardLayout(0, 0)); 

		loginPanel = new LoginPanel();
		contentPane.add(loginPanel, LOGINPANEL);

		mainPanel = new MainPanel();
		contentPane.add(mainPanel, MAINPANEL);

		forecastPanel = new ForecastPanel();
		contentPane.add(forecastPanel, FORECASTPANEL);

		calendarPanel = new CalendarPanel();
		contentPane.add(calendarPanel, CALENDARPANEL);
		
		calendarListPanel = new CalendarListPanel();
		contentPane.add(calendarListPanel, CALENDARLISTPANEL);
		
		eventListPanel = new EventListPanel();
		contentPane.add(eventListPanel, EVENTLISTPANEL);

		c = (CardLayout) getContentPane().getLayout(); 
	}

	public void setSize(int h, int w){
		setBounds(0,0, h, w);
	}

	public LoginPanel getLoginPanel() {
		return loginPanel; 
	}

	public MainPanel getMainPanel(){ 
		return mainPanel;
	}
	public ForecastPanel getForecastPanel(){
		return forecastPanel;
	}

	public CalendarPanel getCalendarPanel(){
		return calendarPanel;
	}
	
	public CalendarListPanel getCalendarListPanel() {
		return calendarListPanel;
	}
	
	public EventListPanel getEventListPanel() {
		return eventListPanel;
	}

	public void show(String card) 
	{
		c.show(getContentPane(), card); 
	} 
}