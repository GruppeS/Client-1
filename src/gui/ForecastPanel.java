package gui;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ForecastPanel extends JPanel {
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
		columnNames.add("");
		columnNames.add("");
		columnNames.add("");
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
	}
}
