package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;

public class AppMain {

	private static final String VERSION = "version";
	private static final String LAST_UPDATED_AT = "lastUpdatedAt";
	private static final String LAST_UPDATED_BY = "lastUpdatedBy";
	private static final String CREATED_AT = "createdAt";
	private static final String CREATED_BY = "createdBy";
	private static final String ID = "id";

	public AppMain() {
		DynaProperty[] dynaProperties = new DynaProperty[] { new DynaProperty(ID, Long.class),
				new DynaProperty(CREATED_BY, Long.class), new DynaProperty(CREATED_AT, Date.class),
				new DynaProperty(LAST_UPDATED_BY, Long.class), new DynaProperty(LAST_UPDATED_AT, Date.class),
				new DynaProperty(VERSION, Integer.class), };
		DynaClass dynaClass = new BasicDynaClass("entity", null, dynaProperties);

		DynaBean bean = new BasicDynaBean(dynaClass);
		bean.set(ID, 100l);
		bean.set(CREATED_BY, 20l);
		bean.set(CREATED_AT, new Date());
		bean.set(LAST_UPDATED_BY, 10L);
		bean.set(LAST_UPDATED_AT, new Date());
		bean.set(VERSION, 1);

//		SqlGenerator generator=new SqlGenerator();
//		generator.sa

		Repository repository = new RepositoryImpl();
		repository.save(bean);
	}

	public static void main(String[] args) {
		System.out.println("AppMain.main()");
		new AppMain();
	}

	public static void main1(String[] args) {
		System.out.println("Hello World!");
		Course course = new Course();
		Student student = new Student();
		String name = "Computer Science";
		List<String> codes = Arrays.asList("CS", "CS01", "MA01");

		try {
			PropertyUtils.setSimpleProperty(course, "name", name);

			PropertyUtils.setSimpleProperty(course, "codes", codes);
			PropertyUtils.setIndexedProperty(course, "codes[1]", "CS02");
			PropertyUtils.setIndexedProperty(course, "codes[2]", "CS03");

			PropertyUtils.setMappedProperty(course, "enrolledStudent(ST-1)", student);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(course.toString());

		DynaBean bean = new Teacher();
//		bean.set(name, index, value);

//		System.out.println(course.getName());
	}
}
