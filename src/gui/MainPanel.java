package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;

public class MainPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	private JButton btnViewCalendar;
	private JButton btnQotd;
	private JButton btnWeather;
	private JLabel lblMainMenu;
	private JTextArea textArea;
	
	public MainPanel() {
		setLayout(null);
		
		lblMainMenu = new JLabel("Main menu");
		lblMainMenu.setBounds(85, 11, 127, 35);
		add(lblMainMenu);
		
		btnViewCalendar = new JButton("View calendar");
		btnViewCalendar.setBounds(10, 63, 127, 59);
		add(btnViewCalendar);
		
		btnQotd = new JButton("QOTD");
		btnQotd.setBounds(85, 133, 127, 59);
		add(btnQotd);
		
		btnWeather = new JButton("Weather");
		btnWeather.setBounds(163, 63, 127, 59);
		add(btnWeather);
		
		textArea = new JTextArea();
		textArea.setBounds(25, 220, 245, 169);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		add(textArea);
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
	
	public void setQoute(String qoute){
		textArea.setText(qoute);
	}
}
