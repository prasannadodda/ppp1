package com.cg.ui;

import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.cg.Exception.CustomerException;
import com.cg.Exception.CustomerExceptionMessage;
import com.cg.bean.AccountBean;
import com.cg.bean.CustomerBean;
import com.cg.bean.WalletTransaction;
import com.cg.service.AccountServiceImpl;
import com.cg.service.IAccountService;


public class Client {

	
	CustomerBean customer = new CustomerBean();
	Scanner scanner = new Scanner(System.in);
	AccountBean accountBean = new AccountBean();
   

	public static void main(String[] args) throws Exception {
		char ch;
		Client client = new Client();
		IAccountService service = new AccountServiceImpl();
		do {
			System.out.println("========Payment wallet application========");
			 List<String> opr = service.getOperations();
			int i = 1;
			for (String str : opr) {

				System.out.println(i + " : " + str);
				i++;

			}

			System.out.println("Choose an option");
			int option = client.scanner.nextInt();

			switch (option) {
			case 1:
				client.create();
				break;
			case 2:
				client.showbalance();

				break;

			case 3:
				client.deposit();

				break;

			case 4:
				client.withdraw();

				break;

			case 5:
				client.fundtransfer();

				break;

			case 6:
				client.printTransaction();

				break;
			case 7:
				System.exit(0);

				break;

			default:
				System.out
						.println("invalid option, please choose from the above list");
				break;
			}

			System.out.println("Do you want to continue press Y/N");
			ch = client.scanner.next().charAt(0);

		} while (ch == 'y' || ch == 'Y');

	}


	void create() throws Exception {
		fname();
		lname();
		mail();
		phone();
		addr();
		pan();
		

		Random rand = new Random();
		int accId = rand.nextInt(90000000) + 1000000000;

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter f = DateTimeFormatter
				.ofPattern("dd MMMM yyyy hh:mm a");
		String accDateInput = ldt.format(f);

		System.out.println("Enter balance to create account");
		double balance = scanner.nextDouble();
	if(balance < 0)
	{
		System.err.println(" Balance shouls be greather than 0 ");
		System.exit(0);
	}
		accountBean.setAccountId(accId);
		accountBean.setBalance(balance);
		accountBean.setInitialDeposit(balance);
		accountBean.setDateOfOpening(accDateInput);

		customer.setAccountBean(accountBean);

		IAccountService service=new AccountServiceImpl();
		boolean result = service.createAccount(customer);
	
		if (result) {
			System.out
					.println("\n\n\t\tCongratulations Customer account has been created successfully...\n\n\t\t");
			System.out.println("Your Accound ID is :"+customer.getAccountBean().getAccountId());
			System.out.println("Account created at " + accDateInput);

		} else {
			System.err.println("\n\n\t\tEnter valid details..\n\n\t\t");
		}
	}

	

	private void pan() {
		// TODO Auto-generated method stub
		System.out.print("Enter  Customer PAN number :\t");
		String pan = scanner.next();
		AccountServiceImpl impl=new AccountServiceImpl();
		if (impl.isValidPan(pan)) {
			customer.setPanNum(pan);
		} else {
			pan();
		}
	}

	private void phone() {
		// TODO Auto-generated method stub
		System.out.print("Enter  Customer  phone number :\t");
		String phone = scanner.next();
		AccountServiceImpl impl=new AccountServiceImpl();
		if (impl.isValidPhoneNum(phone)) {
			customer.setPhoneNo(phone);
		} else {
			phone();
		}

	}

	private void addr() {
		// TODO Auto-generated method stub
		System.out.print("Enter  Customer  address :\t");
		String address = scanner.next();
		AccountServiceImpl impl=new AccountServiceImpl();
		if (impl.isValidAddr(address)) {
			customer.setAddress(address);
		} else {
			addr();
		}
	}

	private void mail() {
		// TODO Auto-generated method stub
		System.out.print("Enter  Customer  email id :\t");
		String email = scanner.next();
		AccountServiceImpl impl=new AccountServiceImpl();
		if (impl.isValidMail(email)) {
			customer.setEmailId(email);
		} else {
			mail();
		}
	}

	private void lname() {
		// TODO Auto-generated method stub
		System.out.print("Enter Customer lastname :\t");
		String lname = scanner.next();
		AccountServiceImpl impl=new AccountServiceImpl();
		if (impl.isValidLName(lname)) {

			customer.setLastName(lname);
		} else {
			lname();
		}

	}

	private void fname() {
		System.out.print("Enter Customer firstname :\t");
		String fname = scanner.next();
		AccountServiceImpl impl=new AccountServiceImpl();
		if (impl.isValidFName(fname)) {
			customer.setFirstName(fname);
		} else {
			fname();
		}

	}

	void showbalance() throws CustomerException, Exception {
		System.out.println("Enter Account ID");
		int accId = scanner.nextInt();

		IAccountService service=new AccountServiceImpl();
		AccountBean accountBean = service.findAccount(accId);

		if (accountBean == null) {
			System.out.println("Account Does not exist");
			return;
		}

		System.out.println("Your balance is: " +  accountBean.getBalance());

	}

	void deposit() throws Exception {
		System.out.println("Enter Account ID");
		int accId = scanner.nextInt();

		IAccountService service=new AccountServiceImpl();
		AccountBean accountBean = service.findAccount(accId);
        customer.setAccountBean(accountBean);
		
	if(customer.getAccountBean()!=null)
		{System.out.println("Enter amount that you want to deposit");
		double depositAmt = scanner.nextDouble();

		WalletTransaction wt = new WalletTransaction();
		wt.setTransactionType(1);
		wt.setTransactionDate(new Date());
		wt.setTransactionAmt(depositAmt);
		wt.setBeneficiaryAccountBean(null);

		accountBean.addTransation(wt);
		customer.setAccountBean(accountBean);

		
		boolean result = service.deposit(customer.getAccountBean(), depositAmt);

		if (result) {
			System.out.println("Deposited Money into Account ");
		} else {
			System.err.println("NOT Deposited Money into Account ");
		}

	}
	else
	{
		System.err.println("ACCOUNT DOES NOT EXIT");
	}
	}
	

	void withdraw() throws Exception {
		System.out.println("Enter Account ID");
		int accId = scanner.nextInt();
		IAccountService service=new AccountServiceImpl();
		AccountBean accountBean = service.findAccount(accId);
		customer.setAccountBean(accountBean);
if(customer.getAccountBean()!=null)
{
		System.out.println("Enter amount that you want to withdraw");
		double withdrawAmt = scanner.nextDouble();

		WalletTransaction wt = new WalletTransaction();
		wt.setTransactionType(2);
		wt.setTransactionDate(new Date());
		wt.setTransactionAmt(withdrawAmt);
		wt.setBeneficiaryAccountBean(null);

		customer.getAccountBean().addTransation(wt);

		boolean result = service.withdraw(customer.getAccountBean(), withdrawAmt);
		if (result) {
			System.out.println("Withdaw Money from Account done");
		} else {
			throw new CustomerException(CustomerExceptionMessage.BALERROR);
		//System.out.println("amount not valid");
		}
}
else
{
	System.err.println("ACCOUNT DOES NOT EXIT");
}
}

	void fundtransfer() throws Exception {
		System.out.println("Enter Account ID to Transfer Money From");
		int srcAccId = scanner.nextInt();
		// IAccountService service1 =new AccountServiceImpl();
		IAccountService service=new AccountServiceImpl();
		AccountBean accountBean1 = service.findAccount(srcAccId);
	    CustomerBean bean1=new CustomerBean();
	    bean1.setAccountBean(accountBean1);
		
		if(bean1.getAccountBean()!=null)
		{ System.out.println("Enter Account ID to Transfer Money to");
                int targetAccId = scanner.nextInt();
		
		AccountBean accountBean2 = service.findAccount(targetAccId);
		CustomerBean bean2=new CustomerBean();
	    bean2.setAccountBean(accountBean1);
		
			if(bean2.getAccountBean()!=null)
			{
				System.out.println("Current Balance is: " + bean1.getAccountBean().getBalance());
				
				if(service.fundaccountvalidation(accountBean1, accountBean2))
				{
				//System.out.println("Name: "+ accountBean2.getCustomerBean().getFirstName());
				System.out.println("Current Balance is: " + bean2.getAccountBean().getBalance());
		
				System.out.println("Enter amount that you want to transfer");
				double transferAmt = scanner.nextDouble();
		
				WalletTransaction wt = new WalletTransaction();
				wt.setTransactionType(3);
				wt.setTransactionDate(new Date());
				wt.setTransactionAmt(transferAmt);
				wt.setBeneficiaryAccountBean(accountBean2);
		
				accountBean1.addTransation(wt);
		        customer.setAccountBean(accountBean1);
				
				WalletTransaction wt1 = new WalletTransaction();
				wt1.setTransactionType(1);
				wt1.setTransactionDate(new Date());
				wt1.setTransactionAmt(transferAmt);
				wt1.setBeneficiaryAccountBean(accountBean2);
		
				accountBean2.addTransation(wt1);
		        customer.setAccountBean(accountBean2);
				boolean result = service.fundTransfer(accountBean1, accountBean2,
						transferAmt);
		
				if (result) {
					System.out.println("Transfering Money from Account done");
				} else {
					System.out.println("Transfering Money from Account Failed ");
				}
				}
				else
				{
					System.err.println("AccountID should be different for fund transerfer");
				}
				
			}
	
			else {
				System.err.println("benifiiary account does not exit");
			}
		}
			else {
				System.err.println("Transfering account id does not exit");
			}
		}
	void printTransaction() throws Exception {
		System.out
				.println("Enter Account ID (for printing Transaction Details");
		int accId = scanner.nextInt();
		IAccountService service=new AccountServiceImpl();
		AccountBean accountBean = service.findAccount(accId);
		customer.setAccountBean(accountBean);
if(customer.getAccountBean()!=null)
{
		List<WalletTransaction> transactions = customer.getAccountBean().getAllTransactions();

		
		System.out.println("Name: "
				+ customer.getFirstName() + " "
				+ customer.getLastName());
		System.out.println("Phone Number : "
				+ customer.getPhoneNo());
		System.out.println("Initial Deposit : "
				+ customer.getAccountBean().getInitialDeposit());

		System.out
				.println("------------------------------------------------------------------");

		for (WalletTransaction wt : transactions) {

			String str = "";
			if (wt.getTransactionType() == 1) {
				str = str + "DEPOSIT";
			}
			if (wt.getTransactionType() == 2) {
				str = str + "WITHDRAW";
			}
			if (wt.getTransactionType() == 3) {
				str = str + "FUND TRANSFER";
			}

			str = str + "\t\t" + wt.getTransactionDate();

			str = str + "\t\t" + wt.getTransactionAmt();
			System.out.println(str);
		}

		System.out
				.println("------------------------------------------------------------------");

	}


	else
	{
		System.err.println("ACCOUNT DOES NOT EXIT");
	}
}
}