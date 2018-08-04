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
		receiptStr += String.format("%-15s%10s%n", "��������", this.receipt.getWaiter());
		receiptStr += "��� �" + this.receipt.getTable() + "\n";
        receiptStr += "--------------\n";

		for (Entry<String, ReceiptGuest> receiptGuestkeyValue : receipt.getReceiptGuests().entrySet()) {
			receiptStr += receiptGuestkeyValue.getKey() + "\n";

			ReceiptGuest receiptGuest = receiptGuestkeyValue.getValue();
            
			for (Entry<String, HashMap<String, Integer>> itemKeyValue : receiptGuest.getItems().entrySet()) {
				receiptStr += String.format("     %-10s%10s%n", itemKeyValue.getKey(), itemKeyValue.getValue().get("amount") + "x " + itemKeyValue.getValue().get("price") + " ���");
			}       	

			receiptStr += String.format("     ____________________%n");
			receiptStr += String.format("%-15s%10s%n",  "     �����", receiptGuest.getTotalPrice() + " ���");
			receiptStr += "-------------------------\n";
		}

		receiptStr += String.format("%-15s%10s%n", "�������� ����", this.receipt.getTotalPrice() + " ���");
		
		return receiptStr;
    }
}
