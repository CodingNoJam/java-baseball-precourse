package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	@Test
	void 플레이어_입력값_응답_정답처리_테스트() {
		for (int number : computer.getNumbers()) {
			stringBuilder.append(String.valueOf(number));
		}
		String answer = computer.createHint(stringBuilder.toString());
		assertThat(answer).isEqualTo("3스트라이크 \n3개의 숫자를 모두 맞히셨습니다! 게임 끝");
	}

	@Test
	void 플레이어_입력값_응답_낫싱_테스트() {
		for (int number : computer.getNumbers()) {
			checkSet.remove(number);
		}
		for (Integer number : checkSet) {
			stringBuilder.append(number);
		}
		String answer = computer.createHint(stringBuilder.substring(0, 3));
		assertThat(answer).isEqualTo("낫싱");
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
		String answer = computer.createHint(stringBuilder.substring(0, 3));
		assertThat(answer).isEqualTo("1스트라이크");
	}

	@Test
	void 플레이어_입력값_응답_볼_테스트() {
		List<Integer> testList = computer.getNumbers();
		stringBuilder.append(testList.get(1));
		stringBuilder.append(testList.get(2));
		stringBuilder.append(testList.get(0));

		String answer = computer.createHint(stringBuilder.toString());
		assertThat(answer).isEqualTo("3볼");
	}

	@Test
	void 플레이어_입력값_응답_볼_스트라이크_테스트() {
		List<Integer> testList = computer.getNumbers();
		stringBuilder.append(testList.get(0));
		stringBuilder.append(testList.get(2));
		stringBuilder.append(testList.get(1));

		String answer = computer.createHint(stringBuilder.toString());
		assertThat(answer).isEqualTo("1스트라이크 2볼");
	}
}