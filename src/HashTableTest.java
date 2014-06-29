import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class HashTableTest {

	@Test
	public void testAddReturnsResult() {
		HashTableLLBase<String, String> testTable = new HashTableLLBase<String, String>();
		Boolean result = testTable.put("Fred", "penguin");
		assertFalse(result);
	}

	@Test
	public void testAddRetrieve() {
		HashTableLLBase<String, String> testTable = new HashTableLLBase<String, String>();
		Boolean result = testTable.put("Fred", "penguin");
		String value = testTable.get("Fred");
		assertEquals("penguin", value);
	}
	
	@Test
	public void testAddRetrieveWithDuplicateHash() {
		//we also want the two objects to be different to each other in this test
		//make a fake object that holds a string - hashcode is always 7 but use string values for equals
		MyTestString str1 = new MyTestString("Fred");
		MyTestString str2 = new MyTestString("Mark");
		HashTableLLBase<MyTestString, String> testTable = new HashTableLLBase<MyTestString, String>();
		testTable.put(str1, "penguin");
		Boolean result = testTable.put(str2, "eagle");
		String val1 = testTable.get(str1);
		String val2 = testTable.get(str2);
		assertFalse(result);
		assertEquals("penguin", val1);
		assertEquals("eagle", val2);
	}
	
	@Test
	public void testAddRetrieveWithDuplicateKey() {
		HashTableLLBase<String, String> testTable = new HashTableLLBase<String, String>();
		testTable.put("Fred", "penguin");
		Boolean result = testTable.put("Fred", "goat");
		String value = testTable.get("Fred");
		assertEquals("goat", value);
		assertTrue(result);
	}
	
	class MyTestString {
		String myString;
		
		MyTestString(String str) {
			myString = str;
		}
		
		@Override
		public int hashCode() {
			return 7;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof MyTestString) {
				return myString.equals(((MyTestString) obj).myString);
			} else {
			return false;
			}
		}
	}
}
