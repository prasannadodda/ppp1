package com.cg.service;

import java.util.List;

import com.cg.Exception.CustomerException;
import com.cg.bean.AccountBean;
import com.cg.bean.CustomerBean;

	
	public interface IAccountService {

	          public boolean createAccount(CustomerBean customerBean) throws CustomerException;
	          public AccountBean findAccount(int accountId) throws CustomerException, Exception;
	          public boolean deposit(AccountBean accountBean,double depositAmount) throws  CustomerException ;
	          public boolean withdraw(AccountBean accountBean,double withdrawAmount) throws  CustomerException;
	          public boolean fundTransfer(AccountBean transferingAccountBean, AccountBean beneficiaryAccountBean, double transferAmount) throws  CustomerException;
			public List<String> getOperations();
//			public String gender(String g);
			public boolean fundaccountvalidation(AccountBean transferingAccountBean,AccountBean beneficiaryAccountBean);
         
			 
	          
		
}
