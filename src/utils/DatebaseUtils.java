package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ModelBean;
import model.ModelFields;
import utils.constant.DataTypeEnum;

public class DatebaseUtils {

	public final static String SPILIT = ",";
	public final static String sql = "SELECT TABLE_NAME,COLUMN_NAME,DATA_TYPE,COLUMN_KEY,EXTRA,COLUMN_COMMENT FROM information_schema.`COLUMNS` WHERE TABLE_SCHEMA=? AND TABLE_NAME=?";
	public final String type = "java.util.Date";
	private static Connection conn;
	static {
		Property jdbc = Property.getInstance();
		try {
			Class.forName(jdbc.getDriverClassName());
			conn = DriverManager.getConnection(jdbc.getUrl(), jdbc.getUsername(), jdbc.getPassword());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据数据库名称和表名称获取对应的实体
	 * 
	 * @param dbName
	 * @param tableName
	 * @return
	 */
	public static List<ModelBean> gainModelBean() {
		List<ModelBean> modelList = new ArrayList<ModelBean>();
		Property property = Property.getInstance();
		PreparedStatement pstmt;
		try {
			String dbName = property.getDbName();
			String tableNames = property.getTableName();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dbName);
			for (String tableName : tableNames.split(SPILIT)) {
				List<ModelFields> fieldsList = new ArrayList<ModelFields>();
				ModelBean modelBean = new ModelBean();
				modelBean.setTableName(tableName);
				pstmt.setString(2, tableName);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					String type = rs.getString("DATA_TYPE");
					String name = rs.getString("COLUMN_NAME");
					String comment = rs.getString("COLUMN_COMMENT");
					String mapperType = DataTypeEnum.getJavaType(type);
					ModelFields modelFields = new ModelFields(mapperType, name, comment);
					fieldsList.add(modelFields);
					if ("Date".equals(mapperType)) {
						List<String> packages = modelBean.getImportPackage();
						if (null == packages) {
							List<String> importPackage = new ArrayList<String>();
							importPackage.add("java.util.Date");
							modelBean.setImportPackage(importPackage);
						} else {
							if (!packages.contains(type)) {
								packages.add(type);
							}
						}
					}
				}
				modelBean.setProperties(fieldsList);
				modelList.add(modelBean);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modelList;
	}
}
