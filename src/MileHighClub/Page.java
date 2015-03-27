package MileHighClub;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;

public class Page implements Serializable {
	transient int Pnumber;
	transient String tblname;
	Hashtable<Integer, Tuple> tuples;
	int Ntuples = 0;

	public Page(int pnumber, String tblname) {
		this.Pnumber = pnumber;
		this.tblname = tblname;
		tuples = new Hashtable<Integer, Tuple>();
	}

	public void insertTupleInPage(Tuple t) { // The serializable part should go
		this.tuples.put(Ntuples++, t);
		try {
			String path = "/data/" + tblname + Pnumber + ".ser";
			FileOutputStream fileOut = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.printf("Serialized data is saved in " + path);
		} catch (IOException i) {
			i.printStackTrace();
		}

	}

	public boolean isFull() {
		if (Ntuples == 200) {
			return true;
		} else
			return false;
	}

}
