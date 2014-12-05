package gui; // en del af ui

// importerer de nødvendige pakker fra swing og cardlayout
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Screen extends JFrame // Screen klasse der extender JFrame
{
	// instansvariable
	private static final long serialVersionUID = 1L; // id for screen
	
	//final static strenge til at kalde de korresponderende paneler
	public static final String MAINPANEL = "1";
	public static final String LOGINPANEL = "2";
	public static final String FORECASTPANEL = "3";
	public static final String WEEKPANEL = "4";
	public static final String DAYPANEL = "5";

	// variable til at holde på objekter af JPanel
	private JPanel contentPane;
	private LoginPanel loginPanel;
	private MainPanel mainPanel;
	private ForecastPanel forecastPanel;
	private WeekPanel weekPanel;
	
	
	CardLayout c; //variabel til at holde på cardlayout

	/**
	 * Constructer that holds the frame and an object for every panel
	 */
	public Screen() // konstruktør
	{
		setTitle("DoekCalendar"); // titel på vindue
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Programmet lukkes ned når vinduet lukkes
		setBounds(100, 100, 460, 519); // størrelsen på vinduet
		contentPane = new JPanel(); // der oprettes et tomt panel
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0)); // størrelsen på vinduet
		setContentPane(contentPane); // det tomme panel sættes i vinduet
		contentPane.setLayout(new CardLayout(0, 0)); // panelets layout sættes som et cardlayout

		// Der laves objekter af alle paneler og disse tilføjes contentpane, sammen med et kaldenavn

		loginPanel = new LoginPanel();
		contentPane.add(loginPanel, LOGINPANEL);
		
		mainPanel = new MainPanel();
		contentPane.add(mainPanel, MAINPANEL);
		
		forecastPanel = new ForecastPanel();
		contentPane.add(forecastPanel, FORECASTPANEL);
		
		weekPanel = new WeekPanel();
		contentPane.add(weekPanel, WEEKPANEL);

		c = (CardLayout) getContentPane().getLayout(); // cardlayoutet sættes til kunne bestå af de forskellige contentpanes
	} // konstruktør slutter
	
	public void setSize(int h, int w){
		setBounds(0,0, h, w);
	}

	
	// getters og setters til paneler

	/**
	 * @return loginPanel
	 */
	public LoginPanel getLoginPanel() {
		return loginPanel; 
	}
	
	public MainPanel getMainPanel(){ 
		return mainPanel;
	}
	public ForecastPanel getForecastPanel(){
		return forecastPanel;
	}
	
	public WeekPanel getWeekPanel(){
		return weekPanel;
	}
	/**
	 * @param card
	 */
	public void show(String card) // metode til at skifte mellem de forskellige paneler gennem cardlayout
	{
		c.show(getContentPane(), card); // cardlayout viser den contentpane der bliver sendt gennem argumentet
	} // metoden slutter
} // klassen slutter