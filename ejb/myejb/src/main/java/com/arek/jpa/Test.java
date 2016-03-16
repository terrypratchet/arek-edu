package com.arek.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

	private EntityManager em;
	EntityManagerFactory emf;

	public Test() {
		String unitName;
		// unitName ="sample";
		unitName = "fileDatabase";

		emf = Persistence
				.createEntityManagerFactory(unitName);
		em = emf.createEntityManager();

		emf.close();
	}

	public void create() {
		Person person = new Person();
		person.setFirstName("Kubuś");
		person.setLastName("Uszatek" + System.currentTimeMillis());
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("color", "green");
		person.setSomeMap(map);
		
		em.merge(person);
		em.flush();
	}

	public void find() {
		List list = em.createQuery("select p from Person p").getResultList();
		System.out.println("rows: " + list.size());
		for (Object row : list) {
			System.out.println("row: " + row);
		}
	}

	public static void main(String[] args) {
		
		Test test = new Test();
		test.em.getTransaction().begin();
		test.create();
		test.find();
		test.em.close();
		test.emf.close();
		

	}
}
