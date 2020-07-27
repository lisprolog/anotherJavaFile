import java.util.Scanner;
public class addSpace{
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String s = "";
	while(sc.hasNext()){
	    s = sc.next();
	    for(int i = 0; i < s.length(); i++){
		System.out.print(s.charAt(i) + " ");
	    }
	}
    }
}
	    
