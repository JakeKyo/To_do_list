import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import net.miginfocom.swing.MigLayout;

public class toDoList {

	
	private static DefaultTableModel todotablemodel = new DefaultTableModel(0, 3);
	private static JTable todotable = new JTable(todotablemodel);
	private JPanel todolistpanel = new JPanel();
	
	
	public toDoList() {

		todotable.setRowMargin(10);
		todotable.setRowHeight(30);
		todolistpanel.setLayout(new MigLayout());
		todotable.setVisible(true);
		todotable.setFont(new Font("Serif", Font.BOLD, 16));
		todotable.getColumnModel().getColumn(0).setPreferredWidth(800);
		todolistpanel.add(todotable, "growx, pushx");
		todolistpanel.setVisible(true);
	}
	
	
	public JPanel getToDoListPanel () {
		return this.todolistpanel;
	}
	
	
	public static void filltable (String task, int priority) {
		
		 
		LocalTime time = LocalTime.now();
		StringBuilder timestring = new StringBuilder();
		
		for (int i = 0; i < 5; i++) {
			System.out.println(time.toString().charAt(i));
			timestring.append(time.toString().charAt(i));
		}

	    String [] tabledata = new String [3];
	    
	    if (priority == 1) {
	    	tabledata [2] = "High";
	    }
	    
	    else if (priority == 2) {
	    	tabledata [2] = "Med";
	    }
	    	
	    else if (priority == 3) {
	    	tabledata [2] = "Low";
	    }
	    
	    
	    tabledata [0] = task;
	    tabledata [1] = timestring.toString();
	    
	    
	    
	    todotable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer (){
	        /**
			 * 
			 */
	    	
	    	
	    	
			private static final long serialVersionUID = 1L;

			@Override
	        public Component getTableCellRendererComponent(JTable table,
	                Object value, boolean isSelected, boolean hasFocus, int row, int col) {


	            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);

	           
	            String status = (String)table.getModel().getValueAt(row, 2);
	            
	            if ("High".equals(status)) {
	                setBackground(Color.RED);
	                setForeground(Color.WHITE);
	            } 
	            
	            else if ("Med".equals(status)) {
	            	setBackground(Color.ORANGE);
	                setForeground(Color.WHITE);
	            }
	            
	            else if ("Medium".equals(status)) {
	            	setBackground(Color.WHITE);
	                setForeground(Color.BLACK);
	            }
	            
	            else {
	                setBackground(table.getBackground());
	                setForeground(table.getForeground());
	            } 
	            
	            
	            
	            
	            
	            
	            return this;
	        }  
			
			
			
	    });
	    
	    
	    
	    
	    todotablemodel.addRow(tabledata);
				
		
	}
	
	
}
