package com.example.stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

	StringCalculator calculator = new StringCalculator();

	@ParameterizedTest
	@CsvSource({"'', 0"})
	void callAddMethodWithEmptyStringReturnZero(String numbers, int expected){

		assertThat(calculator.add(numbers)).isEqualTo(expected);
	}

}