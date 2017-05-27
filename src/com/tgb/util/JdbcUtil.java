package com.tgb.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * jdbc工具类
 * @author Administrator
 *
 */
public class JdbcUtil {
	private static Connection connection;
	private static Statement statment;
	private static ResultSet resultSet;
	//建立连接
	public static Connection getConnection(String jdbcType,String jdbcUrl,String user,String password) throws Exception{
		if(!("mysql".equals(jdbcType)|| "oracle".equals(jdbcType) || "sqlServer".equals(jdbcType))){
			throw new Exception("暂时只支持mysql,oracle,sqlServer");
		}
		switch (jdbcType) {
		case "mysql":
			Class.forName("com.mysql.jdbc.Driver");
			break;
		case "oracle":
			Class.forName("oracle.jdbc.driver.OracleDriver");
			break;
		case "sqlServer":
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			break;
		}
		try {
			connection = DriverManager.getConnection(jdbcUrl,user,password);
		} catch (Exception e) {
			throw new Exception("请检查数据库信息是否正确!");
		}
	    return connection;
	}
	
	//关闭连接
	public static void close(ResultSet rs,Statement st,Connection con){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				rs = null;
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				st = null;
			}
		}
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				con = null;
			}
		}
	}
	
	//返回数据库所有表名
	public static ResultSet getTables(DatabaseMetaData databaseMetaData,String user) throws Exception{
		ResultSet  rs = null;
		try {
			rs = databaseMetaData.getTables(null,user,null,new String[]{"TABLE"});
		} catch (Exception e) {
			throw new Exception("数据库操作失败!");
		}
		return rs;
	}
	
	
	//
}
