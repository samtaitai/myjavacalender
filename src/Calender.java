

public class Calender {
	
	//throws keyword means I don't care for now
	//exception will be handled at the moment of the method being called 
	public static void main(String[] args) throws Exception { 
		// TODO Auto-generated method stub
		
		//AddNumbers.insertNumber();
		//AddNumbers.calculate(AddNumbers.number1, AddNumbers.number2);
		//FindDays.FindMonthlyDays();
		
		//PrintCalender pc = new PrintCalender(); //public method not static
		//pc.printChoiceCal(1970, 1);
		//pc.printChoiceCal(2022, 8);
		
		CommandCalendar cc = new CommandCalendar();
		//cc.cmdRegister("2022-08-05", "food festival");
		//System.out.println(cc.cmdSearch("2022-08-05").equals("food festival"));
		cc.selectMenu();
	}

}
