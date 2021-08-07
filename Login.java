package ATM_Project;
import java.awt.*;


import java.sql.*;
import java.sql.ConnectionBuilder;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login implements ActionListener{ 
	JFrame j=new JFrame();
	JLabel l,l1,l2;
	JTextField t1;
	JPasswordField p1;
	JButton b1,b2,b3;
	JCheckBox sp;
	
	Login()
	{
		//JFrame.setDefaultLookAndFeelDecorated(true);
		
		
		j.getContentPane().setBackground(Color.GRAY);;
		
		j.setTitle("ATM Interface");
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setBounds(10,10,450,600);
		
		
	    l=new JLabel("WELCOME TO ATM");
		l.setFont((new Font("Times New Roman",Font.BOLD,20)));
		l.setBounds(130, 50, 200, 30);
		l.setForeground(Color.WHITE);
		
		l1=new JLabel("Phone Number ");
		l1.setFont((new Font ("Times New Roman",Font.BOLD,15)));
		l1.setBounds(50, 150, 130, 30);
		l1.setForeground(Color.BLACK);
		
		l2=new JLabel("Pin");
		l2.setFont((new Font("Times New Roman",Font.BOLD,15)));
		l2.setBounds(50, 220, 100, 30);
		l2.setForeground(Color.BLACK);
		
		t1=new JTextField();
		t1.setFont(new Font("Times New Roman",Font.PLAIN,15));
		t1.setBounds(170, 150, 200, 30);
		t1.setForeground(Color.BLACK);
		
		p1=new JPasswordField();
		p1.setFont(new Font("Times New Roman",Font.PLAIN,15));
		p1.setBounds(170, 220, 200, 30);
		p1.setForeground(Color.BLACK);
		
		sp=new JCheckBox("    Show Password");
		sp.setFont(new Font("Times New Roman",Font.PLAIN,15));
		sp.setBounds(170, 270, 200, 30);
		sp.setForeground(Color.BLACK);
		sp.addActionListener(this);
		
		
		
		b1=new JButton("Login");
		b1.setFont(new Font("Times New Roman",Font.PLAIN,15));
		b1.setBounds(110, 370, 100, 30);
		b1.setForeground(Color.BLUE);
		b1.addActionListener(this);
		
		b2=new JButton("Reset");
		b2.setFont(new Font("Times New Roman",Font.PLAIN,15));
		b2.setBounds(250, 370, 100, 30);
		b2.setForeground(Color.BLUE);
		b2.addActionListener(this);
		
		b3=new JButton("Sign Up");
		b3.setFont(new Font("Times New Roman",Font.PLAIN,15));
		b3.setBounds(180, 420, 100, 30);
		b3.setForeground(Color.BLUE);
		b3.addActionListener(this);
		
		
		j.add(l);
		j.add(l1);
		j.add(l2);
		j.add(t1);
		j.add(p1);
		j.add(sp);
		j.add(b1);
		j.add(b2);
		j.add(b3);
		
		j.setBounds(370, 130, 460, 500);
		j.setLayout(null);
		j.setVisible(true);
		j.setResizable(false);
		
		
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
	try 
	{
		Connection con=null;
		String Driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/atm";
		String username="root";
		String pass="Meenu@27";
		
		if(a.getSource()==b1)
		{
			String s=t1.getText();
			String s1=p1.getText();
			
			
			Class.forName(Driver);
			con = DriverManager.getConnection(url, username, pass);
			PreparedStatement st=con.prepareStatement("select * from account where contact_no='"+s+"' AND pin='"+s1+"'");
						//st.setString(1,s);
						//st.setString(2,s1);
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				new MainPage(s1).setVisible(true);
				j.dispose();
							
			}
			else
			{
			JOptionPane.showMessageDialog(j, "Invalid Login ");
			}
						
					
		}
			    	
			    
		if(a.getSource()==b2)
		{
			t1.setText("");
			p1.setText("");
			JOptionPane.showMessageDialog(b2, "Login Page is Reseted");
		}
		
	    if(a.getSource()==sp)
		{
			if(sp.isSelected())
			{
				p1.setEchoChar((char) 0);
			}
			else
			{
				p1.setEchoChar('*');
			}
		}
		
	    if(a.getSource()==b3)
		{
			JOptionPane.showMessageDialog(b3, "Create a New Account");
			SignUp s=new SignUp();
			s.setVisible(true);
			j.dispose();
			
		}	
	}
		catch(Exception e) 
		{}
			
	}
	

	public void setVisible(boolean b)
	{}
	
	public static void main(String[] args) {
		Login l=new Login();
		
		


	}
	
	

}
