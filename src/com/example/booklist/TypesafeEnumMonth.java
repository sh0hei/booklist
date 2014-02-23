package com.example.booklist;

public class TypesafeEnumMonth {
	
	private final String name;

	private TypesafeEnumMonth(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public static final TypesafeEnumMonth JANUARY = new TypesafeEnumMonth("JANUARY");
	public static final TypesafeEnumMonth FEBRUARY = new TypesafeEnumMonth("FEBRUARY");
	public static final TypesafeEnumMonth MARCH = new TypesafeEnumMonth("MARCH");

	private static final TypesafeEnumMonth[] PRIVATE_VALUES = { JANUARY, FEBRUARY, MARCH, };

	public static TypesafeEnumMonth[] values() {
		return PRIVATE_VALUES;
	}
}
