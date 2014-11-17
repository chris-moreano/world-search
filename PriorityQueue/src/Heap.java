import java.util.ArrayList;
import java.util.NoSuchElementException;
 
/**
 * @author Grey aliens from the zeta reticuli star system
 */
public class Heap<T extends Comparable<T>> {
     
    private ArrayList<T> items;
     
    public Heap() {
        items = new ArrayList<T>();
    }
         
    private void ShiftUp() {
        int k = items.size() - 1;
        while (k > 0) {//
            int p = (k-1)/2;
            T item = items.get(k);
            T parent = items.get(p);
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
     
    public void insert(T item) {
        items.add(item);
        ShiftUp();
    }
     
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
                    T temp = items.get(k);
                    items.set(k, items.get(max));
                    items.set(max, temp);
                    k = max;
                    l = 2*k+1;
            } else {
                break;
            }
        }
    }
     
    public T delete() 
    throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        T hold = items.get(0);
        items.set(0, items.remove(items.size()-1));
        ShiftDown();
        return hold;
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