package com.jameel.javatryouts;

import java.util.Date;

import org.apache.commons.beanutils.DynaProperty;
import org.junit.BeforeClass;
import org.junit.Test;

import db.Entity;
import db.EntityDef;
import db.Repository;
import db.RepositoryImpl;

public class RepositoryTest {

	private static final String NAME = "NAME";
	private static final String AGE = "AGE";
	private static final String DOB = "DOB";
	private static final String SALARY = "SALARY";

	static EntityDef entityDef = new EntityDef("EMPLOYEE");
	static Entity entity = new Entity(entityDef);

	Repository repository = new RepositoryImpl();

	@BeforeClass
	public static void setup() {
		entityDef.addProperty(NAME, String.class);
		entityDef.addProperty(AGE, Integer.class);
		entityDef.addProperty(DOB, Date.class);
		entityDef.addProperty(SALARY, Double.class);

		entity.setAppName("UST");
		entity.setId(111L);
		entity.setCreatedBy("JAMEEL");
		entity.setCreatedAt(new Date());
		entity.setLastUpdatedBy("ASRAF");
		entity.setLastUpdatedAt(new Date());
		entity.setVersion(5);
		entity.set(NAME, "SAFFI");
		entity.set(AGE, 25);
		entity.set(DOB, new Date());
		entity.set(SALARY, 10000.00D);

	}

	@Test
	public void testSave() {
		System.out.println("RepositoryTest.testSave()");

		Entity result = repository.save(entity);

		System.out.println(entity.toString());
		for (DynaProperty property : entity.getDynaClass().getDynaProperties()) {
			System.out.println(property.getName() + " : " + entity.get(property.getName()));
		}
	}

}
