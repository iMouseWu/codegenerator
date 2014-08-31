package model;

import utils.StringUtils;

public class ModelFields {
	private String popName;
	private String popType;
	private String columnName;
	private String comment;

	public ModelFields() {
		super();
	}

	public ModelFields(String popType, String columnName, String comment) {
		this.popType = popType;
		this.columnName = columnName;
		this.comment = comment;
	}

	public String getPopName() {
		return changeColumnName(columnName);
	}

	public String getPopType() {
		return popType;
	}

	public void setPopType(String popType) {
		this.popType = popType;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	private String changeColumnName(String columnName) {
		if (columnName != null) {
			String[] strs = columnName.split("_");
			StringBuilder sb = new StringBuilder();
			for (String str : strs) {
				sb.append(StringUtils.upperCaseFirstOne(str));
			}
			return StringUtils.lowerCaseFirstOne(sb.toString());
		} else {
			return null;
		}
	}
}