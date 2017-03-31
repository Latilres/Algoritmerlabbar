// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-03-24

public class SingleBuffer {
//public static <T> List<T> reverse(List<T> reverseCollection){

    private String [] theBuffer;
    public SingleBuffer(){

    }

    public boolean put(String input){
        theBuffer = new String[input.length()];

        if (theBuffer[0] != null)
            return false;
        else {
            theBuffer[0] = input;
            return true;
        }
    }

    public String get(){
        String temp;
        if (theBuffer[0] == null)
            return null;
        else {
            temp = theBuffer[0];
            theBuffer[0] = null;
            return temp;
        }
    }
}
