// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-04-01

import java.util.Comparator;

class IntegerComparator implements Comparator<Integer> {
    public int compare(Integer i1,Integer i2) {
        if (i1 < i2)
            return -1;
        else
            return 1;
    }
}

