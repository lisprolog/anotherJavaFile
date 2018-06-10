//'main' method must be in a class 'Rextester'.
//Compiler version 1.8.0_111

import java.util.*;
import java.lang.*;

class Rextester
{  
    public static void main(String args[])
    {
        System.out.println("Hello, Programmer World!");
        System.out.println("Syria: "+ percent(21000000, 16600));
        System.out.println("Pakistan: "+ percent(200000000, 1400));
        System.out.println("Bangladesh: "+ percent(165000000, 1200));
        System.out.println("Myanmar: "+ percent(53000000, 850));
        System.out.println("Egypt: "+ percent(94700000, 136000));
    }
    
    public static double percent(double bev, double dev){
         return dev * 100 / bev;    
    }
}