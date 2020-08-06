package com.jd.pwdgen;

public class pwdGenCLI 
{
    public static void main(String[] args) 
    {
        Pass pass = new Pass(args[0], Integer.valueOf(args[1]), Integer.valueOf(args[2]));
        pass.generatePasswords();
        pass.printPasswords();
    }
    
    public static void showHelp(String[] args)
    {
    	
    }
}