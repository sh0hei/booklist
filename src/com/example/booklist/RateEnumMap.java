package com.example.booklist;

import java.util.EnumMap;

public class RateEnumMap {

	private enum Rate {
		NOT_SPECIFIED, SINGLE_STAR, DOUBLE_STAR, TRIPLE_STAR, QUADRUPLE_STAR, QUINTUPLE_STAR
	}

	private EnumMap<Rate, String> rateMap;

	public RateEnumMap() {
		rateMap = new EnumMap<Rate, String>(Rate.class);
		rateMap.put(Rate.NOT_SPECIFIED, "指定無し");
		rateMap.put(Rate.SINGLE_STAR, "☆");
		rateMap.put(Rate.DOUBLE_STAR, "☆☆");
		rateMap.put(Rate.TRIPLE_STAR, "☆☆☆");
		rateMap.put(Rate.QUADRUPLE_STAR, "☆☆☆☆");
		rateMap.put(Rate.QUINTUPLE_STAR, "☆☆☆☆☆");

	}
}
