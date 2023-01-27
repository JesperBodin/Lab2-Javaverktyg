package com.example.stringcalculator;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class StringCalculator {
	int add(String numbers) {
		if (numbers.equals(""))
			return 0;
		if (numbers.length()==1)
			return parseInt(numbers);
		int[] numbersSplit = Arrays.stream(numbers.split(",")).mapToInt(Integer::parseInt).toArray();
		return numbersSplit [0] + numbersSplit [1];
	}
}
