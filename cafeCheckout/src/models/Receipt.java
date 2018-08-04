package models;

import java.util.HashMap;

public class Receipt {
	protected String waiter;
	protected int table;
	protected int totalPrice;
	protected HashMap<String, ReceiptGuest> receiptGuests;
    
	public Receipt(String waiter, int table) {
		this.waiter = waiter;
		this.table = table;
		this.totalPrice = 0;
		this.receiptGuests = new HashMap<String, ReceiptGuest>();
	}
    
	public void addItem(String guest, String item, int price) {
		ReceiptGuest receiptGuest;

		if (!this.receiptGuests.containsKey(guest)) {
			receiptGuest = new ReceiptGuest();
			this.receiptGuests.put(guest, receiptGuest);
		} else {
			receiptGuest = this.receiptGuests.get(guest);
		}

		receiptGuest.addItem(item, price);

		this.totalPrice += price;
	}

	public String getWaiter() {
		return this.waiter;
	}

    public int getTable() {
        return this.table;
	}

    public int getTotalPrice() {
		return this.totalPrice;
	}

	public HashMap<String, ReceiptGuest> getReceiptGuests() {
		return this.receiptGuests;
    }
}
