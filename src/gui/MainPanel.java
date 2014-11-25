package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class MainPanel extends JPanel {
	public MainPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Main menu");
		lblNewLabel.setBounds(85, 11, 127, 35);
		add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View calendar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(85, 62, 127, 59);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("QOTD");
		btnNewButton_1.setBounds(85, 162, 127, 59);
		add(btnNewButton_1);
		
		JButton btnWeather = new JButton("Weather");
		btnWeather.setBounds(85, 264, 127, 59);
		add(btnWeather);
	}
}
