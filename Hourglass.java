/*
    Solved challenge from hackerrank.com
    Implementation and specification removed.
*/

public class Hourglass{
    
    public static void main(String[] args){
	
	int [][] test = {
	    {1, 1, 1, 0, 0, 0},
	    {0, 1, 0, 0, 0, 0},
	    {1, 1, 1, 0, 0, 0},
	    {0, 0, 2, 4, 4, 0},
	    {0, 0, 0, 2, 0, 0},
	    {0, 0, 1, 2, 4, 0},
	};

	int [][] test2 = {
	    {-9, -9, -9, 1, 1, 1},
	    {0, -9, 0, 4, 3, 2},
	    {-9, -9, -9, 1, 2, 3},
	    {0, 0, 8, 6, 6, 0},
	    {0, 0, 0, -2, 0, 0},
	    {0, 0, 1, 2, 4, 0},
	};

	int [][] test3 = {
	    {-1, -1, 0, -9, -2, -2},
	    {-2, -1, -6, -8, -2, -5},
	    {-1, -1, -1, -2, -3, -4},
	    {-1, -9, -2, -4, -4, -5},
	    {-7, -3, -3, -2, -9, -9},
	    {-1, -3, -1, -2, -4, -5}
	};
	    
	int [] hourGlasSums = allHourglasses(test3);
	
	System.out.println(getMaxValue(hourGlasSums));
    }

    public static int hourglassSumPrintArray(int[][] arr) {
        return 0;
    }

    public static int[] extractHourglass(int[][] arr, int x, int y){
	return hourglass;
    }

    public static int HourglassSum(int [] hg){
	return sum;
    }

    public static int[] allHourglasses(int [][] arr){
	return hourGlasSums;
    }

    public static int getMaxValue(int [] array){
	return maxValue;
    }
}
	
