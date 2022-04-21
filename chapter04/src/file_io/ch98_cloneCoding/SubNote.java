package file_io.ch98_cloneCoding;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class SubNote extends JFrame {

	private WriteNote onWriteNote;
	private JTextArea textArea;
	private JButton saveBtn;
	
	public SubNote(WriteNote onWriteNote) {
		this.onWriteNote = onWriteNote;
		
		saveBtn = new JButton("파일 저장");
		textArea = new JTextArea("내용 입력 칸");
		
		setTitle("My Note");
		setSize(400, 400);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(saveBtn);
		add(textArea);
		
		saveBtn.setBounds(150, 10, 100, 50);
		
		textArea.setSize(200, 200);
		textArea.setBackground(Color.PINK);
		textArea.setBounds(100, 100, 200, 200);
		
		addListener();
	}

	private void addListener() {
		saveBtn.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				onWriteNote.saveNate(textArea.getText());
			}
		});
	}
}
