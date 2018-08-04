package models;

public class OrderLine {
	protected String waiter;
	protected String guest;
	protected int table;
	protected String item;

	public OrderLine(String waiter, String guest, int table, String item) {
		this.waiter = waiter;
		this.guest = guest;
		this.table = table;
		this.item = item;
    }
	
	public String getWaiter() {
		return this.waiter;
	}

    public String getGuest() {
		return this.guest;
	}

    public int getTable() {
		return this.table;
	}
    
	public String getItem() {
		return this.item;
    }
}
