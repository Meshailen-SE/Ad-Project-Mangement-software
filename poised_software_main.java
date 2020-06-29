/*Task 24
 *Compulsory task 2
 *14\05\2022
 *Meshailen Chetty 
 * */



//imported all the packages date and time and Scanner
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class poised_software_main{

	public static void main(String[] args) throws ParseException, FileNotFoundException {
		
		//printed the projects opening statement
		System.out.println("Welcome");
		boolean menu_bool = false;
		while(menu_bool = true) {
		
		
		//created my scanner input
		Scanner options_in = new Scanner(System.in);
		System.out.print("Please select one of the following:\n"
				+ "=============================================================\n"
				+ "cr - Create Project\n"
				+ "vw - View Project Information\n"
				+ "ed - Edit Project Infotmation\n"
				+ "e  - Exit\n"
				+ "=============================================================\n");
		String menu = options_in.nextLine().toLowerCase();
		
		
		
		if (menu.equals("cr")) {
			System.out.println("-------------------------------------------------------------\n"
					+ "Creating Project...\n"
					+ "-------------------------------------------------------------\n");
			//project name
			
			//created my new class object
			
			
			Scanner project_in = new Scanner(System.in);
			project_object_class project = new project_object_class();
			System.out.println("Please enter the name of the project (ex :Tom's house) ");
			
			//using the project class i was able to return the values to the inputs from the user
			project.set_project_name(project_in.nextLine());
			
			//creating a new textfile and adding all the project names to the text file
			try {
				
				File proj_name_textf = new File("List_of_projects.txt");
				Scanner scan_proj_name = new Scanner(proj_name_textf);
				
				//created an array list
				ArrayList<String> proj_name_list = new ArrayList<String>();
				
				//while loop to scan the text file
				 while(scan_proj_name.hasNextLine()) {
			
					 String scanned1 = scan_proj_name.nextLine();
					 proj_name_list.add(scanned1);

				 }
				 //adding the new project name to the text file using the formatter
					Formatter form_proj_name_textf = new Formatter("List_of_projects.txt");
					proj_name_list.add(project.set_project_name(project_in));

				 
					//writing to the text file
				 for (int b = 0;b <proj_name_list.size();b++) {
					 form_proj_name_textf.format("%s", proj_name_list.get(b)+"\n");
 
				 }
				 form_proj_name_textf.close();
				 
			scan_proj_name.close();
				
			}
			catch(FileNotFoundException e) {
				System.out.println("error");
			}
			

			//project number
			project_in = new Scanner(System.in);
			System.out.println("What is the projects number? ");
			project.set_project_num(project_in.nextInt());
			
			//project type
			project_in = new Scanner(System.in);
			System.out.println("What type of project is it? (building, apartment, house etc ");
			project.set_project_type(project_in.nextLine());
			
			//erf number
			project_in = new Scanner(System.in);
			System.out.println("What is the ERF number of the property? ");
			project.set_erf_num(project_in.nextLong());
			
			//total fee
			project_in = new Scanner(System.in);
			System.out.println("What is the total fee of the project? ");
			project.set_total_fee(project_in.nextInt());
			
			
			//total paid amount
			project_in = new Scanner(System.in);
			System.out.println("What is the total amount that the customer has paid up until now? ");
			project.set_total_amount_paid(project_in.nextInt());
			
			
			//deadline date
			
			//getting the current date 
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		    LocalDateTime now = LocalDateTime.now();
		    
		    //displaying the current date
		    String current_date = dtf.format(now);
		    System.out.println("The current date is:\n"
		    		+ current_date);
		    
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Now enter your deadline date in the format of (dd/MM/yyyy) ex:'21/06/2019'");
			
			//asking the user to enter the deadline date
			Scanner input = new Scanner(System.in);
			String deadline_date = input.next();
			
			//working out to see if the deadline date is over due or on time
			Date date2 = sdf.parse(deadline_date);
			Date date1 = sdf.parse(current_date);
			
			
			//using if an else statements to workout if the dates are overdue or on time
			if (date1.compareTo(date2)<0) {
				System.out.println("Your project is on time");
			}
			else if (date1.compareTo(date2)>0) {
				System.out.println("Your Project is overdue");

				//creating a new text file and adding the names of the project to a text file to display overdue projects
				try {
					//creating a text file
					File deadln_file = new File("overdueDates.txt");
					
					//reading a text file
					Scanner sc_deadln = new Scanner(deadln_file);
					ArrayList<String> deadline_list = new ArrayList<String>();

					 while(sc_deadln.hasNextLine()) {		 
						 
						 String scan_deadline = sc_deadln.nextLine();
						 deadline_list.add(scan_deadline);

					 }
					 
					 //writing to the text file
					 Formatter dead_line_form = new Formatter("overdueDates.txt");
					 deadline_list.add(project.set_project_name(project_in)+" - "+deadline_date);
					 
					 //using a for loop to display the array list 
					 for (int z = 0;z <deadline_list.size();z++) {
						 
						 dead_line_form.format("%s", deadline_list.get(z)+"\n"); 
					 }

					 dead_line_form.close();

					 sc_deadln.close();

					 
					}
				catch(Exception e){
					System.out.println("error");
						
				}
			}
			
			
			else if (date1.compareTo(date2)==0) {
				System.out.println("both dates are equal");
			}
			
			//set the deadline date to the project
			project.set_deadline_date(deadline_date);
			
			
			
			System.out.println("\nGreat, we have created a project now lets create the arhcitect's, contractors and customers personal details.\n ");
			System.out.println("=====================================================================================\n");
			
		
	//architect details
			
			//name
			person_class architect = new person_class();
			Scanner archi_in = new Scanner(System.in);
			System.out.println("What is architects name?");
			architect.set_name(archi_in.nextLine());

			//telephone number
			archi_in = new Scanner(System.in);
			System.out.println("What is the architects telephone number?");
			architect.set_tele_num(archi_in.nextInt());
			
			
			//email address
			archi_in = new Scanner(System.in);
			System.out.println("What is the architects email adress?");
			architect.set_email(archi_in.nextLine());
			
			//physical address
			archi_in = new Scanner(System.in);
			System.out.println("What is architects physical adress?");
			architect.set_address(archi_in.nextLine());
			System.out.println("=====================================================================================\n");

				
		//Customers details
			
			//customers name
			person_class customer = new person_class();
			Scanner cust_in = new Scanner(System.in);
			System.out.println("Now lets create the customers details:\nWhat is the customers name?");
			customer.set_name(cust_in.nextLine());

			//customers telephone number
			cust_in = new Scanner(System.in);
			System.out.println("What is the customers telephone number?");
			customer.set_tele_num(cust_in.nextInt());
			
			//customer email
			cust_in = new Scanner(System.in);
			System.out.println("What is customers email address?");
			customer.set_email(cust_in.nextLine());
			
			//customer physical address
			Scanner cust_address_in = new Scanner(System.in);
			System.out.println("What is the customers physical address?");
			customer.set_address(cust_in.nextLine());
			System.out.println("=====================================================================================\n");

		
		//contractors details
			
			//contractors name
			person_class contractor = new person_class();
			Scanner cont_in = new Scanner(System.in);
			System.out.println("Now lets create the contractors details\nWhat is the contractors name?");
			contractor.set_name(cont_in.nextLine());
			
			//contractors telephone number
			cont_in = new Scanner(System.in);
			System.out.println("What is the contractors telephone number?");
			contractor.set_tele_num(cont_in.nextInt());
			
			//Contractor email
			cont_in = new Scanner(System.in);
			System.out.println("What is the contractors email address?");
			contractor.set_email(cont_in.nextLine());
			
			//contractor physical address
			cont_in = new Scanner(System.in);
			System.out.println("What is the contractors physical address?");
			contractor.set_address(cont_in.nextLine());
			
			
			System.out.println("Great you have succesfully created your project.\n");
			System.out.println("=====================================================================================\n");

		 //i then printed out the classes for class by placing the toString method next to it
			System.out.print("Project information:");
			System.out.println(project.project_object());
			String project_name;
			
			//for every project entered it now becomes its own text file with its unique data
			try {
				
				//creating the text file based on the users input of the projects name
				project_name= project.get_project_name();
				project_name = project_name+".txt";
				
				File project_file = new File(project_name);
				File file = new File(project_name);
				
				//function to create a new file
				file.createNewFile();
				
				
				//writing to the text file all the necessary data
				Formatter f = new Formatter(project_name);
				
				f.format("%s", "Project information:"+project.project_object());
				f.format("%s", "\n\nArchitect information:\n"+architect);
				f.format("%s", "\n\nCustomer information:\n"+customer);
				f.format("%s", "\n\nContractor information:\n"+contractor);
				f.close();
				
				
			}
			catch(Exception e){
				System.out.println("error");
				
			}
			
			//printed the architects details
			System.out.print("Architct informtion:\n");
			System.out.println(architect);
			
			//printed the customers details
			System.out.println("\nCustomer informtion:");
			System.out.println(customer);
		
			//printed the contractors details
			System.out.println("\nContractor  informtion:");
			System.out.println(contractor);

			
			System.out.println("\n=====================================================================================\n");
			
		}
		
		
		
		else if (menu.equals("vw")) {
			
			//scanner to get the users input
			Scanner input_proj = new Scanner(System.in);
			
			//menu 
			System.out.println("Please select one of the textfiles you would like to view:\n"
					+ "\np   -  My Projects"
					+ "\npi  -  Project information"
					+ "\n-------------------------------------------------------------\n");
			
			String in_proj = input_proj.next().toLowerCase();
			

			//if statement if the user select a certain option
			if (in_proj.equals("p")){
					
				System.out.println("Please select which number project you would like to view:\n"
						+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				
				//reading the text file
				File read = new File("List_of_projects.txt");
				Scanner sc_read = new Scanner(read);
				
				//created a counting variable
				int count_ed_text = 0;
				
				//storing all the data in a array list 
				ArrayList<String> view_ed_array = new ArrayList<String>();
				
				//scanning through the text file
				while(sc_read.hasNextLine()) {
					
					String scanned_textfiles_ed = sc_read.nextLine();
					//adding the data to the array list 
					view_ed_array.add(scanned_textfiles_ed);
	
					
				}
				int ar_count = 0;

				//a for loop to display all the data in the array list
				for (int p = 0; p<view_ed_array.size();p++) {
					System.out.println((ar_count+=1)+") "+view_ed_array.get(p));
				}	
				
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
				
				Scanner edit_project = new Scanner(System.in);
				int n = edit_project.nextInt();
				
				//reading a selected text file
				try {
					File x = new File(view_ed_array.get(n-1)+".txt");
					Scanner sc = new Scanner(x);
					
					//using a while loop read through each line in the text file and printing it
					while(sc.hasNextLine()) {
						System.out.println(sc.nextLine());
						
					}
					//closed the scanner
					sc.close();
					System.out.println("\n");
					
				}
				catch(Exception e) {
					
				}
			}
				
			else if(in_proj.equals("pi")){
				
				//scanner input
				Scanner input_vw = new Scanner(System.in);
				
				//menu for the user to choose an option
				System.out.println("\nWhich would you like to view:\n"
						+ "fp  -  Finalised Projects\n"
						+ "lp  -  List of all the projects\n"
						+ "od  -  Overdue projects\n");
				
				//a string input that will make all the input letters lower case
				String vw_proj = input_vw.nextLine().toLowerCase();
				
				//an if statement if a user selects a certain option
				if (vw_proj.equals("fp")) {
					
					//try & catch method
					try {
						//reading a text file
						File proj_info = new File("Finalised-Projects.txt");
						Scanner sc_proj = new Scanner(proj_info);
						
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

						//displaying the text files data
						while(sc_proj.hasNextLine()){
							System.out.println(sc_proj.nextLine());
						}
						
						System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

						
						
					}
					catch(Exception e){
						
					}
				}
				
				else if (vw_proj.equals("lp")) {
					
					//reading a text file
					try {
						
						File list_proj_info = new File("List_of_projects.txt");
						Scanner sc_proj = new Scanner(list_proj_info);
						
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
						
						//displaying all the data in the text file
						while(sc_proj.hasNextLine()){
							System.out.println(sc_proj.nextLine());
						}
						
						//printing borders for a more user friendly view
						System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
						
					}
					//catch block
					catch(Exception e){
						
					}
					
				}
				
				else if (vw_proj.equals("od")) {
					
					try {
						//reading a text file
						File overdue_proj_info = new File("overdueDates.txt");
						Scanner sc_proj = new Scanner(overdue_proj_info);
						
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

						//displaying all the information of the text file to the user
						while(sc_proj.hasNextLine()){
							System.out.println(sc_proj.nextLine());
							
						}
						//printing borders
						System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

						
						
					}
					catch(Exception e){
						
					}
				}	
			}			
		}
		
		//an else if statement for a different option choosen by the user
		else if (menu.equals("ed")) {
			
			System.out.println("-------------------------------------------------------------\n"
					+ "Editing Project...\n"
					+ "-------------------------------------------------------------\n");
			
			Scanner edit_project = new Scanner(System.in);
			
			System.out.println("Please select which number project you would like to edit:\n"
					+ "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
				//readng a text file
				File read = new File("List_of_projects.txt");
				Scanner sc_read = new Scanner(read);
				
				//counting variable
				int count_ed_text = 0;
				
				//created an array list
				ArrayList<String> textf_ed_array = new ArrayList<String>();

				//using a while loop to scan through the textfile line by line
				while(sc_read.hasNextLine()) {
					
					//adding data line by line from the textfile to the array list
					String scanned_textfiles_ed = sc_read.nextLine();
					textf_ed_array.add(scanned_textfiles_ed);

					
				}
				int ar_count = 0;

				//using a for loop to print out a menu to the user to select which project they would like to edit
				for (int p = 0; p<textf_ed_array.size();p++) {
				System.out.println((ar_count+=1)+") "+textf_ed_array.get(p));
					
				}
				
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
				
				//input from the user
				int edit_textfile = edit_project.nextInt();
				
				System.out.println(edit_textfile);
				
				System.out.println(textf_ed_array.get(edit_textfile-1));
				
				//closed the scanner
				sc_read.close();
				
				
				project_object_class project = new project_object_class();
				options_in= new Scanner(System.in);
				person_class contractor = new person_class();
				
				//created a boolean variable and set it to false
				boolean edit = false;
				
				//created a while loop and set it to true
				while (edit = true) {
					
				//printed a option menu and created a scanner input for it	
				Scanner edit_task_in = new Scanner(System.in);
				System.out.println("Please select a option:\n\n"
						+ "ec  - edit contrctors details\n"
						+ "ed  - edit deadline date\n"
						+ "ea  - edit amount paid \n"
						+ "f   - finalise task(Invoice)"
						+ "e   - Exit");
				System.out.println("\n=====================================================================================\n");
				String edit_task = edit_task_in.next().toLowerCase();
				
				
				//created an if statement for the users input
				if (edit_task.equals("f")) {

					System.out.println(textf_ed_array.get(edit_textfile-1));
					ArrayList<String> ed_invoice_textfile = new ArrayList<String>();

					//reading a text file selected by the user
					File invoice = new File(textf_ed_array.get(edit_textfile-1)+".txt");
					Scanner scan_total_amount = new Scanner(invoice);
					
					//created a while loop to read each line of the teaxtfile and add it to the new array list so it can be manipulated
					while(scan_total_amount.hasNextLine()) {
						
						ed_invoice_textfile.add(scan_total_amount.nextLine());
						
					}
					//writing to the textfile
					Formatter b = new Formatter("finalise.txt");
					ed_invoice_textfile.add(textf_ed_array.get(edit_textfile-1));
					
					//displaying all the data from text file
					for (int i = 0;i <ed_invoice_textfile.size();i++) {
						 b.format("%s", ed_invoice_textfile.get(i)+"\n");
					}
					b.close();
					
					//created an array that will store a certain line in the array list 
					//i then split it to work with a certain part of the line
					String total_paid_line [] = ed_invoice_textfile.get(5).split(": ");
					
					//i then converted the string to an integer using parseInt()
					int total_paid = Integer.parseInt(total_paid_line[1]);
					
					//created an array that will store a certain line in the array list 
					//i then split it to work with a certain part of the line
					String total_line [] = ed_invoice_textfile.get(6).split(": ");
					
					//i then converted the string to an integer using parseInt()
					int total = Integer.parseInt(total_line[1]);
					
					
					ed_invoice_textfile.get(6);
					System.out.println(ed_invoice_textfile.get(6));
					
					//created a total variable which is the difference between the total amount paid and total amount of the project
					int total_amount_owe = total - total_paid;
					
					//displaying the invoice to the user
					
					System.out.println("INVOICE:");
					LocalDate time = LocalDate.now();
					System.out.println(
					"-------------------------------------------\n"+
					"Date: "+time+"\nProject Name: "+textf_ed_array.get(edit_textfile-1)+"\n"+
					"-------------------------------------------\n"+
					"Total amount paid by the customer  : R"+total_paid+
					"\nTotal amount of the project        : R"+total+
					"\n===========================================\n"+
					"Total amount owed : R"+total_amount_owe+"\n"+
					"===========================================");
					
					
					System.out.println("Your project has been finalised.");
					
					//creating a new text file
					try {
						
						//created an array list
						ArrayList<String> finalised_list = new ArrayList<String>();
						
						//created a textfile
						File scan_finalise = new File("Finalised-Projects.txt");
						Scanner sc_final = new Scanner(scan_finalise);
						
						//reading the text file using a while loop
						while(sc_final.hasNext()) {
							
							String next_final_line = sc_final.nextLine();
							finalised_list.add(next_final_line);
									
						}
						
						//writing the project name to the new text file that has been finalised
						Formatter finalise = new Formatter("Finalised-Projects.txt");
						finalised_list.add(textf_ed_array.get(edit_textfile-1));

						//using a for loop to write out all the information from the array list
						for (int fin = 0;fin<finalised_list.size();fin++) {
							finalise.format("%s",finalised_list.get(fin)+"\n" );
							
						}
						finalise.close();
						sc_final.close();

					}
					catch(Exception e){
						
					}
					//break the loop 
					break;

				}
				
				
				else if (edit_task.equals("ed")) {
					
					//edit deadline date
					options_in = new Scanner(System.in);
					System.out.println("Please enter the new deadline date.");
					String deadln = options_in.nextLine(); 
					
					//try and catch blocks to create a new text file
					try {
						File ed_deadln = new File(textf_ed_array.get(ar_count-1)+".txt");
						
						//created an array list
						ArrayList<String> ed_deadln_textfile = new ArrayList<String>();
						
						//users input 
						Scanner scan_ed_deadln = new Scanner(ed_deadln);
						
						//reading text file
						while(scan_ed_deadln.hasNextLine()) {

							ed_deadln_textfile.add(scan_ed_deadln.nextLine());
							
						}
						
						//replacing the new deadline date with the new deadline date
						//using the set function with a specific index
						System.out.println(ed_deadln_textfile.get(8));
						ed_deadln_textfile.set(8, "Deadline date     : "+deadln);

						//Writing to the text file
						Formatter form_deadln = new Formatter(textf_ed_array.get(ar_count-1)+".txt");
						
						//printing the new project information
						for(int d = 0;d<ed_deadln_textfile.size();d++) {
							System.out.println(ed_deadln_textfile.get(d));
							form_deadln.format("%s", ed_deadln_textfile.get(d)+"\n");
							
							
						}
						//closed the formatter 
						form_deadln.close();
						
						//closed the scanner
						scan_ed_deadln.close();	
						
						System.out.println("\nYour new due date has been set to "+deadln+"\n");
						
						//set boolean variable to false so that menu pops up again to the user
						edit = false;
						}
					
					catch(Exception e){
						System.out.println("deadline error");
						
					}

					
				}
				//an exit option 
				else if(edit_task.contentEquals("e")){
					
					System.out.println("Exited application");
					
					//break the loop to stop the program
					break;
					
				}
				
				//created an else if statement for the different option if the user entered a different option
				
				else if (edit_task.contentEquals("ec")) {
					
					Scanner cont_in = new Scanner(System.in);
					
				//changing the contractors details
					System.out.println("Changing the contractors details ");
					
					cont_in = new Scanner(System.in);
					System.out.println("What is the name of the contractor? ");
					String cont_name = cont_in.nextLine();
					
					cont_in = new Scanner(System.in);
					System.out.println("What is contractors telephone number? ");
					String cont_telenum = cont_in.nextLine();
					
					cont_in = new Scanner(System.in);
					System.out.println("What is the contractors email's address? ");
					String cont_email = cont_in.nextLine();		
					
					cont_in = new Scanner(System.in);
					System.out.println("What is the contractors physical address? ");
					String cont_address = cont_in.nextLine();
					
					System.out.println("\nThe contractors details have been updated...\n");
					
					//reading a text file
					try {
						File ed_contract = new File(textf_ed_array.get(ar_count-1)+".txt");
						
						//created an array list to edit the new contractord information
						ArrayList<String> ed_contract_textfile = new ArrayList<String>();
						
						Scanner scan_ed_contract = new Scanner(ed_contract);
						
						//scanning the text file
						while(scan_ed_contract.hasNextLine()) {
							ed_contract_textfile.add(scan_ed_contract.nextLine());
							
						}
						
						//updating the new information in the text file by replacing the old information 
						
						//using the set function i am able to work with specific locations in the text file
						ed_contract_textfile.set(24, "Name             : "+cont_name);
						ed_contract_textfile.set(25, "Telephone        : "+cont_telenum);
						ed_contract_textfile.set(26, "Email address    : "+cont_email);
						ed_contract_textfile.set(27, "Physical address : "+cont_address);

						//writing to the text file
						Formatter form_contract = new Formatter(textf_ed_array.get(ar_count-1)+".txt");
						
						for(int c = 0;c<ed_contract_textfile.size();c++) {
							System.out.println(ed_contract_textfile.get(c));
							form_contract.format("%s", ed_contract_textfile.get(c)+"\n");
							
							
						}
						
						//closed formatter
						form_contract.close();
						
						//closed scanner
						scan_ed_contract.close();
						
						//set boolean variable to false
						edit = false;
						}
					catch(Exception e){
						System.out.println("contractor error");
						
					}
					
					
					}
				
				//created an else if statement for the different option if the user entered a different option 
				else if (edit_task.equals("ea")) {
					
					
					options_in = new Scanner(System.in);
					System.out.println("Please enter the new amount paid.");
					String paid_amount = options_in.nextLine(); 
					
					//reading a text file
					try {
						File ed_paid_amount = new File(textf_ed_array.get(ar_count-1)+".txt");
						
						//created a new array list
						ArrayList<String> ed_paid_amount_textfile = new ArrayList<String>();
						
						//reading a text file line by line
						Scanner scan_ed_paid_amount = new Scanner(ed_paid_amount);
						
						while(scan_ed_paid_amount.hasNextLine()) {

							ed_paid_amount_textfile.add(scan_ed_paid_amount.nextLine());
							
						}
						
						//updating the new information by replacing the old information
						System.out.println(ed_paid_amount_textfile.get(5));
						
						//updating the array list
						ed_paid_amount_textfile.set(5, "Total amount paid : "+paid_amount);

						//writing the updated array list to the the text file
						Formatter form_paid_amount = new Formatter(textf_ed_array.get(ar_count-1)+".txt");
						System.out.println("The total amount paid has been updated to the textfile.\n");

						for(int p = 0;p<ed_paid_amount_textfile.size();p++) {
							System.out.println(ed_paid_amount_textfile.get(p));
							form_paid_amount.format("%s", ed_paid_amount_textfile.get(p)+"\n");
							
							
						}
						
						//closed formatter
						form_paid_amount.close();
						
						//closed scanner
						scan_ed_paid_amount.close();	
						
						//set boolean variable to false
						edit = false;
						
						}
					catch(Exception e){
						System.out.println("paid amount error");
						
					}
				
				}
				//an else statement that will display a menu if the user enters the incorrect  information
				else {
					System.out.println("Error please ensure you enter the correct details.");
					edit = false;
					
				}
				//set my boolean variable to false so that i am able to display the options after every option the user inputs
				edit = false;
				
			
				}

		

	}
	else if (menu.equals("e")) {
		
		//using a break to end the project
		System.out.println("-------------------------------------------------------------"
				+ " Exited Project "
				+ "-------------------------------------------------------------");
		break;
		
	}
		
	//an else statement that will display a menu if the user enters the incorrect information
	else {
		System.out.println("Error please enter the correct information");
			menu_bool = false;
		}
	
	
		
	}
	}
}





