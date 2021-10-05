package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ComputerTest {
	private Computer computer;
	private StringBuilder stringBuilder;
	private Set<Integer> checkSet;

	@BeforeEach
	void beforeEach() {
		computer = Computer.createAndInit();
		stringBuilder = new StringBuilder();
		checkSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
	}

	@Test
	void 컴퓨터객체_생성_테스트() {
		assertThat(computer).isNotNull();
	}

	@Test
	void 랜덤숫자_자릿수_테스트() {
		List<Integer> numbers = computer.getNumbers();
		assertThat(numbers).hasSize(3);
	}

	@Test
	void 랜덤숫자_범위_테스트() {
		List<Integer> numbers = computer.getNumbers();
		for (Integer number : numbers) {
			assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
		}
	}

	@Test
	void 랜덤숫자_중복여부_테스트() {
		List<Integer> numbers = computer.getNumbers();
		for (Integer number : numbers) {
			checkSet.remove(number);
		}
		assertThat(numbers.size()).isEqualTo(9 - checkSet.size());
	}

	@ParameterizedTest
	@ValueSource(strings = {"1234", "우아한테크코스", "1", "39", "car", "000"})
	void 플레이어_입력값_길이_타입_검증_테스트(String input) {
		String[] answer = computer.createAnswer(input);
		assertThat(answer[0]).isEqualTo("30");
		assertThat(answer[1]).isEqualTo("[ERROR] 3자리 숫자만 입력가능하며, 숫자는 1~9사이의 값이여야 합니다.");
	}

	@ParameterizedTest
	@ValueSource(strings = {"999", "121", "939", "422", "882", "111"})
	void 플레이어_입력값_중복_검증_테스트(String input) {
		String[] answer = computer.createAnswer(input);
		assertThat(answer[0]).isEqualTo("31");
		assertThat(answer[1]).isEqualTo("[ERROR] 중복된 숫자는 입력할 수 없습니다.");
	}

	@Test
	void 플레이어_입력값_응답_정답처리_테스트() {
		for (int number : computer.getNumbers()) {
			stringBuilder.append(String.valueOf(number));
		}
		String[] answer = computer.createAnswer(stringBuilder.toString());
		assertThat(answer[0]).isEqualTo("50");
		assertThat(answer[1]).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	@Test
	void 플레이어_입력값_응답_낫싱_테스트() {
		for (int number : computer.getNumbers()) {
			checkSet.remove(number);
		}
		for (Integer number : checkSet) {
			stringBuilder.append(number);
		}
		String[] answer = computer.createAnswer(stringBuilder.substring(0, 3));
		assertThat(answer[0]).isEqualTo("40");
		assertThat(answer[1]).isEqualTo("낫싱");
	}

	@Test
	void 플레이어_입력값_응답_스트라이크_테스트() {
		for (int number : computer.getNumbers()) {
			checkSet.remove(number);
		}
		stringBuilder.append(computer.getNumbers().get(0));
		for (Integer number : checkSet) {
			stringBuilder.append(number);
		}
		String[] answer = computer.createAnswer(stringBuilder.substring(0,3));
		assertThat(answer[0]).isEqualTo("41");
		assertThat(answer[1]).isEqualTo("1스트라이크");
	}

	@Test
	void 플레이어_입력값_응답_볼_테스트() {
		List<Integer> testList = computer.getNumbers();
		stringBuilder.append(testList.get(1));
		stringBuilder.append(testList.get(2));
		stringBuilder.append(testList.get(0));

		String[] answer = computer.createAnswer(stringBuilder.toString());
		assertThat(answer[0]).isEqualTo("42");
		assertThat(answer[1]).isEqualTo("3볼");
	}

	@Test
	void 플레이어_입력값_응답_볼_스트라이크_테스트() {
		List<Integer> testList = computer.getNumbers();
		stringBuilder.append(testList.get(0));
		stringBuilder.append(testList.get(2));
		stringBuilder.append(testList.get(1));

		String[] answer = computer.createAnswer(stringBuilder.toString());
		assertThat(answer[0]).isEqualTo("43");
		assertThat(answer[1]).isEqualTo("1스트라이크 2볼");
	}
}