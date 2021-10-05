package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

	public String[] createAnswer(String data) {
		if (!verifyDataLengthAndDataType(data)) {
			return new String[] {"3", "[ERROR] 3자리 숫자만 입력가능하며, 숫자는 1~9사이의 값이여야 합니다."};
		}
		if (!verifyDuplicateData(data)) {
			return new String[] {"3", "[ERROR] 중복된 숫자는 입력할 수 없습니다."};
		}
		return checkNumber(data);
	}

	private boolean verifyDataLengthAndDataType(String data) {
		if (data.matches("^[1-9]{3}$")) {
			return true;
		}
		return false;
	}

	private boolean verifyDuplicateData(String data) {
		Set<Character> duplicateCheckSet = new HashSet<>();
		for (int i = 0; i < data.length(); i++) {
			duplicateCheckSet.add(data.charAt(i));
		}
		if (duplicateCheckSet.size() == 3) {
			return true;
		}
		return false;
	}

	private String[] checkNumber(String data) {

		return new String[] {};
	}
}
