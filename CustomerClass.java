
public class CustomerClass {
	private String name;
	private String surname;
	private int customerId;

	// **************************************** setter and getter for property
	public void setName(String name) {
		if (name==null)
			System.out.println("name is null");
		else
			this.name = name;
	}

	public String getname() {
		return name;
	}

	// *********************
	public void setSurname(String surname) {
		if (surname==null)
			System.out.println("name is null");
		else
			this.surname = surname;
	}

	public String getSeurname() {
		return surname;
	}

	// *********************
	public void setCustomerId(int customerid) {
		this.customerId = customerid;
	}

	public int getCustomerId() {
		return customerId;
	}

	// **************************************** create constructor
	
	public CustomerClass() {
		// TODO Auto-generated constructor stub
		this.name="test";
		this.surname="test";
		this.customerId=0;
	}
	
	// **************************************** Define Customer Method
	
	CustomerClass CreatCustomer(String _name,String _surname,int _id)
	{
		CustomerClass _newCustomer=new CustomerClass();
		_newCustomer.name=_name;
		_newCustomer.customerId=_id;
		_newCustomer.surname=_surname;
		
		return _newCustomer;
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

