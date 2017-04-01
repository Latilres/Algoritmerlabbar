// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-04-01

public class SingleBuffer<T> {

    private T theBuffer = null;

    public boolean put(T input){
        if (theBuffer != null)
            return false;
        else {
            theBuffer = input;
            return true;
        }
    }

    public T get(){
        T temp;
        if (theBuffer == null)
            return null;
        else {
            temp = theBuffer;
            theBuffer = null;
            return temp;
        }
    }
}
