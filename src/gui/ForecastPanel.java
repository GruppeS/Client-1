package gui;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ForecastPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JButton btnBackToMain;
	private JScrollPane scrollPane;
	private JTable table;
	
	Vector<Object> columnNames = new Vector<Object>();
	
	public ForecastPanel() {
		setLayout(null);
		
		btnBackToMain = new JButton("Back to main");
		btnBackToMain.setBounds(176, 266, 93, 23);
		add(btnBackToMain);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 430, 244);
		add(scrollPane);
	}
	
	public void createTable(Vector<?> data) {
		columnNames = new Vector<Object>();
		columnNames.add("Day");
		columnNames.add("Temperature");
		columnNames.add("Description");
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
	}
	public void addActionListener(ActionListener l) {
		btnBackToMain.addActionListener(l);
		btnBackToMain.setActionCommand("btnBackToMain");
	}
}
