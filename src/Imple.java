import java.rmi.RemoteException;

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

}
