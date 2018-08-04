package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResponseService {
	protected String receipt;

	public ResponseService(String receipt) {
		this.receipt = receipt;
    }

	public void writeInConsole() {
		System.out.println(this.receipt);
	}

    public void writeInFile() {
    	try {
			File file = new File("receipt.txt");
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(this.receipt);
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
    }
}
