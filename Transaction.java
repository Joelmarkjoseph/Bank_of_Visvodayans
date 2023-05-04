package New;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Transaction implements ActionListener {
	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	static JTextField tf1,tf2,tf3;
	JButton b1,b2,b3,b4;
	String cid;
	public Boolean boolea=false;
	Transaction(){}
	Transaction(String cid,String cname){
		this.cid=cid;
		jf= new JFrame("WELCOME TO VISVODAYANS BANK");
		jf.setSize(800,600);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		jf.setLayout(null);
		jf.setLocation(350, 150);
		ImageIcon img = new ImageIcon("C:\\Users\\Joel\\Downloads\\yellowpiggybank.png");
		Image im=img.getImage();
		Image temp_img=im.getScaledInstance(1550, 850, Image.SCALE_SMOOTH);
		img = new ImageIcon(temp_img);
		JLabel bg = new JLabel("",img,JLabel.CENTER);
		bg.setBounds(10,10,1515,815);
		l1 = new JLabel("Deposit");
		l1.setFont(new Font("Algerian",Font.PLAIN,35));
		l1.setBounds(300,50, 1000, 100);
		
		l3 = new JLabel("Withdrawl");
		l3.setFont(new Font("Algerian",Font.PLAIN,35));
		l3.setBounds(300,230, 1000, 100);
		
		l5 = new JLabel();
		l5.setBounds(550,150, 1000, 100);
		
		l6 = new JLabel();
		l6.setBounds(550,320, 1000, 100);
		
		l7 = new JLabel("Hello, "+cname);
		l7.setFont(new Font("Sanserif",Font.BOLD,30));
		l7.setBounds(75,0, 1000, 100);
		
		l8 = new JLabel("Check Balance:");
		l8.setBounds(300,350, 1000, 100);
		l8.setFont(new Font("Sanserif",Font.BOLD,20));
		
		tf1= new JTextField();
		tf1.setEditable(true);
		tf1.setBounds(600,148,200,20);
		
		tf2= new JTextField();
		tf2.setEditable(true);
		tf2.setBounds(625,320,200,20);
		
		tf3= new JTextField();
		tf3.setEditable(true);
		tf3.setBounds(550,245,200,20);
		
		l2 = new JLabel("Enter Amount to deposit: ");
		l2.setBounds(300,100, 400, 100);
		l2.setFont(new Font("sanserif", Font.BOLD, 25));

		l4 = new JLabel("Enter Amount to withdraw: ");
		l4.setBounds(300,275, 400, 100);
		l4.setFont(new Font("sanserif", Font.BOLD, 25));
		
		b1 = new JButton("Enter");
		b1.setBounds(805,140, 100,30);
		b1.setFocusable(false);
		b1.addActionListener(this);
		
		b2 = new JButton("Enter");
		b2.setBounds(830,310, 100,30);
		b2.setFocusable(false);
		b2.addActionListener(this);
		
		b3 = new JButton("Click me to Check Balance");
		b3.setBounds(300,425, 275,50);
		b3.setFont(new Font("sanserif", Font.BOLD, 18));
		b3.setFocusable(false);
		b3.addActionListener(this);
		//"C:\\Users\\Joel\\Downloads\\signout.png"
		b4 = new JButton("<- Logout");
		b4.setBounds(300,500, 275,50);
		b4.setFont(new Font("sanserif", Font.BOLD, 18));
		b4.setFocusable(false);
		b4.addActionListener(this);
		
		jf.add(l5);
		jf.add(tf2);
		jf.add(l6);
		jf.add(l8);
		jf.add(tf1);
		jf.add(l2);
		jf.add(l1);
		jf.add(l7);
		jf.add(l4);
		jf.add(l3);
		jf.add(b1);
		jf.add(b2);
		jf.add(b3);
		jf.add(b4);
		jf.add(bg);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
	}
	
	public void actionPerformed(ActionEvent e) { 
		String dpst = tf1.getText(); 
		String wtdrl=tf2.getText(); 
		int amount = 0;
		if(e.getSource()==b1) {
			try{ 
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","joel"); 						 
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select balance from bank WHERE CID='"+cid+"'"); 
				while(rs.next()) {
							amount=Integer.parseInt(rs.getString(1)); 
				}
				int newamount=amount+Integer.parseInt(dpst);
				String sql="update bank set balance="+newamount+" where cid='"+cid+"'";
				boolea=stmt.execute(sql);
				con.close(); 
				}catch(Exception exe){ System.out.println(e);} 
				
		if(boolea==false)
			l5.setText(dpst+" .rs Deposited Successfully !!");
			l5.setFont(new Font("sanserif", Font.BOLD, 20));
		}

		else if(e.getSource()==b2){
			try{ 
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","joel"); 						 
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select * from bank WHERE CID='"+cid+"'"); 
				while(rs.next()) {
							amount=Integer.parseInt(rs.getString(5)); 
				}
				int namount;
				if(Integer.parseInt(wtdrl)<=amount) {
					namount=amount-Integer.parseInt(wtdrl);
						if(namount<500) {
							int opt=JOptionPane.showConfirmDialog(jf,"Can't perform withdrawl due to Minimum balance policy! Would you like to continue?(It may result in account DELETION)", "Warning", JOptionPane.YES_NO_OPTION);
							if(opt==0) {
								String sql="update bank set balance="+0+" where cid='"+cid+"'";
								boolea=stmt.execute(sql);
								if(boolea==false)
								l6.setText(amount+" .rs Withdrawl Successfull !!");
								l6.setFont(new Font("sanserif", Font.BOLD, 20));
									Thread.sleep(2000);
									String sql2=" delete from bank where cid='"+cid+"'";
									boolea=stmt.execute(sql2);
									if(boolea==false) {
										new bankguidupli();
								    }
							}
						}
						else {
							String sql="update bank set balance="+namount+" where cid='"+cid+"'";
							boolea=stmt.execute(sql);
							if(boolea==false)
							l6.setText(wtdrl+" .rs Withdrawl Successfull !!");
							l6.setFont(new Font("sanserif", Font.BOLD, 20));
						}
				}
				else
					l6.setText("Insufficient Balance !!");
					l6.setFont(new Font("sanserif", Font.BOLD, 20));
			}
			catch(Exception ex) {
				System.out.println(e);
			}
		}
		else if(e.getSource()==b3) {
			try{ 
				Class.forName("oracle.jdbc.driver.OracleDriver"); 
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","joel"); 						 
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery("select balance from bank WHERE CID='"+cid+"'"); 
				while(rs.next()) {
							amount=Integer.parseInt(rs.getString(1)); 
				}
				b3.setText(String.valueOf(amount));
			}
			catch(Exception ex) {
				System.out.println(e);
			}
		}
		else if(e.getSource()==b4) {
			int op=JOptionPane.showConfirmDialog(jf,"Do you really want to LOGOUT? !!", "LOGOUT", JOptionPane.YES_NO_OPTION);
			if(op==0)
			new bankguidupli();
			else {
				//DO NOTHING!!
			}
		}
	}
	public static void main(String[] args) {
	new Transaction("C001","Joel");
	}

}
