package gui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

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
		btnBack.setBounds(431, 371, 79, 26);
		add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(60, 60, 450, 300);
		add(scrollPane);
		
		lblCalendar = new JLabel("Calendar");
		lblCalendar.setBounds(258, 11, 65, 43);
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
		btnBack.setActionCommand("btnBackToMain");
}

}


