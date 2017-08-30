/*
Specification on http://0xf.at/play/26

The image you see below contains the password to this level
Rules:
Every horizontal line stands for one letter
The pixel's offset from the left in each line is equal to its number of the letter in the alphabet (eg: offset 0: A, offset 25: Z)
The password is not case sensitive
The color of each pixel is random (but never white) and has no meaning
When you reload the page a new image (and therefore new password) is generated
You have 30 seconds to solve this level

helped to solve this challenge:
//https://www.dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java

*/

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class MyImage02{
	public static void main(String args[])throws IOException{
		int width = 26; 		//963;    //width of the image
		int height = 36; 		//640;   //height of the image
		BufferedImage image = null;
		File f = null;

		//read image
		//image example			"0d5a854f802b2301fd3d46a09eba6d8d.png"
		//original code      		f = new File("D:\\Image\\Taj.jpg"); //image file path
		try{
			f = new File("0d5a854f802b2301fd3d46a09eba6d8d.png"); //image file path
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(f);
//			System.out.println("Reading complete.");
		}catch(IOException e){
			System.out.println("Error: "+e);
		}
		int[] figures0 = new int[height];
		char[] figuresA = new char[height];
		char[] alpha = {'A','B','C','D', 'E','F','G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		int p = image.getRGB(0,0);
		int q = 0;
		int w = 0;
		boolean first = true;
		for(int i = 0; i< height; i++){
			for(int j = 0; j < width; j++){
				q = image.getRGB(j,i);
//				System.out.print(q);
				if(q != -1){
					figures0[i] = j;
					figuresA[i] = alpha[j];
				}
			}
//			System.out.println("");
		} 
		for(int i = 0; i < figuresA.length; i++){
			System.out.print(figuresA[i]);
		}
		System.out.println("");
	}
}
