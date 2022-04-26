package project2;

public interface CallBackService {
	default void startServer() {};
	void connectServer(String id);
	void sendMessage(String messageText);
	default void sendSecretMessage(String msg) {};
	default void makeRoom(String roomName) {};
	default void outRoom() {};
}
