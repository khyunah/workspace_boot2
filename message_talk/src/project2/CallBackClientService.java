package project2;

public interface CallBackClientService {
	void clickConnectServerBtn(String id);
	void clickSendMessageBtn(String messageText);
	void clickSendSecretMessageBtn(String msg);
	void clickMakeRoomBtn(String roomName);
	void clickOutRoomBtn(String roomName);
	void clickEnterRoomBtn();
}