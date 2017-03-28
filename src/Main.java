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
         CollectionOps.less(li1,li2,intcomp);
         CollectionOps.less(li1,li3,intcomp);
         CollectionOps.less(johanneberg,lindholmen,stringcomp);

         // Assignment 5: Write code to test map here
             
         // Assignment 5: Write code to test filter here

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














