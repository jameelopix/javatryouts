package com.jameel.tryouts.newa;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {

	public App() {
//		boolean result = DataProvider.getPersonList().stream()
//		.allMatch(person -> person.getGender().equals(Gender.FEMALE));

//		boolean result = DataProvider.getPersonList().stream()
//				.anyMatch(person -> person.getGender().equals(Gender.MALE));

//		System.out.println(result);

//		Predicate<Integer> greaterThanTen = (i) -> i > 10;

//		System.out.println(greaterThanTen.and(lowerThanTwenty).test(15));

//		Predicate<Integer> isEven = (i) -> i % 2 == 0;

		long count = DataProvider.getPersonList().stream().filter(person -> person.getGender().equals(Gender.MALE))
				.peek(System.out::println).count();

		System.out.println(count);
		System.out.println("=============");

		Stream.of(2, 3, 5, 4, 2, 4, 3, 4, 5, 6, 4, 5, 6).peek(e -> System.out.println())
				.peek(e -> System.out.print("->" + e)).distinct().peek(e -> System.out.print("=>" + e)).map(e -> e * 10)
				.peek(e -> System.out.print("=>" + e)).flatMap(e -> Stream.of(e, e * 5))
				.peek(e -> System.out.print("--->" + e)).toArray();

		System.out.println("=============");
		int sum = IntStream.of(2, 3, 5, 4, 2, 4, 3, 4, 5, 6, 4, 5, 6).sum();
		System.out.println(sum);

//				.collect(Collectors.toList());

//				.count();

	}

	public static void main(String[] args) {
//		new App();

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		integers.stream().forEach(System.out::print);
		System.out.println();
		System.out.println("--------o");
		integers.parallelStream().forEach(System.out::print);
	}

	public Predicate<Integer> greaterThanTen = new Predicate<Integer>() {
		@Override
		public boolean test(Integer t) {
			System.out.println("App.greaterThanTen.new Predicate() {...}.test()");
			return t > 10;
		}
	};

	public Predicate<Integer> lowerThanTwenty = new Predicate<Integer>() {
		@Override
		public boolean test(Integer t) {
			System.out.println("App.lowerThanTwenty.new Predicate() {...}.test()");
			return t < 20;
		}
	};
}
