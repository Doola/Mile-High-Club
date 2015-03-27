package MileHighClub;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import lib.Bucket;

public class DBApp implements DatabaseInterface {
	static String metadata = "metadata.csv";

	// For now i will read all data in the CSV file add the new table info to
	// the
	// string and then add all data to the CSV file.
	public void init() {

	}

	public void createTable(String strTableName,
			Hashtable<String, String> htblColNameType,
			Hashtable<String, String> htblColNameRefs, String strKeyColName)
			throws FileNotFoundException, IOException {
		Table T = new Table(strTableName, htblColNameType, htblColNameRefs,
				strKeyColName);
		MetaDataHandler mt = new MetaDataHandler();
		mt.addTable(strTableName, htblColNameType, htblColNameRefs,
				strKeyColName);
	}

	public void createIndex(String strTableName, String strColName) {

	}

	public void createMultiDimIndex(String strTableName,
			Hashtable<String, String> htblColNames) {

	}

	public void insertIntoTable(String strTableName,
			Hashtable<String, String> htblColNameValue) {
		Table T = Table.tables.get(strTableName);
		Tuple x = new Tuple(htblColNameValue);
		try {
			T.insertTupleInTable(x);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteFromTable(String strTableName,
			Hashtable<String, String> htblColNameValue, String strOperator) {

	}

	public Iterator selectFromTable(String strTable,
			Hashtable<String, String> htblColNameValue, String strOperator) {
		return null;

	}

	// I will need to call write tablePages with csv handler to save number of
	// pages we keda
	public void saveAll() {
		MetaDataHandler meta = new MetaDataHandler();
		try {
			meta.updateTablePages();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Table t = new Table();
		Hashtable<String, Table> allTables = t.tables;
		Set<String> set = allTables.keySet();
		for (String s : set) {
			t = allTables.get(s);
			try {
				t.saveIndex();
				t.saveAllData();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	/*
	 * public static void main(String[] args) { Hashtable<String, String>
	 * nameType = new Hashtable<String, String>(); nameType.put("ID",
	 * "java.lang.Integer"); nameType.put("Name", "java.lang.String");
	 * nameType.put("Location", "java.lang.String"); String table =
	 * "Department"; Hashtable<String, String> refs = new Hashtable<String,
	 * String>(); String key = "ID"; DBApp test = new DBApp(); try {
	 * test.createTable(table, nameType, refs, key); } catch
	 * (FileNotFoundException e) {
	 * System.out.println("Fein el file ya magdy ?"); } catch (IOException e) {
	 * System.out.println("el reader aw el writer bystahbel"); }
	 * 
	 * 
	 * 
	 * }
	 */

}
