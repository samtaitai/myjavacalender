

public class Calender {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//AddNumbers.insertNumber();
		//AddNumbers.calculate(AddNumbers.number1, AddNumbers.number2);
		//FindDays.FindMonthlyDays();
		
		PrintCalender pc = new PrintCalender(); //public method not static
		pc.getDayCode(1970, 1, 1);
		pc.printChoiceCal(1970, 1);
		pc.printChoiceCal(2022, 8);
		//pc.getDayCode("2008", 4);
		
		
		
			
		
	}

}
