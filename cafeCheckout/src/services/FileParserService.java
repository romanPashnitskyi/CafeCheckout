package services;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import fileParsers.TxtParser;
import models.OrderLine;

public class FileParserService {
	protected static final String TXT = "txt";
	
	private String filePath;

    public FileParserService(String filePath) {
		this.filePath = filePath;
    }
    
    public List<OrderLine> parse() {
		this.checkIfFileExists();

		String fileExtension = getFileExtension(this.filePath);

		switch(fileExtension) {
			case TXT:
				return (new TxtParser(this.filePath)).parse();

            // You can add here additional file parsers

			default:
				System.out.println("Currently we don't support files with '" + fileExtension + "' extension!");
				System.exit(0);
				return new ArrayList<OrderLine>();
		}
	}
    
    protected void checkIfFileExists() {
    	File fileName = new File(this.filePath);
		if (!fileName.exists()) {
			System.out.println("File doesn't exist!");
            System.exit(0);
		}
	}
    
    protected static String getFileExtension(String fileString) {
    	File file = new File(fileString);
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
