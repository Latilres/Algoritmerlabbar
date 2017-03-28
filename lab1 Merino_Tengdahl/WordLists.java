// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-03-25

import java.io.*;
import java.util.*;

public class WordLists {
    private Reader in = null;
    private TreeMap<String, Integer> allTheWords = new TreeMap<>();
    private List<String> reverseList = new ArrayList<>();
    private int highestValue;
    int longestKey;

    // Creates a word list of all the words in a given text.
    public WordLists(String inputFileName) {
        int i;
        String temp;
        try {
            in = new FileReader(inputFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                if ((temp = getWord())!= null) {
                    if (allTheWords.containsKey(temp)) {
                        i = allTheWords.get(temp);
                        allTheWords.put(temp, ++i);
                        if (highestValue < i)
                            highestValue = i;
                        if (longestKey < temp.length())
                            longestKey = temp.length();
                    } else {
                        allTheWords.put(temp, 1);
                        reverseList.add(temp);
                    }
                } else
                    break;
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    // Checks if the given char is among the punctChars.
    private boolean isPunctuationChar(char c) {
        final String punctChars = ",.:;?!";
        return punctChars.indexOf(c) != -1;
    }

    // Goes through a text and retrieves all the words it finds.
    private String getWord() throws IOException {
        int state = 0;
        int i;
        String word = "";
        while ( true ) {
            i = in.read();
            char c = (char)i;
            switch ( state ) {
                case 0:
                    if ( i == -1 )
                        return null;
                    if ( Character.isLetter( c ) ) {
                        word += Character.toLowerCase( c );
                        state = 1;
                    }
                    break;
                case 1:
                    if ( i == -1 || isPunctuationChar( c ) || Character.isWhitespace( c ) )
                        return word;
                    else if ( Character.isLetter( c ) )
                        word += Character.toLowerCase( c );
                    else {
                        word = "";
                        state = 0;
                    }
            }
        }
    }

    // Reverses the string it gets and returns it.
    private String reverse(String s) {
        return (new StringBuilder(s).reverse().toString());
    }

    // Creates a list of all words organized according to frequency.
    private void computeWordFrequencies() {
        String key;
        try{
            PrintWriter out = new PrintWriter(new FileWriter("frequencySorted.txt"));
            for (int i = highestValue; i > 0; i--) {
                int doExist = 0;
                out.println("     " + i + ":");
                for (Map.Entry<String, Integer> entry : allTheWords.entrySet()) {
                    key = entry.getKey();
                    if (entry.getValue() == i) {
                        out.println("        " + key);
                        doExist++;
                    }
                }
                if (doExist == 0)
                    out.println("        n/a");
            }
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // Creates an alphabetical word list of the words in the file.
    private void computeFrequencyMap() {

        String key;
        Integer value;
        try{
            PrintWriter out = new PrintWriter(new FileWriter("alfaSorted.txt"));
            for (Map.Entry<String, Integer> entry : allTheWords.entrySet()) {
                key = entry.getKey();
                value = entry.getValue();
                out.println(key + "    " + value);
            }
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    // Creates an reversed alphabetical word list of the words in the file.
    private void computeBackwardsOrder() {
        Collections.sort(reverseList, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return reverse(o1).compareTo(reverse(o2));
            }
        });

        try{
            PrintWriter out = new PrintWriter(new FileWriter("backwardsSorted.txt"));
            for (String word : reverseList) {
                // Because it looks better this way
                if (longestKey < 10)
                    out.println( String.format("%10s", word));
                else if (longestKey < 20)
                    out.println( String.format("%20s", word));
                else if (longestKey < 30)
                    out.println( String.format("%30s", word));
                else
                    out.println( String.format("%40s", word));
            }
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //WordLists wl = new WordLists(args[0]);  // arg[0] contains the input file name
        WordLists wl = new WordLists("woodchuck.txt");
        wl.computeFrequencyMap();
        wl.computeWordFrequencies();
        wl.computeBackwardsOrder();

        System.out.println("Finished!");
    }
}



















