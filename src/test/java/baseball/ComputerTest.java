package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class ComputerTest {

	@Test
	void 컴퓨터객체_생성_테스트() {
		Computer computer = Computer.createAndInit();
		assertThat(computer).isNotNull();
	}

	@Test
	void 랜덤숫자_자릿수_테스트() {
		Computer computer = Computer.createAndInit();
		List<Integer> numbers = computer.getNumbers();
		assertThat(numbers).hasSize(3);
	}

	@Test
	void 랜덤숫자_범위_테스트() {
		Computer computer = Computer.createAndInit();
		List<Integer> numbers = computer.getNumbers();
		for (Integer number : numbers) {
			assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(9);
		}
	}

	@Test
	void 랜덤숫자_중복여부_테스트() {
		Computer computer = Computer.createAndInit();
		List<Integer> numbers = computer.getNumbers();
		Set<Integer> checkSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
		for (Integer number : numbers) {
			checkSet.remove(number);
		}
		assertThat(numbers.size()).isEqualTo(9 - checkSet.size());
	}
}