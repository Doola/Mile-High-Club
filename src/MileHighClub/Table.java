package MileHighClub;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

public class Table implements Serializable {
	static Hashtable<String, Table> tables = new Hashtable<String, Table>();;
	String name;
	String primaryKey;
	ArrayList<String> cols;
	Hashtable<String, String> coltype;
	Hashtable<Integer, Page> pages;
	Hashtable<String, String> refs;
	Hashtable<String, Record> index;
	int Npages = 0;

	// Will be used to create a placebo table to retrieve the Hashtable
	// containing all created tables
	// to write the new values of tables/pages to tablePages.csv
	public Table() {

	}

	public Table(String name, Hashtable<String, String> coltype,
			Hashtable<String, String> refs, String primaryKey) {
		this.name = name;
		this.coltype = coltype;
		this.refs = refs;
		this.primaryKey = primaryKey;
		this.cols = new ArrayList<String>(coltype.keySet());
		tables.put(name, this);
	}

	public void insertTupleInTable(Tuple t) throws IOException {
		Page p = this.pages.get(Npages);
		if (p.isFull()) {
			p = new Page();
			Npages++;
		}
		int row = p.insertTupleInPage(t);
		Record r = new Record(row, Npages, name);
		String tupleKeyValue = t.keyvalue.get(primaryKey);
		String location = "";
		if (row < 10) {
			location += "00" + row;
		} else {
			if (row < 100) {
				location += "0" + row;
			} else {
				location += row;
			}
		}
		location += Npages;
		index.put(tupleKeyValue, r);

	}

	public void saveIndex() throws IOException {

		FileOutputStream fileOut = new FileOutputStream(
				"/Users/ahmedabodeif1/GitHub/Mile-High-Club/data/" + name
						+ "Index.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(index);
		out.close();
		fileOut.close();
	}

	public void saveAllData() throws IOException {
		for (int i = 0; i <= Npages; i++) {
			Page p = pages.get(i);
			p.saveContent("/Users/ahmedabodeif1/GitHub/Mile-High-Club/data/"
					+ name + "-" + i + ".ser");
		}

	}

}
