package MileHighClub;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class MetaDataHandler {

	private static String metaDataPath = "/data/metadata.csv";
	private static String tablePagesPath = "/data/tablePages.csv";

	// In this method we read the data currently in the metaData file
	// then we add the new table's info to the ArrayList and then write all
	// to the metaData file.
	public void addTable(String strTableName,
			Hashtable<String, String> htblColNameType,
			Hashtable<String, String> htblColNameRefs, String strKeyColName)
			throws FileNotFoundException, IOException {
		CSVHandler csv = new CSVHandler();
		ArrayList<String[]> newMeta = csv.read(metaDataPath);
		String fullNameTypeHashTable = htblColNameType.toString();
		String s = fullNameTypeHashTable.substring(1,
				fullNameTypeHashTable.length() - 1);
		String[] nameTypeHashArray = s.split(", ");
		String[] nameType = new String[2];
		for (int i = 0; i < nameTypeHashArray.length; i++) {
			String[] temp = new String[6];
			temp[0] = strTableName;
			nameType = nameTypeHashArray[i].split("=");
			temp[1] = nameType[0];
			temp[2] = nameType[1];
			if (nameType[0] == strKeyColName) {
				temp[3] = "True";
				temp[4] = "True";
			} else {
				temp[3] = "False";
				temp[4] = "False";
			}
			temp[5] = htblColNameRefs.get(nameType[0]);
			newMeta.add(temp);
		}
		csv.write(metaDataPath, newMeta);

	}

	// called when save all called
	public void updateTablePages() throws IOException {
		Table t = new Table();
		CSVHandler csv = new CSVHandler();
		csv.writeTablePages(tablePagesPath, t.tables);
	}

}
