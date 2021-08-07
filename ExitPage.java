package ATM_Project;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ExitPage implements ActionListener {
	JFrame f;
	JLabel l1;
	JButton b;
	
	ExitPage()
	{
		f=new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().setBackground(Color.GRAY);
		
		l1=new JLabel("THANK YOU FOR USING ATM ");
		l1.setForeground(Color.BLACK);
		l1.setFont((new Font("Times New Roman",Font.BOLD,18)));
		l1.setBounds(70,100, 300, 30);
		
		b=new JButton("Exit");
		b.setBackground(Color.BLACK);
		b.setForeground(Color.WHITE);
		b.setFont((new Font("Tahoma",Font.PLAIN,16)));
		b.setBounds(140, 250, 100, 30);
		b.addActionListener(this);
		
		
        f.add(l1);
		f.add(b);
		
		f.setLayout(null);
		f.setBounds(370,130,400, 350);
		f.setVisible(true);
		f.setResizable(false);
		
	}
	
	public void actionPerformed(ActionEvent a)
	{
	
	if(a.getSource()==b)
	{
		MainPage m=new MainPage("");
		m.setVisible(true);
		f.dispose();
		
	}
	
}

	public static void main(String[] args) {
		ExitPage e=new ExitPage();
		

	}

	public void setVisible(boolean c) {
		// TODO Auto-generated method stub
		
	}

}
