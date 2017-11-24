package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql {
	
	static Connection conn = null;
	
	public static Connection getConnection()
	{
		if (conn != null) return conn;
		return getConnection("simpleMVC", "root", "");
	}
	
	private static Connection getConnection(String db_name, String user_name, String password)
	{
		try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/"+db_name+"?user="+user_name+"&password="+password);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        return conn;   
	}

}
