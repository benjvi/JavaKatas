import java.util.Iterator;
import java.util.LinkedList;


public class HashTableLLBase<T, V> {
	private static int ARRAY_SIZE = 10000;
	LinkedList<Tuple>[] arrayOfLists;
	
	private class Tuple {
		T key;
		V value;
		
		Tuple(T key,V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public HashTableLLBase() {
		//todo: this hash table can get full up!
		arrayOfLists = new LinkedList[ARRAY_SIZE];
		
	}
	
	public Boolean put(T key, V value) { 
		int pos = calcArrayPosition(key);
		LinkedList<Tuple> box = arrayOfLists[pos];
		//array objects are initialised to null
		if (box != null) {
			//iterate over the list testing for key equality
			Tuple currentEntry;
			Iterator<Tuple> boxItr = box.iterator();
			while (boxItr.hasNext()) {
				currentEntry = boxItr.next();
				if (currentEntry.key.equals(key)) {
					currentEntry.value = value;
					return true;
				}
			}
			// if key is not found, add it to the end of the list
			box.add(new Tuple(key, value));
		} else {
			//if box was not accessed before, need to initialise it now
			box = new LinkedList<Tuple>();
			box.add(new Tuple(key, value));
			arrayOfLists[pos] = box;
		}
		return false; 
	
	}
	
	public V get(T key) { 
		//returns value associated with the key 
		//if not present, return null
		LinkedList<Tuple> box = arrayOfLists[calcArrayPosition(key)];
		
		if (box != null) {
			Tuple currentEntry;
			//iterate over the list testing for key equality
			Iterator<Tuple> boxItr = box.iterator();
			while (boxItr.hasNext()) {
				currentEntry = boxItr.next();
				if (currentEntry.key.equals(key)) {
					return currentEntry.value;
				}
			}
			// if key is not found, return null
			return null;
		} else {
			//if box was not accessed before
			return null;
		}
	}
	
	private int calcArrayPosition(T key) {
		return key.hashCode() % ARRAY_SIZE;
	}
}
	

