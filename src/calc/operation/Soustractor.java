package calc.operation;

import java.util.List;

public abstract class Soustractor {

    public static Integer compute(List<Integer> numbers) {
        Integer result = null;
        for(Integer number:numbers) {
            if(result == null) {
                result = number;
            } else {
                result -= number;
            }
        }
        return result;
    }
}
