package dispatcher;

import java.util.List;

import models.OrderLine;
import models.Parameters;
import models.Receipt;
import services.CheckoutCalculatorService;
import services.FileParserService;
import services.ParameterParserService;
import services.ReceiptToStringService;
import services.ResponseService;

public class App {

	public static void main(String[] args) {
		ParameterParserService parameterParserService = new ParameterParserService(args);
		Parameters parameters = parameterParserService.parse();
		
		FileParserService fileParserService = new FileParserService(parameters.getFile());
		List<OrderLine> orderLines = fileParserService.parse();
		
		CheckoutCalculatorService checkoutCalculatorService = new CheckoutCalculatorService(orderLines);
		Receipt receipt = checkoutCalculatorService.getReceipt(parameters.getTable(), parameters.getGuest());
		
		ReceiptToStringService receiptToStringService = new ReceiptToStringService(receipt);
		String receiptStr = receiptToStringService.getString();
		
		ResponseService responseService = new ResponseService(receiptStr);
		responseService.writeInConsole();
		responseService.writeInFile();
	}

}
