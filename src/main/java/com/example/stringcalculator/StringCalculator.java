package com.example.stringcalculator;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class StringCalculator {

	int add(String numbers) {
		if (numbers.equals(""))
			return 0;
		if (numbers.length()==1)
			return parseInt(numbers);
		if(numbers.startsWith("//"))
			return Arrays.stream(numbers.substring(4).
					split("[,\\n" + numbers.charAt(2) +"]")).
					mapToInt(Integer::parseInt).sum();

		return Arrays.stream(numbers.split("[,\\n]")).mapToInt(Integer::parseInt).sum();
	}
}
