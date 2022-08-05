/**
 * Show main menu
 * Register a new event
 * Search events
 * @author samta
 *
 */

import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.parser.ParseException;

public class CommandCalendar {
	
	private Scanner scanner;
	private HashMap<String, EventItem> storedEvents; //first create 'field'
	private EventItem newEvent;
	private static final String SAVE_FILE = "calendar.csv"; 
	
	//second create 'constructor'
	public CommandCalendar() throws IOException, ParseException {
		scanner = new Scanner(System.in);
		storedEvents = new HashMap<String, EventItem>();
		newEvent = new EventItem(null, null, null);
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
		
		System.out.println("Input date(MM-dd-yyyy): ");
		newEvent.eventDate = scanner.next();
		System.out.println("Input event title: (a word)");
		newEvent.eventTitle = scanner.next();
		
		System.out.println("Input event detail: (submit with space+semicolon)");
		String text = "";
		String word;
		while(!(word = scanner.next()).endsWith(";")) {
			text+=word + " ";
		}
		
		newEvent.eventDetail = text; 
		
		storedEvents.put(newEvent.eventDate, newEvent); //store input to hashmap
		
		writeFile();
		
	}
	
	/**
	 * unfold hashmap 
	 * make it string 
	 * save it 
	 */
	public void writeFile() {
		
		File saveFile = new File(SAVE_FILE); //create file instance
		
		try {
			FileWriter writer = new FileWriter(saveFile, true);
			
			String savedDate = newEvent.eventDate;
			String savedTitle = newEvent.eventTitle;
			String savedDetail = newEvent.eventDetail;
			String savedData = savedDate + "," + savedTitle + "," + savedDetail + "\n";
			
			writer.write(savedData); //write string into the file
			
			System.out.println("File is saved succesfully.");
			
			writer.close();
			
		} catch (IOException e) {
			System.out.println("File write error!");
			e.printStackTrace();
		} 	
		
	}
	
	/**
	 * create or load the csv file
	 * read a line by line
	 * split date/title/detail then save each as a form of EventItem class
	 * create and return a hashmap
	 * @return
	 */
	public HashMap<String, EventItem> loadFile() {
		
		File loadFile = new File(SAVE_FILE);
		if(!loadFile.exists()) {
			System.out.println("No file to be loaded.");
		}
		
		EventItem savedEvent = new EventItem(null, null, null);
		
		try {
			
			Scanner fileScanner = new Scanner(loadFile);
			while(fileScanner.hasNext()) {
				
				String data = fileScanner.next();
				
				String[] splittedData = data.split(",", -2);
				
				savedEvent.eventDate = splittedData[0]; 
				savedEvent.eventTitle = splittedData[1];
				savedEvent.eventDetail = splittedData[2];
				
			}
			
			fileScanner.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		HashMap<String, EventItem> loadedEvents = new HashMap<String, EventItem>();
		loadedEvents.put(savedEvent.eventDate, savedEvent);
		
		return loadedEvents;
		
	}
	
	/**
	 * get user input
	 * find the event based on the date by loadFile method
	 * @param scanner
	 * @throws Exception
	 */
	public void cmdSearch(Scanner scanner) throws Exception {
				
		System.out.println("Input date(MM-dd-yyyy): ");
		String date = scanner.next();
		
		EventItem value = loadFile().get(date);  
		
		System.out.println("Your event: "+value.eventTitle);
		System.out.println("Your event detail: "+value.eventDetail);
		
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
