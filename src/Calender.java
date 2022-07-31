import java.util.ArrayList;
import java.util.List;

public class Calender {

	static List<Integer> longMonth = new ArrayList<>(List.of(1,3,5,7,8,10,12));
	static List<Integer> shortMonth = new ArrayList<>(List.of(2,4,6,9,11));
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//AddNumbers.insertNumber();
		//AddNumbers.calculate(AddNumbers.number1, AddNumbers.number2);
		FindDays.FindMonthlyDays();
		
	}

}
