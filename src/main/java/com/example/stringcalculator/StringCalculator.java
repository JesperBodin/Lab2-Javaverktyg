package com.example.stringcalculator;

import java.util.Arrays;

public class StringCalculator {

	int add(String numbers) {
		if (numbers.equals(""))
			return 0;
		int[] numbersArray;
		if (numbers.startsWith("//")) {
			numbersArray = Arrays.stream(numbers.substring(4).
							split("[,\\n" + numbers.charAt(2) + "]")).
					mapToInt(Integer::parseInt).toArray();
			checkNegativeNumbers(numbersArray);
			return Arrays.stream(numbersArray).sum();
		}
		numbersArray = Arrays.stream(numbers.split("[,\\n]")).mapToInt(Integer::parseInt).toArray();
		checkNegativeNumbers(numbersArray);
		return Arrays.stream(numbersArray).sum();
	}

	private void checkNegativeNumbers(int[] numbersArray) {
		numbersArray = Arrays.stream(numbersArray).filter(num -> num < 0).toArray();
		if (numbersArray.length != 0) {
			throw new IllegalArgumentException("Negatives not allowed: " + Arrays.toString(numbersArray));
		}
	}
}
