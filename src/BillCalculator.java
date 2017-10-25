import java.util.Scanner;
public class BillCalculator {

	public static void main(String[] args) {
		int result=0, User=0;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter one or more bills, the input ends if the number is 0: ");
		while((User=sc.nextInt())!=0) {
			result+=User;
			System.out.print("Enter your next number: ");
		}
		System.out.println("Total bill: "+result);
	}

}
