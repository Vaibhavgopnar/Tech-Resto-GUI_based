package restoGui;

import java.awt.*;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;

public class Refunds extends JFrame implements ActionListener{

	private static final long serialVersionUID = -2825557049082073511L;
	private JPanel contentPane;
	private JTable table;
	String x[] = { "P_ID", "P_Name", "P_Quantity", "P_Bill", "ID_No" };
	String y[][] = new String[200][5];
	int i = 0, j = 0;
	private JTextField textField, textField_1 ;
	private JButton btnNewButton_3, btnNewButton_4, btnNewButton_1;
	float bill = 0;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rest;

	public Refunds(String s) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 807, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		con = DatabaseConn.creatC();
		String query = " select * from Resto r JOIN Productdata p ON r.ID_No = p.ID_No where Customer_ID='" + s + "' ";
		
		try {
			ps = con.prepareStatement(query);
			rest = ps.executeQuery();
			while (rest.next()) {
				y[i][j++] = rest.getString("P_ID");
				y[i][j++] = rest.getString("P_Name");
				y[i][j++] = rest.getString("P_Quantity");
				y[i][j++] = rest.getString("P_Bill");
				y[i][j++] = rest.getString("ID_No");
				i++;
				j = 0;
			}

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 40, 805, 169);
			contentPane.add(scrollPane);
			table = new JTable(y, x);
			scrollPane.setViewportView(table);
			table.setFillsViewportHeight(true);
			table.setColumnSelectionAllowed(true);
			table.setCellSelectionEnabled(true);
			table.setForeground(Color.RED);

			JLabel lblNewLabel = new JLabel("Refund Products");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(357, 11, 118, 14);
			contentPane.add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Enter Product to Refund");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel_1.setBounds(27, 231, 176, 14);
			contentPane.add(lblNewLabel_1);

			textField = new JTextField();
			textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
			textField.setBounds(283, 228, 164, 20);
			contentPane.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(563, 230, 176, 20);
			contentPane.add(textField_1);
			textField_1.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("What you want to do ?");
			lblNewLabel_2.setFont(new Font("Sitka Text", Font.PLAIN, 15));
			lblNewLabel_2.setBounds(27, 283, 220, 35);
			contentPane.add(lblNewLabel_2);

			btnNewButton_1 = new JButton("Change");
			btnNewButton_1.addActionListener(this);
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_1.setBounds(283, 287, 89, 23);
			contentPane.add(btnNewButton_1);

			JButton btnNewButton_2 = new JButton("Refunds");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						con = DatabaseConn.creatC();
						String query = " select * from Resto JOIN Productdata ON Resto.ID_No = Productdata.ID_No where P_ID ='"+ textField.getText() + "' and P_Name = '"+textField_1.getText()+"'";
						ps = con.prepareStatement(query);
						rest = ps.executeQuery();
						int count=0;  
						while (rest.next()) {
							System.out.println("Product ID : " + rest.getInt(5));
							System.out.println("Product Name : " + rest.getString(6));
							System.out.println("Product Quantity : " + rest.getInt(7));
							System.out.println("Product Bill : " + rest.getFloat(8));
							bill = rest.getFloat(8);
							count++;
						}
						if(count>0)
						JOptionPane.showMessageDialog(null,
								"Your Product Bill : " + bill+ "\nYour bill will be Refunded soon ");
						else
							JOptionPane.showMessageDialog(null, "Please Enter Product-Id or Product-Name");
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_2.setBounds(505, 287, 105, 23);
			contentPane.add(btnNewButton_2);
			
			btnNewButton_3 = new JButton("Exit");
			btnNewButton_3.addActionListener(this);
			btnNewButton_3.setForeground(Color.RED);
			btnNewButton_3.setFont(new Font("Sitka Text", Font.PLAIN, 14));
			btnNewButton_3.setBounds(176, 357, 89, 23);
			contentPane.add(btnNewButton_3);
			
			btnNewButton_4 = new JButton("Back");
			btnNewButton_4.addActionListener(this);
			btnNewButton_4.setFont(new Font("Sitka Text", Font.PLAIN, 14));
			btnNewButton_4.setForeground(Color.BLUE);
			btnNewButton_4.setBounds(564, 357, 89, 23);
			contentPane.add(btnNewButton_4);
			
			JLabel lblNewLabel_3 = new JLabel("P-id :");
			lblNewLabel_3.setForeground(Color.BLACK);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_3.setBounds(227, 231, 46, 14);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("P-Name :");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_4.setBounds(473, 233, 74, 14);
			contentPane.add(lblNewLabel_4);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnNewButton_3) {
			this.setVisible(false);
		}
		if(e.getSource() == btnNewButton_4) {
			new Home().setVisible(true);
			this.setVisible(false);
		}
		if(e.getSource() ==btnNewButton_1) {
			JOptionPane.showMessageDialog(null, "Please Order new Product ");
			new ProductMenu().setVisible(true);
			this.setVisible(false);
		}
	}
}
