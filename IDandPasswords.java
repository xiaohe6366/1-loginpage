import java.util.HashMap;	//import hashmap

public class IDandPasswords {	//public class 

	HashMap<String,String> logininfo = new HashMap<String,String>();	//creates and keeps the keys
	
	IDandPasswords(){		//adding entries to the logininfo
		logininfo.put("Bro","pizza");
		logininfo.put("Brometheus","PASSWORD");
		logininfo.put("BroCode","abc123");	
	}
	
	protected HashMap getLoginInfo() {
		return logininfo;
	} 
}