package MileHighClub;

import java.io.FileNotFoundException;
import java.util.Hashtable;
import java.util.Iterator;

public interface DatabaseInterface {

	public void init();

	public void createTable(String strTableName,
			Hashtable<String, String> htblColNameType,
			Hashtable<String, String> htblColNameRefs, String strKeyColName)
			throws DBAppException, FileNotFoundException;

	public void createIndex(String strTableName, String strColName)
			throws DBAppException;

	public void createMultiDimIndex(String strTableName,
			Hashtable<String, String> htblColNames) throws DBAppException;

	public void insertIntoTable(String strTableName,
			Hashtable<String, String> htblColNameValue) throws DBAppException;

	public void deleteFromTable(String strTableName,
			Hashtable<String, String> htblColNameValue, String strOperator)
			throws DBEngineException;

	public Iterator selectFromTable(String strTable,
			Hashtable<String, String> htblColNameValue, String strOperator)
			throws DBEngineException;
	
	public void saveAll( ) throws DBEngineException;


}
