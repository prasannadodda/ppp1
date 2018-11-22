package com.cg.util;


import java.util.ArrayList;
import java.util.List;

public class Database 
{
	static List<String> opr = new ArrayList<>();
	public static List<String> getOperations()
	{
		opr.add( "Create account");
		opr.add( "Show Balance");
		opr.add( "Deposit");
		opr.add( "Withdraw");
		opr.add( "FundTransfer");
		opr.add( "Print Transactions");
		opr.add( "Exit");
		
		return opr;
	}

}
