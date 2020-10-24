package com.walmart.desafio;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	public boolean isInteger(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public boolean isPalindrome(String text) {
		text = text.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o")
				.replace("ú", "u").replace(" ", "").replace(".", "").replace(",", "");

		String invert = new StringBuilder(text).reverse().toString();
		return !isInteger(text) && invert.equals(text);
	}
}
