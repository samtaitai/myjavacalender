import java.util.Scanner;

public class PrintCalender {
	
	public int getMaxDaysinLeapYear() {
		
		System.out.println("Input your choice of month: ");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		scanner.close();
		
		switch(month) {
		case 2:
			return 29;
		case 4:
			return 30;
		case 6:
			return 30;
		case 9:
			return 30;
		case 11:
			return 30;
		default:
			return 31;
		}
	}
	
	public int getMaxDays() {
		
		System.out.println("Input your choice of month: ");
		Scanner scanner = new Scanner(System.in);
		int month = scanner.nextInt();
		scanner.close();
		
		switch(month) {
		case 2:
			return 28;
		case 4:
			return 30;
		case 6:
			return 30;
		case 9:
			return 30;
		case 11:
			return 30;
		default:
			return 31;
		}
	}
	
	public void printChoiceCal(int year, String month) {
		
		PrintCalender pc = new PrintCalender();
		int endPoint; 
		
		if(year % 4 == 0) {
			endPoint = pc.getMaxDaysinLeapYear();
		}else {
			endPoint = pc.getMaxDays();
		}
		
		
		System.out.println("  " + year + " " + month);
		System.out.println("  SU MO TU WE TH FR SA");
		System.out.println("  --------------------");
		
		for(int i=1; i<endPoint+1; i++) {
			System.out.printf("%3d", i);
			if(i%7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
		
	}
	
	
}
