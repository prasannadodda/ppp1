package com.cg.DAO;

import java.util.List;

import com.cg.bean.AccountBean;
import com.cg.bean.CustomerBean;

public interface IAccountDao {

	  public boolean createAccount(CustomerBean customerBean) ;
      public AccountBean findAccount(int accountId) ;
      public boolean deposit(AccountBean accountBean,double depositAmount)  ;
      public boolean withdraw(AccountBean accountBean,double withdrawAmount) ;
      public boolean fundTransfer(AccountBean transferingAccountBean, AccountBean beneficiaryAccountBean, double transferAmount) ;
	public List<String> getOperations();
	  
		
		 
	    
	}


