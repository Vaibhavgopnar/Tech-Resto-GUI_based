package restoGui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class PhoneLogin extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	static LoginPage window;
		JPanel p1,p2,p3,p4;
		JLabel l1,l2,l3;
		JTextField tf1;
		JButton bt1,bt2;
		Font f1,f2;
		
		PhoneLogin(){
				
				super("Login ");
				setLocation(400,300);
				setSize(500,150);
				
				f1 = new Font("Arial",Font.BOLD,20);
				f2 = new Font("Arial",Font.BOLD,18);
				
				l1 = new JLabel("Welcome To Tech-Resto");
				l2 = new JLabel("Phone Number : ");
				tf1 = new JTextField();
				bt1 = new JButton("Login");
				bt2 = new JButton("Cancel");
				
				ImageIcon  img = new ImageIcon(ClassLoader.getSystemResource("Image/loginimg.jpeg"));
				Image img2 = img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
				ImageIcon img3 = new ImageIcon(img2);
				l3 = new JLabel(img3);
				
				l1.setHorizontalAlignment(JLabel.CENTER);
				l1.setFont(f1);
				l2.setFont(f2);
				tf1.setFont(f2);
				bt1.setFont(f2);
				bt2.setFont(f2);
				
				bt1.addActionListener(this);
				bt2.addActionListener(this);
				
				p1 = new JPanel();
				p1.setLayout(new GridLayout(1,1,10,10));
				p1.add(l1);
				
				p2 = new JPanel();
				p2.setLayout(new GridLayout(1,2,10,10));
				p2.add(l2);
				p2.add(tf1);
				
				p3 = new JPanel();
				p3.setLayout(new GridLayout(1,1,10,10));
				p3.add(l3);
				
				p4 = new JPanel();
				p4.setLayout(new GridLayout(1,2,10,10));
				p4.add(bt1);
				p4.add(bt2);
				
				setLayout(new BorderLayout(10,10));
				add(p1,"North");
				add(p2,"Center");
				add(p3,"East");
				add(p4,"South");
				
		}
		String username;
		@Override
		public void actionPerformed(ActionEvent e) {
			username = tf1.getText();
			if(e.getSource() == bt1) {
				
				try {
					Connection con = DatabaseConn.creatC();
					String q = "select * from customerid where emails='"+username+"'  ";
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
			new PhoneLogin().setVisible(true);
		}
}
