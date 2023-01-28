package com.example.stringcalculator;

import java.util.Arrays;

public class StringCalculator {


	int add(String numbers) {
		if (numbers.equals(""))
			return 0;
		int[] numbersArray = new int[0];

		if (numbers.startsWith("//")) {
			numbersArray = getNumbersArray(numbers);
			return Arrays.stream(numbersArray).filter(num -> num < 1000).sum();
		}
		numbersArray = Arrays.stream(numbers.split("[,\\n]")).mapToInt(Integer::parseInt).toArray();
		checkNegativeNumbers(numbersArray);
		return Arrays.stream(numbersArray).filter(num -> num < 1000).sum();
	}

	private int[] getNumbersArray(String numbers) {
		numbers = numbers.substring(2);
		String[] strings = numbers.split("\\n", 2);
		numbers = strings[1];
		System.out.println(Arrays.toString(strings));
		String deli = strings[0];
		deli = deli.replace("[", "(");
		deli = deli.replace("]", ")");
		deli = deli.replace(")(", ")|(");
		if (deli.contains("*"))
			deli = deli.replace("*", "\\*");
		int [] numbersArray = Arrays.stream(numbers.
						split("[,\\n]|" + deli )).
				mapToInt(Integer::parseInt).toArray();
		checkNegativeNumbers(numbersArray);
		return numbersArray;
	}

	private void checkNegativeNumbers(int[] numbersArray) {
		numbersArray = Arrays.stream(numbersArray).filter(num -> num < 0).toArray();
		if (numbersArray.length != 0) {
			throw new IllegalArgumentException("Negatives not allowed: " + Arrays.toString(numbersArray));
		}
	}

}
