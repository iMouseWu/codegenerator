package model;

import java.util.List;

import utils.StringUtils;

public class ModelBean {

	private String packageName;
	private List<String> importPackage;
	private String className;
	private String tableName;
	private String comment;
	private List<ModelFields> properties;

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public List<String> getImportPackage() {
		return importPackage;
	}

	public void setImportPackage(List<String> importPackage) {
		this.importPackage = importPackage;
	}

	public String getClassName() {
		return changeTableName(tableName);
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<ModelFields> getProperties() {
		return properties;
	}

	public void setProperties(List<ModelFields> properties) {
		this.properties = properties;
	}

	private String changeTableName(String columnName) {
		if (columnName != null) {
			String[] strs = columnName.split("_");
			StringBuilder sb = new StringBuilder();
			for (String str : strs) {
				sb.append(StringUtils.upperCaseFirstOne(str));
			}
			return sb.toString();
		} else {
			return null;
		}
	}

}
