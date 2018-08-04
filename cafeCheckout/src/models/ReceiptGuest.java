package models;

import java.util.HashMap;
import java.util.Map;

public class ReceiptGuest {
	protected Map<String, HashMap<String, Integer>> items;
	protected int totalPrice = 0;
	
	public ReceiptGuest() {
		this.items = new HashMap<String, HashMap<String, Integer>>();
	}

	public void addItem(String item, int price) {
		if (this.items.containsKey(item)) {
			Map<String, Integer> guestItem = this.items.get(item);
            guestItem.put("amount", guestItem.get("amount") + 1);
        } else {
            HashMap<String, Integer> guestItem = new HashMap<String, Integer>();
            guestItem.put("price", price);
            guestItem.put("amount", 1);
			this.items.put(item, guestItem);
        }

		this.totalPrice += price;
	}

	public Map<String, HashMap<String, Integer>> getItems() {
		return this.items;
	}

	public int getTotalPrice() {
		return this.totalPrice;	
	}
}
