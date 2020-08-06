package com.jd.pwdgen;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{
		final String alphabet = "abcdefghijklmnopqrstuvwxyz";
		final String alphabetUpper = alphabet.toUpperCase();
		final String nums = "1234567890";
		final String symbols = "!@#$%&()-_";
		String arguments = "";
		String options;
		int length;
		int numPasswords;
		Scanner scan = new Scanner(System.in);
		ArrayList<String> passwords = new ArrayList<String>();

		System.out.println("this is a password generator");
		System.out.println("enter the numbers for which options you want:" + " eg. 124 OR 123");
		System.out.println("\n1. lowercase alphabet" + 
				"\n2. uppercase alphabet" +
				"\n3. numbers" +
				"\n4. symbols");

		options = scan.nextLine();

		for (int i = 0; i < options.length(); i++)
		{
			if (String.valueOf(options.charAt(i)).equals("1"))
			{
				arguments += alphabet;
			}
			else if (String.valueOf(options.charAt(i)).equals("2"))
			{
				arguments += alphabetUpper;
			}
			else if (String.valueOf(options.charAt(i)).equals("3"))
			{
				arguments += nums;
			}
			else if (String.valueOf(options.charAt(i)).equals("4"))
			{
				arguments += symbols;
			}
		}

		if (options.isEmpty())
			arguments += alphabet + alphabetUpper + nums + symbols;

		System.out.println("what should the length of the passwords be?");
		length = scan.nextInt();

		System.out.println("how many passwords do you want to create?");
		numPasswords = scan.nextInt();

		for (int i = 0; i < numPasswords; i++)
		{
			String password = "";
			for (int j = 0; j < length; j++)
			{
				int index = ThreadLocalRandom.current().nextInt(0, arguments.length());
				password += arguments.charAt(index);
			}
			passwords.add(password);
		}

		System.out.println("\nHere are your passwords:");
		for (String pass : passwords)
		{
			System.out.println(pass);
			System.out.println();
		}

		scan.close();
	}    
}