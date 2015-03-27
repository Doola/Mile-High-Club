package MileHighClub;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class CSVHandler {

	// This method takes a string which is the path of the file to be read and
	// reads it.
	public ArrayList<String[]> read(String s) throws IOException,
			FileNotFoundException {
		ArrayList<String[]> result = new ArrayList<String[]>();
		FileReader fr = new FileReader(s);
		BufferedReader br = new BufferedReader(fr);
		String[] row = new String[6];
		String line;
		while (true) {
			line = br.readLine();
			if (line == null) {
				br.close();
				return result;
			}

			row = line.split(",");
			result.add(row);
		}
	}

	public ArrayList<String[]> readTablePage(String s) throws IOException {
		ArrayList<String[]> result = new ArrayList<String[]>();
		FileReader fr = new FileReader(s);
		BufferedReader br = new BufferedReader(fr);
		String[] row = new String[2];
		String line;
		while (true) {
			line = br.readLine();
			if (line == null) {
				br.close();
				return result;
			}
			row = line.split(",");
			result.add(row);

		}

	}

	// This method takes a path to create the new file and an ArrayList
	// containing
	// the rows to added, each row is an array of strings. The row array is
	// concatenated
	// with commas between them and then written in bufferWriter. The
	// BufferedWriter is closed.
	public void write(String s, ArrayList<String[]> data) throws IOException {
		File metaFile = new File(s);
		metaFile.createNewFile();
		FileWriter fw = new FileWriter(metaFile);
		BufferedWriter bw = new BufferedWriter(fw);

		for (int i = 0; i < data.size(); i++) {
			String row = "";
			for (int j = 0; j < 5; j++) {
				row = row + data.get(i)[j] + ",";
			}
			row = row + data.get(i)[5];
			bw.write(row);
			bw.newLine();
		}
		bw.close();
	}

	// This still neeeds to be tested
	public void writeTablePages(String s, Hashtable<String, Table> allTables)
			throws IOException {
		File metaFile = new File(s);
		metaFile.createNewFile();
		FileWriter fw = new FileWriter(metaFile);
		BufferedWriter bw = new BufferedWriter(fw);
		String hashTable = allTables.toString();
		String temp = hashTable.substring(1, hashTable.length() - 1);
		String[] data = temp.split(", ");
		for (int i = 0; i < data.length; i++) {
			String row = "";
			String[] temp2 = data[i].split("=");
			Table T = allTables.get(temp2[0]);
			row += temp2[0];
			row += ",";
			row += T.Npages;
			bw.write(row);
			bw.newLine();
		}
		bw.close();

	}

	/*public static void main(String[] args) throws IOException {
		CSVHandler csv = new CSVHandler();
		Hashtable<String, Table> t = new Hashtable<String, Table>();
		Table t1 = new Table("Employees", null, null, "");
		Table t2 = new Table("Departments", null, null, "");
		
		t1.Npages = 3;
		t2.Npages = 5;
		t.put("Employees", t1);
		t.put("Departments", t2);
		csv.writeTablePages("/Users/ahmedabodeif1/GitHub/Mile-High-Club/data/tablePages.csv", t);

	}*/

}
