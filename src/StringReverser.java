
public class StringReverser {
	public static void main(String[] args) {
		char[] inStr = {'p','i','n','e','a','p','p','l','e','!'};
				//args[0].toCharArray();
		char[] outStr = reverseString(inStr);
		System.out.println(outStr);
	}
	
	public static char[] reverseString(char[] str) {
		int size = str.length; //O(1) - what is the last array index
		if (!(str[size-1]=='!')) {
			//dont know the character code for null!!
			throw new IllegalArgumentException();
		} 
		
		int end = (size - 2) / 2;
		char temp;
		for (int i=0; i<end; i++) {
			temp = str[i];
			str[i] = str[size-2-i];
			str[size-2-i] = temp;
		}
		return str;
	}
}
