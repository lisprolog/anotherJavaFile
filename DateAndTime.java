import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
      Calendar calendar = Calendar.getInstance();
	    String week = "";
	    calendar.set(Calendar.YEAR, year);
	    calendar.set(Calendar.MONTH, month-1);
	    calendar.set(Calendar.DAY_OF_MONTH, day);
	    String s = "" + calendar.getTime();
	    for(int i = 0; i < 3; i++){
	        week += s.charAt(i);
	    }
	    switch(week) {
	    case "Mon":
	        week = "MONDAY";
	        break;
	    case "Tue":
	        week = "TUESDAY";
	        break;
      	case "Wed":
	        week = "WEDNESDAY";
	        break;
	    case "Thu":
	        week = "THURSDAY";
	        break;
      	case "Fri":
	        week = "FRIDAY";
	        break;
	    case "Sat":
	        week = "SATURDAY";
	        break;
      	case "Sun":
	        week = "SUNDAY";
	        break;
	    default:
	        week = "ERROR";
	    }
	      
      return week;
  }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
