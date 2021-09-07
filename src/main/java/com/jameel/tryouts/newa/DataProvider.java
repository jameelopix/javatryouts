package com.jameel.tryouts.newa;

import java.util.LinkedList;
import java.util.List;

public class DataProvider {
	public static List<Person> getPersonList() {
		List<Person> personList = new LinkedList<Person>();

		Person s1 = new Person("Gandhi", 30, "INDIA", Gender.MALE);
		Person s2 = new Person("Bill Gates", 30, "USA", Gender.MALE);
		Person s3 = new Person("Elon Musk", 30, "South Africa", Gender.MALE);
		Person s4 = new Person("Ronaldo", 30, "PORTUGAL", Gender.MALE);
		Person s5 = new Person("Elizabeth", 30, "UK", Gender.FEMALE);
		Person s6 = new Person("TERASA", 35, "UK", Gender.FEMALE);

		personList.add(s1);
		personList.add(s2);
		personList.add(s3);
		personList.add(s4);
		personList.add(s5);
		personList.add(s6);

		return personList;
	}
}
