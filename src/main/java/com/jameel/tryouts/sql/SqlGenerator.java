package com.jameel.tryouts.sql;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class SqlGenerator {

	public static void main(String[] args) {
		SqlGenerator generator = new SqlGenerator();

		List<Long> idList = Arrays.asList(45l, 56l, 67l);
		List<String> nameList = Arrays.asList("Mohamed", "Jameel", "fazila");
		List<Integer> rollNoList = Arrays.asList(123, 456, 789);
		List<Double> feesList = Arrays.asList(45000.00, 56000.00, 67000.00);
		System.out.println(generator.getInValue(idList));
		System.out.println(generator.getInValue(nameList));
		System.out.println(generator.getInValue(rollNoList));
		System.out.println(generator.getInValue(feesList));

		System.out.println("==================");
		System.out.println(generator.getFilterString(idList, "id"));
		System.out.println(generator.getFilterString(nameList, "name"));
		System.out.println(generator.getFilterString(rollNoList, "rollno"));
		System.out.println(generator.getFilterString(feesList, "fees"));

		System.out.println("==================");
		System.out.println(generator.getFilterString(Arrays.asList(idList.get(2)), "id"));
		System.out.println(generator.getFilterString(Arrays.asList(nameList.get(0)), "name"));
		System.out.println(generator.getFilterString(Arrays.asList(rollNoList.get(1)), "rollno"));
		System.out.println(generator.getFilterString(Arrays.asList(feesList.get(2)), "fees"));

		System.out.println("==================");
		StudentSearchDTO studentDTO = new StudentSearchDTO();
//		studentDTO.setIdList(idList);
//		studentDTO.setNameList(nameList);
		studentDTO.setRollNoList(rollNoList);
//		studentDTO.setFeesList(feesList);

		System.out.println(generator.selectQuery(studentDTO));
		System.out.println("==================");
		studentDTO.setIdList(Arrays.asList(idList.get(2)));
//		studentDTO.setNameList(Arrays.asList(nameList.get(0)));
//		studentDTO.setRollNoList(Arrays.asList(rollNoList.get(1)));
//		studentDTO.setFeesList(Arrays.asList(feesList.get(2)));

		System.out.println(generator.selectQuery(studentDTO));
		System.out.println("==================");
		Map<String, List<?>> map = new HashMap<String, List<?>>();
//		map.put("id", idList);
//		map.put("name", nameList);
//		map.put("rollno", rollNoList);
//		map.put("fees", Arrays.asList(feesList.get(2)));

		System.out.println(generator.getSelectQuery("STUDENT", map));
		System.out.println(generator.getDeleteQuery("STUDENT", map));
	}

	private String getDeleteQuery(String tableName, Map<String, List<?>> map) {
		StringBuilder sb = new StringBuilder("DELETE FROM ").append(tableName);

		Set<String> filterList = new HashSet<String>();
		filterList.add(null);
		for (Entry<String, List<?>> entry : map.entrySet()) {
			filterList.add(getFilterString(entry.getValue(), entry.getKey()));
		}
		filterList.remove(null);

		if (!isEmpty(filterList)) {
			String filterSection = String.join(" AND ", filterList);

			sb.append(" WHERE ").append(filterSection);
		}

		return sb.append(";").toString();
	}

	private String getSelectQuery(String tableName, Map<String, List<?>> map) {
		StringBuilder sb = new StringBuilder("SELECT * FROM ").append(tableName);

		Set<String> filterList = new HashSet<String>();
		filterList.add(null);
		for (Entry<String, List<?>> entry : map.entrySet()) {
			filterList.add(getFilterString(entry.getValue(), entry.getKey()));
		}
		filterList.remove(null);

		if (!isEmpty(filterList)) {
			String filterSection = String.join(" AND ", filterList);

			sb.append(" WHERE ").append(filterSection);
		}

		return sb.append(";").toString();
	}

	private String selectQuery(StudentSearchDTO studentDTO) {
		StringBuilder sb = new StringBuilder("SELECT * FROM STUDENT");

		Set<String> filterList = new HashSet<String>();
		filterList.add(null);
		filterList.add(getFilterString(studentDTO.getIdList(), "id"));
		filterList.add(getFilterString(studentDTO.getNameList(), "name"));
		filterList.add(getFilterString(studentDTO.getFeesList(), "fees"));
		filterList.add(getFilterString(studentDTO.getRollNoList(), "rollno"));
		filterList.remove(null);

		if (!isEmpty(filterList)) {
			String filterSection = String.join(" AND ", filterList);

			sb.append(" WHERE ").append(filterSection).append(";");
		}

		return sb.toString();
	}

	private String getFilterString(Collection<?> collection, String field) {
		if (!isEmpty(collection)) {
			List<String> tokens = new ArrayList<String>();
			tokens.add(field);

			if (collection.size() == 1) {
				tokens.add("=");
				Iterator<?> iterator = collection.iterator();
				Object obj = iterator.next();
				if (obj instanceof String) {
					tokens.add("\"" + obj + "\"");
				} else {
					tokens.add(obj.toString());
				}
			} else {
				tokens.add("IN");
				tokens.add(getInValue(collection));
			}
			return String.join(" ", tokens);
		}
		return null;
	}

	private String getInValue(Collection<?> collection) {
		List<String> values = new ArrayList<String>();
		for (Object obj : collection) {
			if (obj instanceof String) {
				values.add("\"" + obj + "\"");
			} else {
				values.add(obj.toString());
			}
		}
		return "(" + String.join(", ", values) + ")";
	}

	private boolean isEmpty(Collection<?> collection) {
		if (collection == null || collection.isEmpty()) {
			return true;
		}
		return false;
	}
}

@Setter
@Getter
@Builder
class Student {
	private Long id;
	private String name;
	private Double fees;
	private Date dateOfBirth;
	private Integer rollNo;
}

@Setter
@Getter
//@Builder
class StudentSearchDTO {
	private List<Long> idList;
	private List<String> nameList;
	private List<Double> feesList;
	private List<Date> dateOfBirthList;
	private List<Integer> rollNoList;
}