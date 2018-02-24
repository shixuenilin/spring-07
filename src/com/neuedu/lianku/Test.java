package com.neuedu.lianku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://192.168.145.128:3306/db2";
		String user = "root";
		String password = "123456";
		try {
			//加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			//创建主机和要操作的数据库
			Connection con = DriverManager.getConnection(url, user, password);
			//创建命令窗口
			PreparedStatement ps = con.prepareStatement("select * from student");
			//运行sql语句
			ResultSet rs = ps.executeQuery();
			//查看结果
			while (rs.next()) {
				System.out.println(rs.getInt("id")+" "+rs.getString("name"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
