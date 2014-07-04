

import java.util.LinkedList;

public class TowersOfHanoi {
	LinkedList<Integer> s1;
	LinkedList<Integer> s2;
	LinkedList<Integer> s3;
	Integer size;
	
	public static void main(String[] args) {
		TowersOfHanoi test = new TowersOfHanoi(5);
		test.moveTower(5, test.s1, test.s2, test.s3);
		System.out.println(test.s3.toString());
	}
	
	TowersOfHanoi(Integer n) {
		//values are ints
		s1 = new LinkedList<Integer>();
		for (int i=n; i>0; i--) {
			s1.push(i);
		}
		s2 = new LinkedList<Integer>();
		s3 = new LinkedList<Integer>();
		size = n;
	}
	
	void moveTower(Integer size, LinkedList<Integer> source, LinkedList<Integer> inter, LinkedList<Integer> dest) {
		if (size>1) moveTower(size-1, source, inter, dest);
		Integer value = source.pop();
		inter.push(value);
		if (size>1) moveTower(size-1, dest, inter, source);
		value = inter.pop();
		dest.push(value);
		if (size>1) moveTower(size-1, source, inter, dest);
	}

}
