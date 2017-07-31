package com.ifly.edu.java.thread.sysn;

/**
 *
 * @author pangzhw
 * @date 2015年3月15日
 */
	public class GetMoneyTest {  
	    public static void main(String[] args) {  
	        Account account = new Account(5000);  
	        GetMoneyRun runnable = new GetMoneyRun(account);  
	        new Thread(runnable, "你").start();  
	        new Thread(runnable, "你老婆").start();  
	    }  
	}  
	  
	// 账户Mode  
	class Account {  
	    private int money;  
	  
	    public Account(int money) {  
	        super();  
	        this.money = money;  
	    }  
	  
	    public int getMoney() {  
	        return money;  
	    }  
	  
	    public void setMoney(int money) {  
	        this.money = money;  
	    }  
	  
	}  
	//runnable类  
	class GetMoneyRun implements Runnable {  
	    private Account account;  
	  
	    public GetMoneyRun(Account account) {  
	        this.account = account;  
	    }  
	  
	    
	    public void run() {
	    
		        if (account.getMoney() > 3000) {  
		            System.out.println(Thread.currentThread().getName() + "的账户有"  
		                    + account.getMoney() + "元");  
		            try {  
		                Thread.sleep(10);  
		            } catch (InterruptedException e) {  
		                e.printStackTrace();  
		            }  
		            int lasetMoney=account.getMoney() - 3000;  
		            account.setMoney(lasetMoney);  
		            System.out.println(Thread.currentThread().getName() + "取出来了3000元"  
		                    + Thread.currentThread().getName() + "的账户还有"  
		                    + account.getMoney() + "元");  
		  
		        } else {  
		            System.out.println("余额不足3000" + Thread.currentThread().getName()  
		                    + "的账户只有" + account.getMoney() + "元");  
		        }
	  
	    }  
	  
	}  
