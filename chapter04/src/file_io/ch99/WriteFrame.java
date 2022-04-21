package file_io.ch99;

import java.awt.Color;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WriteFrame extends JFrame {
	
	JPanel panel;
	TextArea textArea;
	JButton button;
	
	FileWriter fw;
	BufferedWriter bw;
	
	String text;

	public WriteFrame() {
		initObject();
		initSetting();
		initEventListener();
	}

	private void initObject() {
		panel = new JPanel();
		textArea = new TextArea("하고싶은 말을 써주세요 !", 30, 80, Scrollbar.VERTICAL);
		button = new JButton("글 저장");
	}

	private void initSetting() {
		setTitle("다이어리 쓰기");
		setSize(650, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		textArea.setSize(600, 600);
		button.setBackground(Color.WHITE);
		
		add(panel);
		panel.add(textArea);
		panel.add(button);

		setVisible(true);
	}
	
	private String checkDate() {
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		return  dateFormat.format(calendar.getTimeInMillis());
	}
	
	private void initEventListener() {
		
		button.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					fw = new FileWriter("my_diary.txt", true);
					bw = new BufferedWriter(fw);
					
					text = textArea.getText();
					
					bw.write("today date : " + checkDate());
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
		});
	}
	
	public static void main(String[] args) {
		new WriteFrame();
	}
}
