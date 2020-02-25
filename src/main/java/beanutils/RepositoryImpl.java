package beanutils;

import org.apache.commons.beanutils.DynaBean;

public class RepositoryImpl implements Repository {

	SqlGenerator generator = new SqlGenerator();

	public void save(DynaBean bean) {
		System.out.println(generator.save(bean));
	}

}
