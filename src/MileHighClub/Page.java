package MileHighClub;

import java.util.Hashtable;

public class Page {
	Hashtable<Integer, Tuple> tuples;
	int Ntuples = 0;

	public Page() {
		tuples = new Hashtable<Integer, Tuple>();
	}

	public void insertTupleInPage(Tuple t) { // The serializable part should go
												// here
		this.tuples.put(Ntuples++, t);
	}

	public boolean isFull() {
		if (Ntuples == 200) {
			return true;
		} else
			return false;
	}
}
