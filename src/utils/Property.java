package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 获取属性文件类
 * 
 * @author Wuhao
 */
public class Property {

	private static Property property;
	private Properties config;
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private String dbName;
	private String tableName;
	private String filePath;
	private String domainPackage;
	private Boolean isNeedDomain;
	private Boolean isNeedSqlmapper;
	private Boolean isNeedDao;

	public Boolean getIsNeedDomain() {
		return ("true").equals(config.getProperty("need.domain"));
	}

	public Boolean getIsNeedSqlmapper() {
		return ("true").equals(config.getProperty("need.sqlmapper"));
	}

	public Boolean getIsNeedDao() {
		return ("true").equals(config.getProperty("need.dao"));
	}

	public String getDomainPackage() {
		return config.getProperty("file.domainpackage");
	}

	public String getDaoPackage() {
		return config.getProperty("file.daopackage");
	}

	public String getFilePath() {
		return config.getProperty("file.path");
	}

	public String getDbName() {
		return config.getProperty("database.dbName");
	}

	public String getTableName() {
		return config.getProperty("database.tableName");
	}

	public String getDriverClassName() {
		return config.getProperty("jdbc.driverClassName");
	}

	public String getUrl() {
		return config.getProperty("jdbc.url");
	}

	public String getUsername() {
		return config.getProperty("jdbc.username");
	}

	public String getPassword() {
		return config.getProperty("jdbc.password");
	}

	private Property(){
		try {
			config = new Properties();
			InputStream in = Property.class.getClassLoader().getResourceAsStream("resources/config.properties");
			config.load(in);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static Property getInstance() {
		if (null == property) {
			property = new Property();
		}
		return property;
	}
}
