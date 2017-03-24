// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-03-25

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.TreeMap;

public class WordLists {
    private Reader in = null;
    private TreeMap<String, Integer> allTheWords = new TreeMap<>();

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
        //System.out.println(allTheWords);
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
        // todo: ta s och skicka tillbaka den med alla bokstäver omsorterat till baklänges
        return "hej";
    }

    private void computeWordFrequencies() {
        // define! todo: vi tror att den här är frekvensordlista
        // kolla om filen finns
        // skapa/öppna filen
    }


    private void computeFrequencyMap() {
        // define! todo: jag och min kille tror att den här ska vara i bokstavsordning
        // kolla om filen finns
        // skapa/öppna filen
        // skriv i den (skriv över om det finns text i den, tror jag)
    }


    private void computeBackwardsOrder() {
        // todo
        // kolla om filen finns
        // skapa/öppna filen
        // släng in varje ord i reverse-metoden
        // lägg in returen som key i en ny TreeMap med orginalordet som value
        // skriv ut value i filen, i den ordning som key kommer. och med högermarginal?
    }

    public static void main(String[] args) throws IOException {
        // todo:sätt tillbaka args[0] i new wordlists
        WordLists wl = new WordLists("woodchuck.txt");  // arg[0] contains the input file name
        wl.computeWordFrequencies();
        wl.computeFrequencyMap();
        wl.computeBackwardsOrder();

        System.out.println("Finished!");
    }
}



















