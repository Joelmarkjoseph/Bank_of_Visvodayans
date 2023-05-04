package New;

import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Newaccount implements ActionListener{
	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
	static JTextField tf1,tf2,tf3,tf4;
	ImageIcon img;
	JButton b1,b2,b3;
	JCheckBox cb1;
	JLabel bg,lab;
	String getname;
	int bal=0,cnumber;
	Newaccount()
	{
		jf= new JFrame("SIGNUP to VISVODAYANS Bank");
		jf.setSize(800,600);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		jf.setLayout(null);
		jf.setLocation(350, 150);
		img = new ImageIcon("C:\\Users\\Joel\\Downloads\\yellowpiggybank.png");
		Image im=img.getImage();
		Image temp_img=im.getScaledInstance(1550, 850, Image.SCALE_SMOOTH);
		img = new ImageIcon(temp_img);
		bg = new JLabel("",img,JLabel.CENTER);
		bg.setBounds(10,10,1515,815);
		l1 = new JLabel("SIGNUP FOR FREE!!");
		l1.setFont(new Font("Algerian",Font.PLAIN,50));
		l1.setBounds(100,20, 1000, 100);
		l6 = new JLabel("New Account?");
		l6.setFont(new Font("Algerian", Font.PLAIN, 25));

		l6.setBounds(100,60, 500, 100);
		tf1= new JTextField();
		tf1.setEditable(true);
		tf1.setBounds(400,145,200,20);
		
		tf2= new JTextField();
		tf2.setEditable(true);
		tf2.setBounds(400,195,200,20);
		
		tf3= new JTextField();
		tf3.setEditable(true);
		tf3.setBounds(400,245,200,20);
		
		tf4= new JTextField("500");
		tf4.setEditable(true);
		tf4.setBounds(400,290,200,20);
		
		l2 = new JLabel("Enter your Name: ");
		l2.setBounds(100,100, 600, 100);
		l2.setFont(new Font("sanserif", Font.BOLD, 20));

		l3 = new JLabel("Enter your Phone number: ");
		l3.setBounds(100,150, 350, 100);
		l3.setFont(new Font("sanserif", Font.BOLD, 20));

		l4 = new JLabel("Enter your City/Town/Village: ");
		l4.setBounds(100,200, 350, 100);
		l4.setFont(new Font("sanserif", Font.BOLD, 20));

		l7 = new JLabel("Enter your Deposit amount: ");
		l7.setBounds(100,240, 350, 100);
		l7.setFont(new Font("sanserif", Font.BOLD, 20));
		
		l8 = new JLabel();
		l8.setBounds(100,380, 500, 100);
		l8.setFont(new Font("sanserif", Font.BOLD, 25));
		
		l9 = new JLabel();
		l9.setBounds(100,450, 700, 100);
		l9.setFont(new Font("sanserif", Font.BOLD, 20));
		
		l10 = new JLabel();
		l10.setBounds(100,420, 600, 100);
		l10.setFont(new Font("sanserif", Font.BOLD, 25));
		
		b1 = new JButton("Enter");
		b1.setBounds(300,370, 100,30);
		b1.setFont(new Font("sanserif", Font.BOLD, 20));
		b1.setFocusable(false);
		b1.addActionListener(this);
		b1.setEnabled(true);
		cb1= new JCheckBox("I agree to the terms and conditions");
		cb1.setFont(new Font("sanserif", Font.BOLD, 20));
		cb1.setBounds(100,320,500,30);
		cb1.setFocusable(false);
		cb1.setBackground(Color.orange);
		
		b2 = new JButton("Check Balance");
		b2.setBounds(1000,75, 300,50);
		b2.setFont(new Font("sanserif", Font.BOLD, 20));
		b2.setFocusable(false);
		b2.addActionListener(this);
		//ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\Joel\\Downloads\\download (1).png"); 
		b3 = new JButton("<-- Go Back to Home Page");
		b3.setBounds(1000,140, 300,50);
		b3.setFont(new Font("sanserif", Font.BOLD, 20));
		b3.setFocusable(false);
		b3.addActionListener(this);
	
		l5 = new JLabel();
		l5.setBounds(550,280, 500, 100);
		jf.add(l5);
		jf.add(tf2);
		jf.add(tf3);
		jf.add(tf1);
		jf.add(tf4);
		jf.add(l2);
		jf.add(l1);
		jf.add(l3);
		jf.add(l3);
		jf.add(l4);
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);
		jf.add(l6);
		jf.add(l7);
		jf.add(l8);
		jf.add(l9);
		jf.add(l10);
		jf.add(cb1);
		jf.add(bg);
		//jf.add(lab);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			if(((tf2.getText()).length()<10 )|| (tf1.getText()).length()==0 || (tf3.getText()).length()==0 || Integer.parseInt(tf4.getText())<500 || (tf4.getText()).length()==0 || cb1.isSelected()==false) {
				if(tf1.getText().length()==0)
					JOptionPane.showMessageDialog(jf,"Name cannot be Empty", "Insufficient details", JOptionPane.ERROR_MESSAGE);
				else if((tf2.getText()).length()<10 )
					JOptionPane.showMessageDialog(jf,"Enter 10 - Digit Number", "Insufficient details", JOptionPane.ERROR_MESSAGE);
				else if((tf2.getText()).length()>10 )
					JOptionPane.showMessageDialog(jf,"Enter ONLY 10 - Digit Number", "Insufficient details", JOptionPane.ERROR_MESSAGE);
				else if(tf3.getText().length()==0) 
					JOptionPane.showMessageDialog(jf,"City/Town/Village details Required", "Insufficient details", JOptionPane.ERROR_MESSAGE);
				else if(Integer.parseInt(tf4.getText())<500||(tf4.getText()).length()==0)
					JOptionPane.showMessageDialog(jf,"Enter Minimum Rs.500/-", "Low Balance", JOptionPane.ERROR_MESSAGE);
				else if(cb1.isSelected()==false)
					JOptionPane.showMessageDialog(jf,"Cannot Signup Without Accepting Terms & Conditions ", "Warning !!", JOptionPane.WARNING_MESSAGE);
			}
			else {
				this.insert();
			}
			
		}
		if(e.getSource()==b2) {
			b2.setText(String.valueOf(bal));
		}
		if(e.getSource()==b3) {
			new bankguidupli();
		}
	}
	
	private void insert() {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver"); 
		 
		Connection con=DriverManager.getConnection( 
		"jdbc:oracle:thin:@localhost:1521:xe","system","joel"); 
		 
		Statement stmt=con.createStatement();
		String cname=tf1.getText();
		String pno=tf2.getText();
		String ccity=tf3.getText();
		
		ResultSet rs=stmt.executeQuery("select * from bank"); 
		
	    ArrayList <Integer> l1= new ArrayList<Integer>();
	    
	    String acno="";
	    
	    
	    while(rs.next()){
	    	acno=rs.getString(1);
	    char no1= acno.charAt(2);
	    char no2= acno.charAt(3);
	    String cnum=String.valueOf(no1);
	    String cnum2=String.valueOf(no2);
	    cnumber=(Integer.parseInt(cnum)*10)+Integer.parseInt(cnum2);
	    l1.add(cnumber);
	    }
        Collections.sort(l1, Collections.reverseOrder());
	    String cid="C0"+(l1.get(0)+1);
	    System.out.println(cid);
	    bal=Integer.parseInt(tf4.getText());
		Namefinder nf= new Namefinder();
		if(nf.finder(cname)==false) {
		String sql="insert into bank values('"+cid+"','"+cname+"',"+pno+",'"+ccity+"',"+bal+")";
		boolean result=stmt.execute(sql);
		if(result==false) {
			JOptionPane.showMessageDialog(jf,"SIGNUP SUCCESS !!", "Success", JOptionPane.INFORMATION_MESSAGE);
			l8.setText("YOUR ACCOUNT NUMBER:: "+cid);
			String phone =tf2.getText();
			l10.setText("Phone Number : XXXXXXX"+phone.charAt(7)+phone.charAt(8)+phone.charAt(9));
			l9.setText("(Remember Account number to make deposit and withdrawls)");
		}                                                                                                        
		else {
			l5.setText("Insufficient Details");
		}
		}
		else
			JOptionPane.showMessageDialog(jf,"UserName Already Exists !!", "Signup error", JOptionPane.ERROR_MESSAGE);
		
		con.close(); 
		}
		catch(Exception e) {
		}
	}
	public static void main(String[] args) {
		new Newaccount();
	}

}
