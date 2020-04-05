package commands;

import java.io.FileWriter;
import java.io.Writer;
import resources.EncryptDecrypt;
import resources.ReadWrite;
import resources.Run;

import java.io.IOException;

public class LockUnlockCommand
{
	static String key;
	static String path;
	static String enPath;
	
	public static void lockUnlock(String name, String password, String action) throws IOException
	{
		//settup
		key = ReadWrite.read(name + "Key");
		path = ReadWrite.read(name + "Path");
		enPath = ReadWrite.read(name + "EnPath");
		//lockOrUnlock
		if(action == "-l")
		{
			lock(name, password);
		}
		else if(action == "-u")
		{
			unlock(name, password);
		}
		else
		{
			System.out.println("Invalid /action\nTry /?");
		}
	}
	
	public static void lock(String name, String pw) throws IOException
	{
		//decrypt
		key = EncryptDecrypt.decryptKey(key, pw);
		path = EncryptDecrypt.decrypt(enPath, key);
		//lock
		ReadWrite.write(name + "Path", path);
		//Run.run(dir + "\\FolderLock\\Files\\cmd\\Lock.bat");
		Run.run("cmd /c start \"\" Lock.bat");
		ReadWrite.write(name + "Path", "");
	}
	public static void unlock(String name, String pw) throws IOException
	{
		//decrypt
		key = EncryptDecrypt.decryptKey(key, pw);
		path = EncryptDecrypt.decrypt(enPath, key);
		//unlock
		ReadWrite.write(name + "Path", path);
		Run.run("cmd /c start \"\" Unlock.bat");
		ReadWrite.write(name + "Path", "");
	}
}
