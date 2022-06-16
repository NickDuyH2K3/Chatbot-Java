import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Imple implements Hello{

	public String Chat(String key) throws RemoteException {
		// TODO Auto-generated method stub
		if (ChucNang.Chat(key)!=null)
		{
			return ChucNang.Chat(key);
		}
		
		return "Có cc bố m trả lời được :)))";
	}

	@Override
	public String login(String tk, String mk) throws RemoteException {
		return ChucNang.Login(tk, mk);
		
	}

	@Override
	public void updateUser(String name) throws RemoteException {
		// TODO Auto-generated method stub
		ServerFrame.updateUser(name);
		
	}

	@Override
	public void updateChat(String name, String chat) throws RemoteException {
		// TODO Auto-generated method stub
		ServerFrame.updateChat(name, chat);
	}

	@Override
	public void add(String key, String answer) throws RemoteException {
		// TODO Auto-generated method stub
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

}
