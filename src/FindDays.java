import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FindDays {

	static List<Integer> longMonth = new ArrayList<>(List.of(1,3,5,7,8,10,12));
	static List<Integer> shortMonth = new ArrayList<>(List.of(2,4,6,9,11));

	static int month;
	
	public static void FindMonthlyDays() {
		
		System.out.println("Input your choice of month: ");
		
		Scanner scanner = new Scanner(System.in);
		month = scanner.nextInt();
		
		System.out.println("Your choice of month is: " + month);
		
		if(longMonth.contains(month)) {
			System.out.println("It has 31 days.");
		}else if(shortMonth.contains(month)) {
			System.out.println("It has 30 days.");
		}else {
			System.out.println("Your number is out of range.");
		}
		
		scanner.close();
	}
	
	
}
