package baseball;

import nextstep.utils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Computer {
    private Set<Integer> numbers = new HashSet<>();

    private Computer(){
    }

    public static Computer createAndInit() {
        Computer computer = new Computer();
        computer.createRandomNumbers();
        return computer;
    }

    private void createRandomNumbers() {
        while (numbers.size() < 3) {
            numbers.add(Randoms.pickNumberInRange(1, 9));
        }
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
