package ATM_Project;
import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;



public class SignUp implements ActionListener {
	
	JFrame f=new JFrame();
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JButton b,b1;
	JTextField t1,t2,t3,t4;
	JPasswordField p1,p2;
	JComboBox c1;
	JCheckBox sp;
	JCheckBox j;
    
	
	SignUp()
	{
		f.getContentPane().setBackground(Color.GRAY);
		
		l1=new JLabel("NEW USER - REGISTERATION");
		l1.setForeground(Color.BLACK);
		l1.setFont((new Font("Times New Roman",Font.BOLD,20)));
		l1.setBounds(90, 50, 300, 30);
		
		l2=new JLabel("Account Number");
		l2.setForeground(Color.BLACK);
		l2.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		l2.setBounds(70, 100, 130, 30);
		
		t1=new JTextField();
		t1.setForeground(Color.BLACK);
		t1.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		t1.setBounds(190, 100, 200, 30);
		
		l3=new JLabel("Bank Name");
		l3.setForeground(Color.BLACK);
		l3.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		l3.setBounds(70, 150, 130, 30);
		
		String[] s= {"Select","Indian Bank","State Bank of India","Axis Bank","Kotak Mahindra Bank","HDFC Bank","Karur Vyasya Bank","Indian Overseas Bank","ICICI Bank","Canara Bank"};
		c1=new JComboBox(s);
		c1.setForeground(Color.BLACK);
		c1.setFont((new Font("Times New Roman",Font.PLAIN,20)));
		c1.setBounds(190, 150, 200, 30);
		
		l4=new JLabel("IFSC Code");
		l4.setForeground(Color.BLACK);
		l4.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		l4.setBounds(70, 200, 130, 30);
		
		t2=new JTextField();
		t2.setForeground(Color.BLACK);
		t2.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		t2.setBounds(190, 200, 200, 30);
		
		l5=new JLabel("Contact Number");
		l5.setForeground(Color.BLACK);
		l5.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		l5.setBounds(70, 250, 130, 30);
		
		t3=new JTextField();
		t3.setForeground(Color.BLACK);
		t3.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		t3.setBounds(190, 250, 200, 30);
		
		
		l6=new JLabel("Email Id");
		l6.setForeground(Color.BLACK);
		l6.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		l6.setBounds(70, 300, 130, 30);
		
		t4=new JTextField();
		t4.setForeground(Color.BLACK);
		t4.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		t4.setBounds(190, 300, 200, 30);
		
		l7=new JLabel("Enter PIN");
		l7.setForeground(Color.BLACK);
		l7.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		l7.setBounds(70, 350, 130, 30);
		
		p1=new JPasswordField();
		p1.setForeground(Color.BLACK);
		p1.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		p1.setBounds(190, 350, 200, 30);
		
		
		l8=new JLabel("Confirm PIN");
		l8.setForeground(Color.BLACK);
		l8.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		l8.setBounds(70, 400, 130, 30);
		
		p2=new JPasswordField();
		p2.setForeground(Color.BLACK);
		p2.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		p2.setBounds(190, 400, 200, 30);
		
		sp=new JCheckBox("Show Password");
		sp.setFont(new Font("Times New Roman",Font.PLAIN,15));
		sp.setBounds(190, 450, 200, 30);
		sp.setForeground(Color.BLACK);
		sp.addActionListener(this);
		
		
		j=new JCheckBox("  I agree to the Terms and Conditions");
		j.setForeground(Color.BLACK);
		j.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		j.setBounds(110, 530, 250, 30);
		
		
		b=new JButton("Submit");
		b.setForeground(Color.BLUE);
		b.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		b.setBounds(120, 580, 100, 30);
		b.addActionListener(this);
		
		b1=new JButton("Cancel");
		b1.setForeground(Color.BLUE);
		b1.setFont((new Font("Times New Roman",Font.PLAIN,15)));
		b1.setBounds(240, 580, 100, 30);
		b1.addActionListener(this);
		
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l7);
		f.add(l8);
		f.add(c1);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(p1);
		f.add(p2);
		f.add(j);
		f.add(b);
		f.add(b1);
		f.add(sp);
		
		f.setTitle("Sign Up Form");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout(null);
        f.setBounds(370,130,500,750);
        f.setVisible(true);
        f.setResizable(false);

				
	}
	
	public void actionPerformed(ActionEvent a)
	{
		Connection con=null;
		String Driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/atm";
		String username="root";
		String pass="Meenu@27";
		if(a.getSource()==sp)
		{
			if(sp.isSelected())
			{
				p1.setEchoChar((char) 0);
				p2.setEchoChar((char) 0);
			}
			else
			{
				p1.setEchoChar('*');
				p2.setEchoChar('*');
			}
		}
		
		if(a.getSource()==b)
		{
			if(j.isSelected())
			{
			String acc_no=t1.getText();
			String bank_name=(String)c1.getSelectedItem();
			String ifsc_code=t2.getText();
			String contact_no=t3.getText();
			String email_id=t4.getText();
			String pin=p2.getText();
			String balance="0";
			
			
			
			
				try{
					Class.forName(Driver);
					con = DriverManager.getConnection(url, username, pass);
					PreparedStatement st=con.prepareStatement("insert into account values ('"+acc_no+"','"+bank_name+"','"+ifsc_code+"','"+contact_no+"','"+email_id+"','"+pin+"','"+balance+"')");
					/*st.setString(1,acc_no);
					st.setString(2,bank_name);
					st.setString(3,ifsc_code);
					st.setString(4,contact_no);
					st.setString(5,email_id);
					st.setString(6, pin); */
					st.executeUpdate(); 
					
					JOptionPane.showMessageDialog(b, "Your Account is Created Successfully");
					Login l=new Login();
					l.setVisible(true);
					
		            f.dispose();
					con.close();
				}
				catch(Exception e){
				JOptionPane.showMessageDialog(f,"Error in submitting data!");
				}
			}
			
			else
			{
				JOptionPane.showMessageDialog(j, "please Accept the terms and Conditions");
			}
				
			}
	
			
			
		if(a.getSource()==b1)
		{
			int opt=JOptionPane.showConfirmDialog(b1, "Do You need to Go Back to the Login Page ?",
					"Yes",JOptionPane.YES_NO_OPTION);
			if(opt==0) {
			Login lf=new Login();
			lf.setVisible(true);
			f.dispose();
			}
			
		}
	}
	
	public static void main(String[] args) {
		SignUp s =new SignUp();
		
	}

	public void setVisible(boolean c) {
		// TODO Auto-generated method stub
		
	}

}
