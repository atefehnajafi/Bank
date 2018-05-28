import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CustomerClass _customerObj = new CustomerClass();
		AccountClass _accountObj = new AccountClass();
		TransactionClass _transactionObj = new TransactionClass();

		Scanner _intsc = new Scanner(System.in);
		Scanner _strsc = new Scanner(System.in);

		int _customerCount = 0;// count of customer
		int _accountCount = 0;// count of account
		int _ownerCount = 0;// count of owner for one account
		String _customerName;// for add to Customer name
		String _customeSurname;// for add to Customer surname
		int _customerId = 0;// for add to Customer id(add automatic)
		int _balance = 0;// for add to account
		int _accountNumber = 0;

		int _src_account_Id;// for transaction
		int _dst_account_Id;// for transaction
		int _transactionId = 0;// for transaction
		int _amount;// for transaction
		String _statuse;// for transaction

		System.out.println("Enter Customer Count");
		_customerCount = _intsc.nextInt();

		System.out.println("Enter Account Count");
		_accountCount = _intsc.nextInt();

		System.out.println("Enter Transaction Count");
		int _countTransaction = _intsc.nextInt();

		CustomerClass[] _customerList = new CustomerClass[_customerCount];
		AccountClass[] _accountList = new AccountClass[_accountCount];
		TransactionClass[] _transationList = new TransactionClass[_countTransaction];

		// Create Customer List
		for (int i = 0; i < _customerCount; i++) {
			System.out.println("Enter Customer Name and Customer Surname");
			_customerName = _strsc.nextLine();
			_customeSurname = _strsc.nextLine();
			_customerId++;

			_customerList[i] = _customerObj.CreatCustomer(_customerName, _customeSurname, _customerId);
		}

		// _menuObj.SelectMenu(_customerList);
		// Create New Account

		for (int j = 0; j < _accountCount; j++) {
			System.out.println("How Many Users allow access " + j + " account ?");
			_ownerCount = _intsc.nextInt();
			CustomerClass[] _helpCustomerList = new CustomerClass[_ownerCount];

			System.out.println("enter Balance :");
			_balance = _intsc.nextInt();
			_accountNumber++;

			for (int m = 0; m < _ownerCount; m++) {
				System.out.println("enter Owner Id For Number" + m);
				int _ownerId = _intsc.nextInt();

				for (int i = 0; i < _customerList.length; i++) {
					if (_customerList[i].getCustomerId() == _ownerId) {
						String _ownerName = _customerList[i].getname();
						String _ownerSurname = _customerList[i].getSeurname();

						_helpCustomerList[m] = _accountObj.AddOwner(_ownerName, _ownerSurname, _ownerId);
						break;
					}

				}
			}
			_accountList[j] = _accountObj.CreateAccount(_helpCustomerList, _balance, _accountNumber);
		}

		// create transaction
		for (int i = 0; i < _transationList.length; i++) {
			System.out.println("Enter Below Information For Transaction");
			System.out.println("Enter Soure Accout Id");
			_src_account_Id = _intsc.nextInt();
			System.out.println("Enter Destination Accout Id");
			_dst_account_Id = _intsc.nextInt();
			System.out.println("Enter Amount For Transfer");
			_amount = _intsc.nextInt();
			_transactionId++;

			String _message = _transactionObj.TransactionMessage(_accountList, _src_account_Id, _dst_account_Id,
					_amount);

			if (_message.contains("accept")) {// if account list has a customer
												// create
				// transaction and money transfer
				_transactionObj.MoneyTransfer(_amount, _accountList, _src_account_Id, _dst_account_Id);
				_statuse = "accept";
				_transationList[i] = _transactionObj.CreateTransaction(_src_account_Id, _dst_account_Id, _amount,
						_transactionId, _statuse);

			} else {
				_statuse = "reject";
				_transactionObj.CreateTransaction(_src_account_Id, _dst_account_Id, _amount, _transactionId, _statuse);
			}
		}

		System.out.println("if you want add owner to one account press 1");
		int n = _intsc.nextInt();
		if (n == 1) {
			System.out.println("Pleaze Enter Account ID");
			int _accountid = _intsc.nextInt();
			int _countOwnerInAccount = 0;
			int _LastOwnerId = 0;

			for (int i = 0; i < _accountList.length; i++) {
				if (_accountList[i].getAccountNumber() == _accountid) {
					for (int j = 0; j < _accountList[i].getCustomerlist().length; j++) {
						_countOwnerInAccount++;
					}//end of for j

					CustomerClass[] _newOwnerList = new CustomerClass[_countOwnerInAccount + 1];
					for (int j = 0; j < _accountList[i].getCustomerlist().length; j++) {
						_LastOwnerId = _accountList[i].getCustomerlist()[j].getCustomerId();
						String _LastOwnerName = _accountList[i].getCustomerlist()[j].getname();
						String _LastOwnerSurName = _accountList[i].getCustomerlist()[j].getSeurname();

						_newOwnerList[j] = _accountObj.AddOwner(_LastOwnerName, _LastOwnerSurName, _LastOwnerId);
					}//end of for j

					System.out.println("Enter New Owner Name: ");
					String _newOwnerName = _strsc.nextLine();
					System.out.println("Enter New Owner SurName: ");
					String _newOwnerSurname = _strsc.nextLine();

					_newOwnerList[_countOwnerInAccount] = _accountObj.AddOwner(_newOwnerName, _newOwnerSurname,
							_LastOwnerId + 1);
				
					break;
				}//end of if
				
			}//end of for
		}//end of if n
		
			//***************************************************************************************
	
		System.out.println("Do you want see account information ? if yes press 1");
		int check = _intsc.nextInt();
		int id=0;
		if (check == 1) {
			System.out.println("How many accounts' information you want to see ?");
			int countOfAccount = _intsc.nextInt();
			for (int m = 0; m < countOfAccount; m++) {
				
				
				System.out.println("enter account id : ");
				int accountid = _intsc.nextInt();
				for (int k = 0; k < _accountList.length; k++) {
					
					for (int j = 0; j < _accountList[k].getCustomerlist().length; j++) {
						if (_accountList[k].getAccountNumber() == accountid) {
							String _OwnerName = _accountList[k].getCustomerlist()[j].getname();
							String _OwnerSurName = _accountList[k].getCustomerlist()[j].getSeurname();
							int _balance1=_accountList[k].getBalance();
							 id=_accountList[k].getAccountNumber();
							System.out.println(_OwnerName + " " + _OwnerSurName + " " + _balance1);
						}//end of if
					}//end of for j
					for(int s=0;s<_transationList.length;s++)
					{
						if(id==_transationList[s].getSourceAccountId())
						{
							System.out.println("Destination Account: "+_transationList[s].getDestinationAccountId()+"\n Amount: "
									+ _transationList[s].getAmount() + "\n Statuse:  " + _transationList[s].getStatuse() + "\n TransactionId :  " + 
									_transationList[s].getTransactionId());
						}
					}break;
					
				}//end of for k
				
			}//end of for m

		} //end of if check
	}

}

