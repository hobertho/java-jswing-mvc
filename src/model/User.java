package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class User {
	
	public Integer id = null;
	public String username = "";
	public String password = "";
	public String error = "";
	
	public User()
	{
		this.username = "";
		this.password = "";
	}
	
	public User(HashMap<String, String> params)
	{
		this.username = params.get("username");
		this.password = params.get("password");
	}
	
	public static User findById(int id)
	{
		String query = "SELECT * FROM USERS WHERE ID = ? LIMIT 1";
		User user = new User();
		try {
			PreparedStatement stmt = Mysql.getConnection().prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				user.id = rs.getInt("id");
				user.username = rs.getString("username");
				user.password = rs.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public boolean save()
	{
		String query = "INSERT INTO USERS (id, username, password) VALUES(?, ?, ?) ON DUPLICATE KEY UPDATE username = ?, password = ?";
		try {
			PreparedStatement stmt = Mysql.getConnection().prepareStatement(query);
			stmt.setInt(1, this.id);
			stmt.setString(2, this.username);
			stmt.setString(3, this.password);
			stmt.setString(4, this.username);
			stmt.setString(5, this.password);
			stmt.executeUpdate();
			Mysql.getConnection().commit();
			this.error = "";
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.error = e.getMessage();
			return false;
		}
	}

}
