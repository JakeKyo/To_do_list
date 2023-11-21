import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class inputFeild {
	
	private JTextField todoinput = new JTextField("What do you need to do today?");
	private JButton addbutton = new JButton("ADD");
	private JRadioButton highradio = new JRadioButton("High Priority");
	private JRadioButton middleradio = new JRadioButton("Medium Priority");
	private JRadioButton lowradio = new JRadioButton("Low Priority");
	private JRadioButton invisiblebutton = new JRadioButton();
	private JPanel inputpanel = new JPanel();
	
	Font font1 = new Font("SansSerif", Font.PLAIN, 15);
	
	
	
	public inputFeild() {
		
		inputpanel.setLayout(new MigLayout());
		
		inputpanel.add(highradio, "skip2, wrap, growx");
		inputpanel.add(todoinput, "gapright 20, width 300, height 40");
		inputpanel.add(addbutton, "gapright 20");
		inputpanel.add(middleradio, "wrap");
		inputpanel.add(lowradio, "skip2, growx");
		
		ButtonGroup radios = new ButtonGroup();
		radios.add(highradio);
		radios.add(middleradio);
		radios.add(lowradio);
		radios.add(invisiblebutton);
		invisiblebutton.setVisible(false);
		
		inputpanel.setBorder(BorderFactory.createTitledBorder(null, "What's On The Menu Today?", TitledBorder.CENTER, 0, new Font("times new roman",Font.PLAIN,20), Color.WHITE));
		
		
		
		highradio.setFont(font1);
		highradio.setBackground(Color.RED);
		highradio.setForeground(Color.WHITE);
		middleradio.setFont(font1);
		middleradio.setBackground(Color.ORANGE);
		middleradio.setForeground(Color.WHITE);
		lowradio.setFont(font1);
		lowradio.setBackground(Color.WHITE);
		lowradio.setForeground(Color.BLACK);
		
		todoinput.setBackground(Color.white);
		todoinput.setForeground(Color.BLACK);
		todoinput.setFont(font1);
		
		todoinput.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                todoinput.setText("");
            }
        });
		
		
		addbutton.setBackground(Color.white);
		addbutton.setForeground(Color.BLACK);
		addbutton.setFont(font1);
		
		
		addbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             toDoList.filltable(todoinput.getText(), checkpriotirty());
             todoinput.setText(null);
             highradio.setSelected(false);
             middleradio.setSelected(false);
             lowradio.setSelected(false);
             invisiblebutton.setSelected(true);
             
        }});
	}
	
	
	public JTextField getToDoInput() {
		return this.todoinput;
	}
	
	
	public JButton getAddButton() {
		return this.addbutton;
	}
	
	
	public JPanel getInputPanel() {
		return this.inputpanel;
	}
	
	
	public int checkpriotirty () {
		if (highradio.isSelected()) {
			return 1;
		}
		
		else if (middleradio.isSelected()) {
			return 2;
		}
		
		else if (lowradio.isSelected()) {
			return 3;
		}
		
		else {
			return 0;
		}
		
	}
	
	
	
	

}
