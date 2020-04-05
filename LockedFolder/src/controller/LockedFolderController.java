package controller;

import java.io.IOException;

import commands.*;

public class LockedFolderController
{
	public static void main(String[] args) throws IOException
	{
		LockUnlockCommand.lockUnlock("Test", "zzz", "-l");
		/*try
		{
			String test0 = args[0];
			String test1 = args[1];
			String test2 = args[2];
			String test3 = args[3];
			String test4 = args[4];
			String test5 = args[5];
			int test6 = Integer.parseInt(args[5]);
			MakeDeleteCommand.makeDelete(args[0], args[1], args[2], args[3], args[4], args[5], Integer.parseInt(args[5]));
		}
		catch(Exception java.lang.ArrayIndexOutOfBoundsException)
		{
			
		}
		try
		{
			String test0 = args[0];
			String test1 = args[1];
			String test2 = args[2];
			LockUnlockCommand.lockUnlock(args[0], args[1], args[2]);
		}
		catch(Exception java.lang.ArrayIndexOutOfBoundsException)
		{
			
		}
		try
		{
			String test0 = args[0];
			//if statement to runHelp
			//else System.out.println("Invalid Paramaters\nTry with /?");
		}
		catch(Exception java.lang.ArrayIndexOutOfBoundsException)
		{
			System.out.println("Try with /?");
		}*/
	}
}
