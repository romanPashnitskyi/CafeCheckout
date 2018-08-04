package services;

import java.util.HashMap;
import java.util.Map;

import models.Parameters;

public class ParameterParserService {
	private String[] args;
	private Map<String, String> parameters;
	
	public ParameterParserService() { }
	
	public ParameterParserService(String[] args) {
		this.args = args;
		this.parameters = new HashMap<String, String>();
    }
	
	public Parameters parse() {
		for (String argument : this.args) {
			this.checkForFile(argument);
			this.checkForTable(argument);
			this.checkForGuest(argument);
		}

		if (!this.parameters.containsKey("file") || !this.parameters.containsKey("table")) {
			System.out.println("Required parameters(file and table) are not passed or passed not correctly");
			System.exit(0);
		}
        
		if (!this.parameters.containsKey("guest")) {
			this.parameters.put("guest", null);
		}

		return new Parameters(this.parameters.get("file"), Integer.parseInt(this.parameters.get("table")), this.parameters.get("guest"));
	}
	
	protected void checkForFile(String argument) {
		if (argument.contains("--file=")) {
			String value = argument.substring("--file=".length());
			
			if (this.parameters.containsKey("file")) {
				this.parameters.put("file", value);
			} else {
				this.parameters.put("file", value);
			}

		}
	}
	
	protected void checkForTable(String argument) {
		if (argument.contains("--table=")) {
			String value = argument.substring("--table=".length());

			if (!tryParseInt(value)) {
				System.out.println("Table number is not correct");
				System.exit(0);
			}

            if (this.parameters.containsKey("table")) {
            	this.parameters.put("table", value);
            } else {
				this.parameters.put("table", value);
            }
        }
	}
	
	protected void checkForGuest(String argument) {
		if (argument.contains("--guest=")) {
			String value = argument.substring("--guest=".length());

            if (this.parameters.containsKey("guest")) {
            	this.parameters.put("guest", value);
            } else {
				this.parameters.put("guest", value);
            }
        }
    }
	
	public boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
}
