/*
The purpose of this file is to delete the first three digits (aka line numbers) out of the file.
*/
import java.util.Scanner;
public class Reduze{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String buffer = "";
        while(sc.hasNextLine()){
            buffer = sc.nextLine();
            for(int i = 3; i < buffer.length(); i++){
                System.out.print(buffer.charAt(i));
            }
            System.out.print("\n");
        }
    }
}
