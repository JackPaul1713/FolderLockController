package resources;

import java.math.BigInteger;

public class EncryptDecrypt
{
	static final int[] NUMBKEYS = 
			{
				1, 2, 3, 4, 5, 
				6, 7, 8, 9, 10, 
				11, 12, 13, 14, 15, 
				16, 17, 18, 19, 20,
				21, 22, 23, 24, 25,
				26, 27, 28, 29, 30,
				31, 32, 33, 34, 35, 
				36, 37, 38, 39, 40,
				41, 42, 43, 44, 45, 
				46, 47, 48, 49, 50, 
				51, 52, 53, 54, 55, 
				56, 57, 58, 59, 60, 
				61, 62, 63, 64, 65, 
				66, 67, 68, 69, 70, 
				71, 72, 73, 74, 75, 
				76, 77, 78, 79, 80,
				81
			};
	static final String[] SYMBKEYS = 
			{
				"!", "\"", "#", "$", 
				"%", "&", "'", "(", 
				")", "*", "+", ",", 
				"-", ".", "/", "\\",
				"?", "@", "{", "}", 
				"[", "]", ";", ":",
				"0", "1", "2", "3", "4", 
				"5", "6", "7", "8", "9", 
				"a", "b", "c", "d", "e", 
				"f", "g", "h", "i", "j", 
				"k", "l", "m", "n", "o", 
				"p", "q", "r", "s", "t", 
				"u", "v", "w", "x", "y", 
				"z", 
				"A", "B", "C", "D", "E", 
				"F", "G", "H", "I", "J", 
				"K", "L", "M", "N", "O", 
				"P", "Q", "R", "S", "T", 
				"U", "V", "W", "X", "Y", 
				"Z"
			};
	static final int SIZE = NUMBKEYS.length;
	
	public static String encrypt(String str, String encryptor)
	{
		//var
		int[] strNumbs = getNumbs(str);
		int[] encryptorNumbs = getNumbs(encryptor);
		//encrypt
		for(int n = 0; n < strNumbs.length; n++)
		{
			strNumbs[n] += (encryptorNumbs[n % encryptorNumbs.length]);
			strNumbs[n] = strNumbs[n] % SIZE;
			if(strNumbs[n] == 0) strNumbs[n]++;
		}
		str = getStr(strNumbs);
		//ret
		return(str);
	}
	public static String decrypt(String str, String decryptor)
	{
		//var
		int[] strNumbs = getNumbs(str);
		int[] decryptorNumbs = getNumbs(decryptor);
		//encrypt
		for(int n = 0; n < strNumbs.length; n++)
		{
			strNumbs[n] = strNumbs[n] - decryptorNumbs[n % decryptorNumbs.length];
			if(strNumbs[n] < 0) strNumbs[n] += SIZE;
			if(strNumbs[n] == 0) strNumbs[n]++;
		}
		str = getStr(strNumbs);
		return(str);
	}
	
	public static String encryptKey(String key, String pw)
	{
		//var
		BigInteger numbKey = combineInts(getNumbs(key));
		System.out.println("numbKey: " + numbKey);
		BigInteger numbPw = combineInts(getNumbs(pw));
		System.out.println("numbPw: " + numbPw);
		BigInteger invNumbPw = invertBigInt(numbPw);
		BigInteger bigInt;
		//encrypt
		System.out.print(numbKey + " * " + numbPw);
		bigInt = numbKey.multiply(numbPw);
		System.out.println(" = " + bigInt);
		System.out.print(numbKey + " + " + invNumbPw);
		bigInt = bigInt.add(invNumbPw);
		System.out.println(" = " + bigInt);
		key = bigInt.toString();
		//ret
		return(key);
	}
	public static String decryptKey(String key, String pw)
	{
		//var
		BigInteger numbKey = new BigInteger (key);
		BigInteger numbPw = combineInts(getNumbs(pw));
		BigInteger invNumbPw = invertBigInt(numbPw);
		BigInteger bigInt;
		int[] numbs;
		//encrypt
		System.out.print(numbKey + " - " + invNumbPw);
		bigInt = numbKey.subtract(invNumbPw);
		System.out.println(" = " + bigInt);
		System.out.print(numbKey + " / " + numbPw);
		bigInt = bigInt.divide(numbPw);
		System.out.println(" = " + bigInt);
		System.out.println("numbKey(de): " + bigInt);
		//format
		numbs = splitBigInt(bigInt);
		System.out.println(numbs[0]);
		System.out.println(numbs[1]);
		key = getStr(numbs);
		//ret
		return(key);
	}
	
	private static int[] getNumbs(String str)
	{
		//var
		String[] letts = str.split("");
		int[] numbs = new int[letts.length];
		//switch
		for(int l = 0; l < letts.length; l++)
		{
			for(int a = 0; a < SYMBKEYS.length; a++)
			{
				if(letts[l].equals(SYMBKEYS[a]))
				{
					numbs[l] = NUMBKEYS[a];
				}
			}
		}
		//ret
		return(numbs);
	}
	private static String getStr(int[] numbs)
	{
		//var
		String[] letts = new String[numbs.length];
		//switch
		for(int n = 0; n < numbs.length; n++)
		{
			for(int a = 0; a < NUMBKEYS.length; a++)
			{
				if(numbs[n] == NUMBKEYS[a])
				{
					letts[n] = SYMBKEYS[a];
				}
			}
		}
		//ret
		return(combineStr(letts));
	}
	
	private static String combineStr(String[] strs)
	{
		//var
		String str = "";
		//combine
		for(String s: strs)
		{
			str += s;
		}
		//ret
		return(str);
	}
	private static BigInteger combineInts(int[] numbs)
	{
		//var
		String temp;
		String strNumb = "";
		BigInteger bigInt;
		//combine
		for(int n = 0; n < numbs.length; n++)
		{
			bigInt = BigInteger.valueOf(Long.valueOf(numbs[n]));
			temp = bigInt.toString();
			if(temp.length() == 1)
			{
				temp = "0" + temp;
			}
			strNumb += temp;
		}
		//ret
		return(new BigInteger(strNumb));
	}
	private static int[] splitBigInt(BigInteger numb)
	{
		//var
		String strNumb = numb.toString();
		int[] numbs;
		int length;
		//split
		if(strNumb.length() % 2 == 1)
		{
			strNumb = "0" + strNumb;
		}
		numbs = new int[strNumb.length()/2];
		length = strNumb.length();
		for(int n = 0; n < length/2; n++)
		{
			numbs[n] = Integer.parseInt(strNumb.substring(0, 2));
			strNumb = strNumb.substring(2, strNumb.length());
		}
		//ret
		return(numbs);
	}
	private static BigInteger invertBigInt(BigInteger numbPw)
	{
		//var
		String strNumb = numbPw.toString();
		String strInvNumb = "";
		//invert
		for(int l = 0; l < strNumb.length(); l++)
		{
			strInvNumb = strNumb.substring(l, l+1) + strInvNumb;
		}
		numbPw = new BigInteger(strInvNumb);
		//ret
		return(numbPw);
	}
	
}
