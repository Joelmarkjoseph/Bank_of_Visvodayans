package New;

//import javax.imageio.ImageIO; 
import javax.swing.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

class Mythread extends Thread{
	String input;
	JLabel l;
	Mythread(String i,JLabel label){
		input=i;
		l=label;
	}
	public void run() {
	String letter="";
	try {
		for(int i=0;i<input.length();i++) {
			letter+=input.charAt(i);
			l.setText(letter);
			Thread.sleep(100);
	    }
		
		}
	catch(Exception e) {
		System.out.println(e);
	}
	}
}
class NewThread extends Thread{
	String input,correct;
	JLabel l;
	NewThread(String i,JLabel label,String crkt){
		input=i;
		l=label;
		correct=crkt;
	}
	public void run() {
	String letter="";
	String newl="WELCOME TO ";
	try {
		for(int i=0;i<input.length();i++) {
			letter+=input.charAt(i);
			l.setText(letter);
			Thread.sleep(100);
	    }
		for(int i=0;i<1;i++) {
			l.setText(letter+"|");
			Thread.sleep(300);
			l.setText(letter);
			Thread.sleep(300);
			}
			for(int i=0;i<=0;i++) {
				l.setText("WELCOME T|");
				Thread.sleep(300);
				l.setText("WELCOME T");
				Thread.sleep(300);
				}
			
			for(int i=0;i<=0;i++) {
				l.setText("WELCOME |");
				Thread.sleep(300);
				l.setText("WELCOME ");
				Thread.sleep(300);
				}
			for(int i=0;i<=0;i++) {
				l.setText("WELCOME T|");
				Thread.sleep(300);
				l.setText("WELCOME T");
				Thread.sleep(300);
				}
			for(int i=0;i<=0;i++) {
				l.setText("WELCOME TO |");
				Thread.sleep(300);
				l.setText("WELCOME TO ");
				Thread.sleep(300);
				}
			
		for(int i=11;i<correct.length()-3;i++) {
			newl+=correct.charAt(i);
			l.setText(newl);
			Thread.sleep(100);
	    }
		for(int i=0;i<1;i++) {
			l.setText(newl+"|");
			Thread.sleep(500);
			l.setText(newl); 
			Thread.sleep(500);
			}
		for(int i=correct.length()-3;i<correct.length();i++) {
			newl+=correct.charAt(i);
			l.setText(newl);
			Thread.sleep(100);
	    }
		for(int i=0;i<2;i++) {
			l.setText(newl+"|");
			Thread.sleep(500);
			l.setText(newl);
			Thread.sleep(500);
			}
	}
	catch(Exception e) {
		System.out.println(e);
	}
	}
	
}

public class BankGui implements ActionListener {
	JFrame jf;
	public static JLabel l1,l2,l3,l4,l5,l6,bg;
	static JTextField tf1;
	static JButton b1;
	static JButton b2;
	JButton b3;
	ImageIcon img;
	ImageIcon img1;
	public static String welcome="WELCOME TI ",cwel="WELCOME TO BANK OF VISVODAYANS",home="Home Page",ex="Exixting Bank User:",newbu="New Bank User:";
	public static String name;
	String getname;
	BankGui()
	{
		jf= new JFrame("BANK OF VISVODAYANS");
		jf.setSize(1200,700);
		jf.setLayout(null);                                                     //"C:\Users\Joel\Downloads\kenrick-baksh-Wm8opOd-MDE-unsplash.jpg"
		img=new ImageIcon("C:\\Users\\Joel\\Downloads\\yellowpiggybank.png");
		Image im=img.getImage();
		Image temp_img=im.getScaledInstance(1550, 850, Image.SCALE_SMOOTH);
		img = new ImageIcon(temp_img);
		bg= new JLabel("",img,JLabel.CENTER);
		bg.setBounds(10,10,1515,815);
		//jf.add(bg);
		jf.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		//jf.setBackground(null);
		l1 = new JLabel(welcome);
		l1.setBounds(55,145, 1500, 100);
		tf1= new JTextField();
		tf1.setEditable(true);
		tf1.setBounds(200,100,200,20);
		
		l2 = new JLabel();
		l2.setBounds(91,240, 300, 100);
		l2.setFont(new Font("sanserif", Font.BOLD, 25));     
		l3 = new JLabel();
		l3.setBounds(391,240, 300, 100);
		l3.setFont(new Font("sanserif", Font.BOLD, 25));

		
		l4 = new JLabel();
		l4.setBounds(1350,765, 300, 100);
		l4.setFont(new Font("sanserif", Font.BOLD, 18));
		l6 = new JLabel();
		l6.setBounds(55,75, 300, 100);
		l6.setFont(new Font("Algerian", Font.PLAIN, 35));

		ImageIcon imageIcon = new ImageIcon("C:\\Users\\Joel\\Downloads\\login-button-icon-5.jpg"); 
		Image image = imageIcon.getImage(); 
		Image newimg = image.getScaledInstance(145, 60,  java.awt.Image.SCALE_SMOOTH); 
		imageIcon = new ImageIcon(newimg); 
		b1 = new JButton("Login");
		b1.setBounds(95,315, 130,55);
		b1.setFont((new Font("sanserif", Font.BOLD, 25)));
		b1.setFocusable(false);
		b1.addActionListener(this);
		//"C:\\Users\\Joel\\Downloads\\login-button-png.svg.hi (1).png"
		ImageIcon imageIcon2 = new ImageIcon("C:\\Users\\Joel\\Downloads\\signup image.png"); 
		Image image2 = imageIcon2.getImage(); 
		Image newimg2 = image2.getScaledInstance(145, 80,  java.awt.Image.SCALE_SMOOTH); 
		imageIcon2 = new ImageIcon(newimg2); 
		b2 = new JButton("Signup");
		b2.setBounds(395,315, 130,55);
		b2.setFont((new Font("sanserif", Font.BOLD, 25)));
		b2.addActionListener(this);
		b2.setFocusable(false);
		//jf.add(tf1);
		jf.add(l2);
		l1.setFont(new Font("Algerian", Font.PLAIN, 55));
		
		jf.add(l1);
		jf.add(l3);
		jf.add(l6);
		jf.add(l4);
		jf.add(b1);
		jf.add(b2);
		jf.add(bg);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		name = tf1.getText();
		if(e.getSource()==b1) {
			//LOGIN
			new Login();
		}
		else if(e.getSource()==b2){
		    	//SIGNUP
		    	new Newaccount();
		    }
		}
		
	public static void main(String[] args) throws InterruptedException {
		new BankGui();
		NewThread bg1 = new NewThread(welcome,l1,cwel);
		Mythread bg2 = new Mythread(home,l6);
		Mythread bg3 = new Mythread(ex,l2);
		Mythread bg4 = new Mythread(newbu,l3);

		bg1.start();
		bg2.start();
		Thread.sleep(2000);
		bg3.start();
		bg4.start();
		Thread.sleep(3500);

	}
}
