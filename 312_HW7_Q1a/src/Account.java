class Account {
	private int account_number;
	private double balance;
	String account_name;

	public Account(int account_number, String account_name, double balance) {
		super();
		this.account_number = account_number;
		this.balance = balance;
		this.account_name = account_name;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public void withdraw(double amount) {
		if (balance >= amount)
			balance -= amount;
		else
			System.out.println("Insufficient fund");

	}

	public void printBalance() {
		System.out.println(balance);
	}

}