package New;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login implements ActionListener {
	JFrame jf;
	JLabel l1,l2,l3,l4,l5,l6,l7;
	static JTextField tf1,tf2,tf3;
	JButton b1,b2;
	String cname="";
	Login(){
		
		jf= new JFrame("LOGIN TO VISVODAYANS BANK");
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
		l1 = new JLabel("LOGIN TO VISVODAYANS BANK!!");
		l1.setFont(new Font("Algerian",Font.PLAIN,50));
		l1.setBounds(100,0, 1000, 100);
		
		tf1= new JTextField();
		tf1.setEditable(true);
		tf1.setBounds(450,145,200,20);
		
		tf2= new JTextField();
		tf2.setEditable(true);
		tf2.setBounds(550,195,200,20);
		
		tf3= new JTextField();
		tf3.setEditable(true);
		tf3.setBounds(550,245,200,20);
		
		l2 = new JLabel("Enter your Account Number: ");
		l2.setBounds(100,100, 350, 100);
		l2.setFont(new Font("sanserif", Font.BOLD, 25));

		l3 = new JLabel();
		l3.setBounds(500,225, 250, 100);
		l3.setFont(new Font("sanserif", Font.BOLD, 25));
		
		b1 = new JButton("Enter");
		b1.setBounds(200,300, 100,30);
		b1.setFont(new Font("sanserif", Font.BOLD, 20));
		b1.setFocusable(false);
		b1.addActionListener(this);
		b2 = new JButton("Go Back to Home Page");
		b2.setBounds(350,300, 500,40);
		b2.setFont(new Font("sanserif", Font.BOLD, 25));
		b2.setFocusable(false);
		b2.addActionListener(this);
		l5 = new JLabel();
		l5.setBounds(75,250, 300, 100);
		
		jf.add(l5);
		//jf.add(tf2);
		//jf.add(tf3);
		jf.add(tf1);
		jf.add(l2);
		jf.add(l1);
		jf.add(l3);
		jf.add(b1);
		jf.add(b2);
		jf.add(bg);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		String cid = tf1.getText();
		if(e.getSource()==b1) {
			CNamefinder cnf= new CNamefinder();
			Boolean bool=cnf.afinder(cid);
			if(bool==true) {
				try{ 
					Class.forName("oracle.jdbc.driver.OracleDriver"); 
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","joel"); 						 
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery("select cname from bank WHERE CID='"+cid+"'"); 
					while(rs.next()) {
								cname=(rs.getString(1)); 
					}
					con.close(); 
					}catch(Exception exe){ System.out.println(exe);} 
				new Transaction(cid,cname);
			}
			else
			{
				l3.setText("User not found !!");
			}
		}
		else if(e.getSource()==b2) {
			new bankguidupli();
		}
	}
	public static void main(String[] args) {
		//Login l = new Login();
	}

}
