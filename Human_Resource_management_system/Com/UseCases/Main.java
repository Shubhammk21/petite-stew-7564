package Com.UseCases;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static {
		System.out.println("This System made my Shubham Singh");
		System.out.println("Thank you for using");
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		
		System.out.println("1 .For Admin Login");
		System.out.println("2 .For Employee Login");
		int x = Integer.parseInt(in.readLine());
		
		switch(x) {
		
			case 1:
				Adminuses.main(args);
				break;
				
			case 2:
				EmployeeUse.main(args);
				break;
				
			default :
				System.out.println("Invalid Input");
		}
		
	}

}
