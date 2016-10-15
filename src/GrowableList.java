//List of Integers
public class GrowableList {
	
	private int[] array;
	private int noItems;
	
	public GrowableList(){
		array=new int[100];
		noItems=0;
	}
	
	private void increaseArray(){
		int[] tempArray=new int[array.length*2];
		for (int i=0;i<array.length;i++){
			tempArray[i]=array[i];
		}
		array=tempArray;
	}
	public void addItem(int newItem){
		if (noItems+1>array.length){
			increaseArray();
		}
		array[noItems]=newItem;
		noItems++;
	}
	public int getItem(int index){
		if (index>(noItems-1) || index<0){
			throw new IndexOutOfBoundsException();
		}
		int tempItem=array[index];
		return tempItem;
	}
	public void removeItem(int index){
		if (index>(noItems-1) || index<0){
			throw new IndexOutOfBoundsException();
		}
		for (int i=index; i<(noItems-1);i++){
			array[i]=array[i+1];
		}
		noItems--;
	}
	public void setItem(int index, int newValue){
		if (index>(noItems-1) || index<0){
			throw new IndexOutOfBoundsException();
		}
		array[index]=newValue;
	}
	public int getSize(){
		return noItems;
	}
	public void insertItem(int index, int newItem){
		if (index>(noItems) || index<0){
			throw new IndexOutOfBoundsException();
		}
		if (noItems+1>array.length){
			increaseArray();
		}
		for (int i=noItems;i>index;i--){
			array[i]=array[i-1];
		}
		array[index]=newItem;
		noItems++;
	}
	
	public String toString(){
		String tempArray="";
		for (int i=0;i<noItems;i++){
			tempArray+=array[i]+" ";
		}
		return tempArray;
	}
/* The following code tests the above Growable List Class.
	public static void main(String[] args){
		int Leon=100;
		int Booty=29;
		int Artemis=500;
		int Waffle=10000;
		int Louise=2;
		int Tina=6;
		int Callie=456;
		
		GrowableList catList=new GrowableList();
		catList.addItem(Leon);
		System.out.println(catList);
		catList.addItem(Booty);
		System.out.println(catList);
		catList.addItem(Artemis);
		System.out.println(catList);
		catList.addItem(Waffle);
		System.out.println(catList);
		catList.addItem(Louise);
		System.out.println(catList);
		catList.addItem(Tina);
		System.out.println(catList);
		catList.insertItem(0,Callie);
		System.out.println(catList);
		

		for (int i=0;i<catList.getSize();i++){
			System.out.println("Item "+i+"'s number is: "+catList.getItem(i));
		}
		
		catList.removeItem(4);
		System.out.println(catList);
		catList.setItem(0, Waffle);
		System.out.println(catList);
		
		try{
			catList.getItem(0);
			System.out.println("We didnt caught the exception (maybe good)");
		}
		catch(IndexOutOfBoundsException e){
			System.out.println("We caught the exception!!!!!");
			e.printStackTrace();
		}
	}
*/
}

