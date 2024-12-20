package abeet.patel.jdbc.preparedStatement;

import java.text.SimpleDateFormat;
import java.util.List;

public class TestUserModel {
	
	public static void main(String[] args) throws Exception {
		
		//testInsert();
		//testUpdate();
		//testDelete();
		//testFinedById();
		//testAuthentication();
		testSearch();
		
	}

	private static void testSearch() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserBean been = new UserBean();
		
		UserModel model = new UserModel();
		
		//been.setFirstName("pooja");
		//been.setLastName("gupta");
		//been.setLoginId("gita@gamil.com");
		//been.setPassword("rahul123");
		//been.setDob(sdf.parse("2000-08-18"));
		been.setAddress("indore");
		
		List list = model.search(been);
		
	}

	private static void testAuthentication() throws Exception {
		
		UserBean been = new UserBean();
		
		UserModel model = new UserModel();
		
		been = model.authentication("demo@gmail.com", "demo123");
		
		if(been != null) {
			
			System.out.println(been.getId());
			System.out.println(been.getFirstName());
			System.out.println(been.getLastName());
			System.out.println(been.getDob());
			System.out.println(been.getAddress());
			
		}else {
			
			System.out.println("user not found....");
			
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
		been.setFirstName("abeet");
		been.setLastName("patel");
		been.setLoginId("demo@gmail.com");
		been.setPassword("demo123");
		been.setDob(sdf.parse("2000-01-01"));
		been.setAddress("jabalpur");
		
		model.update(been);
		
	}

	private static void testInsert() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
		
		UserBean been = new UserBean();
		
		UserModel model = new UserModel();
		
		been.setId(11);
		been.setFirstName("abeet");
		been.setLastName("patel");
		been.setLoginId("demo@gmail.com");
		been.setPassword("demo123");
		been.setDob(sdf.parse("2000-01-01"));
		been.setAddress("jabalpur");
		
		model.insert(been);
		
	}

}
