import java.util.Scanner;

public class TransactionClass {

	Scanner _strsc = new Scanner(System.in);

	private int src_account_Id;
	private int dst_account_Id;
	private int transactionId;
	private int amount;
	private String statuse;

	// **************************************** setter and getter for property
	public void setSourceAccountId(int src_account_Id) {
		this.src_account_Id = src_account_Id;
	}

	public int getSourceAccountId() {
		return src_account_Id;
	}

	// ******************************

	public void setDestinationAccountId(int dst_account_Id) {
		this.dst_account_Id = dst_account_Id;
	}

	public int getDestinationAccountId() {
		return dst_account_Id;
	}

	// ******************************

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getTransactionId() {
		return transactionId;
	}

	// ******************************

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	// ******************************

	public void setStatuse(String statuse) {
		if (statuse.isEmpty())
			System.out.println("statuse is null");
		else
			this.statuse = statuse;
	}

	public String getStatuse() {
		return statuse;
	}

	// **************************************** create constructor
	public TransactionClass() {
		// TODO Auto-generated constructor stub
		this.src_account_Id = 0;
		this.dst_account_Id = 0;
		this.transactionId = 0;
		this.amount = 0;
		this.statuse = "accept";
	}

	// **************************************** Define Transaction Method
	TransactionClass CreateTransaction(int _srcAccountId, int _dstAccountId, int _amount, int _transactionId,
			String _statuse) {
		TransactionClass _newTransaction = new TransactionClass();
		_newTransaction.amount = _amount;
		_newTransaction.dst_account_Id = _dstAccountId;
		_newTransaction.src_account_Id = _srcAccountId;
		_newTransaction.transactionId = _transactionId;
		_newTransaction.statuse = _statuse;

		return _newTransaction;
	}

	String TransactionMessage(AccountClass[] _accountList, int _sourceAccountId, int _destinationAccountId,
			int _amount) {
		int _count = 0;
		String _message = "";
		for (int i = 0; i < _accountList.length; i++) {
			if (_accountList[i].getAccountNumber() == _sourceAccountId) {
				for (int j = 0; j < _accountList[i].getCustomerlist().length; j++) {
					System.out.println(
							_accountList[i].getCustomerlist()[j].getSeurname() + " Are you allowed to transfer from "
									+ _sourceAccountId + "With the amount " + _amount + "");
					String _allow = _strsc.nextLine();
					if (_allow.contains("yes")) {
						System.out
								.println(" Owner " + _accountList[i].getCustomerlist()[j].getSeurname() + ": Accept ");
						_count++;
					} else {
						System.out.println(_accountList[i].getCustomerlist()[j].getSeurname() + ": Reject ");
					}

				} // end of for loop
				if (_count == _accountList[i].getCustomerlist().length)
					_message = "accept";// moneyTransfer(_accountList[i].getCustomerList)
				else
					_message = "reject";

			}
		}
		return _message;
	}

	void MoneyTransfer(int _amount, AccountClass[] _accountList, int _srcAccountId, int _dstAccountId) {
		if (_accountList[_srcAccountId].getBalance() > _amount) {
			for (int i = 0, j = 0; i < _accountList.length; i++, j++) {
				if (_accountList[i].getAccountNumber() == _srcAccountId) {
					_accountList[i].setBalance(_accountList[i].getBalance() - _amount);
				}
				if (_accountList[j].getAccountNumber() == _dstAccountId) {
					_accountList[j].setBalance(_accountList[j].getBalance() + _amount);
				}
				
			}
			System.out.println("*********** The transfer took place......************");
			System.out.println("Source Account Balance now :" + _accountList[_srcAccountId-1].getBalance());
			System.out.println("Destination Account Balance now :" + _accountList[_dstAccountId-1].getBalance());
		} else
			System.out.println("Balance is not enough");
	}

}
