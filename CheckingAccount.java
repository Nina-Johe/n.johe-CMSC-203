
public class CheckingAccount extends BankAccount{
	
	final static double FEE = 0.15;
	
	public CheckingAccount(String name, double amount) {
		super(name, amount);
		String accountNumber = super.getAccountNumber() + "-10";
	}
	
	@Override
	public boolean withdraw(double amount) {
		
		amount+=FEE;
		if(super.withdraw(amount)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	

}
