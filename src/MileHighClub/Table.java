package MileHighClub;

import java.util.ArrayList;
import java.util.Hashtable;

public class Table {
	static Hashtable<String, Table> tables = new Hashtable<String, Table>();;
	String name;
	String primaryKey;
	ArrayList<String> cols;
	Hashtable<String, String> coltype;
	Hashtable<Integer, Page> pages;
	Hashtable<String, String> refs;
	int Npages = 0;

	public Table(String name, Hashtable<String, String> coltype,
			Hashtable<String, String> refs, String primaryKey) {
		this.name = name;
		this.coltype = coltype;
		this.refs = refs;
		this.primaryKey = primaryKey;
		this.cols = new ArrayList<String>(coltype.keySet());
		tables.put(name, this);
	}

	public void insertTupleInTable(Tuple t) {
		Page p = this.pages.get(Npages);
		if (p.isFull()) {
			p = new Page();
			Npages++;
		}
		p.insertTupleInPage(t);
	}
}
