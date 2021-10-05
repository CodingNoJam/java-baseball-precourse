package baseball;

import nextstep.utils.Console;

public class Printer {
	public static String enterNumbers() {
		System.out.print("숫자를 입력해주세요 : ");
		return Console.readLine();
	}

	public static void printMessage(String message) {
		System.out.println(message);
	}
}
