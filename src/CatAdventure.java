import java.util.Scanner;
public class CatAdventure {
	
	Scanner typed = new Scanner(System.in);
	
	private boolean isValidInt(String check, int min, int max){
		try
		{
			int check1 = Integer.parseInt(check);
			if (check1<min || check1>max){
				return false;
			}
		}
		catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	private boolean isValidString(String check){
		for (int i=0; i<(check.length()); i++){
			char tempCar=check.charAt(i);
			if (!Character.isLetter(tempCar))
			{
				return false;
			}
		}
		return true;
	}

	public int assignAttribute(Cat newcat,String attribute,int initialValue){
		System.out.println("You currently have "+newcat.getPointsAvail()+" points to distribute to "+newcat.getName()+".");
		System.out.println(newcat.getName()+" currently has "+initialValue+" "+attribute+" points. How many points would you like to assign to "+newcat.getName()+"'s "+attribute+"?");
		String tempAttribute;
		do{
			tempAttribute=typed.next();
			if(!isValidInt(tempAttribute,0,newcat.getPointsAvail()))
			{
				System.out.println("Invalid response! Please enter an integer between 0 and "+newcat.getPointsAvail());
			}
		}while(!isValidInt(tempAttribute,0,newcat.getPointsAvail()));
	
		return Integer.parseInt(tempAttribute);
		}
	public void updateCat(Cat newcat){
		while(newcat.getPointsAvail()>0){
			int changeInSpeed=assignAttribute(newcat,"speed",newcat.getSpeed());
			newcat.reducePoints(changeInSpeed);
			newcat.increaseSpeed(changeInSpeed);
			System.out.println(newcat.getName()+" now has "+newcat.getSpeed()+" speed points.");
			if (newcat.getPointsAvail()==0){
				return;
			}
			int changeInPower=assignAttribute(newcat,"power",newcat.getPower());
			newcat.reducePoints(changeInPower);
			newcat.increasePower(changeInPower);
			System.out.println(newcat.getName()+" now has "+newcat.getPower()+" power points.");
			if (newcat.getPointsAvail()==0){
				return;
			}
			int changeInStealth=assignAttribute(newcat,"stealth",newcat.getStealth());
			newcat.reducePoints(changeInStealth);
			newcat.increaseStealth(changeInStealth);
			System.out.println(newcat.getName()+" now has "+newcat.getStealth()+" stealth points.");
		}
	}
	
	public static void main(String[] args){
		
		Scanner typed = new Scanner(System.in);
		CatAdventure validS=new CatAdventure();
		
		System.out.println("Please choose a name for your cat.");
		String tempName;
		do {
			tempName=typed.next();
			if (!validS.isValidString(tempName)){
				System.out.println("Name must contain letters ONLY. Please enter another name.");
			}
		}while (!validS.isValidString(tempName));
			
		
		Cat newcat = new Cat(tempName);
		System.out.println("Your cat's name is "+newcat.getName()+".");
		System.out.println("You have a total of "+newcat.getPointsAvail()+" points to allocate to three attributes of "+newcat.getName()+".");
		System.out.println("The three attributes are speed, power, and stealth. Choose wisely! If you use all of your points on one attribute, you will not be able to increase the other attributes!");
		
		CatAdventure updateNewCat = new CatAdventure();
		updateNewCat.updateCat(newcat);
		
		System.out.println(newcat.getName()+" now has "+newcat.getSpeed()+" speed points, "+newcat.getPower()+" power points, and "+newcat.getStealth()+" stealth points.");
		System.out.println(newcat.getName()+" is ready to explore the world!");
		
		CatNest newNest = new CatNest();
		newNest.location(newcat);
		
		StringGrowableList catList = new StringGrowableList();
		catList.addItem("Nap");
		catList.addItem("Explore");
		
		//newNest.fillList("Nap");
		//newNest.fillList("Explore");
		
		//System.out.println(newNest.getListActions());
		
		//String[] list=newNest.getListActions();
		//System.out.println(list[0]);
		newNest.chooseAction(newNest, newcat, catList);
		
		CatOuterWorld newOuter = new CatOuterWorld();
		
	}
}
