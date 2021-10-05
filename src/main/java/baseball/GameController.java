package baseball;

import java.util.HashSet;
import java.util.Set;

public class GameController {
	private final Computer computer;
	private static final String GAME_RESTART = "1";
	private static final String GAME_END = "2";

	public GameController() {
		this.computer = Computer.createAndInit();
	}

	public void run() {
		boolean running = true;
		while (running) {
			String data = Printer.enterNumbers();
			String answer = createAnswer(data);
			Printer.printMessage(answer);
			running = !answer.endsWith(GameMessage.ANSWER_END);
		}
	}

	private String createAnswer(String data) {
		if (!verifyDataLengthAndDataType(data)) {
			return GameMessage.ERROR_DATA_LENGTH_DATA_TYPE;
		}
		if (!verifyDuplicateData(data)) {
			return GameMessage.ERROR_DUPLICATE_DATA;
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
		if (data.equals(GAME_RESTART)) {
			return true;
		}
		return false;
	}

	private boolean verifyDataWrongValue(String data) {
		if (data.equals(GAME_RESTART) || data.equals(GAME_END)) {
			return false;
		}
		Printer.printMessage(GameMessage.ERROR_RESTART_OR_END_DATA_WRONG_VALUE);
		return true;
	}
}
