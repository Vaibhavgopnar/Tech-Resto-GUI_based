package restoGui;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class CustomerDetails extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	String x[] = { "ID_No", "Customer_ID", "Password", "Address", "P_ID", "P_Name", "P_Quantity", "P_Bill", "ID_No" };
	String y[][] = new String[200][9];
	int i = 0, j = 0;
	JTable t;
	Font f;
	JButton bt,bt2;
	JPanel p1;
	
	CustomerDetails(String s) {
		
		super("Contact Information");
		setLocation(1, 1);
		setSize(800, 420);

		f = new Font("Arial", Font.BOLD, 12);

		try {		
			Connection con = DatabaseConn.creatC();
			String query = " select * from Resto r JOIN Productdata p ON r.ID_No = p.ID_No where Customer_ID='"
					+ s + "' ";
			PreparedStatement ps = con.prepareStatement(query);

			ResultSet rest = ps.executeQuery();
			while (rest.next()) {

				y[i][j++] = rest.getString("ID_No");
				y[i][j++] = rest.getString("Customer_ID");
				y[i][j++] = rest.getString("Password");
				y[i][j++] = rest.getString("Address");
				y[i][j++] = rest.getString("P_ID");
				y[i][j++] = rest.getString("P_Name");
				y[i][j++] = rest.getString("P_Quantity");
				y[i][j++] = rest.getString("P_Bill");
				y[i][j++] = rest.getString("ID_No");
				i++;
				j = 0;

			}

			t = new JTable(y, x);
			t.setFont(f);

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		JScrollPane sp = new JScrollPane(t);
		add(sp);

		bt = new JButton("Exit");
		bt2 = new JButton("Back");

		bt.addActionListener(this);
		bt2.addActionListener(this);

		p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 2, 10, 10));
		p1.add(bt);
		p1.add(bt2);

		setLayout(new BorderLayout(10, 10));
		add(p1, "South");
		add(sp, "Center");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == bt)
		{
			this.setVisible(false);
		}
		if(e.getSource() == bt2) {
			new Home().setVisible(true);
			this.setVisible(false);
		}
	}

}
