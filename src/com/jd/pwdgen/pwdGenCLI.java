package com.jd.pwdgen;

public class pwdGenCLI 
{
	public static void main(String[] args) 
	{
		boolean cont = true;
		if (args.length != 3)
		{
			showHelp();
			cont = false;
		}
		do
		{
			Pass pass = new Pass(args[0], Integer.valueOf(args[1]), Integer.valueOf(args[2]));
			pass.generatePasswords();
			pass.printPasswords();
			cont = false;
		}while(cont = true);

	}

	public static void showHelp()
	{
		System.out.println("Argument Example: 1234 5 7");
		System.out.println("The above will generate a password using upper and lowercase characters, numbers. and symbols.");
		System.out.println("It was also generate SEVEN passwords at a length of FIVE characters.");
		System.out.println("The first argument will be options for which types of characters you want in your password(s):");
		System.out.println("\n\t1 will allow for lowercase"
							+ "\n\t2 will allow for uppercase"
							+ "\n\t3 will allow for numbers"
							+ "\n\t4 will allow for symbols");
	}
}