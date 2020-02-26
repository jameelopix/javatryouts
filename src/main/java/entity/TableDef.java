package entity;

import org.apache.commons.beanutils.BasicDynaClass;
import org.apache.commons.beanutils.DynaProperty;

public class TableDef extends BasicDynaClass {

	private static final long serialVersionUID = 1L;

	public TableDef(String name) {
		super(name, Table.class, null);
	}

	public void addProperty(String name) {
		this.addProperty(name, null, null);
	}

	public void addProperty(String name, Class<?> type) {
		this.addProperty(name, type, null);
	}

	public void addProperty(final String name, final Class<?> type, final Class<?> contentType) {
		DynaProperty[] targetProperties = new DynaProperty[properties.length + 1];

		System.arraycopy(properties, 0, targetProperties, 0, targetProperties.length);
		DynaProperty dynaProperty = null;
		if (contentType == null) {
			dynaProperty = new DynaProperty(name, type);
		} else {
			dynaProperty = new DynaProperty(name, type, contentType);
		}
		targetProperties[targetProperties.length - 1] = dynaProperty;
	}
}
