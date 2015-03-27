package MileHighClub;

import java.util.ArrayList;
import java.util.Hashtable;

public class Table {
	static Hashtable<String, Table> tables = new Hashtable<String, Table>();;
	String name;
	ArrayList<String> cols;
	Hashtable<String, String> coltype;
	Hashtable<Integer, Page> pages;
	Hashtable<String, String> refs;
	int Npages = 0;

	public Table(String name, Hashtable<String, String> coltype,
			Hashtable<String, String> refs) {
		this.name = name;
		this.coltype = coltype;
		this.refs = refs;
		this.cols = new ArrayList<String>(coltype.keySet());
		tables.put(name, this);
	}

	public void inserttuple(Tuple t) {
		Page p = pages.get(Npages);
		if (p.isFull()) {
			p = new Page();
			Npages++;
		}
		p.inserttuple(t);
	}
}
