package com.example.booklist;

public class TypeSafeEnum {

    protected int _enumValue;
    
    protected TypeSafeEnum(int enumValue) {
        this._enumValue = enumValue;
    }

    public int Value() {
        return this._enumValue;
    }
}
