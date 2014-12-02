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
	public void addActionListener(ActionListener l) // metode til at tilf�je actionlisteners og actioncommands til knapper
	{
		btnViewCalendar.addActionListener(l); // tilf�jer actionlistener
		btnViewCalendar.setActionCommand("btnViewCalendar"); // tilf�jer actioncommand
		btnQotd.addActionListener(l); // tilf�jer actionlistener
		btnQotd.setActionCommand("btnQotd"); // tilf�jer actioncommand
		btnWeather.addActionListener(l); // tilf�jer actionlistener
		btnWeather.setActionCommand("btnWeather"); // tilf�jer actioncommand
		
	} // metode slutter
	
	public void setQoute(String qoute){
		textArea.setText(qoute);
	}
}
