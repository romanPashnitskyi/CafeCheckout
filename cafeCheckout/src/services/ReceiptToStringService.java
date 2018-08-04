package services;

import java.util.HashMap;
import java.util.Map.Entry;

import models.Receipt;
import models.ReceiptGuest;

public class ReceiptToStringService {
	protected Receipt receipt;
    
	public ReceiptToStringService(Receipt receipt) {
		this.receipt = receipt;
    }
    
    public String getString() {
		String receiptStr = "";
		receiptStr += String.format("%-15s%10s%n", "Офіціант", this.receipt.getWaiter());
		receiptStr += "Стіл №" + this.receipt.getTable() + "\n";
        receiptStr += "--------------\n";

		for (Entry<String, ReceiptGuest> receiptGuestkeyValue : receipt.getReceiptGuests().entrySet()) {
			receiptStr += receiptGuestkeyValue.getKey() + "\n";

			ReceiptGuest receiptGuest = receiptGuestkeyValue.getValue();
            
			for (Entry<String, HashMap<String, Integer>> itemKeyValue : receiptGuest.getItems().entrySet()) {
				receiptStr += String.format("     %-10s%10s%n", itemKeyValue.getKey(), itemKeyValue.getValue().get("amount") + "x " + itemKeyValue.getValue().get("price") + " грн");
			}       	

			receiptStr += String.format("     ____________________%n");
			receiptStr += String.format("%-15s%10s%n",  "     Разом", receiptGuest.getTotalPrice() + " грн");
			receiptStr += "-------------------------\n";
		}

		receiptStr += String.format("%-15s%10s%n", "Загальна сума", this.receipt.getTotalPrice() + " грн");
		
		return receiptStr;
    }
}
