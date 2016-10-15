public class Cat {
	
	private String name;
	private int hp;
	private int maxHp;
	private int pointsAvail;
	private int speed;
	private int stealth;
	private int power;
	
	//constructor is next:
	public Cat(String name){
		this.name=name;
		hp=30;
		maxHp=30;
		pointsAvail=10;
		
		speed=0;
		stealth=0;
		power=0;
	}
	//getters:
	public String getName(){
		return name;
	}
	public int getPointsAvail(){
		return pointsAvail;
	}
	public int getSpeed(){
		return speed;
	}
	public int getStealth(){
		return stealth;
	}
	public int getPower(){
		return power;
	}
	
	//setters:
	public void setHp(int hp){
		this.hp=hp;
	}
	
	public void reducePoints(int pointsAvail){
		this.pointsAvail=this.pointsAvail-pointsAvail;
	}
	
	public void increaseSpeed(int speed){
		this.speed=this.speed+speed;
	}
	public void increaseStealth(int stealth){
		this.stealth=this.stealth+stealth;
	}
	public void increasePower(int power){
		this.power=this.power+power;
	}
	
	public void increaseHp(int hp){
		this.hp=this.hp+hp;
	}
	
	public void decreaseHp(int hp){
		this.hp=this.hp-hp;
	}
	
	public void goToMaxHp(){
		hp=maxHp;
	}
	
}
