package file_io.ch99;

import java.awt.Color;
import java.awt.Scrollbar;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;


public class WritePanel extends JPanel {
	
	private TextArea textArea;
	private JButton button;
	
	private CallBackCheckButton callBackCheckButton;
	
	public TextArea getTextArea() {
		return textArea;
	}

	public JButton getButton() {
		return button;
	}

	public WritePanel(CallBackCheckButton callBackCheckButton) {
		this.callBackCheckButton = callBackCheckButton;
		initObject();
		initSetting();
		initListener();
	}
	
	private void initObject() {
		textArea = new TextArea("글 쓰기", 30, 80, Scrollbar.VERTICAL);
		button = new JButton("글 저장");
	}
	
	private void initSetting() {
		setSize(600, 600);
		
		textArea.setSize(600, 600);
		button.setBackground(Color.WHITE);
		
		add(textArea);
		add(button);
	}
	
	private void initListener() {

		button.addMouseListener(new MouseAdapter() {
		
			@Override
			public void mouseClicked(MouseEvent e) {
				callBackCheckButton.clickedButton();
			}
		});
	}
}
