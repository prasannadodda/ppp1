package com.cg.Test;

import static org.junit.Assert.*;

import org.junit.Test;


import org.junit.BeforeClass;

import com.cg.bean.AccountBean;
import com.cg.bean.CustomerBean;
import com.cg.service.AccountServiceImpl;
import com.cg.service.IAccountService;
import com.cg.Exception.*;


public class AccountServiceImplTest {
                
                static IAccountService service = null;
                static AccountBean accBean = null;
                static CustomerBean custBean = null;
                @BeforeClass
                public static void createInstance(){
                                service= new AccountServiceImpl();
                                accBean = new AccountBean();
                                custBean = new CustomerBean();
                }
                
                
                @Test(expected = CustomerException.class)
                public void testForValiIndFirstName() throws Exception{
                                custBean.setFirstName("ra");
                                custBean.setLastName("Joseph");
                                custBean.setPhoneNo("9988776655");
                                custBean.setEmailId("priyajoseph@gmail.com");
                                custBean.setPanNum("EXR7890654");
                                custBean.setAddress("Hyderabad");
                                accBean.setAccountId(1021123456);
                                accBean.setBalance(10000);
                                custBean.setAccountBean(accBean);
                                boolean result = service.createAccount(custBean);
                                assertFalse(result);
                }
                @Test(expected = CustomerException.class)
                public void testForInValidLastName() throws Exception{
                                custBean.setFirstName("Priya");
                                custBean.setLastName("Jo");
                                custBean.setPhoneNo("9988776655");
                                custBean.setEmailId("priyajoseph@gmail.com");
                                custBean.setPanNum("EXR7890654");
                                custBean.setAddress("Hyderabad");
                                accBean.setBalance(10000);
                                custBean.setAccountBean(accBean);
                                boolean result = service.createAccount(custBean);
                                assertFalse(result);
                }
                @Test(expected = CustomerException.class)
                public void testForValidInPhoneNumber() throws Exception{
                                custBean.setFirstName("Priya");
                                custBean.setLastName("Joseph");
                                custBean.setPhoneNo("122333");
                                custBean.setEmailId("priyajoseph@gmail.com");
                                custBean.setPanNum("EXR7890654");
                                custBean.setAddress("Hyderabad");
                                accBean.setBalance(10000);
                                custBean.setAccountBean(accBean);
                                boolean result = service.createAccount(custBean);
                                assertFalse(result);
                }
                @Test(expected = CustomerException.class)
                public void testForInValidEmail() throws Exception{
                                custBean.setFirstName("Priya");
                                custBean.setLastName("Joseph");
                                custBean.setPhoneNo("9988776655");
                                custBean.setEmailId("priya");
                                custBean.setPanNum("EXR7890654");
                                custBean.setAddress("Hyderabad");
                                accBean.setBalance(10000);
                                custBean.setAccountBean(accBean);
                                boolean result = service.createAccount(custBean);
                                assertFalse(result);
                }
                @Test(expected = CustomerException.class)
                public void testForInValidAddress() throws Exception{
                                custBean.setFirstName("Priya");
                                custBean.setLastName("Joseph");
                                custBean.setPhoneNo("122333");
                                custBean.setEmailId("priyajoseph@gmail.com");
                                custBean.setPanNum("EXR7890654");
                                custBean.setAddress(null);
                                accBean.setBalance(10000);
                                custBean.setAccountBean(accBean);
                                boolean result = service.createAccount(custBean);
                                assertFalse(result);
                }
                @Test(expected = CustomerException.class)
                public void testForInValidBalance() throws Exception{
                                custBean.setFirstName("Priya");
                                custBean.setLastName("Joseph");
                                custBean.setPhoneNo("122333");
                                custBean.setEmailId("priyajoseph@gmail.com");
                                custBean.setPanNum("EXR7890654");
                                custBean.setAddress("Hyderabad");
                                accBean.setBalance(100);
                                custBean.setAccountBean(accBean);
                                boolean result = service.createAccount(custBean);
                                assertFalse(result);
                }
                
                @Test
                public void testDeposit() throws Exception{
                                custBean.setFirstName("Priya");
                                custBean.setLastName("Joseph");
                                custBean.setPhoneNo("9988776655");
                                custBean.setEmailId("priyajoseph@gmail.com");
                                custBean.setPanNum("EXR7890654");
                                custBean.setAddress("Hyderabad");
                                accBean.setBalance(10000);
                                custBean.setAccountBean(accBean);
                                service.deposit(accBean, 2000);
                                assertEquals(12000,accBean.getBalance(),0);
                
}

                @Test
                public void testWithdraw() throws Exception {
                                custBean.setFirstName("Priya");
                                custBean.setLastName("Joseph");
                                custBean.setPhoneNo("9988776655");
                                custBean.setEmailId("priyajoseph@gmail.com");
                                custBean.setPanNum("EXR7890654");
                                custBean.setAddress("Hyderabad");
                                accBean.setBalance(10000);
                                custBean.setAccountBean(accBean);
                                service.withdraw(accBean, 2000);
                                assertEquals(8000,accBean.getBalance(),0);
                } 
                /*@Test(expected = CustomerException.class)
                public void testWithdrawForNegativeCase() throws Exception {
                    custBean.setFirstName("Priya");
                    custBean.setLastName("Joseph");
                    custBean.setPhoneNo("9988776655");
                    custBean.setEmailId("priyajoseph@gmail.com");
                    custBean.setPanNum("EXR7890654");
                    custBean.setAddress("Hyderabad");
                    accBean.setBalance(10000);
                    custBean.setAccountBean(accBean);
                    service.withdraw(accBean, 12000);
                    assertNotEquals(10000,accBean.getBalance(),0);
    }*/

                
                @Test
                public void testFundTransfer() throws Exception {
                                custBean.setFirstName("Priya");
                                custBean.setLastName("Joseph");
                                custBean.setPhoneNo("9988776655");
                                custBean.setEmailId("priyajoseph@gmail.com");
                                custBean.setPanNum("EXR7890654");
                                custBean.setAddress("Hyderabad");
                                accBean.setBalance(10000);
                                custBean.setAccountBean(accBean);
                                CustomerBean custBean1 = new CustomerBean();
                                AccountBean accBean1 = new AccountBean();
                                custBean1.setFirstName("John");
                                custBean1.setLastName("Joseph");
                                custBean1.setPhoneNo("9988776688");
                                custBean1.setEmailId("johnjoseph@gmail.com");
                                custBean1.setPanNum("KLM7890654");
                                custBean1.setAddress("Chennai");
                                service.fundTransfer(accBean, accBean1, 5000);
                                assertEquals(10000,accBean1.getBalance(),0);
                }

                

}
