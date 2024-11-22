package com.rays.jdbc.preparedStatement;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {

	public static void main(String[] args) throws Exception {

		testAdd();
		//testUpdate();
		//testDelete();
		//testGetById();
		//testSearch();
		//testMeritList();

	}

	private static void testMeritList() throws Exception {
		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();

		List list = model.getMeritList(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			int total = bean.getPhysics() + bean.getChemistry() + bean.getMaths();
			double p = total / 3;
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}

	}

	private static void testSearch() throws Exception {

		MarksheetModel model = new MarksheetModel();

		MarksheetBean bean = new MarksheetBean();

		List list = model.search(bean);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (MarksheetBean) it.next();

			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getPhysics());
			System.out.print("\t" + bean.getChemistry());
			System.out.println("\t" + bean.getMaths());

		}

	}

	private static void testGetById() throws Exception {

		MarksheetBean been = new MarksheetBean();

		MarksheetModel model = new MarksheetModel();

		been = model.getById(10);

		if (been != null) {

			System.out.println(been.getId());
			System.out.println(been.getName());
			System.out.println(been.getRoll_no());
			System.out.println(been.getPhysics());
			System.out.println(been.getChemistry());
			System.out.println(been.getMaths());

		} else {

			System.out.println("user not found...");

		}

	}

	private static void testDelete() throws Exception {

		MarksheetModel model = new MarksheetModel();

		model.delete(17);

	}

	private static void testUpdate() throws Exception {

		MarksheetBean been = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		been.setName("demo");
		been.setRoll_no("demo12");
		been.setPhysics(50);
		been.setChemistry(51);
		been.setMaths(54);
		been.setId(17);

		model.update(been);

	}

	private static void testAdd() throws Exception {

		MarksheetBean been = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		been.setId(17);
		been.setName("demo1");
		been.setRoll_no("demo2");
		been.setPhysics(5);
		been.setChemistry(5);
		been.setMaths(5);

		model.add(been);

	}

}
