package fileParsers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.OrderLine;
import services.ParameterParserService;

public class TxtParser implements IFileParser {
	protected String filePath;
	protected List<OrderLine> orderLines;
    
    public TxtParser(String filePath) {
		this.filePath = filePath;
		this.orderLines = new ArrayList<OrderLine>();
    }
    
	public List<OrderLine> parse() {
		try {
			BufferedReader fileBR = new BufferedReader(new FileReader(this.filePath));
		    String line;
		    
		    while ((line = fileBR.readLine()) != null) {
		    	this.parseRow(line);
		    }
		    fileBR.close();
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		return this.orderLines;
	}

	protected void parseRow(String line) {
		String[] properties = line.split(", ");

		if (properties.length != 4 || !new ParameterParserService().tryParseInt(properties[2])) {
			System.out.println("File contains incorrect data!");
            System.exit(0);
		}

		String waiter = properties[0];
		int table = Integer.parseInt(properties[2]);
		String guest = properties[1];
        String item = properties[3];

		OrderLine orderLine = new OrderLine(waiter, guest, table, item);

		this.orderLines.add(orderLine);
	}
	
}
