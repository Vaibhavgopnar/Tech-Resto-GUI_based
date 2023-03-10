package restoGui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Set {

	private static String user;

	public String getUser() {
		return user;
	}

	public static void setUser(String user) {
		Set.user = user;
	}
	
	private int idno;
	private String Email;
	private String Pass;
	private String Address;
	private Long phoneno;
	private int P_id;
	private String P_name;
	private int P_Quantity;
	private float P_Bill;
	private static String Customer;

	public String getCustomer() {
		return Customer;
	}

	public void setCustomer(String customer) {
		Set.Customer = customer;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		this.Address = address;
	}

	public int getP_id() {
		return P_id;
	}

	public void setP_id(int p_id) {
		P_id = p_id;
	}

	public String getP_name() {
		return P_name;
	}

	public String setP_name(String p_name) {
		return P_name = p_name;
	}

	public int getP_Quantity() {
		return P_Quantity;
	}

	public int setP_Quantity(int p_Quantity) {
		return P_Quantity = p_Quantity;
	}

	public float getP_Bill() {
		return P_Bill;
	}

	public float setP_Bill(float p_Bill) {
		return P_Bill = p_Bill;
	}

	public int getIdno() {
		return idno;
	}

	public void setIdno(int idno) {
		this.idno = idno;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public Long setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
		return phoneno;
	}

	public String getEmail() {
		return Email;
	}

	public String setEmail(String email) {
		this.Email = email;
		return email;
	}

	public String getPass() {
		return Pass;
	}

	public String setPass(String pass) {
		this.Pass = pass;
		return pass;
	}


	public Set() {
		super();

	}

	public Set(String email, String pass, String address) {
		super();
		Email = email;
		Pass = pass;
		Address = address;
	}

	public Set(String email, String pass) {
		this.Email = email;
		this.Pass = pass;
	}

	public Set(Long phoneno) {
		super();
		this.phoneno = phoneno;
	}

	public Set(String p_name, int p_Quantity, float p_Bill) {
		super();
		P_name = p_name;
		P_Quantity = p_Quantity;
		P_Bill = p_Bill;
	}

	public Set(int idno, String email, String pass, int p_id, String p_name, int p_Quantity, float p_Bill) {
		super();
		this.idno = idno;
		Email = email;
		Pass = pass;
		P_id = p_id;
		P_name = p_name;
		P_Quantity = p_Quantity;
		P_Bill = p_Bill;
	}

	public Set(int p_id, String p_name, int p_Quantity, float p_Bill) {
		super();
		P_id = p_id;
		P_name = p_name;
		P_Quantity = p_Quantity;
		P_Bill = p_Bill;
	}

	public static boolean Insert(Set s) {
		try {
			Connection con = DatabaseConn.creatC();
			String query = "Insert into Resto(ID_No,Customer_ID,Password,Address) values(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, s.getIdno());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPass());
			ps.setString(4, s.getAddress());

			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean InsertProduct(Set s) {
		try {
			Connection con = DatabaseConn.creatC();
			String query1 = "select MAX(ID_No) from Resto";
			PreparedStatement ps1 = con.prepareStatement(query1);
			ps1.executeQuery();
			ResultSet rs = ps1.getResultSet();
			int idno = 0;
			while (rs.next()) {
				idno = rs.getInt(1);
			}
			String query = "Insert into ProductData(P_id,P_name,P_Quantity,P_Bill,ID_No) values(?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, s.getP_id());
			ps.setString(2, s.getP_name());
			ps.setInt(3, s.getP_Quantity());
			ps.setFloat(4, s.getP_Bill());
			ps.setInt(5, idno);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	int amounts = 0;
	int pay = 0;
	int cash = 0;
	public void itembill(int rate, String name) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<String, String> IBmap = new HashMap<String, String>();
		HashMap<Integer, Integer> DCmap = new HashMap<Integer, Integer>();
		while (true) {
			System.out.println("How many Product items you want");
			int plates = Integer.parseInt(br.readLine());
			pay = plates * rate;
			System.out.println("Select Your Payment Option..\n");
			System.out.println("1.	Google Pay  ");
			System.out.println("2.	Phone Pay  ");
			System.out.println("3.	Internet Banking  ");
			System.out.println("4.	Debit / Credit Card   ");
			System.out.println("5.	Cash on Delivary");
			System.out.println("6.	Back");
			System.out.println("Enter your choice to payment ");
			int chs = Integer.parseInt(br.readLine());
			if (chs == 1 || chs == 2) {
			} else if (chs == 3) {
				System.out.println("User Name");
				String user = br.readLine();
				System.out.println("Password");
				String pass = br.readLine();
				IBmap.put(user, pass);
			}
			if (chs == 4) {
				System.out.println("Enter Card Number : ");
				Long cardno = Long.parseLong(br.readLine());
				String card = Long.toString(cardno);
				if (card.length() == 12) {
					System.out.println("Ex Date");
					int dt = Integer.parseInt(br.readLine());
					System.out.println("CVV");
					int cvv = Integer.parseInt(br.readLine());
					DCmap.put(dt, cvv);
				} else {
					System.out.println("Card number is wrong ");
				}
			}
			if (chs == 5) {
				cash = pay;
				System.out.println("Your Orders are Received .....");
				System.out.println("Your Order will be Dilivered soon ..");
				System.out.println("Your Payment are added on Receipt ...");
				System.out.println("You can Pay Your Amount " + cash + " on Delivery Time ....");
				break;
			}
			if (chs == 6) {
				break;
			}
			System.out.println("Please Pay " + pay + " Rs");
			amounts = Integer.parseInt(br.readLine());
			float refund = amounts - pay;
			if (amounts == pay) {
				System.out.println("Take Your " + name + " sir/mam");
			} else if (amounts > pay) {
				System.out.println("Take Your " + name + " sir/mam");
				System.out.println("and Take your " + refund + " Rs remaining Sir/Mam");
			} else {
				System.out.println("Insufficient amount ..........!!");
				System.out.println("Please pay " + pay + " Rs");
			}
			break;
		}
	}

	public void dataset(int item, String product, float bill) {

		Set s = new Set(setP_name(product), setP_Quantity(item), setP_Bill(bill));
		Set.InsertProduct(s);
	}

	ArrayList<Resto> al = new ArrayList<Resto>();
	int[] amount = new int[32];
	int[] delivery = new int[32];
	public void getDetails(int n, int rate, String product) {	
		int p1 =0;
		int p2 = 0;
		try {
		p1 = amount[n] / rate;
		}catch(Exception e1) {
			p1=0;
		}
		try {
			p2 = delivery[n] / rate;
		}catch(Exception e) {
			p2 = 0;
		}	
		
		int item = p1 + p2;
		float bill = item * rate;
		al.add(new Resto(item, product));
		dataset(item, product, bill);
	}
	
}
