package gui; // en del af ui

// importerer de n�dvendige pakker fra swing og cardlayout
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Screen extends JFrame // Screen klasse der extender JFrame
{
	// instansvariable
	private static final long serialVersionUID = 1L; // id for screen
	
	//final static strenge til at kalde de korresponderende paneler
	public static final String ADMINADD = "1";
	public static final String ADMINEDIT = "2";
	public static final String ADMINPANEL = "3";
	public static final String LOGINPANEL = "4";
	public static final String USERDEPOSIT = "5";
	public static final String USERPANEL = "6";
	public static final String USERPAY = "7";
	public static final String USERTRANSFER = "8";
	public static final String USERWITHDRAW = "9";
	public static final String RECIPIENTPANEL = "10";

	// variable til at holde p� objekter af JPanel
	private JPanel contentPane;
	private LoginPanel loginPanel;
	
	
	CardLayout c; //variabel til at holde p� cardlayout

	/**
	 * Constructer that holds the frame and an object for every panel
	 */
	public Screen() // konstrukt�r
	{
		setTitle("Bitcoin@CBS"); // titel p� vindue
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Programmet lukkes ned n�r vinduet lukkes
		setBounds(100, 100, 336, 519); // st�rrelsen p� vinduet
		contentPane = new JPanel(); // der oprettes et tomt panel
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0)); // st�rrelsen p� vinduet
		setContentPane(contentPane); // det tomme panel s�ttes i vinduet
		contentPane.setLayout(new CardLayout(0, 0)); // panelets layout s�ttes som et cardlayout

		// Der laves objekter af alle paneler og disse tilf�jes contentpane, sammen med et kaldenavn

		loginPanel = new LoginPanel();
		contentPane.add(loginPanel, LOGINPANEL);

		c = (CardLayout) getContentPane().getLayout(); // cardlayoutet s�ttes til kunne best� af de forskellige contentpanes
	} // konstrukt�r slutter

	
	// getters og setters til paneler

	/**
	 * @return loginPanel
	 */
	public LoginPanel getLoginPanel() {
		return loginPanel; // returnerer loginPanel
	}

	/**
	 * @param card
	 */
	public void show(String card) // metode til at skifte mellem de forskellige paneler gennem cardlayout
	{
		c.show(getContentPane(), card); // cardlayout viser den contentpane der bliver sendt gennem argumentet
	} // metoden slutter
} // klassen slutter