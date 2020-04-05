package commands;

public class HelpCommand
{
	public static void help()
	{
		System.out.println("/n - makes new locked folder, FolderLock /n (name) (hiddenName) (location) (hiddenLocation) (password) (keySize)");
		System.out.println("/d - deletes a locked folder, FolderLock /d (name) (hiddenName) (location) (hiddenLocation) (password)");
		System.out.println("/l - locks a locked folder, FolderLock /l (name) (password)");
		System.out.println("/u - unlocks a locked folder, FolderLock /u (name) (password)");
	}
}
