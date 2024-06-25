package calc.operation;

import java.util.List;

public abstract class Additioner {

    public static Integer compute(List<Integer> numbers) {
        Integer result = 0;
        for(Integer number:numbers) {
            result += number;
        }
        return result;
    }


}
