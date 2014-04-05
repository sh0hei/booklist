/**
 * 
 */
package com.example.booklist;

/**
 * @author sh0hei
 */
public enum EnumRate {

	NOT_SPECIFIED(0, "指定無し"),
	SINGLE_STAR(1, "☆"),
	DOUBLE_STAR(2, "☆☆"),
	TRIPLE_STAR(3, "☆☆☆"),
	QUADRUPLE_STAR(4, "☆☆☆☆"),
	QUINTUPLE_STAR(5, "☆☆☆☆☆");

	/**
	 * レートID
	 */
	private Integer id;

	/**
	 * レート名称
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
	EnumRate(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public static EnumRate get(Integer id) {
		EnumRate rate = EnumRate.NOT_SPECIFIED;
		
		for (EnumRate r : EnumRate.values()) {
			if (r.getId() == id) {
				return r;
			}
		}
		
		return rate;
	}
}
