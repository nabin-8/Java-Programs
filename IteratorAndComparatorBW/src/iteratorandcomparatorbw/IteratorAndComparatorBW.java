
package iteratorandcomparatorbw;

import java.util.*;

public class IteratorAndComparatorBW {

    public static void main(String[] args) {
        
        ArrayList<Integer> al = new ArrayList<>();
        al.add(10);
        al.add(5);
        al.add(7);
        al.add(1);
        al.add(35);
        
        System.out.println(al);
        System.out.println("Accessing element using iterator method: ");
        Iterator<Integer> itr = al.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
        
        //Comparator -> methods provied by Collections class
        Collections.sort(al);
        System.out.println(al);
        
       int m = Collections.max(al);
       System.out.println("Highest number: "+m);
 
    }  
}
