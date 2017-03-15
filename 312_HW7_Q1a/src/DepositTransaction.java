class DepositTransaction extends Transaction {
	private Account a;
	private double amount;

	public DepositTransaction(Account a, double amount) {
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

	@Override
	public void transaction() {

		System.out.println("Printing balance before deposit ");
		a.printBalance();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		a.deposit(amount);
		System.out.println("Printing balance after  deposit ");
		a.printBalance();
	}
}