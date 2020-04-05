package resources;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.io.IOException;

public class ReadWrite
{
	public static String read(String fileName) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line = br.readLine();
		br.close();
		return(line);
	}
	
	public static void write(String fileName, String line) throws IOException
	{
		Writer fw = new FileWriter(fileName);
		fw.write("line");
		fw.close();
	}
}
