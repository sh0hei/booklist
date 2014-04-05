package com.example.booklist.db;

import java.io.Serializable;

import com.example.booklist.EnumRate;
import com.example.booklist.EnumStatus;

/**
 * Rate class
 * 
 * @author sh0hei
 */
public class Rate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TABLE_NAME = "rates";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_ISBN = "isbn";
	public static final String COLUMN_RATE = "rate";
	public static final String COLUMN_STATUS = "status";

	// ユーザ設定レート
	private EnumRate rate;

	// ユーザ設定ステータス
	private EnumStatus status;

	/**
	 * @return rate
	 */
	public EnumRate getRate() {
		return rate;
	}

	/**
	 * @param rate
	 *            セットする rate
	 */
	public void setRate(EnumRate rate) {
		this.rate = rate;
	}

	/**
	 * @return status
	 */
	public EnumStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            セットする status
	 */
	public void setStatus(EnumStatus status) {
		this.status = status;
	}

}
