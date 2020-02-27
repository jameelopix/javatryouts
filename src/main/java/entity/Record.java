package entity;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.DynaClass;

public class Record extends BasicDynaBean {

	private static final long serialVersionUID = 1L;

	public Record(DynaClass dynaClass) {
		super(dynaClass);
	}
}
