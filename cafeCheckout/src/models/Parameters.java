package models;

public class Parameters {
	protected String file;
	protected int table;
	protected String guest;

	public Parameters(String file, int table, String guest) {
		this.file = file;
		this.table = table;
		this.guest = guest;
	}

	public String getFile() {
		return this.file;
	}

    public int getTable() {
		return this.table;
	}

    public String getGuest() {
		return this.guest;
    }
}
