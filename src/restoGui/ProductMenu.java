package restoGui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductMenu extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7228100578737699266L;
	private JPanel contentPane;
	private JButton btnNewButton;
	ProductMenu frame;
	Set s = new Set();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductMenu frame = new ProductMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ProductMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 392);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Menu");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(208, 11, 66, 21);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel(" South Indian Dishes");
		lblNewLabel_1.setBounds(20, 69, 111, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("North Indian Dishes");
		lblNewLabel_2.setBounds(20, 103, 111, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Rajasthani Dishes");
		lblNewLabel_3.setBounds(20, 140, 111, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Gujarati  Dishes\t");
		lblNewLabel_4.setBounds(20, 176, 111, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Bangali Dishes");
		lblNewLabel_5.setBounds(20, 217, 111, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Dessert Dishes");
		lblNewLabel_6.setBounds(20, 257, 111, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Cold Drinks");
		lblNewLabel_7.setBounds(275, 69, 111, 14);
		contentPane.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Ice Creams");
		lblNewLabel_8.setBounds(275, 103, 111, 14);
		contentPane.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Tea");
		lblNewLabel_9.setBounds(275, 140, 111, 14);
		contentPane.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Juce");
		lblNewLabel_10.setBounds(275, 176, 111, 14);
		contentPane.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("Break Fasts");
		lblNewLabel_11.setBounds(275, 217, 111, 14);
		contentPane.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Latur's Speacial Vadapav");
		lblNewLabel_12.setBounds(275, 257, 131, 14);
		contentPane.add(lblNewLabel_12);

		JButton Button_1 = new JButton("click");
		Button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new SouthProducts().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				new ProductMenu().setVisible(false);
			}
		});
		Button_1.setForeground(Color.GREEN);
		Button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_1.setBounds(141, 63, 60, 23);
		contentPane.add(Button_1);

		JButton Button_2 = new JButton("click");
		Button_2.setForeground(Color.GREEN);
		Button_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_2.setBounds(141, 99, 60, 23);
		contentPane.add(Button_2);

		JButton Button_3 = new JButton("click");
		Button_3.setForeground(Color.GREEN);
		Button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_3.setBounds(141, 136, 60, 23);
		contentPane.add(Button_3);

		JButton Button_4 = new JButton("click");
		Button_4.setForeground(Color.GREEN);
		Button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_4.setBounds(141, 172, 60, 23);
		contentPane.add(Button_4);

		JButton Button_5 = new JButton("click");
		Button_5.setForeground(Color.GREEN);
		Button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_5.setBounds(141, 206, 60, 23);
		contentPane.add(Button_5);

		JButton Button_6 = new JButton("click");
		Button_6.setForeground(Color.GREEN);
		Button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_6.setBounds(141, 248, 60, 23);
		contentPane.add(Button_6);

		JButton Button_7 = new JButton("click");
		Button_7.setForeground(Color.GREEN);
		Button_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_7.setBounds(396, 63, 60, 23);
		contentPane.add(Button_7);

		JButton Button_8 = new JButton("click");
		Button_8.setForeground(Color.GREEN);
		Button_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_8.setBounds(396, 99, 60, 23);
		contentPane.add(Button_8);

		JButton Button_9 = new JButton("click");
		Button_9.setForeground(Color.GREEN);
		Button_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_9.setBounds(396, 136, 60, 23);
		contentPane.add(Button_9);

		JButton Button_10 = new JButton("click");
		Button_10.setForeground(Color.GREEN);
		Button_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_10.setBounds(396, 172, 60, 23);
		contentPane.add(Button_10);

		JButton Button_11 = new JButton("click");
		Button_11.setForeground(Color.GREEN);
		Button_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_11.setBounds(396, 213, 60, 23);
		contentPane.add(Button_11);

		JButton Button_12 = new JButton("click");
		Button_12.setForeground(Color.GREEN);
		Button_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Button_12.setBounds(396, 250, 60, 23);
		contentPane.add(Button_12);

		btnNewButton = new JButton("Cancel"); 
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(365, 319, 89, 23);
		contentPane.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			new Home().setVisible(true);
			this.setVisible(false);
		
		}
	}
}
