public class Main { 	//main class

	public static void main(String[] args) {	//public static
		
		IDandPasswords idandPasswords = new IDandPasswords();	//create instance of IDandPasswords
		
		
		
		LoginPage loginPage = new LoginPage(idandPasswords.getLoginInfo());		//creating a new screen or window for the user to log in. It uses the user IDs and passwords that you set up in the IDandPasswords class.
	}
}