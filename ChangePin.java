package ATM_Project;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePin implements ActionListener {
	JFrame f;
	JLabel l1,l2,l3;
	JPasswordField p1,p2,p3;
	JButton b1,b2,b3;
	 String pin;
	
    ChangePin(String pin)
    {
    	this.pin=pin;
    	f=new JFrame ();
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.getContentPane().setBackground(Color.GRAY);
    	
    	l1=new JLabel("Current PIN ");
    	l1.setForeground(Color.BLACK);
 	    l1.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
 	    l1.setBounds(50, 80, 200, 30);
 	    
 	    p1=new JPasswordField();
 	    p1.setForeground(Color.BLACK);
	    p1.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
	    p1.setBounds(200, 80, 200, 30);
	    
 	    l2=new JLabel("New PIN ");
   	    l2.setForeground(Color.BLACK);
	    l2.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
	    l2.setBounds(50, 130, 200, 30);
	    
	    p2=new JPasswordField();
 	    p2.setForeground(Color.BLACK);
	    p2.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
	    p2.setBounds(200, 130, 200, 30);
	    
	    l3=new JLabel("Re-Enter New PIN ");
    	l3.setForeground(Color.BLACK);
 	    l3.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
 	    l3.setBounds(50, 180, 200, 30);
 	    
 	    p3=new JPasswordField();
	    p3.setForeground(Color.BLACK);
	    p3.setFont((new Font("Tahoma",Font.ROMAN_BASELINE,16)));
	    p3.setBounds(200, 180, 200, 30);
    	
    	try {
    		Connection con=null;
    		String Driver="com.mysql.cj.jdbc.Driver";
    		String url="jdbc:mysql://localhost:3306/atm";
    		String username="root";
    		String pass="Meenu@27";
    		
    		//String s=p1.getText();
    		
    		Class.forName(Driver);
			con = DriverManager.getConnection(url, username, pass);
			PreparedStatement st=con.prepareStatement("select * from account where pin='"+pin+"'");
						//st.setString(1,s);
						//st.setString(2,s1);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				p1.setText(rs.getString("pin"));
			}
		}
    	catch(Exception e) {}
    	
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
 	    b3.setBounds(170, 320, 100, 30);
 	    b3.addActionListener(this);
 	    
 	    f.add(l1);
 	    f.add(l2);
 	    f.add(l3);
 	    f.add(p1);
 	    f.add(p2);
 	    f.add(p3);
 	    f.add(b1);
 	    f.add(b2);
 	    f.add(b3);
 	    
 	    f.setLayout(null);
 	    f.setBounds(370,130,450, 400);
 	    f.setVisible(true);
 	    f.setResizable(false);
 	    
    }
    
    public void actionPerformed(ActionEvent a)
	{
    	try {
    		Connection con=null;
    		String Driver="com.mysql.cj.jdbc.Driver";
    		String url="jdbc:mysql://localhost:3306/atm";
    		String username="root";
    		String pass="Meenu@27";
    		
    	
		if(a.getSource()==b1)
		{
			
			String s1=p3.getText();
			
			Class.forName(Driver);
			con = DriverManager.getConnection(url, username, pass);
			Statement st=con.createStatement();
			String r="update account set pin='"+s1+"'";
			st.executeUpdate(r);
			
			
			
			
			JOptionPane.showMessageDialog(f, "PIN Changed Successfully");
			ExitPage e=new ExitPage();
			e.setVisible(true);
			f.dispose();
			
		}
    	}
    	catch(Exception e)
    	{}
		
		if(a.getSource()==b2)
		{
			int opt=JOptionPane.showConfirmDialog(b2,"Do you want to Cancel the Transaction?","yes",JOptionPane.YES_NO_OPTION);
			if(opt==0)
			{
				MainPage m=new MainPage(pin);
				m.setVisible(true);
				f.dispose();
			}
		}
		
		if(a.getSource()==b3)
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
		ChangePin c=new ChangePin("");
		

	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

}
