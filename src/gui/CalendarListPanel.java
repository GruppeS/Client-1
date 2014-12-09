package gui;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class CalendarListPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton btnBack;
	private JButton btnDelete;
	private JCheckBox isPublic;
	private JLabel lblCalendarName;
	private JButton btnCreate;
	private JLabel lblShareWith;
	private JTextField textShare;
	private JTextField textCalendar;
	private JLabel lblCalendars;
	private JButton btnShare;
	private JScrollPane scrollPane;
	private JTable table;

	Vector<Object> columnNames = new Vector<Object>();

	public CalendarListPanel() {
		setLayout(null);

		btnBack = new JButton("Back to Main Menu");
		btnBack.setBounds(200, 332, 150, 23);
		add(btnBack);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(30, 332, 104, 23);
		add(btnDelete);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 33, 320, 288);
		add(scrollPane);
		
		textCalendar = new JTextField();
		textCalendar.setBounds(376, 206, 104, 20);
		add(textCalendar);
		textCalendar.setColumns(10);
		
		isPublic = new JCheckBox("Public");
		isPublic.setBounds(376, 233, 97, 23);
		add(isPublic);
		
		lblCalendarName = new JLabel("Calendar name:");
		lblCalendarName.setBounds(376, 184, 133, 14);
		add(lblCalendarName);
		
		btnCreate = new JButton("Create calendar");
		btnCreate.setBounds(376, 263, 133, 23);
		add(btnCreate);
		
		lblShareWith = new JLabel("Share with:");
		lblShareWith.setBounds(375, 33, 122, 14);
		add(lblShareWith);
		
		textShare = new JTextField();
		textShare.setBounds(375, 71, 122, 20);
		add(textShare);
		textShare.setColumns(10);
		
		lblCalendars = new JLabel("Calendars");
		lblCalendars.setBounds(30, 8, 104, 23);
		add(lblCalendars);
		
		btnShare = new JButton("Share");
		btnShare.setBounds(375, 108, 97, 23);
		add(btnShare);
	}

	public void setCalendars(Vector<?> data) {
		columnNames = new Vector<Object>();
		columnNames.add("Calendar");
		columnNames.add("Created By");
		table = new JTable(data, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
	}
	
	public String getSelectedCalendar() {
		String selectedCalendar;
		
		int row = table.getSelectedRow();
		
		if(row!=-1)
		{
			selectedCalendar = (table.getValueAt(row, 0)).toString();
		} else {
			selectedCalendar = null;
		}
		
		return selectedCalendar;
	}
	
	public String getCalendar() {
		return textCalendar.getText();
	}
	public boolean getIsPublic() {
		return isPublic.isSelected();
	}
	public String getShareWith() {
		return textShare.getText();
	}
	
	public void addActionListener(ActionListener l)
	{
		btnBack.addActionListener(l);
		btnBack.setActionCommand("btnBack");
		btnDelete.addActionListener(l);
		btnDelete.setActionCommand("btnDelete");
		btnCreate.addActionListener(l);
		btnCreate.setActionCommand("btnCreate");
		btnShare.addActionListener(l);
		btnShare.setActionCommand("btnShare");
	}
}
