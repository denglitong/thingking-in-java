package test.java.com.dlt;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test Drive Development 的目标是产生更好、更周全的测试
 * 因为在完全实现之和尝试实现完整的测试覆盖通常会产生匆忙或无意义的测试
 *
 * @author denglitong
 * @date 2021/1/5
 */
public class StringInverterTests {
	StringInverter inverter = new Inverter4();

	@BeforeAll
	static void startMsg() {
		System.out.println(">>> StringInverterTests <<<");
	}

	@Test
	void basicInversion1() {
		String in = "Exit, Pursued by a Bear.";
		String out = "eXIT, pURSUED BY A bEAR.";
		assertEquals(inverter.invert(in), out);
	}

	@Test
	void basicInversion2() {
		assertThrows(Error.class, () -> {
			assertEquals(inverter.invert("X"), "X");
		});
	}

	@Test
	void disallowedCharacters() {
		String disallowed = ":-_()*&^%$#@!~`0123456789";
		String result = disallowed.chars()
				.mapToObj(c -> {
					String cc = Character.toString((char) c);
					try {
						inverter.invert(cc);
						return "";
					} catch (RuntimeException e) {
						return cc;
					}
				}).collect(Collectors.joining(""));
		assertEquals(result, disallowed);
	}

	@Test
	void allowedCharacters() {
		String lowcase = "abcdefghijklmnopqrstuvwxyz ,.";
		String upcase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ,.";
		assertEquals(inverter.invert(lowcase), upcase);
		assertEquals(inverter.invert(upcase), lowcase);
	}

	@Test
	void lengthNoGreaterThen30() {
		String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		assertTrue(str.length() > 30);
		assertThrows(RuntimeException.class, () -> {
			inverter.invert(str);
		});
	}

	@Test
	void lengthLessThan31() {
		String str = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		assertTrue(str.length() < 31);
		inverter.invert(str);
	}
}
