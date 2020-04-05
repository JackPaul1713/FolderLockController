package controller;

import java.io.IOException;

import commands.*;

public class LockedFolderController
{
	public static void main(String[] args) throws IOException
	{
		//LockUnlockCommand.lockUnlock("Test", "zzz", "-l");
		try
		{
			if(args[0].equals("/n"))
			{
				MakeCommand.make(args[0], args[1], args[2], args[3], args[4], args[5], Integer.parseInt(args[5]));
			}
			else 
			{
				System.out.println("Invalid Paramaters\nTry with /?");
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			
		}
		try
		{
			if(args[0].equals("/d"))
			{
				DeleteCommand.delete(args[0], args[1], args[2], args[3], args[4], args[5]);
			}
			else 
			{
				System.out.println("Invalid Paramaters\nTry with /?");
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			
		}
		try
		{
			if(args[0].equals("/l") || args[0].equals("/u"))
			{
				LockUnlockCommand.lockUnlock(args[1], args[2], args[0]);
			}
			else 
			{
				System.out.println("Invalid Paramaters\nTry with /?");
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			
		}
		try
		{
			if(args[0].equals("/?"))
			{
				HelpCommand.help();
			}
			else 
			{
				System.out.println("Invalid Paramaters\nTry with /?");
			}
		}
		catch(Exception ArrayIndexOutOfBoundsException)
		{
			System.out.println("Try with /?");
		}
	}
}
