import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;

public class DBApp implements DatabaseInterface {
	static String metadata = "metadata.csv";

	public void init() {

	}

	// For now i will read all data in the CSV file add the new table info to
	// the
	// string and then add all data to the CSV file.
	public void createTable(String strTableName,
			Hashtable<String, String> htblColNameType,
			Hashtable<String, String> htblColNameRefs, String strKeyColName)
			throws DBAppException, FileNotFoundException {
		BufferedReader br = new BufferedReader(new FileReader(metadata));
		String[] preData = null;
		boolean stop = false;
		try {
			for (int i = 0; !stop; i++) {
				String currentLine = br.readLine();
				if (currentLine != null) {
					preData[i] = currentLine;
				} else {
					stop = true;
				}

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void createIndex(String strTableName, String strColName)
			throws DBAppException {
		// TODO Auto-generated method stub

	}

	@Override
	public void createMultiDimIndex(String strTableName,
			Hashtable<String, String> htblColNames) throws DBAppException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertIntoTable(String strTableName,
			Hashtable<String, String> htblColNameValue) throws DBAppException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteFromTable(String strTableName,
			Hashtable<String, String> htblColNameValue, String strOperator)
			throws DBEngineException {
		// TODO Auto-generated method stub

	}

	@Override
	public Iterator selectFromTable(String strTable,
			Hashtable<String, String> htblColNameValue, String strOperator)
			throws DBEngineException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAll() throws DBEngineException {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		Hashtable<String, String> table = new Hashtable<String, String>();
		table.put("ID", "Integr");
		table.put("name", "string");
		table.put("howa", "fi eih");
		String s = table.toString();
		s = s.substring(1, s.length() - 1);
		String[] elements = s.split(", ");
		for (int i = 0; i < elements.length; i++) {
			String[] temp = elements[i].split("=");
			System.out.println("New element  ");
			for (int j = 0; j < temp.length; j++) {
				System.out.print(temp[j] + " ");
			}
			System.out.println();
			// System.out.println(elements[i]);
		}
		// System.out.println(s);

	}

}
