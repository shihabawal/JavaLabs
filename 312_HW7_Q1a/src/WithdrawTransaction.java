class WithdrawTransaction extends Transaction {
	private Account a;
	private double amount;

	public WithdrawTransaction(Account a, double amount) {
		super();
		this.a = a;
		this.amount = amount;
	}

	@Override
	public void run() {
		synchronized (a) {
			transaction();
		}
	}

	public void transaction() {
		// TODO Auto-generated method stub
		System.out.println("Printing balance before withdrawal  ");
		a.printBalance();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.withdraw(amount);
		System.out.println("Printing balance after withdrawal  ");
		a.printBalance();
	}

}