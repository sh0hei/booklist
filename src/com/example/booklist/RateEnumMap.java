package com.example.booklist;

import java.util.EnumMap;

public class RateEnumMap {

	private enum Rate {
		NOT_SPECIFIED, SINGLE, DOUBLE, TRIPLE, QUADRUPLE, QUINTUPLE
	}

	private EnumMap<Rate, String> rateMap;

	public RateEnumMap() {
		rateMap = new EnumMap<Rate, String>(Rate.class);
		rateMap.put(Rate.NOT_SPECIFIED, "指定無し");
		rateMap.put(Rate.SINGLE, "☆");
		rateMap.put(Rate.DOUBLE, "☆☆");
		rateMap.put(Rate.TRIPLE, "☆☆☆");
		rateMap.put(Rate.QUADRUPLE, "☆☆☆☆");
		rateMap.put(Rate.QUINTUPLE, "☆☆☆☆☆");

	}
}
