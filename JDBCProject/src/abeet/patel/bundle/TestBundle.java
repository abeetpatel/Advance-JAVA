package abeet.patel.bundle;

import java.util.ResourceBundle;

public class TestBundle {
	
	public static void main(String[] args) {
		
		ResourceBundle rb = ResourceBundle.getBundle("abeet.patel.bundle.system");
		
		System.out.println("driver = " + rb.getString("driver"));
		
		System.out.println("url " + rb.getString("url"));
		
		System.out.println("username = "+ rb.getString("username"));
		
		System.out.println("password = "+ rb.getString("password"));
		
	}

}
