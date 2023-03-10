package restoGui;

import java.awt.*;

import javax.swing.*;

import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPage implements ActionListener {

	static LoginPage window;
	JFrame frmLoginPage;
	private JTextField txtemail;
	private JTextField txtaddress;
	private JPasswordField txtpassword;
	private JButton btnsignup;
	private JButton btnLogin;
	private JButton btnuser;
	private JButton btnphone;
	private JButton btnguest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new LoginPage();
					window.frmLoginPage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginPage = new JFrame();
		frmLoginPage.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\java files\\Ecommerce Resto GUI\\src\\Image\\loginimg.jpeg"));
		frmLoginPage.setForeground(new Color(0, 0, 0));
		frmLoginPage.setFont(new Font("Georgia Pro", Font.BOLD, 18));
		frmLoginPage.setTitle("Login Page");
		frmLoginPage.setBounds(100, 100, 751, 543);
		frmLoginPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginPage.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Tech-Resto");
		lblNewLabel.setFont(new Font("Verdana Pro Semibold", Font.BOLD, 22));
		lblNewLabel.setBounds(179, 11, 307, 55);
		frmLoginPage.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email           :");
		lblNewLabel_1.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel_1.setBounds(214, 92, 107, 30);
		frmLoginPage.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password     :");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(214, 145, 107, 30);
		frmLoginPage.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Address       : ");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(212, 205, 109, 30);
		frmLoginPage.getContentPane().add(lblNewLabel_1_2);
		
		txtemail = new JTextField();
		txtemail.setBounds(360, 92, 267, 27);
		frmLoginPage.getContentPane().add(txtemail);
		txtemail.setColumns(10);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(360, 205, 267, 27);
		frmLoginPage.getContentPane().add(txtaddress);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(360, 143, 267, 30);
		frmLoginPage.getContentPane().add(txtpassword);
		
		btnsignup = new JButton("SignUp");
		btnsignup.addActionListener(this);
		btnsignup.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnsignup.setBounds(350, 274, 96, 36);
		frmLoginPage.getContentPane().add(btnsignup);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(this);
		btnLogin.setBackground(new Color(128, 128, 255));
		btnLogin.setFont(new Font("Microsoft JhengHei UI Light", Font.BOLD, 14));
		btnLogin.setBounds(477, 274, 96, 36);
		frmLoginPage.getContentPane().add(btnLogin);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "OR Login With", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_1.setBounds(114, 333, 579, 85);
		frmLoginPage.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		btnuser = new JButton("UserName");
		btnuser.addActionListener(this);
		btnuser.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnuser.setBounds(27, 32, 136, 36);
		panel_1.add(btnuser);
		
		btnphone = new JButton("Phone Number");
		btnphone.addActionListener(this);
		btnphone.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnphone.setBounds(222, 32, 147, 36);
		panel_1.add(btnphone);
		
		btnguest = new JButton("Guest");
		btnguest.addActionListener(this);
		btnguest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnguest.setBounds(419, 32, 136, 36);
		panel_1.add(btnguest);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnexit.setBackground(new Color(128, 128, 128));
		btnexit.setForeground(new Color(255, 0, 0));
		btnexit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnexit.setBounds(577, 457, 136, 36);
		frmLoginPage.getContentPane().add(btnexit);
		
		ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Image/loginimg.jpeg"));
//		img = img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT); 
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 92, 170, 204);
		frmLoginPage.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblimg = new JLabel("");
		lblimg.setIcon( img);
		lblimg.setBounds(10, 11, 150, 182);
		panel.add(lblimg);
	}

	private String emailid;
	private String password;
	private String address;
	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		
		emailid = txtemail.getText();
		password = txtpassword.getText();
		Connection con = DatabaseConn.creatC();

		if (e.getSource() == btnLogin) {
			try {
				String q = "select * from customerid where emails='" + emailid + "' and Passwords='" + password + "'  ";
				Statement st = con.createStatement();
				ResultSet rest = st.executeQuery(q);
				if (rest.next()) {
					Set.setUser(emailid);
					new Home().setVisible(true);
					window.frmLoginPage.setVisible(false);
				}else {
					String s = "Please, Enter UserId or Password Correct ....!";
					JOptionPane.showMessageDialog(null, s);
				}
			} catch (SQLException e1) {

				e1.printStackTrace();
			}

		}
		if (e.getSource() == btnsignup) {
			try {
				String q = "Insert into customerid(emails,Passwords) values(?,?)";
				String q2 = "Insert into resto(customer_id,Password, address) values(?,?,?)";
				PreparedStatement ps = con.prepareStatement(q);
				ps.setString(1, emailid);
				ps.setString(2, password);		
				int n = ps.executeUpdate();
				if (n > 0) {
					window.frmLoginPage.setVisible(false);
					JOptionPane.showMessageDialog(null, "Sign Up Successful ...!!!");
				} else {
					String s = "Please, Enter UserId or Password first ....!";
					JOptionPane.showMessageDialog(null, s);
				}
				
				ps = con.prepareStatement(q2);
				ps.setString(1, emailid);
				ps.setString(2, password);	
				ps.setString(3, address);
				ps.executeUpdate();
				
				ps.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		if (e.getSource() == btnuser) {
			new UsernameLogin().setVisible(true);
			window.frmLoginPage.setVisible(false);
		}
		if (e.getSource() == btnphone) {
			new PhoneLogin().setVisible(true);
			window.frmLoginPage.setVisible(false);
		}
		if (e.getSource() == btnguest) {
			new Home().setVisible(true);
			window.frmLoginPage.setVisible(false);
		}

		}
}
