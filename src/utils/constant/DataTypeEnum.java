package utils.constant;

public enum DataTypeEnum {
	STRING("CHAR", "String"), VARCHAR("VARCHAR", "String"), LONGVARCHAR("LONGVARCHAR", "String"), NUMERIC("NUMERIC", "java.math.BigDecimal"), DECIMAL("DECIMAL", "java.math.BigDecimal"), BIT("BIT", "Boolean"), TINYINT("TINYINT", "Integer"), // Byte
	SMALLINT("SMALLINT", "Integer"), // Short
	INT("INT", "Integer"), INTEGER("INTEGER", "Integer"), BIGINT("BIGINT", "Long"), REAL("REAL", "Float"), FLOAT("FLOAT", "Double"), DOUBLE("DOUBLE", "Double"), DATE("DATE", "Date"), // java.util.Date
	TIME("TIME", "Date"), DATETIME("DATETIME", "Date"), TIMESTAMP("TIMESTAMP", "java.sql.Timestamp"), DEFAUlT("NULL", "Object");
	private String sqlType;
	private String javaType;

	private DataTypeEnum(String sqlType, String javaType) {
		this.sqlType = sqlType;
		this.javaType = javaType;
	}

	public static DataTypeEnum getEnumBySqlType(String sqlType) {
		for (DataTypeEnum e : DataTypeEnum.values()) {
			if (e.getSqlType().equalsIgnoreCase(sqlType)) {
				return e;
			}
		}
		return DEFAUlT;
	}

	public static String getJavaType(String sqlType) {
		return getEnumBySqlType(sqlType).getJavaType();
	}

	public String getSqlType() {
		return sqlType;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setSqlType(String sqlType) {
		this.sqlType = sqlType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

}
