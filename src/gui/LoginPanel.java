package gui; // En del af ui

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel // LoginPanel klasse der extender JPanel
{ 
	private static final long serialVersionUID = 1L; // Genereret ID
	
	// instansvariable til at holde på JLabels, JTextFields og JButtons
	private JLabel lblNewLabel;
	private JLabel lblPleaseLoginBelow;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblBackground;
	private JLabel lblIncorrect;
	private JTextField userName_Login;
	private JPasswordField password_Login;
	private JButton btnLogin;


	/**
	 * Constructer that adds the necessary layout and buttons for the Loginpanel
	 */
	public LoginPanel() // konstruktør der sætter panelets udseende
	{
		setLayout(null); // absolut layout

		// JLabels
		lblNewLabel = new JLabel("Welcome to Calendar");
		lblNewLabel.setBounds(118, 97, 194, 24); // Størrelse og placering
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 19)); // Tekst formattering
		add(lblNewLabel); // Tilføj til panel

		lblPleaseLoginBelow = new JLabel("Please login below:");
		lblPleaseLoginBelow.setBounds(155, 145, 108, 16);
		lblPleaseLoginBelow.setFont(new Font("Calibri", Font.PLAIN, 12));
		add(lblPleaseLoginBelow);

		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(124, 199, 52, 14);
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 11));
		add(lblUsername);

		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(127, 254, 49, 14);
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 11));
		add(lblPassword);
		
		lblIncorrect = new JLabel("Oops something went wrong");
		lblIncorrect.setBounds(124, 321, 165, 14);
		lblIncorrect.setFont(new Font("Calibri", Font.ITALIC, 11));
		lblIncorrect.setForeground(Color.red);
		lblIncorrect.setVisible(false);
		add(lblIncorrect);

		// JTextField
		userName_Login = new JTextField(); // Opret textfield
		userName_Login.setBounds(127, 224, 143, 20); // Størrelse og placering
		userName_Login.setColumns(10); // Størrelse
		add(userName_Login); // Tilføj til panel
		
		//JPasswordField
		password_Login = new JPasswordField(); // Opret passwordfield
		password_Login.setBounds(127, 278, 143, 20); // Størrelse og placering
		password_Login.setColumns(10); // Størrelse
		add(password_Login); // Tilføj til panel

		//JButton
		btnLogin = new JButton("Login"); // Lav knap og sæt tekst
		btnLogin.setBounds(155, 425, 89, 23); // Størrelse og placering
		add(btnLogin); // Tilføj til panel

	} // Konstruktør slutter


	// metode til at vise label
	public void incorrect()
	{
		lblIncorrect.setVisible(true);
	}
	/**
	 * @return UserName_Login.getText()
	 */
	// getters
	public String getUserName_Login()
	{
		return userName_Login.getText();
	}

	/**
	 * @return Password_Login.getText()
	 */
	@SuppressWarnings("deprecation")
	public String getPassword_Login()
	{
		return password_Login.getText();
	}
	/**
	 * Resets textfields
	 */
	public void reset() // metode der nulstiller panelet
	{
		// skjuler labels
		lblIncorrect.setVisible(false);
		// fjerner tekst i textfields
		password_Login.setText("");
	}
	/**
	 * adds actionlisteners and actioncommands for button
	 * @param l
	 */
	public void addActionListener(ActionListener l) // metode til at tilføje actionlisteners og actioncommands til knapper
	{
		btnLogin.addActionListener(l); // tilføjer actionlistener
		btnLogin.setActionCommand("LoginBtn"); // tilføjer actioncommand
	} // metode slutter

	
}