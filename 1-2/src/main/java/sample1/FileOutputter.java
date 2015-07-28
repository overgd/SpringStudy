package sample1;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {

	private String filePath;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void output(String message) throws IOException {

		FileWriter out = new FileWriter(filePath);
		out.write(message);
		out.close();
		System.out.println("파일 출력 완료!");

	}

}