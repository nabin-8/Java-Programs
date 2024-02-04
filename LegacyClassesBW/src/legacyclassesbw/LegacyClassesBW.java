package legacyclassesbw;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;

class LegacyClasses
{
    public static void VectorDemo()
    {
        //Vector vec = new Vector();  //Object
        Vector<String> vec = new Vector<String>();  //String
        vec.add("12");
        vec.add("Danfe ");
        vec.add("College ");
        
        System.out.println(vec); 
        System.out.println("Display using for loop: ");
        for(int i=0; i<vec.size();i++) {
            System.out.println(vec.get(i));
        }
        
        System.out.println("Display using foreach loop: ");
        for(Object obj : vec)
        {
            System.out.println(obj);
        }
        
        System.out.println("Display using foreach method: ");
        vec.forEach(System.out::println);
        
        System.out.println("Display using Enumeration: ");
        
        Enumeration data = vec.elements();
        while(data.hasMoreElements())
        {
            System.out.println(data.nextElement());
        }
        
        //isEmpty or not
        System.out.println("Is vector empty or not? "+vec.isEmpty());
        
        //checking index of Danfe
        System.out.println("Index of Danfe is: "+vec.indexOf("Danfe"));
        
        //checking size of Vector
        System.out.println("Size of vec is "+vec.size());
        System.out.println("Removing element at index 1: "+vec.remove(1));
        System.out.println(vec);
        vec.clear();
        System.out.println("Display afte clearing vector: ");
        System.out.println(vec);
        
        System.out.println("Is vector empty or not? "+vec.isEmpty());
        
        
    }
    
    static void StackDemo()
    {
        Stack<String> st = new Stack<String>();
        st.push("12");
        st.push("Danfe ");
        st.push("College ");
        
        System.out.println(st);
        st.pop();
        System.out.println("Elements after pop: "+st);  
    }
    
    static void HashTableDemo()
    {
        Hashtable hs = new Hashtable();
        hs.put(100, "Ram");
        hs.put(200, "Sita");
        hs.put(300, "Gita");
        
        System.out.println(hs);
        System.out.println("Size of hastable hs: "+hs.size());
        System.out.println("Getting element of key 200: "+hs.get(200));
        System.out.println("Removing element having key 100: "+hs.remove(100));
        
        System.out.println(hs);
        
        System.out.println("Displaying values using keySet method: ");
        for(Object i : hs.keySet())
        {
            System.out.println(hs.get(i));
        }
    }
    
    static void DictionaryDemo()
    {
        Dictionary<Integer, String> hs = new Hashtable();
        hs.put(100, "Ram");
        hs.put(200, "Sita");
        hs.put(300, "Gita");
        
        System.out.println(hs);
        System.out.println("Size of hastable hs: "+hs.size());
        System.out.println("Getting element of key 200: "+hs.get(200));
        System.out.println("Removing element having key 100: "+hs.remove(100));
        
        System.out.println(hs);
        
        
    }
}


public class LegacyClassesBW {

    public static void main(String[] args) {
        //LegacyClasses.VectorDemo();
        //LegacyClasses.StackDemo();
        LegacyClasses.HashTableDemo();
        //LegacyClasses.DictionaryDemo();
    } 
}
