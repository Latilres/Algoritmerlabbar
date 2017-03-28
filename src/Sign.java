// Author(s): Fressia Merino & Therese Tengdahl
// Email: espinosa@student.chalmers.se & theten@student.chalmers.se
// Date: 2017-03-24

import java.util.function.Function;

public class Sign implements Function<Double,Integer> {
    public Integer apply(Double x) {
        return x.compareTo(0.0d);
    }
}