package com.example.booklist;

import java.util.EnumMap;

public class StatusEnumMap {
	
	private enum Status {
		MISYOJI, KARIIRETYUU, BELONGINGS, DOKURYO, KASIDASITYUU, HAIKI
	}
	
	private EnumMap<Status, String> statusMap;
	
	public StatusEnumMap() {
		statusMap = new EnumMap<Status, String>(Status.class);
		statusMap.put(Status.MISYOJI, "未所持");
		statusMap.put(Status.KARIIRETYUU, "借入中");
		statusMap.put(Status.BELONGINGS, "所持");
		statusMap.put(Status.DOKURYO, "読了");
		statusMap.put(Status.KASIDASITYUU, "貸出中");
		statusMap.put(Status.HAIKI, "廃棄");
		
	}

}
