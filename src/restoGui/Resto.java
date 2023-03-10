package restoGui;

import java.io.Serializable;

public class Resto implements Serializable
{

	private static final long serialVersionUID = 1L;
	int item;
	String product;
	
		Resto(int item, String product) {
		this.item = item;
		this.product = product;
		}
		public String toString() {
			return item+"  "+product;
		}
}
