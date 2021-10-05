package baseball;

import nextstep.utils.Console;

public class Printer {
	public static String enterNumbers() {
		System.out.print(GameMessage.ENTER_NUMBERS);
		return Console.readLine();
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static String enterRestartOrEnd() {
		System.out.println(GameMessage.ENTER_RESTART_OR_END);
		return Console.readLine();
	}
}
