// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-03-25

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class WordLists {
    private Reader in = null;
    private TreeMap<String, Integer> allTheWords = new TreeMap<>();
    private TreeMap<String, String> allTheWordsReverse = new TreeMap<>();
    private int highestValue;

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
                    } else
                        allTheWords.put(temp, 1);
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
        String value;
        int longestKey = 0;
        for (Map.Entry<String, Integer> entry : allTheWords.entrySet()) {
            allTheWordsReverse.put(reverse(entry.getKey()), entry.getKey());
            if (longestKey < entry.getKey().length())
                longestKey = entry.getKey().length();
            if (highestValue < entry.getValue())
                highestValue = entry.getValue();
        }
        try{
            PrintWriter out = new PrintWriter(new FileWriter("backwardsSorted.txt"));
            for (Map.Entry<String, String> entry : allTheWordsReverse.entrySet()) {
                value = entry.getValue();
                if (longestKey < 10)
                    out.println( String.format("%10s", value));
                else if (longestKey < 20)
                    out.println( String.format("%20s", value));
                else if (longestKey < 30)
                    out.println( String.format("%30s", value));
                else
                    out.println( String.format("%40s", value));
            }
            out.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        WordLists wl = new WordLists(args[0]);  // arg[0] contains the input file name
        wl.computeBackwardsOrder();
        wl.computeFrequencyMap();
        wl.computeWordFrequencies();

        System.out.println("Finished!");
    }
}



















