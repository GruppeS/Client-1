package gui;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WeekPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JScrollPane scrollPane;
	private JLabel lblCalendar;
	private JTable table;
	private JButton btnBack;
	
	Vector<Object> columnNames = new Vector<Object>();

	public WeekPanel (){
		setLayout(null);
		
		btnBack = new JButton("Back to main");
		btnBack.setBounds(706, 390, 145, 26);
		add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 841, 300);
		add(scrollPane);
		
		lblCalendar = new JLabel("Calendar");
		lblCalendar.setBounds(10, 6, 172, 43);
		add(lblCalendar);

	}
	
	public void createTable(Vector<?> data) {
		columnNames = new Vector<Object>();
		columnNames.add("ID");
		columnNames.add("Type");
		columnNames.add("Event");
		columnNames.add("Start");
		columnNames.add("End");
		columnNames.add("Lokation");
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
	}
	public void addActionListener(ActionListener l) {
		btnBack.addActionListener(l);
		btnBack.setActionCommand("btnBack");
}

}


