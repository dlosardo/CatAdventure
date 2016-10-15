// List of Strings
public class StringGrowableList {

	private String[] array;
	private int noItems;
	
	public StringGrowableList(){
		array=new String[100];
		noItems=0;
	}
	
	private void increaseArray(){
		String[] tempArray=new String[array.length*2];
		for (int i=0;i<array.length;i++){
			tempArray[i]=array[i];
		}
		array=tempArray;
	}
	public void addItem(String newItem){
		if (noItems+1>array.length){
			increaseArray();
		}
		array[noItems]=newItem;
		noItems++;
	}
	public String getItem(int index){
		if (index>(noItems-1) || index<0){
			throw new IndexOutOfBoundsException();
		}
		String tempItem=array[index];
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
	public void setItem(int index, String newValue){
		if (index>(noItems-1) || index<0){
			throw new IndexOutOfBoundsException();
		}
		array[index]=newValue;
	}
	public int getSize(){
		return noItems;
	}
	public void insertItem(int index, String newItem){
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
//The following code tests the above Growable List Class.
	public static void main(String[] args){
		String act1="Nap";
		String act2="Explore";
		String act3="Play";
		String act4="Access Items";
		String act5="Groom";
		String act6="Eat";
		String act7="Drink";
		
		StringGrowableList catList=new StringGrowableList();
		catList.addItem(act1);
		System.out.println(catList);
		catList.addItem(act2);
		System.out.println(catList);
		catList.addItem(act3);
		System.out.println(catList);
		catList.addItem(act4);
		System.out.println(catList);
		catList.addItem(act5);
		System.out.println(catList);
		catList.addItem(act6);
		System.out.println(catList);
		catList.insertItem(2,act7);
		System.out.println(catList);
		

		for (int i=0;i<catList.getSize();i++){
			System.out.println("Item "+i+"'s number is: "+catList.getItem(i));
		}
		/*
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
		*/
	}

}
