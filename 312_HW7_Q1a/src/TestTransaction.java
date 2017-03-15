public class TestTransaction {
	public static void main(String args[]) {
		Account my_account = new Account(1, "Ahmad", 0);

		Transaction t1 = new DepositTransaction(my_account, 25000.00);
		Transaction t2 = new WithdrawTransaction(my_account, 25000.00);
		t1.setName("Deposit Thread");
		t2.setName("Withdraw Thread");

		ATM aus_Branch = new ATM("AUS", t1);
		ATM rolla = new ATM("Rolla", t2);

		rolla.startTransaction();
		aus_Branch.startTransaction();
	}
}