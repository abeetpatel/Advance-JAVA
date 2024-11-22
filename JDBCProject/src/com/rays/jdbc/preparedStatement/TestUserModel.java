package com.rays.jdbc.preparedStatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {

	public static void main(String[] args) throws Exception {

		// testAdd();
		// testDelete();
		// testUpdate();
		// testFindById();
		// testAuthentication();
		testSearch();

	}

	private static void testSearch() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		// bean.setFirstName("Amit");
		// bean.setLastName("Pandey");
		// bean.setLoginId("pooja@gmail.com");
		// bean.setPassword("gita456");
		bean.setDob(sdf.parse("1993-06-05"));
		// bean.setAddress("indore");

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (UserBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getDob());
			System.out.println("\t" + bean.getAddress());

		}

	}

	private static void testAuthentication() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean = model.authenticate("ram@gmail.com", "ram123");

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getDob());
			System.out.println(bean.getAddress());

		} else {
			System.out.println("user not found");
		}

	}

	private static void testFindById() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean = model.findById(15);

		if (bean != null) {

			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());

		} else {
			System.out.println("user not found");
		}

	}

	private static void testUpdate() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setId(10);
		bean.setFirstName("Ramesh");
		bean.setLastName("Prajapati");
		bean.setLoginId("ramesh@gmail.com");
		bean.setPassword("ramesh123");
		bean.setDob(sdf.parse("2002-01-02"));
		bean.setAddress("indore");

		model.update(bean);

	}

	private static void testDelete() throws Exception {

		UserModel model = new UserModel();

		model.delete(11);

	}

	private static void testAdd() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserModel model = new UserModel();

		UserBean bean = new UserBean();

		bean.setFirstName("Ravi");
		bean.setLastName("Prajapati");
		bean.setLoginId("ravi@gmail.com");
		bean.setPassword("ravi123");
		bean.setDob(sdf.parse("2002-01-02"));
		bean.setAddress("indore");

		model.add(bean);

	}

}
