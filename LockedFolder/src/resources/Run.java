package resources;

import java.io.IOException;

public class Run
{
	public static void run(String path) throws IOException
	{
		Runtime run = Runtime.getRuntime(); 
		run.exec(path);
	}
}
