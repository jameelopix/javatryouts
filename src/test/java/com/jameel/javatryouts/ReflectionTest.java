package com.jameel.javatryouts;

import java.util.LinkedList;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.jameel.tryouts.reflection.ReflectionUtils;

public class ReflectionTest {

	static ReflectionUtils reflectionUtils;

	@BeforeAll
	static void setup() {
		reflectionUtils = new ReflectionUtils();
	}

	@DisplayName("Get all Method Names")
	@Test
	@Disabled("not now")
	void testGetMethodNames() {
		reflectionUtils.getMethodNames(LinkedList.class).stream().sorted().forEach(System.out::println);
	}

	@DisplayName("Get all Method Full Names")
	@Test
	void testGetMethodFullNames() {
		reflectionUtils.getFullMethodNames(Stream.class).stream().sorted().forEach(System.out::println);
	}
}
