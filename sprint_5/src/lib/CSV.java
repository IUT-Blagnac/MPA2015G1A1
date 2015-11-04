package lib;

import java.util.*;
import java.io.*;

/**
 * A class allowing to manipulate CSV data, including read/write to CSV files.
 *
 * @author Pablo Donato
 */
public class CSV
{
	/**
	 * The CSV sheet
	 */
	private ArrayList<ArrayList<String>> sheet;
	/**
	 * Separator string between CSV columns
	 */
	private String separator;

	/**
	 * Default constructor, initializing an empty sheet and using ',' as separator.
	 */
	public CSV()
    {
		sheet = new ArrayList<ArrayList<String>>();
		separator = ",";
	}

    /**
     * Default constructor, initializing an empty sheet and using a given separator.
     *
     * @param separator The separator to use.
     */
    public CSV(String separator)
    {
        sheet = new ArrayList<ArrayList<String>>();
        this.separator = separator;
    }

    /** Constructor reading a CSV file.
     * 
     * @param path Path to the CSV file.
     * @exception IOException Error when reading file.
     */
    public CSV(String path, String separator) throws Exception
    {
        sheet = new ArrayList<ArrayList<String>>();
        this.separator = separator;
        read(path);
    }

	/**
	 * Get this object's CSV sheet.
	 *
	 * @return The CSV sheet.
	 */
	public ArrayList<ArrayList<String>> getSheet() 
    {
		return sheet;
	}

	/**
	 * Set this object's CSV sheet.
	 *
	 * @param sheet The CSV sheet to load.
	 */
	public void setSheet(ArrayList<ArrayList<String>> sheet)
    {
		this.sheet = sheet;
	}

	/**
	 * Reads a CSV file into this object's sheet.
	 * 
	 * @param path Path to the CSV file.
	 * @exception IOException Error when reading file.
	 */
	public void read(String path) throws IOException
    {
		String line = null;
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader(path));
		while ((line = br.readLine()) != null) {
			sheet.add(new ArrayList<String>(Arrays.asList(line.split(separator))));
		}
	}

	/**
	 * Write this object's sheet into a CSV file.
	 * 
	 * @param path Path to the CSV file.
	 * @exception IOException Error when writing to file.
	 */
	public void save(String path) throws IOException
    {
		PrintWriter bw = new PrintWriter(path);
		bw.println(this);
		bw.close();
	}

	@Override
	public String toString()
    {
		String str = "";
		for (ArrayList<String> line : sheet) {
			str += line.toString().replace(", ", separator) + "\n";
		}
		return str.substring(0, str.length() - 1).replace("[", "").replace("]", "");
	}
}
