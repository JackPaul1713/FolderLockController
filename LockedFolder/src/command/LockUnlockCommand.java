package command;

import java.io.FileWriter;
import java.io.Writer;
import lockUnlock.*;
import java.io.IOException;


public class LockUnlockCommand
{
	public static void lockUnlock(String name, String password, String action) throws IOException
	{
		//var
		String pw = password;
		String key;
		String path;
		String enPath;
		//read
		key = ReadAndWrite.read("C:\\Users\\JackPaul\\Desktop\\Key.txt");
		path = ReadAndWrite.read("C:\\Users\\JackPaul\\Desktop\\Path.txt");
		enPath = ReadAndWrite.read("C:\\Users\\JackPaul\\Desktop\\EnPath.txt");
		//decrypt
		
		//write
		ReadAndWrite.write("C:\\Users\\JackPaul\\Desktop\\Key.txt", key);
		ReadAndWrite.write("C:\\Users\\JackPaul\\Desktop\\Path.txt", path);
		//unlock
		
	}
}
