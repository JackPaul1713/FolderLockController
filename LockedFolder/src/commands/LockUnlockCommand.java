package commands;

import java.io.FileWriter;
import java.io.Writer;
import resources.EncryptDecrypt;
import resources.ReadWrite;
import resources.Run;

import java.io.IOException;

public class LockUnlockCommand
{
	static String progLoc = "C:\\Program Files\\FolderLock\\";
	static String fileLoc = "Files\\";
	static String resLoc = "Resouces\\";
	
	static String key;
	static String path;
	static String enPath;
	
	public static void lockUnlock(String name, String password, String action) throws IOException
	{
		//settup
		key = ReadWrite.read("Key");
		path = ReadWrite.read("Path");
		enPath = ReadWrite.read("EnPath");
		ReadWrite.write(progLoc + fileLoc + "\\loc\\CurrentLocation", progLoc + resLoc + name);
		//lockOrUnlock
		if(action.equals("/l"))
		{
			lock(name, password);
		}
		else if(action.equals("/u"))
		{
			unlock(name, password);
		}
	}
	
	private static void lock(String name, String pw) throws IOException
	{
		//decrypt
		key = EncryptDecrypt.decryptKey(key, pw);
		path = EncryptDecrypt.decrypt(enPath, key);
		//lock
		ReadWrite.write(progLoc + resLoc + name + "\\" + "Path", path);
		Run.run("cmd /c start \"\" Lock.bat");
		ReadWrite.write(progLoc + resLoc + name + "\\" + "Path", "");
	}
	private static void unlock(String name, String pw) throws IOException
	{
		//decrypt
		key = EncryptDecrypt.decryptKey(key, pw);
		path = EncryptDecrypt.decrypt(enPath, key);
		//unlock
		ReadWrite.write(progLoc + resLoc + name + "\\" + "Path", path);
		Run.run("cmd /c start \"\" Unlock.bat");
		ReadWrite.write(progLoc + resLoc + name + "\\" + "Path", "");
	}
}
