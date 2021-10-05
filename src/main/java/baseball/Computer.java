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

	public String createHint(String data) {
		String[] dataArray = data.split("");
		int numberOfBall = countNumberOfBall(dataArray);
		int numberOfStrike = countNumberOfStrike(dataArray);
		if (numberOfBall == 0 && numberOfStrike == 0) {
			return GameMessage.ANSWER_NOTHING;
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

	private String createHintBallAndStrike(int numberOfBall, int numberOfStrike) {
		if (numberOfStrike == 3) {
			return numberOfStrike + GameMessage.ANSWER_THREE_STRIKE;
		}
		if (numberOfStrike > 0 && numberOfBall == 0) {
			return numberOfStrike + GameMessage.ANSWER_STRIKE;
		}
		if (numberOfStrike == 0 && numberOfBall > 0) {
			return numberOfBall + GameMessage.ANSWER_BALL;
		}
		return numberOfStrike + GameMessage.ANSWER_STRIKE + " " + numberOfBall + GameMessage.ANSWER_BALL;
	}
}
