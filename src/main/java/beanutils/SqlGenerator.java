package beanutils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;

public class SqlGenerator {

	private static String INSERT = "INSERT";
	private static String INTO = "INTO";
	private static String VALUES = "VALUES";

	private String toString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return dateFormat.format(date);
	}

	public String save(DynaBean bean) {
//		INSERT INTO table_name (column1, column2, column3, ...)
//		VALUES (value1, value2, value3, ...); 

		DynaClass dynaClass = bean.getDynaClass();
		DynaProperty[] properties = dynaClass.getDynaProperties();
		List<String> columnNames = new ArrayList<String>(properties.length);
		List<String> values = new ArrayList<String>(properties.length);

		for (DynaProperty dynaProperty : properties) {
			columnNames.add(dynaProperty.getName());
			Object value = bean.get(dynaProperty.getName());
			String valueString = null;

			if (value != null) {
				if (value instanceof String) {
					valueString = Symbol.SINGLE_QUOTE + value + Symbol.SINGLE_QUOTE;
				}
				if (value instanceof Long) {
					valueString = Symbol.SINGLE_QUOTE + Long.toString((Long) value) + Symbol.SINGLE_QUOTE;
				}
				if (value instanceof Integer) {
					valueString = Symbol.SINGLE_QUOTE + Integer.toString((Integer) value) + Symbol.SINGLE_QUOTE;
				}
				if (value instanceof Date) {
					Date date = (Date) value;
					valueString = Symbol.SINGLE_QUOTE + toString((Date) value) + Symbol.SINGLE_QUOTE;
				}
			}

			values.add(valueString);
		}

		String columnNamesStmt = String.join(Symbol.COMMA, columnNames.toArray(new String[columnNames.size()]));
		String valueStmt = String.join(Symbol.COMMA, values.toArray(new String[values.size()]));

		List<String> tokens = new ArrayList<String>(30);
		tokens.add(INSERT);
		tokens.add(INTO);
		tokens.add(bean.getDynaClass().getName());
		tokens.add(Symbol.OPEN_PARENTHESES);
		tokens.add(columnNamesStmt);
		tokens.add(Symbol.CLOSE_PARENTHESES);
		tokens.add(VALUES);
		tokens.add(Symbol.OPEN_PARENTHESES);
		tokens.add(valueStmt);
		tokens.add(Symbol.CLOSE_PARENTHESES);

		return String.join(Symbol.SPACE, tokens.toArray(new String[tokens.size()]));
	}

}
