//created my person class
public class person_class {
	

	//created the person variables	
	private String name;
	private int tele_num;
	private String email;
	private String address;
	
	public person_class(String name,int tele_num,String email,String address){
		
		
	}
	public person_class() {
	}
	
	//created my public toString as to how the layout will be printed out
	public String toString() {
		String cont_output = "Name             : "+name;
		cont_output += "\nTelephone        : "+tele_num;
		cont_output += "\nEmail address    : "+email;
		cont_output += "\nPhysical address : "+address;
		
		
		
		//returned the layout 
		return cont_output;	
		}
	
	
//created public variables to return certain variables to be executed in the main class
	public String get_name() {
		return name;
	}
	
	public int get_tele_num() {
		return tele_num;
	}
	
	public String get_email() {
		return email;
	}
	
	public String get_address() {
		return address;
	}
	
//using public void i able to execute the program in the main class	
	public void set_name(String name) {
		this.name = name;
	}

	public void set_tele_num(int tele_num) {
		this.tele_num = tele_num;
	}
	
	public void set_email(String email) {
		this.email = email;
	}
	
	public void set_address(String address) {
		this.address = address;
	}
	

		

	

}
