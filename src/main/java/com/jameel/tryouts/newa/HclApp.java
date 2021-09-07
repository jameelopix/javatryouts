package com.jameel.tryouts.newa;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class HclApp {

	public static void main(String[] args) {
		String str = "My name is Jameel";

		String result = Arrays.stream(str.split(" ")).map(word -> new StringBuilder(word).reverse())
				.collect(Collectors.joining(" "));

		System.out.println(result);

		StringBuilder sb = new StringBuilder(str).reverse();
//		System.out.println(sb.toString());

		System.out.println("---------------------");
		String result1 = Arrays.stream(str.split(" "))
				.collect(Collectors.collectingAndThen(Collectors.toList(), strings -> {
					System.out.println("---------------------" + strings);
					Collections.reverse(strings);
					System.out.println("---------------------" + strings);
					return strings;
				})).stream().collect(Collectors.joining(" "));

		System.out.println(result1);
		System.out.println("---------------------");

		String input = "AccentureA";

		long count = Stream.of(input.toCharArray()).distinct().count();
		Stream.of(input.toCharArray()).forEach(i -> {
			System.out.println("-");
			System.out.println(i);
			System.out.println("-");
		});
		System.out.println(count);
//		forEach(System.out::println);
		System.out.println("---------------------");

		for (char string : input.toCharArray()) {
			System.out.println(string);
		}

		System.out.println("---------------------");
		Stream<Character> characterStream = input.chars().mapToObj(c -> (char) c);
		characterStream.forEach(i -> System.out.println(i));

		System.out.println("---------------------");
		input.chars().distinct().limit(1).forEach(i -> System.out.println((char) i));

		System.out.println("=========================");
		input.chars().mapToObj(c -> (char) c)
//		.forEach(System.out::println);
				.peek(System.out::println).forEach(i -> System.out.println());

//		System.out.println("$$$$$$$$$");
//		Set<Integer> duplicates = new HashSet<>();
		Set<Integer> uniques = new HashSet<>();
//		input.chars().filter(e -> !uniques.add(e)).count();

		Set<Character> duplicates = input.chars().filter(e -> !uniques.add(e)).mapToObj(c -> (char) c)
				.collect(Collectors.toSet());

//		System.out.println("$$$$$uniques$$$");
//		uniques.stream().forEach(i -> System.out.println(Character.toChars(i)));

//		System.out.println("$$$$$duplicates$$$$");
//		duplicates.stream().forEach(i -> System.out.println((char) i));

		System.out.println("$$$$$$$$$");
		input.chars().filter(e -> !duplicates.contains((char) e)).limit(1).forEach(i -> System.out.println((char) i));
	}

	public static void main1(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("HCL", 15000);
		map.put("INFOSYS", 25000);
		map.put("WIPRO", 35000);
		map.put("UST", 4000);

//		map.forEach((k, v) -> {
//			System.out.println(k);
//			System.out.println(v);
//		});

		Map<String, Integer> result = map.entrySet().stream().filter(entry -> entry.getValue() > 5000)
				.collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

		System.out.println("-------------------------");
		for (Entry<String, Integer> entry : result.entrySet()) {
			System.out.println(entry.getKey());
		}
		System.out.println("-------------------------");

//		map.values().stream().filter(null)

		Iterator<Map.Entry<String, Integer>> entryIterator = map.entrySet().iterator();

		while (entryIterator.hasNext()) {
			Entry<String, Integer> entry = entryIterator.next();
			if (entry.getValue() < 5000) {
				entryIterator.remove();
			}
		}

		System.out.println("-------------------------");
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
