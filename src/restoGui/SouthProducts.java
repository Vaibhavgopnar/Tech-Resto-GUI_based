package restoGui;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

import net.proteanit.sql.DbUtils;

import java.awt.event.*;
import java.io.*;

public class SouthProducts extends JFrame implements ActionListener{

	private static final long serialVersionUID = -2825557049082073511L;
	private JPanel contentPane;
	private JTextField txtid, txtname ;
	private JButton btnexit, btnback, btnorder;
	float bill = 0;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rest;
	Set s = new Set();
	File f = new File(s.getUser()+".txt");
	FileWriter fw = new FileWriter(f, true);
	PrintWriter pw = null;
	FileReader fr = new FileReader(f);
	private JSpinner spinner;
	private JTable table;
	
	public SouthProducts() throws Exception {
		Initialize();
		table_load();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SouthProducts frame = new SouthProducts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void table_load() {
		
		try {
			con = DatabaseConn.creatC();
			ps = con.prepareStatement("select * from southproducts");
			rest = ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rest));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void Initialize() throws Exception {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 708, 499);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

			contentPane.setLayout(null);

			JLabel lblNewLabel = new JLabel("South Indian Dishesh");
			lblNewLabel.setBounds(283, 11, 264, 25);
			lblNewLabel.setFont(new Font("Segoe Print", Font.PLAIN, 18));
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Enter Product to Order");
			lblNewLabel_1.setBounds(21, 276, 176, 22);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPane.add(lblNewLabel_1);

			txtid = new JTextField();
			txtid.setBounds(280, 276, 110, 26);
			txtid.setFont(new Font("Tahoma", Font.PLAIN, 16));
			contentPane.add(txtid);
			txtid.setColumns(10);
			
			txtname = new JTextField();
			txtname.setBounds(544, 276, 130, 27);
			contentPane.add(txtname);
			txtname.setColumns(10);
			
			btnexit = new JButton("Exit");
			btnexit.setBounds(79, 400, 89, 33);
			btnexit.addActionListener(this);
			btnexit.setForeground(Color.RED);
			btnexit.setFont(new Font("Sitka Text", Font.PLAIN, 14));
			contentPane.add(btnexit);
			
			btnback = new JButton("Back");
			btnback.setBounds(566, 400, 89, 33);
			btnback.addActionListener(this);
			btnback.setFont(new Font("Sitka Text", Font.PLAIN, 14));
			btnback.setForeground(Color.BLUE);
			contentPane.add(btnback);
			
			JLabel lblNewLabel_3 = new JLabel("P-id :");
			lblNewLabel_3.setBounds(227, 276, 46, 23);
			lblNewLabel_3.setForeground(Color.BLACK);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("P-Name :");
			lblNewLabel_4.setBounds(457, 276, 74, 21);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPane.add(lblNewLabel_4);
			
			btnorder = new JButton("Order Now");
			btnorder.setBounds(297, 340, 132, 33);
			btnorder.addActionListener(this);
			btnorder.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			btnorder.setBackground(Color.ORANGE);
			btnorder.setForeground(Color.GREEN);
			contentPane.add(btnorder);
			
			spinner = new JSpinner();
			spinner.setBounds(213, 349, 30, 20);
			contentPane.add(spinner);
			
			JLabel lblNewLabel_2 = new JLabel("Quantity : ");
			lblNewLabel_2.setBounds(144, 348, 74, 21);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			contentPane.add(lblNewLabel_2);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(35, 47, 639, 204);
			contentPane.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnexit) {
			this.setVisible(false);
		}
		if(e.getSource() == btnback) {
			new ProductMenu().setVisible(true);
			this.setVisible(false);
		}
		
		if(e.getSource() == btnorder) {
			
			String name = txtname.getText();
			int qnt  = (int) spinner.getValue();
			int price = 0;
			pw = new PrintWriter(fw, true);
			pw.println("*********************************************************************");
			pw.println("Customer Id : "+s.getUser());
			pw.println("Order is : ");
			
			try {
				String query = "select Product_price from southproducts where product_name = ?";
				con = DatabaseConn.creatC();
				ps = con.prepareStatement(query);
				ps.setString(1, name);			
				rest = ps.executeQuery();
				while(rest.next()) {
					price = rest.getInt("product_price") * qnt;
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			pw.println(qnt+"  "+name + " -  " + price+" Rs");
			bill =  price;
			pw.println("          ........ Total Bill is " + bill + " Rs .......");
			pw.println("*********************************************************************\n");	
			
			txtid.setText("");
			txtname.setText("");
			spinner.setValue(0);
		}
	}
}
