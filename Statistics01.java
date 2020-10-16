import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        int [] numbers = readNumbers();
        Arrays.sort(numbers);
        //toString(numbers);
        System.out.println(mean(numbers));
        System.out.println(median(numbers));
        System.out.println(mode(numbers));
    }

    public static int[] readNumbers(){
        Scanner sc = new Scanner(System.in);
        int n = 0;
        if(sc.hasNextInt()){
            n = sc.nextInt();
        }else{
            n = 0;
        }
        int [] numbers = new int [n];
        for (int i = 0; i < n; i++){
            if(sc.hasNextInt()){
                numbers[i] = sc.nextInt();
            }else{
                numbers[i] = 0;
            }
        }
        return numbers;
    }

    //adds the numbers up and divides them by length, 
    //cast necessary to keep remainder
    public static double mean(int [] numbers){
        int sum = 0;
        for(int i = 0; i < numbers.length; i++){
            sum += numbers[i];
        }
        double result = (double)sum/numbers.length;
        return result;
    }

    public static double median(int [] numbers){
        int n = numbers.length;
        double median = 0;
        double i = n/2;
        int index = 0;
        if(n % 2 == 0){ //length of array is even
            index = (int) i;
            median = (double)(numbers[--index] + numbers[++index])/2; //add two center elements
        }else{          //length of array odd
            i = Math.round(i);
            index = (int) i;
            median = numbers[--index]; 
        }
        return median;
    }

    public static int mode(int [] numbers){
        Arrays.sort(numbers);               //first sort array
        int n = numbers.length;             //array length = n
        int[] counter = new int [n];
        int tmp = numbers[0];               //tmp is number that we will count
        int c = 0;                          //counter for tmp number
        int maxCounter = 0;                 
        for(int i = 0; i < n; i++){
            tmp = numbers[i];               //set tmp number
            c = 0;                          //reset counter
            for(int j = 0; j < n; j++){
                if(tmp == numbers[j]){      //count occurences of number in array
                    c++;
                }
                counter[i] = c;             //save count in counter array same index as numbers
            }
            maxCounter = getMaxIndex(counter);//get highest count/index
        }
        return numbers[maxCounter];         //return most common number
    }

    // return the index of the maximum value
    public static int getMaxIndex (int [] numbers){
        int max = 0;
        int index = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > max){
                max = numbers[i];
                index = i;
            }
        }
        return index;
    }

    public static void toString(int [] numbers){
        for(int i = 0; i < numbers.length; i++){
            System.out.println(numbers[i]);
        }
    }   
}
