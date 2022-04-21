package file_io.ch98_cloneCoding;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class MyNote implements WriteNote {
	
	public MyNote() {
		new SubNote(this);
	}
	
	@Override
	public void saveNate(String text) {
		System.out.println("파일을 저장합니다.");
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt"))) {
			bw.write(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MyNote();
	}
}
