import java.rmi.RemoteException;

public interface Hello extends java.rmi.Remote
{
	public String Chat(String key)throws RemoteException;
	public String login(String tk, String mk)throws RemoteException;
	public void updateUser(String name) throws RemoteException;
	public void updateChat(String name, String chat) throws RemoteException;
}