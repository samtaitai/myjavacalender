import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class FindDays {
	
	public List<Integer> longMonth = new ArrayList<>(List.of(1,3,5,7,8,10,12));
	public List<Integer> shortMonth = new ArrayList<>(List.of(2,4,6,9,11));

	public int month;
	public int iterationNum;
	
	public static void FindMonthlyDays() {
		
		FindDays fd = new FindDays();
		
		System.out.println("Insert the number of iteration: ");
		Scanner scanner = new Scanner(System.in);
		fd.iterationNum = scanner.nextInt();	
		
		for(int i=0; i<fd.iterationNum; i++) {
			
			System.out.println("Input your choice of month: ");
			
			fd.month = scanner.nextInt(); 
			
			System.out.println("Your choice of month is: " + fd.month);
			
			if(fd.longMonth.contains(fd.month)) {
				System.out.println("It has 31 days.");
			}else if(fd.shortMonth.contains(fd.month)) {
				System.out.println("It has 30 days.");
			}else {
				System.out.println("Your number is out of range.");
			}
			
		}
		scanner.close(); //make sure to close it outside for loop
		
	}
	
}
