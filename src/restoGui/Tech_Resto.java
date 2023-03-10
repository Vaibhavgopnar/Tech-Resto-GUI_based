package restoGui;

import java.io.IOException;

public class Tech_Resto {

	static LoginPage window;
	public static void main(String[] args) throws IOException {

		try {

		 window = new LoginPage();
		window.frmLoginPage.setVisible(true);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
