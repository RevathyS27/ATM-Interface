package ATM_Project;
import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;

public class Withdraw implements ActionListener{
	
	JFrame f;
	JLabel l,l1,l2;
	JTextField t,t1;
	JButton b1,b2,b3;
	
	Withdraw()
	{
		
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.GRAY);
		
		l=new JLabel("Enter Pin");
		l.setBounds(100, 50, 100, 30);
		l.setFont((new Font("Tahoma",Font.CENTER_BASELINE,16)));
		l.setForeground(Color.BLACK);
		
		t=new JTextField();
		t.setForeground(Color.BLACK);
	    t.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
	    t.setBounds(200, 50, 100, 30);
		
	    l1=new JLabel("Maximum Daily Withdrawal is Rs.10000");
		l1.setBounds(50, 100, 350, 30);
		l1.setFont((new Font("Tahoma",Font.CENTER_BASELINE,16)));
		l1.setForeground(Color.BLACK);
		
		l2=new JLabel("Please Enter your Amount ");
		l2.setForeground(Color.BLACK);
		l2.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
		l2.setBounds(120, 150, 200, 30);
		
		t1=new JTextField();
		t1.setForeground(Color.BLACK);
	    t1.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
	    t1.setBounds(170, 200, 100, 30);
	    
	    
	    b1=new JButton("Ok");
	    b1.setForeground(Color.BLUE);
	    b1.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
	    b1.setBounds(110, 250, 100, 30);
	    b1.addActionListener(this);
	    
	    b2=new JButton("Cancel");
	    b2.setForeground(Color.BLUE);
	    b2.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
	    b2.setBounds(220, 250, 100, 30);
	    b2.addActionListener(this);
	    
	    b3=new JButton("Exit");
	    b3.setBackground(Color.BLACK);
	    b3.setForeground(Color.WHITE);
	    b3.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
	    b3.setBounds(170, 300, 100, 30);
	    b3.addActionListener(this);
	    
	    f.add(l);
	    f.add(t);
	    f.add(l1);
	    f.add(l2);
	    f.add(t1);
	    f.add(b1);
	    f.add(b2);
	    f.add(b3);
	    
	    f.setLayout(null);
	    f.setBounds(370,130,450, 380);
	    f.setVisible(true);
	    f.setResizable(false);
	    
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Connection con=null;
		String Driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/atm";
		String username="root";
		String pass="Meenu@27";
	
		if(ae.getSource()==b1)
		{
			 
			 
			 String a=t1.getText();
			 double b=Double.parseDouble(a);
				
				       
			    try {
			    	Class.forName(Driver);
					con = DriverManager.getConnection(url, username, pass);
								
					String sql = "update account set balance = balance - ? where pin = '"+t.getText()+"'";
	                PreparedStatement p = con.prepareStatement(sql);
			               
	                p.setDouble(1, b);
			        p.executeUpdate();
			 
					
				
				
				JOptionPane.showMessageDialog(f," Amount Withdrawed Successfully");
		     	ExitPage e=new ExitPage();
			    e.setVisible(true);
			    f.dispose();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		if(ae.getSource()==b2)
		{
			int opt=JOptionPane.showConfirmDialog(b2,"Do you want to Cancel the Transaction?","yes",JOptionPane.YES_NO_OPTION);
			if(opt==0)
			{
				MainPage m=new MainPage("");
				m.setVisible(true);
				f.dispose();
			}
		}
		
		if(ae.getSource()==b3)
		{
			int opt=JOptionPane.showConfirmDialog(b3,"Do you want to Exit","yes",JOptionPane.YES_NO_OPTION);
			if(opt==0)
			{
				Login l=new Login();
				l.setVisible(true);
				f.dispose();
			}
		}
		
	}
	

	public static void main(String[] args) {
		Withdraw w=new Withdraw();
		

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
