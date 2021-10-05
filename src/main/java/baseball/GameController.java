package baseball;

import java.util.HashSet;
import java.util.Set;

public class GameController {
	private final Computer computer;

	public GameController() {
		this.computer = Computer.createAndInit();
	}

	public void run() {
		boolean running = true;
		while (running) {
			String data = Printer.enterNumbers();
			String answer = createAnswer(data);
			Printer.printMessage(answer);
			running = !answer.endsWith("끝");
		}
	}

	private String createAnswer(String data) {
		if (!verifyDataLengthAndDataType(data)) {
			return "[ERROR] 3자리 숫자만 입력가능하며, 숫자는 1~9사이의 값이여야 합니다.";
		}
		if (!verifyDuplicateData(data)) {
			return "[ERROR] 중복된 숫자는 입력할 수 없습니다.";
		}
		return computer.createHint(data);
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

	public boolean restartOrEnd() {
		boolean reQuestions = true;
		String data = "";
		while (reQuestions) {
			data = Printer.enterRestartOrEnd();
			reQuestions = verifyDataWrongValue(data);
		}
		if (data.equals("1")) {
			return true;
		}
		return false;
	}

	private boolean verifyDataWrongValue(String data) {
		if (data.equals("1") || data.equals("2")) {
			return false;
		}
		Printer.printMessage("[ERROR] 1 또는 2만 입력 가능합니다.");
		return true;
	}
}
