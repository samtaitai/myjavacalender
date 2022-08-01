/**
 * Show main menu
 * Register a new event
 * Search events
 * @author samta
 *
 */

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CommandCalendar {
	
	private Scanner scanner;
	private HashMap<Date, String> storedEvents; //first create 'field'
	
	//second create 'constructor'
	public CommandCalendar() {
		scanner = new Scanner(System.in);
		storedEvents = new HashMap<Date, String>();
		
	}

	public void printMenu() {
		System.out.println("*--------------*");
		System.out.println("1. Add an event");
		System.out.println("2. Search the event");
		System.out.println("3. View the calendar");
		System.out.println("h. Help q. Quit");
		System.out.println("*--------------*");
		
	}
	
	/**
	 * 
	 * @param scanner
	 * @throws Exception
	 */
	public void cmdRegister(Scanner scanner) throws Exception {
		
		System.out.println("Input date(yyyy-mm-dd): ");
		String date = scanner.next();
		System.out.println("Input event title: ");
		String eventTitle = scanner.next();
		
		storeEvent(date, eventTitle);
		
	}
	
	/**
	 * save events in the hashmap
	 * @param date
	 * @param eventTitle
	 * @throws ParseException
	 */
	public void storeEvent(String date, String eventTitle) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); //input should be dd-MM-yyyy format
		Date dateObj = dateFormat.parse(date); //convert string date to date type date
		//System.out.println(dateObj);
		
		storedEvents.put(dateObj, eventTitle);
		
	}
	
	/**
	 * 
	 * @param scanner
	 * @throws Exception
	 */
	public void cmdSearch(Scanner scanner) throws Exception {
		
		System.out.println("Input date(yyyy-mm-dd): ");
		String date = scanner.next();
		
		findEvent(date);
		
	}
	
	/**
	 * access the hashmap
	 * @param date
	 * @throws ParseException
	 */
	public void findEvent(String date) throws ParseException {
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
		Date dateObj = dateFormat.parse(date); 
		
		String myEvent = storedEvents.get(dateObj);
		System.out.println(myEvent);
		
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
	
	/**
	 * command center
	 * @throws Exception
	 */
	public void selectMenu() throws Exception {
		
		printMenu();
		
		while(true) {
			
			System.out.println("Select command(1, 2, 3, h, q): "); //keep asking inside the loop
			String cmd = scanner.next();
			
			if(cmd.equals("1")) {
				cmdRegister(scanner);
			}else if(cmd.equals("2")) {
				cmdSearch(scanner);
			}else if(cmd.equals("3")) {
				showCal();
			}else if(cmd.equals("h")) {
				printMenu();
			}else if(cmd.equals("q")) {
				break; //only available inside loop
			}else {
				System.out.println("Wrong command");
				break;
			}
		}
		scanner.close(); //outside the loop
				
	}
}
