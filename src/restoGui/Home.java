package restoGui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel p1, p2;
	JLabel l1;
	JButton bt1, bt2, bt3, bt4, bt5;
	Font f1, f2;

	Home() {

		super("Tech Resto");
		setLocation(400, 100);
		setSize(400, 400);

		f1 = new Font("Arial", Font.BOLD, 20);
		f2 = new Font("Arial", Font.BOLD, 18);

		l1 = new JLabel("TECH - RESTO");
		bt1 = new JButton("Menu");
		bt2 = new JButton("Your Details");
		bt3 = new JButton("Product Details");
		bt4 = new JButton("Refund");
		bt5 = new JButton("Exit");

		l1.setHorizontalAlignment(JLabel.CENTER);
		l1.setFont(f1);
		bt1.setFont(f2);
		bt2.setFont(f2);
		bt3.setFont(f2);
		bt4.setFont(f2);
		bt5.setFont(f2);

		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		bt5.addActionListener(this);

		p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 1, 10, 10));
		p1.add(l1);

		p2 = new JPanel();
		p2.setLayout(new GridLayout(5, 1, 10, 10));
		p2.add(bt1);
		p2.add(bt2);
		p2.add(bt3);
		p2.add(bt4);
		p2.add(bt5);

		setLayout(new BorderLayout(10, 10));
		add(p1, "North");
		add(p2, "Center");
	}

	Set s = new Set();

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == bt1) {
			new ProductMenu().setVisible(true);
			this.setVisible(false);
		}
		if (e.getSource() == bt2) {
			new CustomerDetails(s.getUser()).setVisible(true);
			this.setVisible(false);
		}
		if (e.getSource() == bt3) {
			new OrderDetails(s.getUser()).setVisible(true);
			this.setVisible(false);
		}
		if (e.getSource() == bt4) {
			new Refunds(s.getUser()).setVisible(true);
			this.setVisible(false);
		}
		if (e.getSource() == bt5) {
			this.setVisible(false);
		}

	}
}
