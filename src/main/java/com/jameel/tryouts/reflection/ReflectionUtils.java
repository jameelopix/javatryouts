package com.jameel.tryouts.reflection;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReflectionUtils {

	public List<String> getMethodNames(Class<?> cls) {
		Method[] methods = cls.getMethods();
		List<String> methodNames = Stream.of(methods).map(e -> e.getName()).collect(Collectors.toList());
		return methodNames;
	}

	public List<String> getFullMethodNames(Class<?> cls) {
		Method[] methods = cls.getMethods();
		List<String> methodNames = Stream.of(methods).map(e -> e.getName() + ":" + e.getReturnType().getTypeName())
				.collect(Collectors.toList());
		return methodNames;
	}
}
