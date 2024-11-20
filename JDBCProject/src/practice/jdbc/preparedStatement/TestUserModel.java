package practice.jdbc.preparedStatement;

import java.text.SimpleDateFormat;

public class TestUserModel {
	
	public static void main(String[] args) throws Exception {
		
		//testInsert();
		//testUpdate();
		//testDelete();
		//testFinedById();
		testAuthentication();
		
	}

	private static void testAuthentication() throws Exception {
		
		UserBean been = new UserBean();
		
		UserModel model = new UserModel();
		
		been = model.authentication("ravi@gmail.com", "ravi789");
		
		if(been != null) {
			
			System.out.println(been.getId());
			System.out.println(been.getFirstName());
			System.out.println(been.getLastName());
			System.out.println(been.getDob());
			System.out.println(been.getAddress());
			
		}else {
			
			System.out.println("user not found...");
			
		}
		
	}

	private static void testFinedById() throws Exception {
		
		UserBean been = new UserBean();
		
		UserModel model = new UserModel();
		
		been = model.finedById(5);
		
		if(been != null) {
			
			System.out.println(been.getId());
			System.out.println(been.getFirstName());
			System.out.println(been.getLastName());
			System.out.println(been.getLoginId());
			System.out.println(been.getPassword());
			System.out.println(been.getDob());
			System.out.println(been.getAddress());
			
		}else {
			
			System.out.println("user not found...");
			
		}
		
	}

	private static void testDelete() throws Exception {
		
		UserModel model = new UserModel();
		
		model.delete(11);
		
	}

	private static void testUpdate() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserBean been = new UserBean();
		
		UserModel model = new UserModel();
		
		been.setId(11);
		been.setFirstName("demo");
		been.setLastName("demo");
		been.setLoginId("dem0@gamil.com");
		been.setPassword("demo123");
		been.setDob(sdf.parse("2001-01-01"));
		been.setAddress("demo");
		
		model.update(been);
		
	}

	private static void testInsert() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserBean been = new UserBean();
		
		UserModel model = new UserModel();
		
		been.setId(12);
		been.setFirstName("demo");
		been.setLastName("demo");
		been.setLoginId("dem0@gamil.com");
		been.setPassword("demo123");
		been.setDob(sdf.parse("2001-01-01"));
		been.setAddress("demo");
		
		model.Insert(been);
			
	}
	
	

}
