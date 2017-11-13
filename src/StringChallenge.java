import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringChallenge {

	public static void main(String[] args) {
		StringChallenge testSubject = new StringChallenge();
		//Part 1
		System.out.println(testSubject.countCode("aaacodebbb"));
		System.out.println(testSubject.countCode("codexxcode"));
		System.out.println(testSubject.countCode("cozexxcope"));
		
		// Part 2
		System.out.println(testSubject.endMatch("Hiabc", "abc"));
		System.out.println(testSubject.endMatch("AbC", "HiaBc"));
		System.out.println(testSubject.endMatch("abc", "abXabc"));
		
		// Part 3
		System.out.println(testSubject.giveEvenHalf("WooHoo"));
		System.out.println(testSubject.giveEvenHalf("HelloThere"));
		System.out.println(testSubject.giveEvenHalf("abcdef"));
		// Part 4
		System.out.println(testSubject.reverseString("Hello there"));
		System.out.println(testSubject.reverseString("Seattle is cool"));
		System.out.println(testSubject.reverseString("I love Java"));

	}
	//Part 1
	public int countCode(String str) {
		// The \\w is to accept any letter for the 'd' in "code"
		Pattern p = Pattern.compile("co\\we");
		Matcher m = p.matcher(str);
		int count = 0;
		while(m.find())
		{
			count++;
		}
		return count;
	}
	
	//Part 2
	public boolean endMatch(String str1, String str2) {
		boolean match = false;
		if(str1.toLowerCase().substring(str1.length()-1).equalsIgnoreCase(str2.toLowerCase().substring(str2.length()-1))) {
			match = true;
		}
		return match;
	}
	
	//Part 3
	public String giveEvenHalf(String target) {
		if (target.length()%2 == 0) {
			target = target.substring(0, target.length()/2);
		}
		return target;
	}
	
	//Part 4
	public String reverseString(String target) {
		String backWards = "";
		for(int i = target.length()-1;  i >= 0; i--) {
			backWards += target.substring(i, i+1);
		}
		return backWards;
	}

}
