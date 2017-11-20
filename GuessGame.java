/**
 *  GuessGame: Computer chooses a number from 0 - 100 and you will guess it.
 *             Player has only 6 chances to guess.
 *             This file/game needs StdDraw.java or StdDraw.jar to run properly.
 *             
 */
import java.awt.*;
import java.util.Scanner;

public class GuessGame {

    static int height = 500;
    static int width = 500;

    public static void main(String[] args) {
        
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        StdDraw.setCanvasSize(width, height);
        StdDraw.show();

        double random = Math.random() * 100;
        int random2 = (int)random;
        if(random2 < 1){
                random = 1;
        }
        //System.out.println(random2);  //print random number
        game(random2);

    }

    public static void game(int random){
        one();
        StdDraw.show();         //start the screen
        boolean run = true;
        int  count = 0;
        int temp = 0;
        Scanner sc = new Scanner(System.in);
        while(run){
            if (sc.hasNextInt()) {
                temp = sc.nextInt();
                if(temp < 0 || temp > 100){
                    //System.out.println("Fehler: Zahl nicht richtig gewaehlt: Sie muss grosser als 0 und kleiner als 100 sein!");
                    // Laut Spezifikation soll dieser Fall ignoriert werden.
                }else{
                    if(temp < random){
                        System.out.println("Gesuchte Zahl ist groesser!");
                        count++;
                    }else if(temp > random){
                        System.out.println("Gesuchte Zahl ist kleiner!");
                        count++;
                    }else if(temp == random){
                        System.out.println("Gewonnen!");
                        count = 7;
                        run = false;
                    }else{
                        //keine Spezifikation, sollte nicht vorkommen!
                        System.out.println("Fehler!");
                    }

                    // Graphik State Control
                    switch(count){
                        case 0: StdDraw.clear(); one(); break;
                        case 1: StdDraw.clear(); two(); break;
                        case 2: StdDraw.clear(); three(); break;
                        case 3: StdDraw.clear(); four(); break;
                        case 4: StdDraw.clear(); five(); break;
                        case 5: StdDraw.clear(); six(); break;
                        case 6: StdDraw.clear(); lost(); System.out.println("Verloren! Losung:" + random); break;
                        case 7: won(); break;
                        default:
                            System.out.println("Error state"); break;
                            // keine Spezifikation, sollte nicht vorkommen
                    }
                }
            }else if(sc.hasNext()) {
                String s = sc.next();
                // wenn eingabe kein Int ist, wird ausgelesen (damit Endlosschleife verhindert),
            }
        }
    }

    public static void f(){
        // oberste Munze
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(0.5,0.6,0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledCircle(0.5,0.6,0.04);
        //StdDraw.setFont(font);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.text(0.495, 0.595, "€");
    }

    public static void e(){
        //mittlere Munzen rechts
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(0.55,0.5,0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledCircle(0.55,0.5,0.04);
        //StdDraw.setFont(font);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.text(0.55, 0.495, "€");
    }

    public static void d(){
        // mittlere Munzen links
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(0.45,0.5,0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledCircle(0.45,0.5,0.04);
        //StdDraw.setFont(font);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.text(0.45, 0.495, "€");
    }

    public static void c(){
        //unterste Munze rechts
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(0.6,0.4,0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledCircle(0.6,0.4,0.04);
        //StdDraw.setFont(font);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.text(0.595, 0.395, "€");
    }

    public static void b(){
        // unterste Munze mitte
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(0.5,0.4,0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledCircle(0.5,0.4,0.04);
        //StdDraw.setFont(font);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.text(0.495, 0.395, "€");
    }

    public static void a(){
        // unterste Munze links
        StdDraw.setPenColor(StdDraw.YELLOW);
        StdDraw.filledCircle(0.4,0.4,0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.filledCircle(0.4,0.4,0.04);
        Font font = new Font("Arial", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.GRAY);
        StdDraw.text(0.395, 0.395, "€");
    }
    // State alle munzen zu beginn
    public static void one(){
        a();
        b();
        c();
        d();
        e();
        f();
    }

    // State erster Versuch: eine Munze weniger
    public static void two(){
        a();
        b();
        c();
        d();
        e();

    }

    // State zweiter Versuch
    public static void three(){
        a();
        b();
        c();
        d();

    }

    // State dritter Versuch
    public static void four(){
        a();
        b();
        c();

    }

    // State vierter Versuch
    public static void five(){
        a();
        b();
    }

    // State funfter Versuch
    public static void six(){
        a();
    }


    // letzer Versuch, verloren
    public static void lost() {
        Font font = new Font("Arial", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.RED);
        StdDraw.text(0.4, 0.9, "You LOST!!!");
    }

    // Gewonnen
    public static void won() {
        Font font = new Font("Arial", Font.BOLD, 60);
        StdDraw.setFont(font);
        StdDraw.setPenColor(Color.GREEN);
        StdDraw.text(0.4, 0.9, "You WON!!!");
    }
}
