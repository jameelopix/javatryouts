package db;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;

import beanutils.Symbol;

public class SqlBuilder {

	private static String ID = "ID";
	private static String CREATED_BY = "CREATED_BY";
	private static String CREATED_AT = "CREATED_AT";
	private static String LAST_UPDATED_BY = "LAST_UPDATED_BY";
	private static String LAST_UPDATED_AT = "LAST_UPDATED_AT";
	private static String VERSION = "VERSION";

	private static String INSERT = "INSERT";
	private static String INTO = "INTO";
	private static String VALUES = "VALUES";

	public static String save(Entity entity) {

		String tableFullName = String.join("", entity.getAppName(), Symbol.DOT, entity.getTableName());

		DynaClass dynaClass = entity.getDynaClass();
		DynaProperty[] properties = dynaClass.getDynaProperties();
		List<String> columnNames = new ArrayList<String>(properties.length);
		List<String> values = new ArrayList<String>(properties.length);

		columnNames.add(ID);
		values.add(getString(entity.getId()));
		columnNames.add(CREATED_AT);
		values.add(getString(entity.getCreatedAt()));
		columnNames.add(CREATED_BY);
		values.add(getString(entity.getCreatedBy()));
		columnNames.add(LAST_UPDATED_AT);
		values.add(getString(entity.getLastUpdatedAt()));
		columnNames.add(LAST_UPDATED_BY);
		values.add(getString(entity.getLastUpdatedBy()));
		columnNames.add(VERSION);
		values.add(getString(entity.getVersion()));

		for (DynaProperty dynaProperty : properties) {
			columnNames.add(dynaProperty.getName());
			Object value = entity.get(dynaProperty.getName());
			String valueString = null;

			if (value != null) {
				if (value instanceof String) {
					valueString = getString((String) value);
				}
				if (value instanceof Long) {
					valueString = getString((Long) value);
				}
				if (value instanceof Integer) {
					valueString = getString((Integer) value);
				}
				if (value instanceof Date) {
					valueString = getString((Date) value);
				}
			}

			values.add(valueString);
		}

		String columnNamesStmt = String.join(Symbol.COMMA, columnNames.toArray(new String[columnNames.size()]));
		String valueStmt = String.join(Symbol.COMMA, values.toArray(new String[values.size()]));

		List<String> tokens = new ArrayList<String>(30);
		tokens.add(INSERT);
		tokens.add(INTO);
		tokens.add(tableFullName);
		tokens.add(Symbol.OPEN_PARENTHESES);
		tokens.add(columnNamesStmt);
		tokens.add(Symbol.CLOSE_PARENTHESES);
		tokens.add(VALUES);
		tokens.add(Symbol.OPEN_PARENTHESES);
		tokens.add(valueStmt);
		tokens.add(Symbol.CLOSE_PARENTHESES);

		return String.join(Symbol.SPACE, tokens.toArray(new String[tokens.size()]));
	}

	private static String getString(String value) {
		return Symbol.SINGLE_QUOTE + value + Symbol.SINGLE_QUOTE;
	}

	private static String getString(Long value) {
		return Symbol.SINGLE_QUOTE + Long.toString(value) + Symbol.SINGLE_QUOTE;
	}

	private static String getString(Integer value) {
		return Symbol.SINGLE_QUOTE + Integer.toString(value) + Symbol.SINGLE_QUOTE;
	}

	private static String getString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		return Symbol.SINGLE_QUOTE + dateFormat.format(date) + Symbol.SINGLE_QUOTE;
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
//					Date date = (Date) value;
					valueString = Symbol.SINGLE_QUOTE + getString((Date) value) + Symbol.SINGLE_QUOTE;
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
