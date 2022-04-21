package file_io.ch99;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;

public class WriteFrame extends JFrame implements CallBackCheckButton {

	private WritePanel writePanel;
	private CheckDate checkDate;

	private FileWriter fw;
	private BufferedWriter bw;

	private String text;

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
	public void clickedButton() {
		try {
			fw = new FileWriter("my_diary.txt", true);
			bw = new BufferedWriter(fw);

			text = writePanel.getTextArea().getText();

			bw.write("today date : " + checkDate.checkDate());
			bw.write("\n-------------today diary----------------\n");
			bw.write(text);
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
