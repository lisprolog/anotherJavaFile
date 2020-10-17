// Rounding to one digit (6.7) in Java.
public class RoundToOneDigit{
    public static void main(String[] args){
        double d = 6.666d;
        System.out.printf("%.1f\n", roundToOneDigit(d));      // cut the digits to one with printformat
    }

    public static double roundToOneDigit(double d){
        double result = d * 100;            //multiply by 100
        result = Math.round(result);         //round the number, but too many digits left
        result /= 100.0;                    //divide by 100
        return result;                      //correct round, too many digits yet.
    }
}
