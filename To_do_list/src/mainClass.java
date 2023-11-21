import java.awt.Font;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.formdev.flatlaf.FlatDarculaLaf;

import net.miginfocom.swing.MigLayout;

public class mainClass {

	private JFrame mainwindow = new JFrame();
	private JLabel title = new JLabel("To Do List");
	
	public mainClass () {
		toDoList toDoList = new toDoList();
		inputFeild inputFeild = new inputFeild();
		mainwindow.setLayout(new MigLayout());
		mainwindow.add(title, "wrap, pushx, center, gapbottom 30");
		mainwindow.add(inputFeild.getInputPanel(), "center, wrap");
		mainwindow.add(toDoList.getToDoListPanel(), "growx, pushx, gaptop 30");
		
		
		mainwindow.getRootPane().setDefaultButton(inputFeild.getAddButton());
		inputFeild.getAddButton().requestFocus();
		
		
		mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainwindow.setVisible(true);
		mainwindow.setLocationRelativeTo(null);
		mainwindow.setSize(600, 600);
		title.setFont(new Font("Arial", Font.PLAIN, 50)); 
		
	}
	
	public static void main (String [] Args) {
		FlatDarculaLaf.setup();
		mainClass main = new mainClass();
		

	}
}
