import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class project_object_class {
	//set my variables and types
	private String project_name;
	private String project_type;
	private int project_num;
	private long erf_num;
	private int total_amount_paid;
	private int total_fee;
	private String deadline_date;
	
	
	
	public project_object_class(String project_name, String project_type, int project_num, long erf_num, int total_amount_paid, int total_fee, String deadline_date){
		
	}
	project_object_class(){
		
	}
	//created my public toString as to how the layout will be printed out
	public String project_object() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDateTime now = LocalDateTime.now();
	    String current_date = dtf.format(now);
	    //System.out.println(dtf.format(now));
	    
		String project_output = "\nName              : "+project_name;
		project_output += "\nType              : "+ project_type;
		project_output += "\nProject num       : "+ project_num;
		project_output += "\nERF number        : "+erf_num;
		project_output += "\nTotal amount paid : "+total_amount_paid;
		project_output += "\nTotal fee         : "+ total_fee;
		project_output += "\nDate created      : "+ current_date;
		project_output += "\nDeadline date     : "+deadline_date+"\n";
		
		
		
		
		
	
		//returned the layout of the class
		return project_output;	
		}
	//created public variables to return certain variables to be executed in the main class
	//using public void i able to execute the program in the main class	
	//in each bracket i specified the variable type
	public void set_project_name(String project_name) {
		this.project_name = project_name;
	}
	
	public void set_project_type(String project_type) {
		this.project_type = project_type;
	}
	
	public void set_project_num(int project_num) {
		this.project_num = project_num;
	}
	
	public void set_erf_num(long erf_num) {
		this.erf_num = erf_num;
	}
	

	public void set_total_amount_paid(int total_amount_paid) {
		this.total_amount_paid = total_amount_paid;
	}
	
	public void set_total_fee(int total_fee) {
		this.total_fee = total_fee;
	}
	
	public void set_deadline_date(String deadline_date) {
		this.deadline_date = deadline_date;
	}
	
	public int get_total_fee() {
		return total_fee;
	}
	
	//i was then able to retrieve information in the main by creating variables which i returned here
	public int get_total_paid_amount() {
		return total_amount_paid;
	}
	public String get_deadline() {
		return deadline_date;
	}
	public String get_project_name() {
		return project_name;
	}
	public String set_project_name(Scanner project_in) {
		// TODO Auto-generated method stub
		return project_name;
	}
	
}
