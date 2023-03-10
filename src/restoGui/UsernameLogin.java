package restoGui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class UsernameLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 8202838244909908110L;
	static LoginPage window;
	JPanel p1,p2,p3;
	JLabel l1,l2,l3,l4;
	static JTextField tf1;
	JPasswordField pf;
	JButton bt1,bt2;
	Font f1,f2;
	
	UsernameLogin(){
			
			super("Login ");
			setLocation(400,300);
			setSize(600,300);
			
			f1 = new Font("Arial",Font.BOLD,20);
			f2 = new Font("Arial",Font.BOLD,18);
			
			l1 = new JLabel("Welcome To Tech-Resto");
			l2 = new JLabel("Username");
			l3 = new JLabel("Password");
			tf1 = new JTextField();
			pf = new JPasswordField();
			bt1 = new JButton("Login");
			bt2 = new JButton("Cancel");
			
			ImageIcon  img = new ImageIcon(ClassLoader.getSystemResource("Image/loginimg.jpeg"));
			Image img2 = img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
			ImageIcon img3 = new ImageIcon(img2);
			l4 = new JLabel(img3);
			
			l1.setHorizontalAlignment(JLabel.CENTER);
			l1.setFont(f1);
			l2.setFont(f2);
			l3.setFont(f2);
			tf1.setFont(f2);
			pf.setFont(f2);
			bt1.setFont(f2);
			bt2.setFont(f2);
			
			bt1.addActionListener(this);
			bt2.addActionListener(this);
			
			p1 = new JPanel();
			p1.setLayout(new GridLayout(1,1,10,10));
			p1.add(l1);
			
			p2 = new JPanel();
			p2.setLayout(new GridLayout(4,2,10,10));
			p2.add(l2);
			p2.add(tf1);
			p2.add(l3);
			p2.add(pf);
			p2.add(bt1);
			p2.add(bt2);
			
			p3 = new JPanel();
			p3.setLayout(new GridLayout(1,1,10,10));
			p3.add(l4);
			
			setLayout(new BorderLayout(10,10));
			add(p1,"North");
			add(p2,"Center");
			add(p3,"East");
	}
	String username;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		username = tf1.getText();
		@SuppressWarnings("deprecation")
		String password = pf.getText();
		
		if(e.getSource() == bt1) {
			try {
				Connection con = DatabaseConn.creatC();
				String q = "select * from customerid where emails='"+username+"' and Passwords='"+password+"'  ";
				Statement st = con.createStatement();
				ResultSet rest = st.executeQuery(q);
				if(rest.next()) {
					Set.setUser(username);
					new Home().setVisible(true);
					this.setVisible(false);
				}else {
					String s = " UserId or Password not found ....!";
					JOptionPane.showMessageDialog(null, s);
				}
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
		}
		if(e.getSource() == bt2) {
			window = new LoginPage();
			window.frmLoginPage.setVisible(true);
			this.setVisible(false);
		}
		
	}
	
	public static void main(String[] args) {

		new UsernameLogin().setVisible(true);
	}

}
