package gui;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;

public class WeekPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel lblCalendar;
	private JButton btnBack;
	private JScrollPane scrollPane;
	private JTable table;

	Vector<Object> columnNames = new Vector<Object>();
	
	public WeekPanel (){
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 841, 300);
		add(scrollPane);
		
		
		btnBack = new JButton("Back to main");
		btnBack.setBounds(558, 382, 145, 26);
		add(btnBack);

	}

	public void addActionListener(ActionListener l) {
		btnBack.addActionListener(l);
		btnBack.setActionCommand("btnBack");
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


	public void buttonText(){

	}
}


