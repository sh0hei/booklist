package com.example.booklist;

public class StateEnum extends TypeSafeEnum {

	public static final int DEAD = 1;
	public static final int GROW = 2;
	public static final int COMP = 3;

	protected StateEnum(int enumValue) {
		super(enumValue);
		// TODO 自動生成されたコンストラクター・スタブ
	}

}
