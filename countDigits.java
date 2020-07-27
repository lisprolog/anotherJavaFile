import java.util.Scanner;

public class countDigits{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int count = 0;
	int[] digits = new int[10];
	while(sc.hasNextInt()){
	    count = sc.nextInt();
	    digits[count] = digits[count] + 1;
	}
	for(int i = 0; i < digits.length; i++){
	    System.out.println(i + " : " + digits[i]);
	}
    }
}
	    
