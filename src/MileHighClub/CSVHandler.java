import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSVHandler {
	
	// This method takes a string which is the path of the file to be read and reads it.
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

}
