import javax.swing.text.StyledEditorKit.ForegroundAction;

public class AccountClass {
	private CustomerClass[] customerList;
	private int balance;
	private int accountNumber;
	//private String accountType;
	
	// **************************************** setter and getter for property
	public void setCustomerList(CustomerClass[] customerList) {
		if (customerList == null)
			System.out.println("customer list is null");
		else
			this.customerList = customerList;
	}

	public CustomerClass[] getCustomerlist() {
		return customerList;
	}
	
	public void setBalance(int balance) {
			this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
	}

	public int getAccountNumber() {
		return accountNumber;
	}	
	
	// **************************************** create constructor
	
	public AccountClass() {
		// TODO Auto-generated constructor stub
		this.accountNumber=0;
		this.balance=100;
	}

	
	// **************************************** Define Account Method
	
	AccountClass CreateAccount(CustomerClass[] _customerList,int _balance,int _accountNumber)
	{
		AccountClass _newAccount=new AccountClass();
		_newAccount.accountNumber=_accountNumber;
		//_newAccount.accountType=_accountType;
		_newAccount.balance=_balance;
		_newAccount.customerList=_customerList;
		
		return _newAccount;
	}
	
	CustomerClass AddOwner(String _ownerName,String _ownerSurname,int _ownerId)
	{
		CustomerClass _newOwner=new CustomerClass();
		_newOwner.setCustomerId(_ownerId);
		_newOwner.setName(_ownerName);
		_newOwner.setSurname(_ownerSurname);
		
		return _newOwner;
		//use link list or new array and Pour Previous array in new arraye 
		
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

