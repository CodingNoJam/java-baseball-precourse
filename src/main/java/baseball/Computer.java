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
			return new String[] {"30", "[ERROR] 3자리 숫자만 입력가능하며, 숫자는 1~9사이의 값이여야 합니다."};
		}
		if (!verifyDuplicateData(data)) {
			return new String[] {"31", "[ERROR] 중복된 숫자는 입력할 수 없습니다."};
		}
		return createHint(data);
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

	private String[] createHint(String data) {
		String[] dataArray = data.split("");
		int numberOfBall = countNumberOfBall(dataArray);
		int numberOfStrike = countNumberOfStrike(dataArray);
		if (numberOfBall == 0 && numberOfStrike == 0) {
			return new String[] {"40", "낫싱"};
		}
		return createHintBallAndStrike(numberOfBall, numberOfStrike);
	}

	private int countNumberOfBall(String[] dataArray) {
		int numberOfBall = 0;
		for (int i = 0; i < dataArray.length; i++) {
			numberOfBall += checkBall(dataArray[i], i);
		}
		return numberOfBall;
	}

	private int checkBall(String stringNumber, int index) {
		int intNumber = Integer.parseInt(stringNumber);
		if (numbers.contains(intNumber) && numbers.get(index) != intNumber) {
			return 1;
		}
		return 0;
	}

	private int countNumberOfStrike(String[] dataArray) {
		int numberOfStrike = 0;
		for (int i = 0; i < dataArray.length; i++) {
			numberOfStrike += checkStrike(dataArray[i], i);
		}
		return numberOfStrike;
	}

	private int checkStrike(String stringNumber, int index) {
		if (numbers.get(index) == Integer.parseInt(stringNumber)) {
			return 1;
		}
		return 0;
	}

	private String[] createHintBallAndStrike(int numberOfBall, int numberOfStrike) {
		if (numberOfStrike == 3) {
			return new String[] {"50", numberOfStrike + "스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 끝"};
		}
		if (numberOfStrike > 0 && numberOfBall == 0) {
			return new String[] {"41", numberOfStrike + "스트라이크"};
		}
		if (numberOfStrike == 0 && numberOfBall > 0) {
			return new String[] {"42", numberOfBall + "볼"};
		}
		return new String[] {"43", numberOfStrike + "스트라이크 " + numberOfBall + "볼"};
	}

}
