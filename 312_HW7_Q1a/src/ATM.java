class ATM {
	private String Branch;
	private Transaction transaction;

	public ATM(String branch, Transaction transaction) {
		super();
		Branch = branch;
		this.transaction = transaction;
	}

	public void startTransaction() {
		transaction.start();
	}
}