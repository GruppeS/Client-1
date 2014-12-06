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
	private JLabel lblMandag;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JLabel lblTirsdag;
	private JLabel lblOnsdag;
	private JLabel lblTorsdag;
	private JLabel lblFredag;
	private JLabel lblLrdag;
	private JLabel lblSndag;

	public WeekPanel (){
		setLayout(null);

		btnBack = new JButton("Back to main");
		btnBack.setBounds(558, 382, 145, 26);
		add(btnBack);

		lblCalendar = new JLabel("Calendar");
		lblCalendar.setBounds(266, 11, 114, 26);
		add(lblCalendar);

		lblMandag = new JLabel("Mandag");
		lblMandag.setBounds(41, 55, 46, 14);
		add(lblMandag);

		lblTirsdag = new JLabel("Tirsdag");
		lblTirsdag.setBounds(139, 55, 46, 14);
		add(lblTirsdag);

		lblOnsdag = new JLabel("Onsdag");
		lblOnsdag.setBounds(242, 55, 46, 14);
		add(lblOnsdag);

		lblTorsdag = new JLabel("Torsdag");
		lblTorsdag.setBounds(334, 55, 46, 14);
		add(lblTorsdag);

		lblFredag = new JLabel("Fredag");
		lblFredag.setBounds(435, 55, 46, 14);
		add(lblFredag);

		btn1 = new JButton("");
		btn1.setBounds(20, 80, 89, 300);
		add(btn1);

		btn2 = new JButton("");
		btn2.setBounds(119, 80, 89, 300);
		add(btn2);

		btn3 = new JButton("");
		btn3.setBounds(218, 80, 89, 300);
		add(btn3);

		btn4 = new JButton("");
		btn4.setBounds(317, 80, 89, 300);
		add(btn4);

		btn5 = new JButton("");
		btn5.setBounds(416, 80, 89, 300);
		add(btn5);

		btn6 = new JButton("");
		btn6.setBounds(515, 80, 89, 300);
		add(btn6);

		btn7 = new JButton("");
		btn7.setBounds(614, 80, 89, 300);
		add(btn7);

		lblLrdag = new JLabel("L\u00F8rdag");
		lblLrdag.setBounds(536, 55, 46, 14);
		add(lblLrdag);

		lblSndag = new JLabel("S\u00F8ndag");
		lblSndag.setBounds(632, 55, 46, 14);
		add(lblSndag);

	}

	public void addActionListener(ActionListener l) {
		btnBack.addActionListener(l);
		btnBack.setActionCommand("btnBack");
	}

	public void buttonText(String btn1, String btn2, String btn3, String btn4, String btn5, String btn6, String btn7){
		this.btn1.setText(btn1);
		this.btn2.setText(btn2);
		this.btn3.setText(btn3);
		this.btn4.setText(btn4);
		this.btn5.setText(btn5);
		this.btn6.setText(btn6);
		this.btn7.setText(btn7);
	}
}


