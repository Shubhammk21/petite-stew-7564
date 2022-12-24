package Com.UseCases;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
* This is a Main Page 
* 
*If you click 1 than he divert to Admin page.
* 
*If you click 1 than he divert to Employee page.
*
**/
public class Main {
	
	static {
		System.out.println("\r\n"
				+ "█░█ █▀█ ▄▄ █▀▄▀█ ▄▀█ █▄░█ ▄▀█ █▀▀ █▀▀ █▀▄▀█ █▀▀ █▄░█ ▀█▀ ▄▄ █▀ █▄█ █▀ ▀█▀ █▀▀ █▀▄▀█\r\n"
				+ "█▀█ █▀▄ ░░ █░▀░█ █▀█ █░▀█ █▀█ █▄█ ██▄ █░▀░█ ██▄ █░▀█ ░█░ ░░ ▄█ ░█░ ▄█ ░█░ ██▄ █░▀░█");
		System.out.println();
		System.out.println("This System created my Shubham Singh");
		System.out.println("--------------------------------------");
		System.out.println("|------------------------------------|");
		System.out.println("|            ☻ Walcome ☻             |");
		System.out.println("|------------------------------------|");
	}

	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.println("☻-------------------------------------☻");
		System.out.println("|   1 .For Admin Login                |");
		System.out.println("☻-------------------------------------☻");
		System.out.println("|   2 .For Employee Login             |");
		System.out.println("☻-------------------------------------☻");
		System.out.println("+------+");
		int x = Integer.parseInt(in.readLine());
		System.out.println("+------+");
		
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
