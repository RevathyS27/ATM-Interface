package ATM_Project;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage implements ActionListener  {
	
	 JFrame f=new JFrame();
	//JPanel p1,p2;
	JLabel l1,l2,l3,l4,l5;
	JButton b1,b2,b3,b4,b5;
	String pin;
	
	MainPage(String pin)
	{
		this.pin=pin;
		f.getContentPane().setBackground(Color.GRAY);
		//p1=new JPanel();
		//p1.setBounds(12, 10, 410, 440);
		//p2=new JPanel();
		
		l1=new JLabel("What would you like to do for Today ?");
		l1.setForeground(Color.BLACK);
		l1.setFont((new Font("Times New Roman",Font.ROMAN_BASELINE,18)));
		l1.setBounds(20, 50, 400, 30);
		
		l2=new JLabel("Cash Withdrawal");
		l2.setForeground(Color.WHITE);
		l2.setFont((new Font("Times New Roman",Font.BOLD,15)));
		l2.setBounds(60, 150, 200, 30);
		
		b1=new JButton("1");
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.DARK_GRAY);
		b1.setFont((new Font("Times New Roman",Font.ROMAN_BASELINE,15)));
		b1.setBounds(0, 150, 50, 30);
		b1.addActionListener(this);
		
		l3=new JLabel("Deposit");
		l3.setForeground(Color.WHITE);
		l3.setFont((new Font("Times New Roman",Font.BOLD,15)));
		l3.setBounds(60, 200, 200, 30);
		
		b2=new JButton("2");
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.DARK_GRAY);
		b2.setFont((new Font("Times New Roman",Font.ROMAN_BASELINE,15)));
		b2.setBounds(0, 200, 50, 30);
		b2.addActionListener(this);
		
		l4=new JLabel("Balance Enquiry");
		l4.setForeground(Color.WHITE);
		l4.setFont((new Font("Times New Roman",Font.BOLD,15)));
		l4.setBounds(280, 150, 200, 30);
		
		b3=new JButton("3");
		b3.setForeground(Color.WHITE);
		b3.setBackground(Color.DARK_GRAY);
		b3.setFont((new Font("Times New Roman",Font.ROMAN_BASELINE,15)));
		b3.setBounds(400, 150, 50, 30);
		b3.addActionListener(this);
		
		l5=new JLabel("Change PIN");
		l5.setForeground(Color.WHITE);
		l5.setFont((new Font("Times New Roman",Font.BOLD,15)));
		l5.setBounds(280, 200, 200, 30);
		
		b4=new JButton("4");
		b4.setForeground(Color.WHITE);
		b4.setBackground(Color.DARK_GRAY);
		b4.setFont((new Font("Times New Roman",Font.ROMAN_BASELINE,15)));
		b4.setBounds(400, 200, 50, 30);
		b4.addActionListener(this);
		
		b5=new JButton("QUIT");
		b5.setForeground(Color.WHITE);
		b5.setBackground(Color.BLACK);
		b5.setFont((new Font("Times New Roman",Font.ROMAN_BASELINE,15)));
		b5.setBounds(160, 300, 130, 30);
		b5.addActionListener(this);
		
		f.add(l1);
	    f.add(l2);
	    f.add(l3);
	    f.add(l4);
	    f.add(l5);
	    f.add(b1);
	    f.add(b2);
	    f.add(b3);
	    f.add(b4);
	    f.add(b5);
		
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
		f.setBounds(370,130,465,450);
		f.setVisible(true);
		f.setResizable(false);

	}
	
	public void actionPerformed(ActionEvent a)
	{
		Connection con=null;
		String Driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/atm";
		String username="root";
		String password="Meenu@27";
		
		if(a.getSource()==b1)
		{
			Withdraw  w=new Withdraw();
			w.setVisible(true);
			f.dispose();
		}
		
		if(a.getSource()==b2)
		{
			Deposit d =new Deposit();
			d.setVisible(true);
			f.dispose();
		}
		
		if(a.getSource()==b3)
		{
			 String pinn=JOptionPane.showInputDialog(f, "Enter your Pin");
			
			try {
				
				Class.forName(Driver);
				con=DriverManager.getConnection(url,username,password);
				Statement st=con.createStatement();
				String r=("select balance from account where pin='"+pinn+"'");
				ResultSet rs=st.executeQuery(r);
				if(rs.next())
				{
					String balance=rs.getString("balance");
					JOptionPane.showMessageDialog(f,"Your account balance " + balance);
					ExitPage e=new ExitPage();
					e.setVisible(true);
					f.dispose();
					
				}
		
				
			}
			catch(Exception e)
			{}
		}
		
		if(a.getSource()==b4)
		{
			ChangePin c =new ChangePin(pin);
			c.setVisible(true);
			f.dispose();
		}
		
		
		
		
		if(a.getSource()==b5)
		{
			int opt=JOptionPane.showConfirmDialog(b1, "Do you want to Quit?","Yes",JOptionPane.YES_NO_OPTION);
			if(opt==0)
			{
				Login l=new Login();
				l.setVisible(true);
				f.dispose();
			}
		}
		
		
	}

	public static void main(String[] args) {
		MainPage m=new MainPage("");
		
		

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
