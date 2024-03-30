package com.example.jr1.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionController {
	private static String url="jdbc:mysql://127.0.0.1:3306/javajr";
    private static String user="root";
    private static String psw="root";

    private static Connection con;

    public static Connection getInstance() throws SQLException {
        if (con==null){
            con= DriverManager.getConnection(url,user,psw);
        }

        return con;
    }
    
    public void Close() {
    	if (con!=null){
    		try {
				con.close();
			} catch (SQLException e) {
				System.out.println(e);
			
			}
    	}
    	
    }

}
