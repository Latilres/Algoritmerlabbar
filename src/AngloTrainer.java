// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-03-24

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AngloTrainer {
    private TreeSet<String> ourDictionary = new TreeSet<>();
    private Scanner inFile;
    private int longestWord;
    private Random randomGenerator;
    private String randLetters;

    // Creates and starts the Anglo Trainer program.
    public AngloTrainer(String dictionaryFile) {

        randomGenerator = new Random();
        loadDictionary(dictionaryFile);
        System.out.println(ourDictionary.size() + " words loaded from " + dictionaryFile);
        randLetters = randomLetters(longestWord);
        System.out.println("The random letters are: " + randLetters);

        System.out.println("Try to build as many words from these letters as you can!");
        checkIfIncluded();
    }

    // Check if the suggested word is part of the word list and reacts accordingly.
    private void checkIfIncluded(){
        Scanner theInput = new Scanner(System.in);
        String testWord;
        try {
            while ( theInput.hasNextLine()) {
                testWord = theInput.nextLine();
                Boolean doExist = includes(sort(randLetters), sort(testWord));
                if (doExist) {
                    boolean inDictionary = ourDictionary.contains(testWord);
                    if (inDictionary) {
                        System.out.println("ok!");
                    } else {
                        System.out.println("Your suggestion was not found in the dictionary.");
                        break;
                    }
                } else {
                    System.out.println("Your suggestion was not a valid choice.");
                    break;
                }
            }
            dumpDict();
        } catch (Error e){
            dumpDict();
        }
    }

    // Prints out the words that fulfill the requirements.
    private void dumpDict() {
        System.out.println("I found:");
        for(String words : ourDictionary){
            Boolean doExist = includes(sort(randLetters), sort(words));
            if (doExist){
                System.out.println(words);
            }
        }
    }

    // Read the dictionary into a suitable container.
    private void loadDictionary( String fileName ) {
        String temp;
        try {
            inFile = new Scanner(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (inFile.hasNextLine()){
            temp = inFile.nextLine();
            ourDictionary.add(temp);
            if (longestWord < temp.length()) {
                longestWord = temp.length();
            }
        }
    }

    // Randomizes the letters that are allowed when guessing words.
    private String randomLetters( int length ) {
        // this makes vovels a little more likely
        String letters = "aabcdeefghiijklmnoopqrstuuvwxyyz";
        StringBuffer buf = new StringBuffer(length);
        for ( int i = 0; i < length; i++ )
            buf.append( letters.charAt(randomGenerator.nextInt(letters.length())));

        return buf.toString();
    }

    // Sorts the given string and returns it.
    private String sort(String inNeedOfSorting){
        char[] chars = inNeedOfSorting.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /* Def. includes
     * Let #(x,s) = the number of occurrences of the character x in the string s.
     * includes(a,b) holds iff for every character x in b, #(x,b) <= #(x,a)
     *
     * A necessary precondition for includes is that both strings are sorted
     * in ascending order.
     * @param a the randomized string from randomLetters
     * @param b the word we think can be created from the random letters
     */
    private boolean includes( String a, String b ) {
        if ( b == null || b.length() == 0 )
            return true;
        else if ( a == null || a.length() == 0 )
            return false;

        int i = 0, j = 0;
        while ( j < b.length() ) {
            if (i >= a.length() || b.charAt(j) < a.charAt(i))
                return false;
            else if (b.charAt(j) == a.charAt(i)) {
                i++; j++;
            } else if (b.charAt(j) > a.charAt(i))
                i++;
        }
        return true;
    }

    // This is just for demonstration purposes.
    private void testIncludes() {
        //                                            expected value
        System.out.println(includes("abc",""));		//t
        System.out.println(includes("","abc"));		//f
        System.out.println(includes("abc","abc"));	//t
        System.out.println(includes("abc","bcd"));	//f
        System.out.println(includes("abc","a"));	//t
        System.out.println(includes("abc","b"));	//t
        System.out.println(includes("abc","c"));	//t
        System.out.println(includes("abc","ab"));	//t
        System.out.println(includes("abc","bc"));	//t
        System.out.println(includes("abc","ac"));	//t
        System.out.println(includes("abc","abcd"));	//f
        System.out.println(includes("abc","abd"));	//f
        System.out.println(includes("abc","d"));	//f
        System.out.println(includes("",""));		//t
        System.out.println(includes("abc","ca"));	//f
        System.out.println(includes("abc","bac"));	//f
        System.out.println(includes("abc","abbc"));	//f
        System.out.println(includes("abbc","abc"));	//t
        System.out.println(includes(null,null));    //t
        System.out.println(includes(null,""));	    //t
        System.out.println(includes(null,"abc"));	//f
        System.out.println(includes("",null));		//t
        System.out.println(includes("abc",null));   //t
    }

    public static void main(String[] args) throws IOException {
        AngloTrainer anglo = new AngloTrainer("dictionary.txt");
    }
}












