/**
 * Calculate and print calendar based on year, month input
 * @author samta
 *
 */
public class PrintCalender {
	
	public int getMaxDaysinLeapYear(int month) {
		
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
	
	public int getMaxDays(int month) {
		
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
	
	public int getDayCode(int year, int month, int day) {
		
		int zeroYear = 1970;
		int ZEROWEEKDAY;
		
		if(year == zeroYear) { //in case of it passes for loops 
			ZEROWEEKDAY = 3;
		}else {
			ZEROWEEKDAY = 4;
		}
		
		int count = 0;
		int delta;
		int dayCode;
		
		//PrintCalender pc = new PrintCalender();
		
		//year calculation
		for(int i=zeroYear; i<year; i++) {
			
			if(i % 4 == 0 && i % 100 != 0 || i % 4 == 0 && i % 100 == 0 && i % 400 == 0) {
				delta = 366;
			}else {
				delta = 365;
			}
			
			count += delta;
		}
		
		//System.out.println(count);
		
		//day calculation
		for(int i=1; i<month; i++) {
			
			if(i % 4 == 0 && i % 100 != 0 || i % 4 == 0 && i % 100 == 0 && i % 400 == 0) {
				delta = getMaxDaysinLeapYear(month);
			}else {
				delta = getMaxDays(month);
			}
			
			count += delta;
		}
		
		count += day-1; 
		dayCode = (count + ZEROWEEKDAY) % 7;
		
		//System.out.println(dayCode);
		
		return dayCode;
		
	}
	
	public void printChoiceCal(int year, int month) {
		
		//PrintCalender pc = new PrintCalender();
		
		int endPoint; 
		int startPoint;
		
		if(year % 4 == 0 && year % 100 != 0 || year % 4 == 0 && year % 100 == 0 && year % 400 == 0) {
			endPoint = getMaxDaysinLeapYear(month);
		}else {
			endPoint = getMaxDays(month);
		}
		
		startPoint = getDayCode(year, month, 1); //5
		//System.out.println(startPoint); 
		
		System.out.println("  " + year + " " + month);
		System.out.println("  SU MO TU WE TH FR SA");
		System.out.println("  --------------------");
		
		//begin with blanks (still in the first line)
		for(int k=0; k<7-startPoint; k++) { //k<2
			System.out.print("   ");
		}
		
		//the first line
		for(int j=1; j<startPoint+1; j++) { //j<4
			System.out.printf("%3d", j);
		}
		System.out.println();
		
		//the second line
		for(int i=1+startPoint; i<endPoint+1; i++) { //i=2+3, i starts as 5
			
			System.out.printf("%3d", i);
			if(i % 7 == startPoint) { 
				System.out.println();
			}
		}
		System.out.println();

		
	}
	
	
}
