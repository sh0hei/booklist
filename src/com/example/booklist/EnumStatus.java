/**
 * 
 */
package com.example.booklist;

/**
 * @author sh0hei
 */
public enum EnumStatus {

	NOT_YET_BELONGINGS(0, "未所持"),
	BORROWED(1, "借入中"),
	BELONGINGS(2, "所持"),
	READING_THROUGH(3, "読了"),
	LENT(4, "貸出中"),
	SCRAPED(5, "廃棄");

	/**
	 * ステータスID
	 */
	private Integer id;

	/**
	 * ステータス名
	 */
	private String name;

	/**
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            セットする id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            セットする name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param id
	 * @param name
	 */
	EnumStatus(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static EnumStatus get(Integer id) {
		EnumStatus status = EnumStatus.NOT_YET_BELONGINGS;
		
		for (EnumStatus s : EnumStatus.values()) {
			if (s.getId() == id) {
				return s;
			}
		}
		
		return status;
	}

}
