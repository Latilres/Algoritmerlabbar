// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-04-01

import static collection.CollectionOps.*;
import java.util.*;

public class Main  {
    public static void main(String[] args) {
        System.out.println("------------ Uppgift 2 ------------");
         ArrayList<String> names = new ArrayList<String>();

         // Test print for an empty list
         print(names); System.out.println();

         // Test print for a list containing one element
         names.add("a");
         print(names); System.out.println();

         // Test print for a list containing more than one element
         names.add("b");
         names.add("c");
         print(names); System.out.println();

        System.out.println("------------ Uppgift 3 ------------");
         // Test the return value from reverse
         print(reverse(names));
         System.out.println();
         // Test that reverse mutates its argument
         print(names);
         System.out.println();

         ///////////////////////////////////////////
         /////////////// extra tester //////////////
         ///////////////////////////////////////////
         ArrayList<Integer> numbers = new ArrayList<Integer>();
         // Test print for an empty list
         print(numbers); System.out.println();
         // Test print for a list containing one element
         numbers.add(1);
         print(numbers); System.out.println();
         // Test print for a list containing more than one elment
         numbers.add(2);
         numbers.add(5);
         print(numbers); System.out.println();
         // Test the return value from reverse
         print(reverse(numbers));
         System.out.println();
         // Test that reverse mutates its argument
         print(numbers);
         System.out.println();
         ///////////////////////////////////////////
         ///////////////////////////////////////////

        System.out.println("------------ Uppgift 4 ------------");
         // Assignment 4: Write code to test less here
         IntegerComparator intcomp = new IntegerComparator();
         StringComparator stringcomp = new StringComparator();
         List<Integer> li1 = new ArrayList<>();
         li1.addAll(Arrays.asList(4,2,5,1,3));
         List<Integer> li2 = new ArrayList<>();
         li2.addAll(Arrays.asList(8,6,7,9));
         List<Integer> li3 = new ArrayList<>();
         li3.addAll(Arrays.asList(97,5,123,18));
         List<String> johanneberg = new ArrayList<>();
         johanneberg.add("HC2");
         johanneberg.add("ED");
         johanneberg.add("HC3");
         List<String> lindholmen = new ArrayList<>();
         lindholmen.add("Saga");
         lindholmen.add("Svea");
         lindholmen.add("Jupiter");
         System.out.println(less(li1,li2,intcomp));
         System.out.println(less(li1,li3,intcomp));
         System.out.println(less(johanneberg,lindholmen,stringcomp));
         System.out.println(less(lindholmen, johanneberg,stringcomp));

        System.out.println("------------ Uppgift 5 ------------");
         // Assignment 5: Write code to test map here
        List<Double> l1 = new ArrayList<Double>(); 
         // lägg in talen 23.4, -19.0, 377.62, 0.0, 18.9, -32.12 i listan
        l1.addAll(Arrays.asList(23.4,-19.0,377.62,0.0,18.9,-32.12));
         List<Integer>l2 = (List<Integer>)map(new Sign(), l1);
         print(l2);				//[1,-1,1,0,1,-1]
        System.out.println();
        
         // Assignment 5: Write code to test filter here
        List<Integer> l3 = new ArrayList<Integer>();
        l3.addAll(Arrays.asList(3,-42,88,13,-37,0,18));
         List<Integer>l4 = (List<Integer>)filter(new IsEven(), l3);
        print(l4);           //[-42,88,0,18]
        System.out.println();


        System.out.println("------------ Uppgift 6 ------------");
         ArrayList<Person> pl = new ArrayList<>();
         pl.add(new Person("Nisse","nisse@hipnet.moc","male",23));
         pl.add(new Person("Lisa","lisa@shipnet.sea","female",67));
         pl.add(new Person("Ada","ada@jahuu.vanu","female",49));
         pl.add(new Person("Kal","karl@gotnet.vg","male",78));
         pl.add(new Person("Beda","beda@fishnet.cod","female",102));

         // Assignment 6: Write code using lambdas here
        ArrayList<String> oldPersonMail = new ArrayList<>();
        map((Person p) -> {
            if (p.getAge() > 65 && p.getGender() == "female")
                oldPersonMail.add(p.getEmail());
            return null;
        }, pl);
        System.out.println(oldPersonMail);

    }
}














