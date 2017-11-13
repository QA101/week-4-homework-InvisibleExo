import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListTask {

	public static void main(String[] args) {
		//The challenge to not change the original methods given to static.
		ArrayListTask flowThrough = new ArrayListTask();
		//Part 1
		int [] arr = {1, 2, 3, 4};
		System.out.println(flowThrough.inputArray(arr));
		int [] arr1 = {8, 16, 10};
		System.out.println(flowThrough.inputArray(arr1));
		int [] arr2 = {5, 0, -10};
		System.out.println(flowThrough.inputArray(arr2));

		//Part 2
		System.out.println(flowThrough.evenCount(arr));
		System.out.println(flowThrough.evenCount(arr1));
		int [] arr3 = {5, 0, 22};
		System.out.println(flowThrough.evenCount(arr3));
		
		//Part 3
		System.out.println(Arrays.toString(flowThrough.backwardChars("football")));
		System.out.println(Arrays.toString(flowThrough.backwardChars("Career center")));
		System.out.println(Arrays.toString(flowThrough.backwardChars("?")));
		
		//Part 4
		String [] test1 = {"buffalo", "dog"};
		String[] test2 = {"bobcat", "siamese cat", "catbird"};
		String[] test3 = {"Cat", "frog", "mouse"};
		System.out.println(Arrays.toString(flowThrough.catty(test1)));
		System.out.println(Arrays.toString(flowThrough.catty(test2)));
		System.out.println(Arrays.toString(flowThrough.catty(test3)));
		
	}
	//Part 1
	public int sumEvenIndexes(int[] nums) {
	    ArrayList<Integer> numsList = new ArrayList<Integer>();
	    for (int i=0; i<nums.length; i++)
	    {
	       numsList.add(nums[i]);
	    }
	    return sumEvenIndexesB(numsList);
	}

	public int sumEvenIndexesB(ArrayList<Integer> numsList) 
	{
		int a = 0;
		for (int i = 0; i < numsList.size(); i++) {
			if (i%2 == 0) {
				a += numsList.get(i);
			}
		}
		return a;
	}
	//input array for part 1
	public int inputArray(int[] num) {
		return sumEvenIndexes(num);
	}
	
	//Part 2
	public int evenCount(int[] nums) { 

	    ArrayList<Integer> numsList = new ArrayList<Integer>();
	    for (int i=0; i<nums.length; i++)
	    {
	       numsList.add(nums[i]);
	    }
	    
	    return evenCountB(numsList);
	}

	public int evenCountB(ArrayList<Integer> numsList) 
	{     
		int count = 0;
		for(int i = 0; i < numsList.size(); i++) {
			if (numsList.get(i)%2 == 0) {
				count++;
			}
		}
		return count;	
	}
	
	//Part 3
	public String[] backwardChars(String str) { 

	    ArrayList<String> charsList = backwardCharsB(str);
	    
	    String chars[] = new String[charsList.size()];
	    for (int i=0; i<charsList.size(); i++)
	    {
	       chars[i]=charsList.get(i);
	    }
	    return chars;
	}

	public ArrayList<String> backwardCharsB(String str) 
	{    
		ArrayList<String> listChars = new ArrayList<>();
		for (int i = str.length()-1;  i >= 0; i--) {
			listChars.add(str.substring(i, i+1));
		}
		return listChars;
	}
	//Part 4
	public String[] catty(String[] animals) { 

	    ArrayList<String> animalsList = new ArrayList<String>();
	    for (int i=0; i<animals.length; i++)
	    {
	       animalsList.add(animals[i]);
	    }
	    ArrayList<String> catsList = cattyB(animalsList);
	    String cats[] = new String[catsList.size()];
	    for (int i=0; i<catsList.size(); i++)
	    {
	       cats[i]=catsList.get(i);
	    }

	    return cats;
	}

	public ArrayList<String> cattyB(ArrayList<String> animalsList) 
	{    
		ArrayList<String> prizedCats = new ArrayList<>();
		for (int i = 0; i < animalsList.size(); i++) {
			String target = animalsList.get(i);
			
			if (target.contains("cat") || target.contains("Cat")) {
				prizedCats.add(target);
			}
		}
		return prizedCats;

	}
}
