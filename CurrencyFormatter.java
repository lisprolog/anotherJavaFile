import java.util.*;
import java.text.*;

public class CurrencyFormatter {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();
        
        Locale currentLocaleUS = new Locale("en","US");
        Locale currentLocaleINDIA = new Locale("en","IN");
        Locale currentLocaleCHINA = new Locale("zh","CN");
        Locale currentLocaleFRANCE = new Locale("fr","FR");
        Double currencyAmount = payment;
        
        Currency currentCurrencyUS = Currency.getInstance(currentLocaleUS);
        NumberFormat currencyFormatterUS = NumberFormat.getCurrencyInstance(currentLocaleUS);
        String us = currencyFormatterUS.format(payment);
        
        Currency currentCurrencyINDIA = Currency.getInstance(currentLocaleINDIA);
        NumberFormat currencyFormatterINDIA = NumberFormat.getCurrencyInstance(currentLocaleINDIA);
        String india = currencyFormatterINDIA.format(payment);
        
        Currency currentCurrencyCHINA = Currency.getInstance(currentLocaleCHINA);
        NumberFormat currencyFormatterCHINA = NumberFormat.getCurrencyInstance(currentLocaleCHINA);
        String china = currencyFormatterCHINA.format(payment);
        
        Currency currentCurrencyFRANCE = Currency.getInstance(currentLocaleFRANCE);
        NumberFormat currencyFormatterFRANCE = NumberFormat.getCurrencyInstance(currentLocaleFRANCE);
        String france = currencyFormatterFRANCE.format(payment);
        
        String newIndia = "";
        for(int i = 1; i < india.length(); i++){
          newIndia += india.charAt(i);
        }
        india = newIndia;
        
        System.out.println("US: " + us);
        System.out.println("India: " + "Rs." + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
