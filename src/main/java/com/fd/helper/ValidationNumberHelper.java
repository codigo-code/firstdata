package com.fd.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationNumberHelper {

	public static boolean validation(String card) {
		String regex = "^(?:(?<SQUE>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<mastercard>5[1-5][0-9]{14})|"
				+ "(?<PERE>6(?:011|5[0-9]{2})[0-9]{12})|" + "(?<amex>3[47][0-9]{13})|"
				+ "(?<SCO>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

		Pattern pattern = Pattern.compile(regex);

		// Strip all hyphens
		card = card.replaceAll("-", "");

		// Match the card
		Matcher matcher = pattern.matcher(card);

		System.out.println(matcher.matches());

		if (matcher.matches()) {
			// If card is valid then verify which group it belong
			System.out.println(matcher.group("mastercard"));
			return true;
		}
		return false;
	}

}