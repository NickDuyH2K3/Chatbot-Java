
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ChucNang {
	public static String Chat(String key)
	{
		Connection conn = null;
		PreparedStatement s = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://WAKO\\SQLEXPRESS:1433;databaseName=ChatBot;","sa", "120303");
			String sql = "Select * from chat where keyword like ?";
			s=conn.prepareCall(sql);
			s.setString(1,"%"+key+"%");
			ResultSet rs = s.executeQuery();
			if (rs.next())
			{
				return rs.getString("answer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static void add(String key, String answer)
	{
		Connection conn = null;
		PreparedStatement s = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://WAKO\\SQLEXPRESS:1433;databaseName=ChatBot;","sa", "120303");
			String sql = "insert into chat (keyword, answer) values (?,?)";
			s=conn.prepareCall(sql);
			s.setString(1,key);
			s.setString(2,answer);
			s.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String Login(String tk, String mk)
	{
		Connection conn = null;
		Connection connect = null;
		PreparedStatement statement = null;
		PreparedStatement st = null;
		try {
			conn = DriverManager.getConnection("jdbc:sqlserver://WAKO\\SQLEXPRESS:1433;databaseName=ChatBot;","sa", "120303");
			String sql="Select ten from tk where tk =? and mk = ?";
			statement =  conn.prepareCall(sql);
			statement.setString(1, tk);
			statement.setString(2,mk);
			ResultSet rs = statement.executeQuery();
			if (rs.next())
			{
				
				return rs.getString("Ten");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}
