/**
 * Show main menu
 * Register a new event
 * Search events
 * Show help
 * Exit the app 
 * @author samta
 *
 */

import java.util.Scanner;

public class CommandCalendar {
	
	Scanner scanner = new Scanner(System.in);

	public void printMenu() {
		System.out.println("*--------------*");
		System.out.println("1. Add an event");
		System.out.println("2. Search the event");
		System.out.println("3. View the calendar");
		System.out.println("h. Help q. Quit");
		System.out.println("*--------------*");
		
	}
	
	public void cmdRegister() {
		
	}
	
	public void cmdSearch() {
		
	}
	
	public void showCal() {
		
		int year;
		int month; 
		
		System.out.println("Input year: ");
		year = scanner.nextInt();
		
		System.out.println("Input month: ");
		month = scanner.nextInt();
		
		PrintCalender pc = new PrintCalender();
		pc.printChoiceCal(year, month);

		
	}
	
	public void selectMenu() {
		
		printMenu();
		
		System.out.println("Select command(1, 2, 3, h, q): ");
		String cmd = scanner.next();
		
		while(true) {
			
			if(cmd.equals("1")) {
				cmdRegister();
				break;
			}else if(cmd.equals("2")) {
				cmdSearch();
				break;
			}else if(cmd.equals("3")) {
				showCal();
				break;
			}else if(cmd.equals("h")) {
				printMenu();
				break;
			}else if(cmd.equals("q")) {
				break; //only available inside loop
			}else {
				System.out.println("Wrong command");
				break;
			}
			
		}
		
		
		
		scanner.close();
		
	}
}
