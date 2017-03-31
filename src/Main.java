// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-03-24

import java.util.*;

//import collection.*;
//import static CollectionOps.CollectionOps.*; // Use static methods without the "Collection." prefix
//import static jdk.nashorn.internal.objects.Global.print;





public class Main  {
    public static void main(String[] args) {    
         ArrayList<String> names = new ArrayList<String>();

         // Test print for an empty list
         CollectionOps.print(names); System.out.println();

         // Test print for a list containing one element
         names.add("a");
         CollectionOps.print(names); System.out.println();

         // Test print for a list containing more than one elment
         names.add("b");
         names.add("c");
         CollectionOps.print(names); System.out.println();
         
         // Test the return value from reverse
         CollectionOps.print(CollectionOps.reverse(names));
         System.out.println();
         // Test that reverse mutates its argument
         CollectionOps.print(names);
         System.out.println();

         ///////////////////////////////////////////
         /////////////// extra tester //////////////
         ///////////////////////////////////////////
         ArrayList<Integer> numbers = new ArrayList<Integer>();

         // Test print for an empty list
         CollectionOps.print(numbers); System.out.println();

         // Test print for a list containing one element
         numbers.add(1);
         CollectionOps.print(numbers); System.out.println();

         // Test print for a list containing more than one elment
         numbers.add(2);
         numbers.add(5);
         CollectionOps.print(numbers); System.out.println();

         // Test the return value from reverse
         CollectionOps.print(CollectionOps.reverse(numbers));
         System.out.println();
         // Test that reverse mutates its argument
         CollectionOps.print(numbers);
         System.out.println();
         ///////////////////////////////////////////
         ///////////////////////////////////////////

         // Assignment 4: Write code to test less here
         IntegerComparator intcomp = new IntegerComparator();
         StringComparator stringcomp = new StringComparator();
         List<Integer> li1 = new ArrayList<>();
         li1.add(4);
         li1.add(2);
         li1.add(5);
         li1.add(1);
         li1.add(3);
         List<Integer> li2 = new ArrayList<>();
         li2.add(8);
         li2.add(6);
         li2.add(7);
         li2.add(9);
         List<Integer> li3 = new ArrayList<>();
         li3.add(97);
         li3.add(5);
         li3.add(123);
         li3.add(18);
         List<String> johanneberg = new ArrayList<>();
         johanneberg.add("HC2");
         johanneberg.add("ED");
         johanneberg.add("HC3");
         List<String> lindholmen = new ArrayList<>();
         lindholmen.add("Saga");
         lindholmen.add("Svea");
         lindholmen.add("Jupiter");
         System.out.println(CollectionOps.less(li1,li2,intcomp));
         System.out.println(CollectionOps.less(li1,li3,intcomp));
         System.out.println(CollectionOps.less(johanneberg,lindholmen,stringcomp));
         System.out.println(CollectionOps.less(lindholmen, johanneberg,stringcomp));

         // Assignment 5: Write code to test map here
        List<Double> l1 = new ArrayList<Double>(); 
         // lägg in talen 23.4, -19.0, 377.62, 0.0, 18.9, -32.12 i listan
         l1.add(23.4);
         l1.add(-19.0);
         l1.add(377.62);
         l1.add(0.0);
         l1.add(18.9);
         l1.add(-32.12);
         List<Integer>l2 = (List<Integer>)map(new Sign(), l1);
         print(l2);				//[1,-1,1,0,1,-1]
        
         // Assignment 5: Write code to test filter here
        List<Integer> l3 = new ArrayList<Integer>();
         l3.add(3);
         l3.add(-42);
         l3.add(88);
         l3.add(13);
         l3.add(-37);
         l3.add(0);
         l3.add(18);
         List<Integer>l4 = (List<Integer>)filter(new IsEven(), l3);
         print(l4);           //[-42,88,0,18]

         /*
         ArrayList<Person> pl = new ArrayList<>();
         pl.add(new Person("Nisse","nisse@hipnet.moc","male",23));
         pl.add(new Person("Lisa","lisa@shipnet.sea","female",67));
         pl.add(new Person("Ada","ada@jahuu.vanu","female",49));
         pl.add(new Person("Kal","karl@gotnet.vg","male",78));
         pl.add(new Person("Beda","beda@fishnet.cod","female",102));
         */
        
         // Assignment 6: Write code using lambdas here
    }
}














