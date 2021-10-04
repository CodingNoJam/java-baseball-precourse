package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Computer {
	private List<Integer> numbers = new ArrayList<>();

	private Computer() {
	}

	public static Computer createAndInit() {
		Computer computer = new Computer();
		computer.createRandomNumbers();
		return computer;
	}

	private void createRandomNumbers() {
		while (numbers.size() < 3) {
			addNumber();
		}
	}

	private void addNumber() {
		int number = Randoms.pickNumberInRange(1, 9);
		if (numbers.contains(number)) {
			return;
		}
		numbers.add(number);
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
