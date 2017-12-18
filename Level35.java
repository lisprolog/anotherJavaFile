/*
****SPECIFICATION****
http://0xf.at/play/35?pw=
Level 35
by Oscar Arnflo

Count the circles.
Shapes can never intersect and are never broken by image's edges

****MY COMMENTS****
This code perceives 
    squares: if width and height are equal
    circles: width and height differ
*/

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Level35{
    
        static int[][] figures0;
        static int width = 200; 		//963;    //width of the image
        static int height = 200; 		//640;   //height of the image
        public static void main(String args[])throws IOException{

                convertPicture();
                convertPicture2();
                printPicture();
                findCircle();
                //printPicture();
        }

        /**
        *   get RGB values into two dim array
        */
        public static void convertPicture(){

                BufferedImage image = null;
                File f = null;
                try{
                        //f = new File("c0e787a33e08d54c90c34d81d7ff3de3.png"); //image file path
                        f = new File("g.png"); //image file path
                        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                        image = ImageIO.read(f);
                        //System.out.println("Reading complete.");
                }catch(IOException e){
                        System.out.println("Error: "+e);
                }
                figures0 = new int[height][width];
                int p = image.getRGB(0,0);
                for(int j = 0; j < height; j++){
                        for(int i = 0; i < width; i++){
                                figures0[j][i] = image.getRGB(i,j);
                        }
                } 
        }

        /**
        *   convert picture in two colors(1 means color and 0 means space)
        */
        public static void convertPicture2(){
                for(int i = 0; i< height; i++){
                        for(int j = 0; j < width; j++){
                                if(figures0[i][j] != -1){
                                        figures0[i][j] = 1;
                                }else{
                                        figures0[i][j] = 0;
                                }
                        }
                }
        }
        /**
        *   print array in terminal
        */
        public static void printPicture(){
                for(int i = 0; i< height; i++){
                        for(int j = 0; j < width; j++){
                                System.out.print(figures0[i][j]);
                        }
                        System.out.println("");
                }
                System.out.println("");
        }
        
        /**
        *   count circles in 2 dim array:
        *   find an area of ones(1) in a picture of zeros(0)
        *   count the ones in horizontal
        *   count the ones in vertical
        *   if length of horizontal and vertical(width and height) are identical: it's a square 
        *   else a circle
        *   if it is a square, delete the square and square counter up
        *   else it is a circle, therefore we fill the circle with zeros and circle counter up
        *   last we print out both counters
        */
        public static void findCircle(){
            int h = 0;                          // length of horizontal ones
            int v = 0;                          // length of vertical ones
            int squares = 0;                    // counter squares
            int circles = 0;                    // counter circles
            for(int j = 0; j < height; j++){
                for(int i = 0; i < width; i++){
                    if(figures0[j][i] == 1){            //if color found
                        h = countOneHorizontal(i, j);   //count horizontal length
                        v = countOneVertical(i, j);     //count vertical length
                        if(check(h,v)){                 //if both length equal
                            deleteSquare(i,j,h);        //  delete square
                            squares++;                  //  count square
                            System.out.println("x:" + i + "\t y:" + j + "\t\t square");
                        }else{                          //else count as circle
                            circles++;                  // count circle
                            fillCircle(i, j, 0);        // delete circle with fill 
                            System.out.println("x:" + i + "\t y:" + j + "\t\t circle");       
                        }    
                    }
                }
            }
            System.out.println(squares + "\t squares deleted");
            System.out.println(circles + "\t circles deleted");
        }
        
        /**
        *   if we find a area with ones, we count them horizontally
        */
        public static int countOneHorizontal(int x, int y){
            int count = 0;
            int value = figures0[y][x];
            while(value == 1){
                value = figures0[y][x++];
                count++;
            }
            return count;
        }
        
        /**
        *   if we find an area with ones, we count them vertically
        */
        public static int countOneVertical(int x, int y){
            int count = 0;
            int value = figures0[y][x];
            while(value == 1){
                value = figures0[y++][x];
                count++;
            }
            return count;
        }
        
        /**
        *   check if width and height are equal to differ between square and circle
        */
        public static boolean check(int a, int b){
            if(a == b){
                return true;
            }else{
                return false;
            }
        }

        /**
        *   delete the square by setting ones horizontally and vertically h times
        *   since it is a square width and height are equal
        */
        public static void deleteSquare(int x, int y, int h){
            for(int j = 0; j < h; j++){
                for(int i = 0; i < h; i++){
                    figures0[y+j][x+i]= 0;
                }
            }
        }
        
        /**
        *   to fill the circle we use the recursive fill algorithm
        */
        public static void fillCircle(int x, int y, int c){
            if(getPixel(x,y) == 1){
                setPixel(x,y,c);
                fillCircle(x, y+1, c);//down
                fillCircle(x+1, y, c);//right
                fillCircle(x, y-1, c);//up
                fillCircle(x-1, y, c);//left
            }
        }
        
        public static int getPixel(int x, int y){
            return figures0[y][x];
        }
        
        public static void setPixel(int x, int y, int c){
            figures0[y][x] = c;
        }
}
