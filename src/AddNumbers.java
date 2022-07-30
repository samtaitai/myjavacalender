import java.util.Scanner;

public class AddNumbers {

	static int number1;
	static int number2;
	
	public static void insertNumber() {
		System.out.println("Insert two numbers: ");
		
		Scanner scanner = new Scanner(System.in);
		number1 = scanner.nextInt();
		number2 = scanner.nextInt();
		scanner.close();
	}
	
	public static void calculate(int num1, int num2) {
		
		int result = num1 + num2;
		System.out.println("Your result is: " + result);
		
	}
}
