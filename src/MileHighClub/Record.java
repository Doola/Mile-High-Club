package MileHighClub;

public class Record {

	int rowNumber;
	int pageNumber;
	String table;

	public Record(int a, int b, String s) {
		this.rowNumber = a;
		this.pageNumber = b;
		this.table = s;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setRowNumber(int rowNumber) {
		this.rowNumber = rowNumber;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getTable() {
		return table;
	}

	public void setTable(String table) {
		this.table = table;
	}

}
