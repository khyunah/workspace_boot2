package project2;

public interface CallBackService {
	default void startServer() {};
	void connectServer(String ip, int port, String id);
	void sendMessage(String messageText);
	
}
