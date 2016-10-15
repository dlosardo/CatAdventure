import java.util.Scanner;

public class CatNest {
	private int noActs;
	private boolean didSleep;
	private String listActions[];
	
	public CatNest(){
		noActs=0;
		didSleep=false;
		listActions=new String[100];
	}
	
	public void fillList(String newAction){
		noActs++;
		listActions[(noActs-1)]=newAction;
	}
	
	public String[] getListActions(){
		return listActions;
	}
	
	
	public boolean getDidSleep(){
		return(didSleep);
	}
	
	public void hasRecentNap(){
		didSleep=true;
	}
	
	public void location(Cat cat){
		System.out.println(cat.getName()+" is in the cat nest.");
	}
	
	public void chooseAction(CatNest newNest, Cat cat, StringGrowableList catList){
		Scanner typed = new Scanner(System.in);
		while (true){
			System.out.println("Please choose from the following options:");
			
			String allActs="";
			for (int i=0;i<catList.getSize(); i++){
				String temp=(catList.getItem(i));
				if (i==0){
					allActs=temp;
				}
				else allActs=allActs+" or "+temp;
			}
			System.out.println(catList);
			String answer;
			answer=typed.next();
			boolean isValid=false;
			for (int i=0;i<catList.getSize();i++){
				if (catList.getItem(i).equalsIgnoreCase("nap")&&answer.equalsIgnoreCase(catList.getItem(i))){
					System.out.println(newNest.takeNap(cat));
					isValid=true;
					break;
				}
				if (catList.getItem(i).equalsIgnoreCase("explore")&&answer.equalsIgnoreCase(catList.getItem(i))){
					isValid=true;
					System.out.println("You venture out into the unknown.");
					return;
				}
			}
			if (!isValid)
			System.out.println("Invalid response, please type "+allActs+"!");	
		}
	}
	
	public String takeNap(Cat cat){
		if (!getDidSleep()){
			while(true){
				Scanner typed = new Scanner(System.in);
				System.out.println("Would you like to take a nap? Please type Y or N.");
				String answer;
				answer = typed.next();
				if (answer.equalsIgnoreCase("Y")){
					cat.goToMaxHp();
					hasRecentNap();
					return "You curl up in your cat bed and take a snooze. HP restored!";
				}
				else if (answer.equalsIgnoreCase("N"))
					return "You think, no time for naps, must go explore the world!";
				else System.out.println("Invalid response, please type Y or N!");
			}
		}
		else return "You just took a nap, silly! Go explore the world!";
	}
}
