
public class SavingsAccount extends BankAccount {
	private double rate = .025 * 100;
	private int savingsNumber = 0;
	private String accountNumber;
	
	public SavingsAccount(String name, double amount) {
		super(name, amount);
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
		
	}
	
	public SavingsAccount(SavingsAccount oldAccount, double amount) {
		super(oldAccount, amount);
		savingsNumber++;
		accountNumber = super.getAccountNumber() + "-" + savingsNumber;
	}
	
	public void postInterest() {
		double balance = (getBalance() * rate) / 1200;
		
		super.deposit(balance);
		
	}
	
	@Override
	public String getAccountNumber() {
		return accountNumber;
	}
}
