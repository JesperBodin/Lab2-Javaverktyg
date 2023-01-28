package com.example.stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

	StringCalculator calculator = new StringCalculator();

	@ParameterizedTest
	@CsvSource({"'', 0", "'1', 1", "'1,5', 6", "'1,2,3,4,5', 15"})
	void callAddMethodWithStringInputReturnExpectedIntValue(String numbers, int expected) {

		assertThat(calculator.add(numbers)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource({"'1\n4', 5", "'1\n2,3\n4,5', 15"})
	void callAddMethodWithStringAndNewLineInputReturnExpectedIntValue(String numbers, int expected) {

		assertThat(calculator.add(numbers)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource({"'//;\n1;2', 3", "'//€\n1€2\n3,4€5', 15"})
	void callAddMethodWithStringAndNewDelimiterReturnExpectedIntValue(String numbers, int expected) {

		assertThat(calculator.add(numbers)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource({"'1,2,-1', 'Negatives not allowed: [-1]'", "'1,2,-3,-4,-5', 'Negatives not allowed: [-3, -4, -5]'"})
	void callAddMethodWithNegativeNumberShouldThrowAnException(String numbers, String expected) {

		assertThatThrownBy(() -> calculator.add(numbers)).isInstanceOf(IllegalArgumentException.class).hasMessage(expected);
	}

	@ParameterizedTest
	@CsvSource({"'1,1001', 1", "'2,1111', 2", "'5,3500,2324,6', 11"})
	void numbersBiggerThanThousandShouldBeIgnored(String numbers, int expected) {
		assertThat(calculator.add(numbers)).isEqualTo(expected);

	}

	@ParameterizedTest
	@CsvSource({"'//[***]\n1***2***3', 6", "'//[%%**&]\n1%%**&2%%**&4', 7"})
	void anyLengthDelimiterShouldWorkAndReturnExpectedValue(String numbers, int expected) {
		assertThat(calculator.add(numbers)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource({"'//[%][&]\n1%2&3', 6", "'//[*][¤]\n2*4¤6', 12" })
	void multipleDelimitersShouldReturnExpectedValue(String numbers, int expected){
		assertThat(calculator.add(numbers)).isEqualTo(expected);
	}
}