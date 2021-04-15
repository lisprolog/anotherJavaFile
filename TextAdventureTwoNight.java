import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
public class TextAdventureTwoNight{
    
    static Scanner sc;

    private GameLevel g01;
    private String temporaryWelcome, temporaryAnswer;
    private int [] save = {0,0,0,0}; //Level/Room/Person/X

    private ArrayList<GameLevel> levelList = new ArrayList<GameLevel>();
    private GameLevel temporaryGameLevel;
    private Room temporaryRoom;
    private String [] temporaryCommands;
    private String [] temporaryFeedback;
    private String [] temporaryQuestions;
    private static int [] temporaryPrices;
    private String bufferCommand = "";
    private int commandIndex = 0;
    private HashMap map1;
    private boolean isPerson = false;
    private static String item = "";
    
    public static void main(String [] args){

	TextAdventureTwoNight t1 = new TextAdventureTwoNight();

	GameLevel g01 = new GameLevel(0);
	t1.levelList.add(g01);
	t1.setTemporaryGameLevel(g01);
	HashMap<String, Room> mapsRoom = new HashMap<String, Room>();
	HashMap<String, Room> mapsPerson = new HashMap<String, Room>();
	Room r0 = new MainEntrance(0);
	mapsRoom.put("entrance", r0);
	Room r1 = new Bank(1);
	mapsRoom.put("bank", r1);
	Room r2 = new ATM(2);
	mapsRoom.put("atm", r2);
	Room r27 = new BetaCade(27);
	mapsRoom.put("arcade", r27);
	Room r12 = new Burger(12);
	mapsRoom.put("burger", r12);
	Room r13 = new Candy(13);
	mapsRoom.put("candy", r13);
	Room r8 = new Chinese(8);
	mapsRoom.put("chinese", r8);
	Room r7 = new Coffeeshop(7);
	mapsRoom.put("coffeeshop", r7);	
	Room r3 = new CustomerBank(3);
	mapsPerson.put("customerbank", r3);
	Room r14 = new Emergencyexita(14);
	mapsRoom.put("emergencyexita", r14);
	Room r17 = new Grocery(17);
	mapsRoom.put("grocery", r17);	
	Room r4 = new Florist(4);
	mapsRoom.put("florist", r4);
	Room r6 = new Exchange(6);
	mapsPerson.put("exchange", r6);
	Room r18 = new ISPprovider(18);
	mapsRoom.put("ispprovider", r18);
	Room r29 = new Music(29);
	mapsRoom.put("music", r29);
	Room r19 = new Phonebooth(19);
	mapsRoom.put("phonebooth", r19);
	Room r20 = new Playground(20);
	mapsRoom.put("playground", r20);
	Room r21 = new Seatsa(21);
	mapsRoom.put("seatsa", r21);
	Room r22 = new Seatsb(22);
	mapsRoom.put("seatsb", r22);
	Room r23 = new Sports(23);
	mapsRoom.put("sports", r23);
	Room r24 = new Theater(24);
	mapsRoom.put("theater", r24);
	Room r25 = new Tools(25);
	mapsRoom.put("tools", r25);
	Room r26 = new Room(26);
	mapsRoom.put("toys", r26);
	Room r5 = new Security(5);
	mapsPerson.put("security", r5);
	Room r9 = new Sectiona(9);
	mapsRoom.put("sectiona", r9);
	Room r10 = new Sectionb(10);
	mapsRoom.put("sectionb", r10);
	Room r11 = new Sectionc(11);
	mapsRoom.put("sectionc", r11);
	Room r15 = new Sectiond(15);
	mapsRoom.put("Sectiond", r15);
	Room r16 = new HelpDesk(16);
	mapsRoom.put("helpdesk", r16);
	Room r37 = new PacmanGame(37);
	mapsRoom.put("pacman", r37);
	Room r38 = new SnakeGame(38);
	mapsRoom.put("snake", r38);
	Room r39 = new Inventory(39);
	mapsRoom.put("inventory", r39);
	Room r40 = new Notepad(40);
	mapsRoom.put("notepad", r40);

	sc = new Scanner(System.in);

	t1.setTemporaryGameLevel(g01);
	t1.setTemporaryRoom(r0);
	t1.setTemporaryCommands(t1.copyArray(r0.getCommands()));
	t1.setTemporaryFeedback(t1.copyArray(r0.getFeedback()));
	t1.setTemporaryAnswer("Entrance");
	t1.setTemporaryWelcome(r0.getWelcome());

	boolean mainLoop = true;
	String buffer = "";

	t1.toStringOutput();
	
	while(mainLoop){
	    buffer = sc.next();
	    t1.setBufferCommand(buffer);
	    t1.setTemporaryAnswer(" ");
	    if(buffer.equals("quit")){
		mainLoop = false;
	    }else if(mapsRoom.containsKey(buffer)){// change Room
		t1.setTemporaryRoom(mapsRoom.get(buffer));
		t1.setTemporaryWelcome(t1.getTemporaryRoom().getWelcome());
		t1.setPersonBoolean(false);
		t1.setTemporaryAnswer(" ");
		if(t1.getTemporaryRoom().index == 37){
		    t1.getTemporaryRoom().runGame();
		}else if(t1.getTemporaryRoom().index == 38){
		    t1.getTemporaryRoom().runGame();
		}else if(t1.getTemporaryRoom().index == 39){
		    t1.setTemporaryAnswer("€: " + t1.getTemporaryRoom().getMoney() + " @: " + t1.getTemporaryRoom().getHealth());
		}
     	    }else if(mapsPerson.containsKey(buffer)){// change Person/Room
		t1.setTemporaryRoom(mapsPerson.get(buffer));
		t1.setTemporaryWelcome(t1.getTemporaryRoom().getWelcome());
		t1.setPersonBoolean(true);
		t1.setTemporaryAnswer(" ");
		
	    }else{//Level commands
		try{
		    String[] commands = t1.getTemporaryRoom().getCommands();
		    String[] feedback = t1.getTemporaryRoom().getFeedback();
		    int index = t1.checkCommands(commands, buffer);
		    t1.setTemporaryAnswer(feedback[index]);
		    if(t1.checkBuy(buffer)){// buy command
		    	t1.setTemporaryFeedback(t1.copyArray(r0.getFeedback()));
		    	temporaryPrices = t1.getTemporaryRoom().getPrices();
		      Room inventory = mapsRoom.get("inventory");
		      for(int i = 3; i < buffer.length(); i++){
		    		item += buffer.charAt(i);
		      }
		      if(inventory.getMoney() >= temporaryPrices[index]){
		    		inventory.setCommand(item);
		    		inventory.setFeedback(feedback[index]);
		    		inventory.setMoney(temporaryPrices[index]);
		    		mapsRoom.remove("inventory");
		    		mapsRoom.put("inventory", inventory);
				item = "";
		      }
		    }
		}catch(Exception e){
		    t1.setTemporaryAnswer("wrong command");
		}
	    }
		    
	    t1.clearScreen();
	    t1.toStringOutput();
	    
	}
    }


    public void toStringOutput(){
	System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +\n");
	System.out.println(this.temporaryWelcome);
	System.out.println("+ + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + + +\n");
	System.out.println(this.temporaryAnswer);
	System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -\n");
	String[] commands = temporaryRoom.getCommands();
	if(this.isPerson){
	    this.setTemporaryQuestions(this.copyArray(temporaryRoom.getQuestions()));
	    String[] questions = this.getTemporaryRoom().getQuestions();
	    for(int i = 0; i < commands.length; i++){
		System.out.println(commands[i] + ": " + questions[i]);
	    }
	}else{
	    for(int i = 0; i < commands.length; i++){
		System.out.println(commands[i]);
	    }
	}
	System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
	System.out.print(">");
    }

    public void clearScreen(){
	Process p;
	try {
	    String[] cmd = { "sh", "/home/chocun/gitTextAdventure_TwoNight/clear.sh"};
	    p = Runtime.getRuntime().exec(cmd); 
	    p.waitFor(); 
	    BufferedReader reader = new BufferedReader(new InputStreamReader(
									     p.getInputStream())); 
	    String line; 
	    while((line = reader.readLine()) != null) { 
		System.out.println(line);
	    } 
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (InterruptedException e) {
	    e.printStackTrace();
	}
    }

    //check if the user command input is present in mapRooms commands
    public int checkCommands(String [] commands, String command){
	for(int i = 0; i < commands.length; i++){
	    if(commands[i].equals(command)){
		return i;
	    }
	}
	System.out.println("Error: " + command + " not in commands!");
	return -1;
    }

    //checks if the command is a buy/transaction command
    public boolean checkBuy(String s){
	String buff = "";
	for(int i = 0; i < 3; i++){
	    buff += s.charAt(i);
	}
	if(buff.equals("buy")){
	    return true;
	}else{
	    return false;
	}
    }

    //checks if the command is a buy/transaction command
    public boolean checkEur(String s){
	String buff = "";
	for(int i = 0; i < 3; i++){
	    buff += s.charAt(i);
	}
	if(buff.equals("eur")){
	    return true;
	}else{
	    return false;
	}
    }

    public boolean checkNote(String s){
	String buff = "";
	for(int i = 0; i < 4; i++){
	    buff += s.charAt(i);
	}
	if(buff.equals("note")){
	    return true;
	}else{
	    return false;
	}
    }    

    public static String[] copyArray(String [] array){
	String[] copy = new String[array.length];
	for(int i = 0; i < array.length; i++){
	    copy[i] = array[i];
	}
	return copy;
    }

    public static int[] copyArray(int [] array){
	int[] copy = new int[array.length];
	for(int i = 0; i < array.length; i++){
	    copy[i] = array[i];
	}
	return copy;
    }
    
    public void setTemporaryWelcome(String s){
	this.temporaryWelcome = s;
    }

    public String getTemporaryWelcome(){
	return this.temporaryWelcome;
    }
    
    public void setTemporaryAnswer(String s){
	this.temporaryAnswer = s;
    }

    public void setTemporaryGameLevel(GameLevel l){
	this.temporaryGameLevel = l;
    }
    
    public void setTemporaryRoom(Room r){
	this.temporaryRoom = r;
    }

    public Room getTemporaryRoom(){
	return this.temporaryRoom;
    }

    public int[] getTemporaryPrices(){
	return this.temporaryPrices;
    }
    
    public void setTemporaryCommands(String[] tc){
	this.temporaryCommands = tc;
    }

    public void setTemporaryQuestions(String[] q){
	this.temporaryQuestions = q;
    }

    public void setTemporaryPrices(int[] p){
	this.temporaryPrices = p;
    }
    
    public void setCommandIndex(int i){
	this.commandIndex = i;
    }

    public void setBufferCommand(String s){
	this.bufferCommand = s;
    }

    public String getBufferCommand(){
	return this.bufferCommand;
    }

    public void setTemporaryFeedback(String[] fb){
	this.temporaryFeedback = fb;
    }

    public ArrayList<GameLevel> getLevelList(){
	return this.levelList;
    }

    public void setPersonBoolean(boolean b){
	this.isPerson = b;
    }	
}
