/**
 * Show main menu
 * Register a new event
 * Search events
 * @author samta
 *
 */

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CommandCalendar {
	
	private Scanner scanner;
	private HashMap<Date, EventItem> storedEvents; //first create 'field'
	private EventItem newEvent;
	
	//second create 'constructor'
	public CommandCalendar() {
		scanner = new Scanner(System.in);
		storedEvents = new HashMap<Date, EventItem>();
		newEvent = new EventItem();
		
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
	 * get user input
	 * save a new event item into the hash map
	 * @param scanner
	 * @throws Exception
	 */
	public void cmdRegister(Scanner scanner) throws Exception {
		
		System.out.println("Input date(yyyy-mm-dd): ");
		newEvent.eventDate = newEvent.convertStrToDate(scanner.next());
		System.out.println("Input event title: (a word)");
		newEvent.eventTitle = scanner.next();
		
		System.out.println("Input event detail: (submit with space+semicolon)");
		String text = "";
		String word;
		while(!(word = scanner.next()).endsWith(";")) {
			text+=word + " ";
		}
		
		newEvent.eventDetail = text; 
		System.out.println("Your event is saved.");
		
		storedEvents.put(newEvent.eventDate, newEvent);
		
	}
	
	/**
	 * get user input(String date)
	 * convert user input into Date date
	 * find the event item with the key(Date date)
	 * @param scanner
	 * @throws Exception
	 */
	public void cmdSearch(Scanner scanner) throws Exception {
		
		System.out.println("Input date(yyyy-mm-dd): ");
		String date = scanner.next();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd"); 
		Date dateObj = dateFormat.parse(date); 
		
		EventItem myEvent = storedEvents.get(dateObj);
		System.out.println(myEvent.eventDate);
		System.out.println(myEvent.eventTitle);
		System.out.println(myEvent.eventDetail);
		
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
