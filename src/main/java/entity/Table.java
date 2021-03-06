package entity;

import org.apache.commons.beanutils.BasicDynaBean;

public class Table extends BasicDynaBean {

	private static final long serialVersionUID = 1L;

	private long id;
	private String key;
	private String name;
	private String description;
	private long appId;

	public Table(TableDef tableDef) {
		super(tableDef);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getAppId() {
		return appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
