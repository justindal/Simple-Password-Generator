package com.jd.pwdgen;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Pass 
{

	private String options;
	private int length;
	private int numPasswords;

	final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	final static String ALPHABET_UPPER = ALPHABET.toUpperCase();
	final static String NUMBERS = "1234567890";
	final static String SYMBOLS = "!@#$%&()-_";

	private ArrayList<String> passwords = new ArrayList<String>();

	public Pass(String options, int length, int numPasswords)
	{
		this.options = options;
		this.length = length;
		this.numPasswords = numPasswords;
	}

	public void generatePasswords()
	{
		String arguments = "";
		for (int i = 0; i < options.length(); i++)
		{
			if (String.valueOf(options.charAt(i)).equals("1"))
			{
				arguments += ALPHABET;
			}
			else if (String.valueOf(options.charAt(i)).equals("2"))
			{
				arguments += ALPHABET_UPPER;
			}
			else if (String.valueOf(options.charAt(i)).equals("3"))
			{
				arguments += NUMBERS;
			}
			else if (String.valueOf(options.charAt(i)).equals("4"))
			{
				arguments += SYMBOLS;
			}
		}
		if (options.isEmpty())
			arguments += ALPHABET + ALPHABET_UPPER + NUMBERS + SYMBOLS;

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
	}

	public void printPasswords()
	{
		for (String pass : passwords)
		{
			System.out.println(pass);
		}
	}

	@Override
	public String toString()
	{
		String out = "YOUR OPTIONS:";
		out += "\nArguments: " + options;
		out += "\nLength of Passwords: " + length;
		out += "\nNumber of Passwords: " + numPasswords;
		return out;
	}
}