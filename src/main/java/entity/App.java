package entity;

import java.util.Map;

public class App {

	private long id;
	private String key;
	private String name;
	private String description;
	private Map<String, TableDef> keyMap;
	private Map<String, TableDef> nameMap;

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

	public Map<String, TableDef> getKeyMap() {
		return keyMap;
	}

	public void setKeyMap(Map<String, TableDef> keyMap) {
		this.keyMap = keyMap;
	}

	public Map<String, TableDef> getNameMap() {
		return nameMap;
	}

	public void setNameMap(Map<String, TableDef> nameMap) {
		this.nameMap = nameMap;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
