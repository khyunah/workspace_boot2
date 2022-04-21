package file_io.ch99;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
/**
 * File I/O Stream 이용해서 미니다이어리 구현해보기<br>
 * 사용자가 작성한 문자열을 콜백 메서드의 매개변수로 넘겨받아서 <br>
 * 콜백이 일어나면 파일에 저장을 하는 역할.
 * 
 * @author 김현아
 *
 */
public class WriteFrame extends JFrame implements CallBackCheckButton {

	private WritePanel writePanel;
	private CheckDate checkDate;

	private FileWriter fw;
	private BufferedWriter bw;

	public WriteFrame() {
		initObject();
		initSetting();
	}

	private void initObject() {
		checkDate = new CheckDate();
		writePanel = new WritePanel(this);
	}

	private void initSetting() {
		setTitle("다이어리 쓰기");
		setSize(650, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(writePanel);

		setVisible(true);
	}
	
	@Override
	public void clickedButton(String data) {
		try {
			fw = new FileWriter("my_diary.txt", true);
			bw = new BufferedWriter(fw);

			bw.write("today date : " + checkDate.checkDate());
			bw.write("\n-------------today diary----------------\n");
			bw.write(data);
			bw.write("\n----------------------------------------");
			bw.write("\n\n\n");

			bw.flush();
			bw.close();

			System.exit(0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new WriteFrame();
	}
}
