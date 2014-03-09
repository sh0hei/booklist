package com.example.booklist;

import java.util.EnumMap;

public class RateEnumMap {

	private enum Rate {
		NOT_SPECIFIED, SINGLE, DOUBLE, TRIPLE, QUADRUPLE, QUINTUPLE
	}

	private EnumMap<Rate, String> rateMap;

	public RateEnumMap() {
		rateMap = new EnumMap<Rate, String>(Rate.class);
		rateMap.put(Rate.NOT_SPECIFIED, "未所持");
		rateMap.put(Rate.SINGLE, "借入中");
		rateMap.put(Rate.DOUBLE, "所持");
		rateMap.put(Rate.TRIPLE, "読了");
		rateMap.put(Rate.QUADRUPLE, "貸出中");
		rateMap.put(Rate.QUINTUPLE, "廃棄");

	}
}
