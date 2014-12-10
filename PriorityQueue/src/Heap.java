import java.util.ArrayList;
import java.util.NoSuchElementException;
 
/**
 * @author Christian Moreano
 * 		   Roya Del Parastaran
 * 		   Eya Badal
 * 		   Daisy Medina
 */
public class Heap<T extends Comparable<T>> {
     
	// ArrayList of type "Integer" , for use of Comparable class
    private ArrayList<Integer> items;
     
    // Instantiate new ArrayList
    public Heap() {
        items = new ArrayList<Integer>();
    }
    
    // Method that moves element if parent > child
    private void ShiftUp() {
    	
        int k = items.size() - 1;
        while (k > 0) {//
            int p = (k-1)/2;
            Integer item = items.get(k);
            Integer parent = items.get(p);
            if (item.compareTo(parent) < 0) {//
                // swap
                items.set(k, parent);
                items.set(p, item);
                 
                // move up one level
                k = p;
            } else {
                break;
            }
        }
    }
     
    // Method that moves element if parent < child
    private void ShiftDown() {
        int k = 0;
        int l = 2*k+1;
        while (l < items.size()) {//
            int max=l, r=l+1;
            if (r > items.size()) { // there is a right child
                if (items.get(r).compareTo(items.get(l)) < 0) {
                    max++;
                }
            }
            if (items.get(k).compareTo(items.get(max)) > 0) {
                    // switch
                    Integer temp = items.get(k);
                    items.set(k, items.get(max));
                    items.set(max, temp);
                    k = max;
                    l = 2*k+1;
            } else {
                break;
            }
        }
    }

    // Insert Item to the end
    public void insert(Integer item) {
        items.add(item);
        ShiftUp();
    }
    
    // Delete Root from Heap
    public int deleteMin() 
    
    throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        Integer hold = items.get(0);
        // Set the root to the last element in tree , then shift down
        items.set(0, items.remove(items.size()-1));
        ShiftDown();
        return hold;
    }
    
    // Decrease Key @ Location 
    public void decreaseKey(int location , int change)
    {
    	items.set((location-1),((items.get(location-1))-change));
    	ShiftUp();
    }
 
    // Increase Key @ Location
    public void increaseKey(int location , int change)
    {
    	items.set((location-1),((items.get(location-1))+change));
    	ShiftDown();
    }
    
    // Search & Delete Element
    public void delete(int item )
    {
    	for(int i = 0 ; i < items.size() ; i++ )
    	{
    	   if(item == items.get(items.size()-1))
    	   {items.remove(item);}
    	   if(item == items.get(i))
    	   {
    		   items.set(i, items.remove(items.size()-1));
    		   ShiftDown();
    	   }
    	}
    }
    
    public int size() {
        return items.size();
    }
     
    public boolean isEmpty() {
        return items.isEmpty();
         
    }
     
    public String toString() {
        return items.toString();
    }
}