package com.halim;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserGui extends JFrame{
	
	private UserAgent user;
	private JTextField resFiled;
	public UserGui(UserAgent user) {
		this.user = user;
		this.initComponemt();
	}
	public  void initComponemt() {
		
		this.setSize(400,400);
		this.setResizable(false);
		this.setTitle("agent with a gui ");
		this.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
		JPanel panel1 = new JPanel();
		panel1.setBorder( new EmptyBorder(80, 0, 5, 0) );
		panel1.setLayout(new FlowLayout());
		
		JLabel l1 = new JLabel("Nomber 1: ");
		JTextField field1 = new JTextField(30);
	
		panel1.add(l1); panel1.add(field1);
		
		
		  JPanel panel2 = new JPanel();
		  panel2.setLayout(new FlowLayout());
		  
		  JLabel l2 = new JLabel("Nomber 2 : ");
		  JTextField field2 = new JTextField(30);
		  panel2.add(l2); panel2.add(field2);
		
		  
		  JPanel panelOpration = new JPanel();
		  panelOpration.setLayout(new FlowLayout());
		  
		  JLabel opL = new JLabel("Operation : ");
		  String[] sts = {"+","-","*","/"};
		  JComboBox combo = new JComboBox(sts);
		  combo.setBounds(getBounds().x,getBounds().y, 50, 20);
		  panelOpration.add(opL); panelOpration.add(combo);
		  
		JButton submit = new JButton("Calculer");
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				float nb1 = Float.parseFloat(field1.getText());
				float nb2 = Float.parseFloat(field2.getText());
				String operation = combo.getSelectedItem().toString();
				user.setNombres(nb1, nb2,operation);
			}
		});
		JPanel panel3 = new JPanel();
		panel3.setLayout(new FlowLayout());
		panel3.add(submit);
		
		
		JLabel res = new JLabel("resultat :");
		resFiled = new JTextField(30);
		resFiled.setText("...");
		JPanel resP = new JPanel();
		resP.setLayout(new FlowLayout());
		resP.setBorder( new EmptyBorder(20, 0, 5, 0) );
		resP.add(res); resP.add(resFiled);
		 
		
		JPanel helper = new JPanel();
		helper.setAlignmentY(CENTER_ALIGNMENT);
		helper.setLayout(new FlowLayout());
		helper.setLayout(new FlowLayout());
		helper.add(panel1);
		helper.add(panel2);
		helper.add(panelOpration);
		helper.add(panel3);
		helper.add(resP);
		
		
		this.add(helper);
		this.setVisible(true);
		
	}
	public void setRes(float res) {
		this.resFiled.setText(res+"");
	}

}
