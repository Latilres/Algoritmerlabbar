// Author(s):
// Version:
// Date:

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;
import java.util.TreeMap;

public class WordLists {
    private Reader in = null;
    private TreeMap<String, Integer> allTheWords = new TreeMap<>();

    public WordLists(String inputFileName) {

        String temp;
        try {
            in = new FileReader(inputFileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                if ((temp = getWord())!= null)
                    allTheWords.put(temp, 1);
                else
                    break;
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private boolean isPunctuationChar(char c) {
        final String punctChars = ",.:;?!";
        return punctChars.indexOf(c) != -1;
    }

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

    private String reverse(String s) {
        // define!
        return "hej";
    }

    private void computeWordFrequencies() {
        // define!
    }


    private void computeFrequencyMap() {
        // define!
    }


    private void computeBackwardsOrder() {
        // define!
    }

    public static void main(String[] args) throws IOException {
        // todo:sätt tillbaka args[0] i new wordlists
        WordLists wl = new WordLists("provtext.txt");  // arg[0] contains the input file name
        wl.computeWordFrequencies();
        wl.computeFrequencyMap();
        wl.computeBackwardsOrder();

        System.out.println("Finished!");
    }
}



















