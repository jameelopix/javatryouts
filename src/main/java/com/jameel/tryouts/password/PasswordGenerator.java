package com.jameel.tryouts.password;

import java.util.Random;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class PasswordGenerator {

	public static void main(String[] args) {
		PasswordConfig details = PasswordConfig.builder().lowercaseAllowed(true).numberAllowed(true).symbolAllowed(true)
				.uppercaseAllowed(true).build();

		PasswordGenerator generator = new PasswordGenerator();

		for (int i = 0; i < 10; i++) {
			System.out.println(generator.generate(details, 10));
		}
	}

	public String generate(PasswordConfig config, int length) {
		StringBuilder sb = new StringBuilder();
		StringBuilder passwordString = new StringBuilder();
		if (config.isLowercaseAllowed()) {
			passwordString.append("abcdefghijklmnopqrstuvwxyz");
		}
		if (config.isUppercaseAllowed()) {
			passwordString.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		}
		if (config.isNumberAllowed()) {
			passwordString.append("0123456789");
		}
		if (config.isSymbolAllowed()) {
			passwordString.append("!@#$%^&*()");
		}

		Random random = new Random();

		for (int i = 0; i < length; i++) {
			sb.append(passwordString.charAt(random.nextInt(passwordString.length())));
		}

		return sb.toString();
	}
}

@Setter
@Getter
@Builder
class PasswordConfig {
	private boolean symbolAllowed;
	private boolean uppercaseAllowed;
	private boolean lowercaseAllowed;
	private boolean numberAllowed;
}