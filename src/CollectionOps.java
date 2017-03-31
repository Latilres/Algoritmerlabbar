// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-03-24

import java.util.*;
//package Collection;

import java.util.Collection;

public class CollectionOps {

    public CollectionOps(){}

    // Put your code for print here ...
    public static <T> void print(Collection<T> theCollection){
        System.out.print("[");
        Iterator<T> it = theCollection.iterator();
        while (it.hasNext()){
            System.out.print(it.next());
            if (it.hasNext())
                System.out.print(",");
        }
        System.out.print("]");
    }
    
    // Put your code for reverse here ...
    public static <T> List<T> reverse(List<T> reverseCollection){
        Collections.reverse(reverseCollection);
        return reverseCollection;
    }

    // Put your code for less here ...
    public static <T> boolean less(Collection<T> c1,
                                   Collection<T> c2,
                                   Comparator<T> comp){
 
    	// så här hade vi gjort --> int1comp.compare(int2);
    	// if ((Collections.max(c1)comp.compare(Collections.min(c2))))
        // så här ska det struktureras --> comp.compare(int1, int2);
        if (((comp.compare(Collections.max(c1, comp), Collections.min(c2, comp))) < 0)) {
            return true;
        }
        else
        	return false;
    }

    // Example
    public static <T,R> Collection<R>
    map(Function<T,R> f,Collection<T> c) 
    {
        // Determine the dynamic type of the collection
        Class<? extends Collection> cls = c.getClass();
        try {
            // Create an object of the same dynamic type as c
            Collection<R> result = (Collection<R>)cls.newInstance();
            // type.cast(type.newInstance());
            // Copy the elements and apply op to them
            for ( T x : c )
                result.add(f.apply(x));
            return result;   
        }   
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Put your code for filter here ...
    public static <T> Collection<T>
    filter(Predicate<T> p,Collection<T> c) 
    {
        // Determine the dynamic type of the collection
        Class<? extends Collection> cls = c.getClass();
        try {
            // Create an object of the same dynamic type as c
            Collection<T> result = (Collection<T>)cls.newInstance();
            // type.cast(type.newInstance());
            // Copy the elements and apply op to them
            for ( T x : c ) {
            	if((p.test(x))) {
            		result.add(x);
            	}
            }
            return result;   
        }   
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

}
