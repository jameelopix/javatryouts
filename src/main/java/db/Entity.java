package db;

import java.util.Date;

import org.apache.commons.beanutils.BasicDynaBean;
import org.apache.commons.beanutils.DynaClass;

public class Entity extends BasicDynaBean {

	private static final long serialVersionUID = 1L;

	private long id;
	private String createdBy;
	private Date createdAt;
	private String lastUpdatedBy;
	private Date lastUpdatedAt;
	private int version;
	private String appName;
	private String tableName;
	private long appId;

	public Entity(DynaClass dynaClass) {
		super(dynaClass);
		tableName = dynaClass.getName();
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", createdBy=" + createdBy + ", createdAt=" + createdAt + ", lastUpdatedBy="
				+ lastUpdatedBy + ", lastUpdatedAt=" + lastUpdatedAt + ", version=" + version + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public long getAppId() {
		return appId;
	}

	public void setAppId(long appId) {
		this.appId = appId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
}
