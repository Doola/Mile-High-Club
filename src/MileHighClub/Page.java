package MileHighClub;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;

public class Page implements Serializable {
	Hashtable<Integer, Tuple> tuples;
	int Ntuples = 0;

	public Page() {
		tuples = new Hashtable<Integer, Tuple>();
	}

	public int insertTupleInPage(Tuple t) { // The serializable part should go
											// here
		this.tuples.put(Ntuples++, t);
		return Ntuples;
	}

	public boolean isFull() {
		if (Ntuples == 200) {
			return true;
		} else
			return false;
	}

	public void saveContent(String s) {
		FileOutputStream fileOut;
		ObjectOutputStream out;
		try {
			fileOut = new FileOutputStream(s);
			out = new ObjectOutputStream(fileOut);
			for (int i = 0; i < Ntuples; i++) {
				Tuple t = tuples.get(i);
				out.writeObject(t);
			}
			out.close();
			fileOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
