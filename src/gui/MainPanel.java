package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnViewCalendar;
	private JButton btnQotd;
	private JButton btnWeather;
	private JLabel lblMainMenu;
	
	public MainPanel() {
		setLayout(null);
		
		lblMainMenu = new JLabel("Main menu");
		lblMainMenu.setBounds(85, 11, 127, 35);
		add(lblMainMenu);
		
		btnViewCalendar = new JButton("View calendar");
		btnViewCalendar.setBounds(85, 62, 127, 59);
		add(btnViewCalendar);
		
		btnQotd = new JButton("QOTD");
		btnQotd.setBounds(85, 162, 127, 59);
		add(btnQotd);
		
		btnWeather = new JButton("Weather");
		btnWeather.setBounds(85, 264, 127, 59);
		add(btnWeather);
	}
	public void addActionListener(ActionListener l) // metode til at tilføje actionlisteners og actioncommands til knapper
	{
		btnViewCalendar.addActionListener(l); // tilføjer actionlistener
		btnViewCalendar.setActionCommand("btnViewCalendar"); // tilføjer actioncommand
		btnQotd.addActionListener(l); // tilføjer actionlistener
		btnQotd.setActionCommand("btnQotd"); // tilføjer actioncommand
		btnWeather.addActionListener(l); // tilføjer actionlistener
		btnWeather.setActionCommand("btnWeather"); // tilføjer actioncommand
		
	} // metode slutter
}
