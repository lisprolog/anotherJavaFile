import java.util.Scanner;

public class Fib{

    static int a = 0;
    static int b = 1;
    static int addition = 0;
    static int counter = 0;
    static int limit = 0;
    
    public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	System.out.println("limit:");
	limit = sc.nextInt();
	if(limit == 1){// in this case the it will be aborted and 
	    System.out.println(1);
	    return;
	}
        //System.out.println("Start:\n0\n1");
	while(counter < limit-1){
	    counter++;
	    addNshift();
	    //System.out.println(addition);
	}
	System.out.println(addition);
    }

    public static void addNshift(){
	addition = a + b;
	a = b;
	b = addition;
    }

}

	
	    
	    
